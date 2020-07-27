package com.aoying.loan.cust.tool.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.aoying.loan.cust.constant.EVerfCodeAndSmsTemplate;
import com.aoying.loan.cust.tool.service.iservice.ISmsSendService;
import com.aoying.loan.cust.util.MsgCenterTool;

/**
 * 短信发送 Service
 * @author nick
 */
public class SmsSendServiceWeLink implements ISmsSendService {
    /** 日志对象 */
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    private String SIGN = "【91贷款王】";

    private String USERNAME = "dlyxxx00";

    private String PASSWORD = "aoying0718";

    @Override
    public void sendVerfCode(String telNo, String paramJson, String template) throws Exception {
        String postData = this.encodeReq("1012888", telNo, paramJson, template).toString();
        String postUrl = "http://cf.51welink.com/submitdata/Service.asmx/g_Submit";
        String resStr = this.send(postData, postUrl);
        logger.info("短信发送结果 {}", resStr);
    }

    @Override
    public void sendSms(String telNo, String paramJson, String template) throws Exception {
        String postData = this.encodeReq("1012808", telNo, paramJson, template).toString();
        String postUrl = "http://cf.51welink.com/submitdata/Service.asmx/g_Submit";
        String resStr = this.send(postData, postUrl);
        logger.info("短信发送结果 {}", resStr);
    }

    private StringBuilder encodeReq(String prdId, String telNo, String paramJson, String template) throws UnsupportedEncodingException {
        String content = MsgCenterTool.replaceByJson(template, paramJson) + SIGN;
        content = URLEncoder.encode(content, "utf-8");

        StringBuilder urlBuilder = new StringBuilder();
        urlBuilder.append("sname=").append(USERNAME)
                .append("&spwd=").append(PASSWORD)
                .append("&scorpid=").append("")
                .append("&sprdid=").append(prdId)
                .append("&sdst=").append(telNo)
                .append("&smsg=").append(content);
        return urlBuilder;
    }

    private String send(String postData, String postUrl) {
        try {
            //发送POST请求
            URL url = new URL(postUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Connection", "Keep-Alive");
            conn.setUseCaches(false);
            conn.setDoOutput(true);

            conn.setRequestProperty("Content-Length", "" + postData.length());
            OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
            out.write(postData);
            out.flush();
            out.close();

            //获取响应状态
            if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
                System.out.println("connect failed!");
                return "";
            }
            //获取响应内容体
            String line, result = "";
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
            while ((line = in.readLine()) != null) {
                result += line + "\n";
            }
            in.close();
            return result;
        } catch (IOException e) {
            logger.error("微网短信发送异常", e);
        }
        return "";
    }

    public static void main(String[] args) throws Exception {
        String telNo = "15068189077";
        String paramJson = "{'verfCode':'1234'}";

        new SmsSendServiceWeLink().sendSms(telNo, paramJson, EVerfCodeAndSmsTemplate.REGISTER.getTemplate());
//        new SmsSendServiceWeLink().sendSms(telNo, null, ESmsTemplate.AuditRefused.getTemplate());
    }

}
