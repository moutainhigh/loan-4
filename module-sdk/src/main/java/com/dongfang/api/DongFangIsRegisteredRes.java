package com.dongfang.api;

import com.alibaba.fastjson.annotation.JSONField;
import com.aoying.module.sdk.base.BasePojo;

import java.util.stream.Stream;

/**
 * 东方融资网检查用户是否存在响应类
 *
 * @author jack
 */
public class DongFangIsRegisteredRes extends BasePojo {

    public enum ErrorCode {
        SUCC("0", "成功"),
        FAIL("1", "失败"),
        ILLEGAL_SIGN("3", "签名不合法"),
        ILLEGAL_IP("4", "非法ip"),
        CHANNEL_FULL("5", "渠道已满"),
        CITY_FULL("6", "城市已满");

        private String error;
        private String msg;

        ErrorCode(String error, String msg) {
            this.error = error;
            this.msg = msg;
        }

        public String getError() {
            return error;
        }

        public String getMsg() {
            return msg;
        }

        public static ErrorCode of(String error) {
            return Stream.of(ErrorCode.values()).filter(f -> f.getError().equals(error)).findFirst()
                    .orElseThrow(IllegalArgumentException::new);
        }
    }

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
     * 登录凭证
     */
    @JSONField(name = "Token")
    private String token;
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

    public boolean getIsRegistered() {
        return isRegistered;
    }

    public void setIsRegistered(boolean registered) {
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
