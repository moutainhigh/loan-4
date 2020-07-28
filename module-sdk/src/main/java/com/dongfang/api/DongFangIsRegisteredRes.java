package com.dongfang.api;

import com.alibaba.fastjson.annotation.JSONField;
import com.aoying.module.sdk.base.BasePojo;

/**
 * 东方融资网检查用户是否存在响应类
 *
 * @author jack
 */
public class DongFangIsRegisteredRes extends BasePojo {
    /**
     * 是否注册
     */
    @JSONField(name = "IsRegistered")
    private boolean isRegistered;
    /**
     * 错误代码
     */
    @JSONField(name = "Code")
    private String code;
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

    public boolean isRegistered() {
        return isRegistered;
    }

    public void setRegistered(boolean registered) {
        isRegistered = registered;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
