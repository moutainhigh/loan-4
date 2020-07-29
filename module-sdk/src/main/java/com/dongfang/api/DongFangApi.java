package com.dongfang.api;

import com.alibaba.fastjson.JSON;
import com.dongfang.api.util.AesUtil;
import com.dongfang.api.util.HttpUtils;
import com.dongfang.api.util.MD5Utils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

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
    public DongFangIsRegisteredRes isRegistered(String mobile, String timeStamp) {
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
        DongFangIsRegisteredRes res = JSON.parseObject(resStr, DongFangIsRegisteredRes.class);
        return res;
    }


    public DongFangIsRegisteredRes register(String mobile) {


        int UtmSource = 581;

        User user = new User(); //组装用户信息
        user.setCityName("shanghai");
        user.setCellPhoneNumber("17717663280");
        user.setRealName("张三");
        user.setLoanAmount(8);
        user.setUtmSource(UtmSource);
        user.setTimeStamp("20160829181857");


        String md5Pass = MD5Utils.ecodeByMD5(user.getCityName()
                + user.getCellPhoneNumber()
                + user.getRealName()
                + user.getLoanAmount()
                + user.getUtmSource()
                + user.getTimeStamp()
                + "rongzi.com_8763!");
        user.setSignature(md5Pass);
        String userStr = JSON.toJSONString(user);
//        String encryptStr = AesUtil.encryptAES("{\"CityName\":\"SHENZHEN\",\"CellPhoneNumber\":\"16625148159\",\"RealName\":\"\\u6e29\\u9e4f\\u7a0b\",\"LoanAmount\":5,\"UtmSource\":581,\"TimeStamp\":\"20200511153950\",\"Signature\":\"48025cb957182b6d1fece7229f732511\"}", "rongzi.com_8763!");//加密
        String encryptStr = AesUtil.encryptAES(userStr, "rongzi.com_8763!");
        TransferRegisterRequest transferRegisterRequest = new TransferRegisterRequest();//组装发送请求
        transferRegisterRequest.setUtmSource(UtmSource);
        transferRegisterRequest.setEncryptionData(encryptStr);
        logger.info("请求东方融资网注册的参数: " + transferRegisterRequest);
        String resStr = HttpUtils.doPostByJson(REGISTER_URL, null, JSON.toJSONString(transferRegisterRequest));
//        String data =postData("http://58.210.85.58:19999/TransferV2/Register",JSON.toJSONString(transferRegisterRequest));


//        Map<String,Object> param = new HashMap<>();
//        param.put("UtmSource",20);
//        param.put("EncryptionData",timeStamp);
//        String jsonString = JSON.toJSONString(param);
//        logger.info("请求的json: " + jsonString);
//
//        String resStr = HttpUtils.doPostByJson(REGISTER_URL, null, jsonString);
        if (StringUtils.isEmpty(resStr)) {
            logger.error("请求东方融资网注册返回数据为空");
            throw new RuntimeException("请求东方融资网注册返回数据为空");
        }
        logger.info("请求东方融资网注册的响应: " + resStr);
        DongFangIsRegisteredRes res = JSON.parseObject(resStr, DongFangIsRegisteredRes.class);
        if (!DongFangIsRegisteredRes.ErrorCode.SUCC.getError().equals(res.getCode())){
            throw new RuntimeException("请求东方融资网注册调用失败：" + DongFangIsRegisteredRes.ErrorCode.of(res.getCode()));
        }
        return res;
    }

    public static void main(String[] args) {
//        new DongFangApi().isRegistered("17717663280", Timestamp.valueOf(LocalDateTime.now()).toString());
        new DongFangApi().register("17717663280");
    }

}
