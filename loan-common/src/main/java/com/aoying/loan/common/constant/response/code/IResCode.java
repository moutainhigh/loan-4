package com.aoying.loan.common.constant.response.code;

import org.slf4j.Logger;
import com.aoying.loan.common.base.pojo.OptResult;

/**
 * @author nick
 */
public interface IResCode {
    int getCode();
    String getMsg();
    OptResult getOptResult(Logger logger);
    OptResult getOptResult(Logger logger, Object otherMsg);
    OptResult getOptResult(Logger logger, Object otherMsg, Exception e);
}
