package com.aoying.loan.cust.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import com.aoying.loan.common.base.pojo.OptResult;
import com.aoying.loan.common.base.pojo.ResponseData;
import com.aoying.loan.common.constant.response.code.EResCodeCust;
import com.aoying.loan.common.constant.response.exception.CustomMsgException;
import com.aoying.loan.common.constant.response.exception.DefineMsgException;

/**
 * 全局异常处理类
 * @author nick
 */
@Controller
@ControllerAdvice
public class GlobalExceptionHandler {
    /** 日志对象 */
    protected static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 默认异常
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseData defaultExceptionHandler(Exception e) {
        logger.error("", e);
        OptResult info = EResCodeCust.svceErrRegister.getOptResult(logger);
        return new ResponseData<>(info, null);
    }

    /**
     * 枚举定义消息内容异常
     * @param e
     * @return
     */
    @ExceptionHandler(value = DefineMsgException.class)
    @ResponseBody
    public ResponseData defineMsgExceptionHandler(DefineMsgException e) {
        logger.error("", e);
        OptResult info = e.getCode().getOptResult(logger);
        return new ResponseData<>(info, null);
    }

    /**
     * 自定义消息内容异常
     * @param e
     * @return
     */
    @ExceptionHandler(value = CustomMsgException.class)
    @ResponseBody
    public ResponseData customMsgExceptionHandler(CustomMsgException e) {
        logger.error("", e);
        OptResult info = new OptResult(-1, e.getMessage());
        return new ResponseData<>(info, null);
    }
}
