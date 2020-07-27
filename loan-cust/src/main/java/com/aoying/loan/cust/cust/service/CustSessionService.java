package com.aoying.loan.cust.cust.service;

import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;
import com.aoying.loan.common.constant.eenum.ERedisCacheKey;
import com.aoying.loan.common.constant.response.code.EResCodeCommon;
import com.aoying.loan.common.constant.response.exception.DefineMsgException;
import com.aoying.loan.common.config.redis.BaseRedisDao;
import com.aoying.loan.common.util.HttpTool;
import com.aoying.loan.cust.cust.pojo.CustInfoPojo;

/**
 * 用户会话服务
 * @author nick
 */
@Service
@ConfigurationProperties(prefix = "sysCfg.custSessionService")
public class CustSessionService {
    /** 日志对象 */
    protected static final Logger logger = LoggerFactory.getLogger(CustSessionService.class);

    /** 客户端token名称 */
    private String tokenName;
    /** session过期时长，单位：分钟 */
    private int sessionExp;

    @Autowired
    @Qualifier("baseRedisDaoDef")
    private BaseRedisDao baseRedisDao;

    /**
     * 取得当前用户会话，同时延长会话时间
     * @param request
     * @return
     * @throws DefineMsgException
     */
    public CustInfoPojo getCurrentCust(HttpServletRequest request) throws DefineMsgException {
        String token = this.getToken(request);
        if (token == null) {
            throw new DefineMsgException(EResCodeCommon.noUserToken);
        }
        CustInfoPojo cust = this.getLoginCust(token);
        cust.setIp(HttpTool.getIpAddr(request));
        return cust;
    }

    /**
     * 设置当前用户会话，同时设置会话时间
     * @param cust
     * @return
     */
    public String setCurrentCust(CustInfoPojo cust) {
        // 检查该用户是否已经登录，若已经登录则设置重复Token，下次访问时提示您已在另一处登录
        String token = this.getLoginToken(cust.getAppId(), cust.getId());
        if (token != null) {
            this.setLoginRepeat(token, cust);
            this.removeCurrentCust(cust.getAppId(), cust.getId());
        }

        // 设置新的会话
        return this.setLoginCust(cust);
    }

    /**
     * 移除当前登录用户会话，用于用户重复登录或注销
     * @param appId
     * @param custId
     */
    public void removeCurrentCust(Long appId, Long custId) {
        String token = this.getLoginToken(appId, custId);
        if (token != null) {
            baseRedisDao.delete(this.getLoginTokenKey(appId, custId));
            baseRedisDao.delete(this.getLoginCustKey(token));
        }
    }

    /**
     * 获取请求中包含的Token
     * @param request 请求对象
     * @return
     */
    private String getToken(HttpServletRequest request) {
        return HttpTool.getParameterFromRequest(request, tokenName);
    }

    /**
     * 获取Token Redis Key
     * @param appId
     * @param custId
     * @return
     */
    private String getLoginTokenKey(Long appId, Long custId) {
        return ERedisCacheKey.LOGIN_TOKEN.getVal() + appId + "_" + custId;
    }

    /**
     * 获取登录用户 Redis Key
     * @param token
     * @return
     */
    private String getLoginCustKey(String token) {
        return ERedisCacheKey.LOGIN_CUST.getVal() + token;
    }

    /**
     * 获取重复登录用户 Redis Key
     * @param token
     * @return
     */
    private String getLoginRepeatKey(String token) {
        return ERedisCacheKey.LOGIN_REPEAT.getVal() + token;
    }

    /**
     * 获取用户登录Token
     * @param appId APP ID
     * @param custId 用户ID
     * @return
     */
    private String getLoginToken(Long appId, Long custId) {
        return baseRedisDao.get(this.getLoginTokenKey(appId, custId), String.class);
    }

    /**
     * 设置用户登录Token
     * @param appId
     * @param custId
     * @return
     */
    private String setLoginToken(Long appId, Long custId) {
        String token = UUID.randomUUID().toString().replace("-", "").toUpperCase();
        baseRedisDao.saveOrUpdate(this.getLoginTokenKey(appId, custId), token, sessionExp * 60);
        return token;
    }

    /**
     * 取得当前用户会话，同时延长会话时间
     * @param token
     * @return
     * @throws DefineMsgException
     */
    private CustInfoPojo getLoginCust(String token) throws DefineMsgException {
        CustInfoPojo cust = baseRedisDao.get(this.getLoginCustKey(token), CustInfoPojo.class, sessionExp * 60);
        if (cust == null) {
            throw new DefineMsgException(EResCodeCommon.errUserToken);
        }
        return cust;
    }

    /**
     * 设置当前登录用户会话，同时设置会话时间
     * @param cust
     * @return
     */
    private String setLoginCust(CustInfoPojo cust) {
        String token = this.setLoginToken(cust.getAppId(), cust.getId());
        baseRedisDao.saveOrUpdate(this.getLoginCustKey(token), cust, sessionExp * 60);
        return token;
    }

    /**
     * 获取重复登录用户
     * @param token
     * @return
     */
    private String getLoginRepeat(String token) {
        String repeatCust = baseRedisDao.get(this.getLoginRepeatKey(token), String.class);
        if (repeatCust != null) {
            baseRedisDao.delete(this.getLoginRepeatKey(token));
        }
        return repeatCust;
    }

    /**
     * 设置重复登录用户
     * @param token
     * @param cust
     * @return
     */
    private void setLoginRepeat(String token, CustInfoPojo cust) {
        CustInfoPojo c = new CustInfoPojo();
        c.setId(cust.getId());
        c.setTelNo(cust.getTelNo());
        c.setAppId(cust.getAppId());
        baseRedisDao.saveOrUpdate(this.getLoginRepeatKey(token), c.toString(), sessionExp * 60);
    }

    /** 设置 客户端token名称 */
    public void setTokenName(String tokenName) {
        this.tokenName = tokenName;
    }

    /** 设置 session过期时长，单位：分钟 */
    public void setSessionExp(int sessionExp) {
        this.sessionExp = sessionExp;
    }

}
