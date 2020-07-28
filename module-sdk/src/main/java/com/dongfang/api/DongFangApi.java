package com.dongfang.api;

import com.alibaba.fastjson.JSON;
import com.dongfang.api.util.HttpUtils;
import com.dongfang.api.util.MD5Utils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 东方融资网接口
 *
 * @author jack
 */
public class DongFangApi {

    /**
     * 日志对象
     */
    protected static final Logger logger = LoggerFactory.getLogger(DongFangApi.class);

    public DongFangApi() {
    }

    /**
     * 测试地址
     */
    private final String URL = "http://58.210.85.58:19999/rzr/TransferV2/IsRegistered";

    private final String REGISTER_URL = "http://58.210.85.58:19999/rzr/TransferV2/Register";
    /**
     * 秘钥
     */
    private final String SECRET_KEY = "rongzi.com_8763!";

    /**
     * 校验用户是否已存在
     *
     * @param mobile
     * @param timeStamp
     * @return
     * @throws IOException
     */
    public String isRegistered(String mobile, String timeStamp) throws IOException {
        DongFangIsRegisteredReq req = new DongFangIsRegisteredReq();
        req.setCellPhoneNumber(MD5Utils.ecodeByMD5(mobile));
        // todo 时间是申请时间or当前时间
        req.setTimeStamp(MD5Utils.ecodeByMD5(timeStamp));
        req.setSignature(MD5Utils.ecodeByMD5(mobile + timeStamp + SECRET_KEY));
        String jsonString = JSON.toJSONString(req);
        logger.info("请求的json: " + jsonString);

        String resStr = HttpUtils.doPostByJson(URL, null, jsonString);
        if (StringUtils.isEmpty(resStr)) {
            logger.error("返回数据为空");
            throw new RuntimeException("返回数据为空");
        }
        logger.info("响应的信息: " + resStr);
//        DongFangIsRegisteredRes res = JSON.parseObject(resStr, DongFangIsRegisteredRes.class);
        return resStr;
    }

    public String register(String mobile, String timeStamp) throws IOException {
        Map<String,Object> param = new HashMap<>();
        param.put("UtmSource",20);
        param.put("EncryptionData",timeStamp);
        String jsonString = JSON.toJSONString(param);
        logger.info("请求的json: " + jsonString);

        String resStr = HttpUtils.doPostByJson(REGISTER_URL, null, jsonString);
        if (StringUtils.isEmpty(resStr)) {
            logger.error("返回数据为空");
            throw new RuntimeException("返回数据为空");
        }
        logger.info("响应的信息: " + resStr);
//        DongFangIsRegisteredRes res = JSON.parseObject(resStr, DongFangIsRegisteredRes.class);
        return resStr;
    }

}
