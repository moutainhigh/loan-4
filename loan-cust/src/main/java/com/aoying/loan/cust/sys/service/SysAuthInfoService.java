package com.aoying.loan.cust.sys.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import com.aoying.loan.common.base.service.BaseService;
import com.aoying.loan.common.config.redis.BaseRedisDao;
import com.aoying.loan.common.constant.response.code.EResCodeCommon;
import com.aoying.loan.common.constant.response.exception.DefineMsgException;
import com.aoying.loan.common.util.HttpTool;
import com.aoying.loan.common.util.StringTool;
import com.aoying.loan.cust.sys.dao.SysAuthInfoDao;
import com.aoying.loan.cust.sys.pojo.SysAuthInfoPojo;
import com.aoying.loan.cust.sys.service.iservice.ISysAuthInfoService;

/**
 * 系统访问认证信息 Service
 * @author nick
 */
@Service
@ConfigurationProperties(prefix = "sysCfg.sysAuthInfoService")
public class SysAuthInfoService extends BaseService<SysAuthInfoPojo, SysAuthInfoDao> implements ISysAuthInfoService {
    @Autowired
    @Qualifier("baseRedisDaoDef")
    private BaseRedisDao baseRedisDao;

    /** 认证信息缓存Map */
    private Map<String, SysAuthInfoPojo> sysAuthInfoCacheMap;

    /** 授权签名时效 */
    private int authSignExp;

    @PostConstruct
    public void reloadCache() {
        logger.info("====================重新加载AuthInfo信息=====================");
        Map<String, SysAuthInfoPojo> map = new HashMap<String, SysAuthInfoPojo>();
        List<SysAuthInfoPojo> sysAuthInfoList = this.selectList(new SysAuthInfoPojo());
        for (SysAuthInfoPojo pojo : sysAuthInfoList) {
            map.put(pojo.getAccount(), pojo);
        }
        sysAuthInfoCacheMap = map;
    }

    public SysAuthInfoPojo getCacheByKey(SysAuthInfoPojo pojo) {
        return sysAuthInfoCacheMap.get(pojo.getAccount());
    }

    /**
     * 校验签名
     * @param request
     * @throws DefineMsgException
     */
    @Override
    public SysAuthInfoPojo checkSign(HttpServletRequest request) throws DefineMsgException {
        String account = HttpTool.getParameterFromRequest(request, "account");
        String timestamp = HttpTool.getParameterFromRequest(request, "timestamp");
        String sign = HttpTool.getParameterFromRequest(request, "sign");

        Assert.notNull(account, EResCodeCommon.authSignNoAccount.getMsg());
        Assert.notNull(timestamp, EResCodeCommon.authSignNoTimestamp.getMsg());
        Assert.notNull(sign, EResCodeCommon.authSignNoSign.getMsg());

        // 检查签名时效
        Long signTime = Long.parseLong(timestamp);
        Long currTime = System.currentTimeMillis();
        if (Math.abs(currTime - signTime) > authSignExp * 60000) {
            throw new DefineMsgException(EResCodeCommon.authSignExpire);
        }

        // 获取访问认证信息
        SysAuthInfoPojo pojo = new SysAuthInfoPojo();
        pojo.setAccount(account);
        pojo = this.getCacheByKey(pojo);

        if (pojo == null) {
            throw new DefineMsgException(EResCodeCommon.authSignAccInvalid);
        }

        // 检查签名账号类型
        if (!pojo.getType().equals(SysAuthInfoPojo.EType.ALL.getVal()) &&
                !request.getRequestURI().contains(pojo.getEType().getPath())) {
            throw new DefineMsgException(EResCodeCommon.authSignAccErrType);
        }

        // 检查签名账号时效
        if (pojo.getExpirTime() != null && pojo.getExpirTime().getTime() < currTime) {
            throw new DefineMsgException(EResCodeCommon.authSignAccExpire);
        }

        // 检查签名正确性
        String currSign = StringTool.MD5Encode(account + timestamp + pojo.getSecret());
        if (!sign.equalsIgnoreCase(currSign)) {
            throw new DefineMsgException(EResCodeCommon.authSignInvalid);
        }

        return pojo;
    }

    /** 设置 授权签名时效 */
    public void setAuthSignExp(int authSignExp) {
        this.authSignExp = authSignExp;
    }
}
