package com.aoying.loan.cust.tool.service;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;
import com.aoying.loan.common.config.redis.BaseRedisDao;
import com.aoying.loan.common.constant.eenum.EDeviceType;
import com.aoying.loan.common.constant.eenum.ERedisCacheKey;
import com.aoying.loan.common.constant.response.code.EResCodeCommon;
import com.aoying.loan.common.constant.response.exception.CustomMsgException;
import com.aoying.loan.common.constant.response.exception.DefineMsgException;
import com.aoying.loan.common.util.Base64Util;
import com.aoying.loan.common.util.ImageTool;
import com.aoying.loan.common.util.StringTool;
import com.aoying.loan.cust.constant.EVerfCodeAndSmsTemplate;
import com.aoying.loan.cust.cust.pojo.CustInfoPojo;
import com.aoying.loan.cust.cust.service.iservice.ICustInfoService;
import com.aoying.loan.cust.tool.service.iservice.ISmsSendService;

/**
 * 验证码 Service
 * @author nick
 */
@Service
@ConfigurationProperties(prefix = "sysCfg.verfCodeService")
public class VerfCodeService {
    /** 日志对象 */
    protected static final Logger logger = LoggerFactory.getLogger(VerfCodeService.class);

    /** 是否发布模式 */
    @Value("${sysCfg.isRelease}")
    private boolean isRelease;

    /** 静态图片验证码长度 */
    private int staticPicVerfCodeLength;
    /** 静态图片验证码过期时间，单位分钟 */
    private int staticPicVerfCodeExp;
    /** 短信验证码长度 */
    private int smsVerfCodeLength;
    /** 短信验证码过期时间，单位分钟 */
    private int smsVerfCodeExp;

    @Autowired
    @Qualifier("baseRedisDaoDef")
    private BaseRedisDao baseRedisDao;
    @Autowired
    private ISmsSendService smsSendService;
    @Autowired
    private ICustInfoService custInfoService;

    /**
     * 获取点选图片验证码
     */
    public void getClickPicVerfCode() {

    }

    /**
     * 校验点选图片验证码
     * @return
     */
    public void checkClickPicVerfCode() {
        
    }

    /**
     * 获取静态图片验证码
     * @param deviceType
     * @param codeFlag
     * @return
     */
    public String getStaticPicVerfCode(Integer deviceType, String codeFlag) {
        // 根据设备类型，判断是否需要图形验证码
        if (!EDeviceType.getPicVerfCode(deviceType)) {
            return null;
        }

        BufferedImage img = null;
        if (StringUtils.isNotEmpty(codeFlag)) {
            // 产生验证码图片
            char[] chars = ImageTool.getNumArray(staticPicVerfCodeLength);
            img = ImageTool.createRandVerifImage(chars);

            // 存入redis
            String key = ERedisCacheKey.VERF_CODE_OF_STATIC_PIC.getVal() + codeFlag;
            baseRedisDao.saveOrUpdate(key, new String(chars), staticPicVerfCodeExp);
        } else {
            // 产生一个空的图片
            img = ImageTool.createBlankVerifImage(staticPicVerfCodeLength);
        }

        return Base64Util.bufferedImageToBase64String(img);
    }

    /**
     * 校验静态图片验证码
     * @param deviceType
     * @param codeFlag
     * @param verfCode
     * @throws CustomMsgException
     */
    public void checkStaticPicVerfCode(Integer deviceType, String codeFlag, String verfCode) throws CustomMsgException {
        // 根据设备类型，判断是否需要图形验证码
        if (!EDeviceType.getPicVerfCode(deviceType)) {
            return;
        }

        String key = ERedisCacheKey.VERF_CODE_OF_STATIC_PIC.getVal() + codeFlag;
        String redisCode = baseRedisDao.get(key, String.class);
        if (redisCode == null || !redisCode.equalsIgnoreCase(verfCode)) {
            // TODO: 2018-12-05
            throw new CustomMsgException("图形验证码不正确");
        }
    }

    /**
     * 获取短信验证码
     * @param type
     * @param telNo
     * @param realSend
     * @return
     */
    public String getSmsVerfCode(Integer type, String telNo, Boolean realSend,
                                 Integer deviceType, String codeFlag, String picCode) throws Exception {
        Map<String, Object> resultMap = new HashMap<>();

        // 检查是否已注册过
        CustInfoPojo cust = new CustInfoPojo();
        cust.setTelNo(telNo);
        cust = custInfoService.selectUnique(cust);
        // TODO: 2018-12-05

        // 发送限制检查
        realSend = realSend == null || realSend || isRelease;
        // TODO: 2018-12-05

        // 校验图片验证码
        EVerfCodeAndSmsTemplate eType = EVerfCodeAndSmsTemplate.getStatusMap().get(type);
        if (eType.getPicVerfCode()) { checkStaticPicVerfCode(deviceType, codeFlag, picCode); }

        // 产生验证码
        String verfCode = StringTool.bringValidateCode(smsVerfCodeLength);
        // 存入redis
        String key = ERedisCacheKey.VERF_CODE_OF_SMS.getVal() + eType.getType() + "_" + telNo;
        baseRedisDao.saveOrUpdate(key, verfCode, smsVerfCodeExp);

        // 发送短信
        if (realSend) {
            // TODO: 2018-12-05
            smsSendService.sendVerfCode(telNo, "{'verfCode':'"+verfCode+"'}", eType.getTemplate());
        }

        return verfCode;
    }

    /**
     * 校验短信验证码
     * @param type
     * @param telNo
     * @param verfCode
     * @return
     */
    public void checkSmsVerfCode(Integer type, String telNo, String verfCode) throws DefineMsgException {
        EVerfCodeAndSmsTemplate eType = EVerfCodeAndSmsTemplate.getStatusMap().get(type);
        String key = ERedisCacheKey.VERF_CODE_OF_SMS.getVal() + eType.getType() + "_" + telNo;
        String redisCode = baseRedisDao.get(key, String.class);
        if (redisCode == null || !redisCode.equalsIgnoreCase(verfCode)) {
            throw new DefineMsgException(EResCodeCommon.svceErrSmsVerCode);
        }
    }

    /** 设置 静态图片验证码长度 */
    public void setStaticPicVerfCodeLength(int staticPicVerfCodeLength) {
        this.staticPicVerfCodeLength = staticPicVerfCodeLength;
    }

    /** 设置 静态图片验证码过期时间，单位分钟 */
    public void setStaticPicVerfCodeExp(int staticPicVerfCodeExp) {
        this.staticPicVerfCodeExp = staticPicVerfCodeExp * 60;
    }

    /** 设置 短信验证码长度 */
    public void setSmsVerfCodeLength(int smsVerfCodeLength) {
        this.smsVerfCodeLength = smsVerfCodeLength;
    }

    /** 设置 短信验证码过期时间，单位分钟 */
    public void setSmsVerfCodeExp(int smsVerfCodeExp) {
        this.smsVerfCodeExp = smsVerfCodeExp * 60;
    }
}
