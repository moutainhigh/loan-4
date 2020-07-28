package com.dongfang.api;

import com.alibaba.fastjson.annotation.JSONField;
import com.aoying.module.sdk.base.BasePojo;

/**
 * 东方融资网检查用户是否存在请求类
 *
 * @author jack
 */
public class DongFangIsRegisteredReq extends BasePojo {
    /**
     * 手机号
     */
    @JSONField(name = "CellPhoneNumber")
    private String cellPhoneNumber;
    /**
     * 时间戳
     */
    @JSONField(name = "TimeStamp", format = "yyyyMMddHHmmss")
    private String timeStamp;
    /**
     * 数字签名
     */
    @JSONField(name = "Signature")
    private String signature;

    public String getCellPhoneNumber() {
        return cellPhoneNumber;
    }

    public void setCellPhoneNumber(String cellPhoneNumber) {
        this.cellPhoneNumber = cellPhoneNumber;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
