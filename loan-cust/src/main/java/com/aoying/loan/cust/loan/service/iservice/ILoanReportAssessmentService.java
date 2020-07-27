package com.aoying.loan.cust.loan.service.iservice;

import com.aoying.loan.common.base.service.iservice.IBaseService;
import com.aoying.loan.common.constant.response.exception.CustomMsgException;
import com.aoying.loan.cust.cust.pojo.CustInfoPojo;
import com.aoying.loan.cust.loan.pojo.LoanReportAssessmentPojo;

/**
 * 贷款报告之明镜 IService
 * @author nick
 */
public interface ILoanReportAssessmentService extends IBaseService<LoanReportAssessmentPojo> {
    /**
     * 明镜评估
     * @param custId
     * @param orderId
     * @param resStr
     */
    public void add(Long custId, Long orderId, String resStr);
}
