package com.aoying.loan.cust.tool.service.iservice;

/**
 * 短信发送 IService
 * @author nick
 */
public interface ISmsSendService {
    public void sendVerfCode(String telNo, String paramJson, String template) throws Exception;

    public void sendSms(String telNo, String paramJson, String template) throws Exception;
}
