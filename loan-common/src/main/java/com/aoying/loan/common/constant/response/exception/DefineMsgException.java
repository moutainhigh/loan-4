package com.aoying.loan.common.constant.response.exception;

import com.aoying.loan.common.constant.response.code.EResCodeCommon;
import com.aoying.loan.common.constant.response.code.EResCodeCust;
import com.aoying.loan.common.constant.response.code.IResCode;

/**
 * 枚举定义消息内容异常
 * @author nick
 */
public class DefineMsgException extends Exception {
    private IResCode resCode;

    public DefineMsgException() {
        super();
    }

    public DefineMsgException(EResCodeCommon resCode) {
        super();
        this.resCode = resCode;
    }

    public DefineMsgException(EResCodeCust resCode) {
        super();
        this.resCode = resCode;
    }

    public IResCode getCode() {
        return this.resCode;
    }

    public void setCode(IResCode resCode) {
        this.resCode = resCode;
    }
}
