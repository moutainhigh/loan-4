package com.aoying.loan.cust.tool.service;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.aoying.loan.common.constant.response.exception.CustomMsgException;
import com.aoying.loan.common.util.HttpClientTool;
import com.aoying.loan.common.util.StringTool;
import com.aoying.loan.cust.constant.ESmsTemplate;
import com.aoying.loan.cust.tool.service.iservice.ISmsSendService;
import com.aoying.loan.cust.util.MsgCenterTool;

/**
 * 短信发送 Service
 * @author nick
 */
public class SmsSendService1086 implements ISmsSendService {
    /** 日志对象 */
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    private String SIGN = "【91贷款王】";

    private String USERNAME = "51yanzhengma";

    private String PASSWORD = "54B21A7E";

    private String URL_SEND_SMS = "http://api.sms1086.com/Api/Send.aspx";

    private String URL_SEND_VERF_CODE = "http://api.sms1086.com/Api/verifycode.aspx";

    @Override
    public void sendVerfCode(String telNo, String paramJson, String template) throws Exception {
        StringBuilder url = this.encodeReq(URL_SEND_VERF_CODE, telNo, paramJson, template);
        String resStr = HttpClientTool.get(url.toString());
        decodeRes(resStr);
    }

    @Override
    public void sendSms(String telNo, String paramJson, String template) throws Exception {
        StringBuilder url = this.encodeReq(URL_SEND_SMS, telNo, paramJson, template);
        String resStr = HttpClientTool.get(url.toString());
        decodeRes(resStr);
    }

    private StringBuilder encodeReq(String url, String telNo, String paramJson, String template) throws UnsupportedEncodingException {
        String content = MsgCenterTool.replaceByJson(template, paramJson) + SIGN;
        content = URLEncoder.encode(content, "GB2312");

        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String username = USERNAME;
        String password = StringTool.MD5Encode(PASSWORD + timestamp, false);
        timestamp = timestamp.replaceAll(" ", "%20");

        StringBuilder urlBuilder = new StringBuilder();
        urlBuilder.append(url)
                .append("?username=").append(username)
                .append("&password=").append(password)
                .append("&mobiles=").append(telNo)
                .append("&content=").append(content)
                .append("&timestamp=").append(timestamp);
        return urlBuilder;
    }

    private void decodeRes(String resStr) throws UnsupportedEncodingException, CustomMsgException {
        resStr = URLDecoder.decode(resStr, "GB2312");

        Map<String, String> resMap = new HashMap<String, String>();
        String[] resArr = resStr.split("&");
        for (String res : resArr) {
            resMap.put(res.split("=")[0], res.split("=")[1]);
        }
        logger.info("短信发送结果 {}", resMap);

        if (!"0".equals(resMap.get("result"))) {
            throw new CustomMsgException("短信发送失败");
        }
    }

    public static void main(String[] args) throws Exception {
        String telNo = "15068189077";
        String paramJson = "{'verfCode':'5678'}";

//        new SmsSendService().sendVerfCode(telNo, paramJson, EVerfCodeAndSmsTemplate.REGISTER.getTemplate());
//        new SmsSendService().sendSms(telNo, paramJson, EVerfCodeAndSmsTemplate.REGISTER.getTemplate());
        new SmsSendService1086().sendSms(telNo, null, ESmsTemplate.AuditRefused.getTemplate());
    }
}
