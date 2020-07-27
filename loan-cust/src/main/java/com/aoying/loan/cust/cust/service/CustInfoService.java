package com.aoying.loan.cust.cust.service;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.aoying.loan.common.base.service.BaseService;
import com.aoying.loan.common.constant.eenum.EDeviceType;
import com.aoying.loan.common.constant.response.code.EResCodeCust;
import com.aoying.loan.common.constant.response.exception.CustomMsgException;
import com.aoying.loan.common.constant.response.exception.DefineMsgException;
import com.aoying.loan.common.util.HttpClientTool;
import com.aoying.loan.common.util.StringTool;
import com.aoying.loan.cust.cust.dao.CustInfoDao;
import com.aoying.loan.cust.cust.pojo.CustInfoPojo;
import com.aoying.loan.cust.cust.service.iservice.ICustInfoService;
import com.aoying.loan.cust.cust.service.iservice.ICustLoginFailLogService;
import com.aoying.loan.cust.cust.service.iservice.ICustLoginLogService;
import com.github.wxpay.sdk.WXPay;

/**
 * 用户信息表 Service
 * @author nick
 */
@Service
public class CustInfoService extends BaseService<CustInfoPojo, CustInfoDao> implements ICustInfoService {
    @Autowired
    private WXPay wxPayApi;
    @Autowired
    private CustSessionService custSessionService;
    @Autowired
    private ICustLoginLogService custLoginLogService;
    @Autowired
    private ICustLoginFailLogService custLoginFailLogService;

    private Integer loginErrTimes = 5;

    @Override
    public void addRegister(CustInfoPojo registerCust) throws DefineMsgException {
        // 检查是否已注册过
        CustInfoPojo currCust = this.selectUnique(registerCust);

        // 若已注册过
        if (currCust != null) { throw new DefineMsgException(EResCodeCust.svceErrTelNoIsReged); }

        // 若未注册过
        // TODO: 2018-12-05
        if (!StringUtils.isEmpty(registerCust.getLoginPwd())) {
            registerCust.setLoginPwd(StringTool.MD5Encode(registerCust.getLoginPwd()));
        }
        if (StringUtils.isEmpty(registerCust.getName())) {
            registerCust.setName(StringTool.hiddenTelNo(registerCust.getTelNo()));
        }
        if (registerCust.getAgreement() == null) {
            registerCust.setAgreement(0);
        }
        Timestamp now = new Timestamp(System.currentTimeMillis());
        registerCust.setCreateTime(now);
        registerCust.setModTime(now);
        registerCust.setStatus(1);
        this.insert(registerCust);
    }

    /**
     * 通过密码登录
     * @param cust
     * @return
     * @throws DefineMsgException
     */
    @Override
    public Map<String, Object> addLoginByPwd(CustInfoPojo cust) throws DefineMsgException {
        // 检查是否已注册过
        CustInfoPojo currCust = new CustInfoPojo();
        currCust.setTelNo(cust.getTelNo());
        currCust = this.selectUnique(cust);

        try {
            // 账号不存在
            if (currCust == null) { throw new DefineMsgException(EResCodeCust.svceErrAccNoExistOrPwdError); }
            // 账号禁止登录
            if (!currCust.getStatus().equals(1)) { throw new DefineMsgException(EResCodeCust.svceErrAccIsDisable); }
            // 输错密码次数超限，账号被临时锁定
            if (currCust.getPwdErrTimes() >= loginErrTimes) { throw new DefineMsgException(EResCodeCust.svceErrLoginlocked); }
            // 校验密码
            if (!currCust.getLoginPwd().equals(cust.getLoginPwd())) { throw new DefineMsgException(EResCodeCust.svceErrLoginPwdError); }
        } catch (DefineMsgException e) {
            addLoginFail(cust, currCust);
            throw e;
        }

        return addLoginSucc(cust, currCust);
    }

    /**
     * 通过短信验证码登录
     * @param cust
     * @return
     * @throws DefineMsgException
     */
    @Override
    public Map<String, Object> addLoginBySms(CustInfoPojo cust) throws DefineMsgException {
        // 检查是否已注册过
        CustInfoPojo currCust = new CustInfoPojo();
        currCust.setTelNo(cust.getTelNo());
        currCust = this.selectUnique(cust);

        // 若未注册则先注册
        if (currCust == null) {
            addRegister(cust);
        }
        currCust = this.selectUnique(cust);

        try {
            // 账号禁止登录
            if (!currCust.getStatus().equals(1)) { throw new DefineMsgException(EResCodeCust.svceErrAccIsDisable); }
            // 输错密码次数超限，账号被临时锁定
            // TODO: 2018-12-05
//                if (currCust.getPwdErrTimes() >= loginErrTimes) { throw new DefineMsgException(EResCodeCust.svceErrLoginlocked); }
        } catch (DefineMsgException e) {
            addLoginFail(cust, currCust);
            throw e;
        }

        return addLoginSucc(cust, currCust);
    }

