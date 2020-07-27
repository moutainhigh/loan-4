package com.aoying.loan.cust.loan.service.iservice;

import java.util.List;
import com.aoying.loan.common.base.service.iservice.IBaseService;
import com.aoying.loan.common.constant.response.exception.CustomMsgException;
import com.aoying.loan.cust.cust.pojo.CustInfoPojo;
import com.aoying.loan.cust.loan.pojo.LoanApplicationPojo;

/**
 * 贷款申请 IService
 * @author nick
 */
public interface ILoanApplicationService extends IBaseService<LoanApplicationPojo> {
    /**
     * 提交贷款申请，修改数据状态
     * @param cust
     * @return
     */
    void updateSubmit(CustInfoPojo cust) throws CustomMsgException;

    /**
     * 新增贷款申请
     * @param application
     * @return
     * @throws CustomMsgException
     */
    LoanApplicationPojo add(LoanApplicationPojo application) throws CustomMsgException;

    /**
     * 拒绝指定时间之前的申请，并返回用户手机号
     * @param min
     * @return
     */
    List<LoanApplicationPojo> updateAndGetApplyAuditRefused(Integer min);
}
