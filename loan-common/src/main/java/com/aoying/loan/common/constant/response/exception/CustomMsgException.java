package com.aoying.loan.common.constant.response.exception;

/**
 * 自定义消息内容异常
 * @author nick
 */
public class CustomMsgException extends Exception {
    public CustomMsgException() {
        super();
    }

    public CustomMsgException(String message) {
        super(message);
    }
}