    /**
     * 登录成功
     * @param loginCust 前端传过来的登录用户信息
     * @param currCust 从数据库查出来的当前用户信息
     */
    private Map<String, Object> addLoginSucc(CustInfoPojo loginCust, CustInfoPojo currCust) {
        Timestamp now = new Timestamp(System.currentTimeMillis());

        try {
            // 设置微信OPENID
            if (StringUtils.isEmpty(currCust.getWxOpenId())) {
                Map<String, String> resMap = this.getWxOpenId(loginCust.getWxCode());
                CustInfoPojo c = new CustInfoPojo();
                c.setId(currCust.getId());
                c.setWxOpenId(resMap.get("openid"));
                c.setModTime(now);
                this.update(c);
                currCust.setWxOpenId(resMap.get("openid"));
            }
        } catch (CustomMsgException e) {
            logger.error("获取微信OPENID异常", e);
        }

        // 设置是否登录过APP
        if (!EDeviceType.LANDING.getVal().equals(loginCust.getDeviceType()) && currCust.getLoginByAppTime() == null) {
            CustInfoPojo c = new CustInfoPojo();
            c.setId(currCust.getId());
            c.setLoginByAppTime(now);
            c.setModTime(now);
            this.update(c);
        }

        // 重置登录失败次数
        if (currCust.getPwdErrTimes() > 0) {
            CustInfoPojo c = new CustInfoPojo();
            c.setId(currCust.getId());
            c.setPwdErrTimes(0);
            c.setModTime(now);
            this.update(c);
            currCust.setPwdErrTimes(0);
        }

        // 记录登录日志
        loginCust.setId(currCust.getId());
        custLoginLogService.insertByCustInfo(loginCust);

        // 设置当前用户会话，并返回Token
        String token = custSessionService.setCurrentCust(currCust);

        // 生成响应数据
        Map<String, Object> res = new HashMap<String, Object>();
        res.put("cust", currCust);
        res.put("userToken", token);
        res.put("sessionExp", 7200);
        return res;
    }

    /**
     * 登录失败
     * @param loginCust 前端传过来的登录用户信息
     * @param currCust 从数据库查出来的当前用户信息
     */
    private void addLoginFail(CustInfoPojo loginCust, CustInfoPojo currCust) {
        // 记录登录失败日志
        loginCust.setId(currCust.getId());
        custLoginFailLogService.insertByCustInfo(loginCust);
    }

    /**
     * 注册量按渠道查，每行一日期，每列一渠道
     * @param pojo
     * @return
     */
    @Override
    public List<Map<String, String>> getRegByCh(CustInfoPojo pojo) {
        return dao.getRegByCh(pojo);
    }

    /**
     * 注册量所有渠道，每行一渠道，只有一列合计
     * @param pojo
     * @return
     */
    @Override
    public List<Map<String, String>> getRegAll(CustInfoPojo pojo) {
        return dao.getRegAll(pojo);
    }

    /**
     * 首页注册数据
     * @return
     */
    @Override
    public Map<String, String> getRegistrationData() {
        return dao.getRegistrationData();
    }

    /**
     * 获取用户信息
     * @return
     */
    @Override
    public CustInfoPojo getById(CustInfoPojo pojo) {
        return dao.getById(pojo);
    }

    /**
     * 微信获取OPENID
     * @param code
     * @throws CustomMsgException
     */
    private Map<String, String> getWxOpenId(String code) throws CustomMsgException {
        String url = wxPayApi.getCodeToOpenidUrl(code);

        String resStr = null;
        try {
            logger.info("[微信支付] 获取OPENID接口请求 {}", url);
            resStr = HttpClientTool.get(url);
        } catch (Exception e) {
            logger.info("[微信支付] 获取OPENID接口异常", e);
            throw new CustomMsgException("发起微信支付失败");
        }

        Map<String, String> resMap = JSON.parseObject(resStr, new TypeReference<Map<String, String>>(){});
        logger.info("[微信支付] 获取OPENID接口响应 {}", resMap);

        return resMap;
    }
}
