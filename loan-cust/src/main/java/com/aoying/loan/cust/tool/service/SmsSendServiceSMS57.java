package com.aoying.loan.cust.tool.service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.aoying.loan.common.util.HttpClientTool;
import com.aoying.loan.common.util.StringTool;
import com.aoying.loan.cust.constant.EVerfCodeAndSmsTemplate;
import com.aoying.loan.cust.tool.service.iservice.ISmsSendService;
import com.aoying.loan.cust.util.MsgCenterTool;

/**
 * 短信发送 Service
 * @author nick
 */
@Service("SmsSendService")
public class SmsSendServiceSMS57 implements ISmsSendService {
    /** 日志对象 */
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    private String SIGN = "【好帮帮】";

    private String USERNAME = "900026";

    private String PASSWORD = "123456";

    private String EXTNO = "106907";

    private String URL_SEND_VERF_CODE = "http://39.98.72.106:7862/sms";

    @Override
    public void sendVerfCode(String telNo, String paramJson, String template) throws Exception {
        StringBuilder url = this.encodeReq(URL_SEND_VERF_CODE, telNo, paramJson, template);
        String resStr = HttpClientTool.get(url.toString());
        logger.info("短信发送结果 {}", resStr);
    }

    @Override
    public void sendSms(String telNo, String paramJson, String template) throws Exception {
    }

    private StringBuilder encodeReq(String url, String telNo, String paramJson, String template) throws UnsupportedEncodingException {
        String content = SIGN + MsgCenterTool.replaceByJson(template, paramJson);
        content = URLEncoder.encode(content, "UTF-8");

        String password = StringTool.MD5Encode(PASSWORD + EXTNO + content + telNo, false);

        StringBuilder urlBuilder = new StringBuilder();
        urlBuilder.append(url)
                .append("?action=").append("send")
                .append("&account=").append(USERNAME)
                .append("&password=").append(PASSWORD)
                .append("&mobile=").append(telNo)
                .append("&content=").append(content)
                .append("&extno=").append(EXTNO)
                .append("&rt=").append("json");
        return urlBuilder;
    }

    public static void main(String[] args) throws Exception {
        String telNo = "15068189077";
        String paramJson = "{'verfCode':'1234'}";

        new SmsSendServiceSMS57().sendVerfCode(telNo, paramJson, EVerfCodeAndSmsTemplate.REGISTER.getTemplate());
    }

}
