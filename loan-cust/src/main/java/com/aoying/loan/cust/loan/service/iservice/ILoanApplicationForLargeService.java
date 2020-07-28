package com.aoying.loan.cust.loan.service.iservice;

import com.aoying.loan.common.base.service.iservice.IBaseService;
import com.aoying.loan.cust.loan.pojo.LoanApplicationForLargePojo;
import com.aoying.loan.cust.sys.pojo.SysAuthInfoPojo;

/**
 * 大额贷款申请 IService
 * @author nick
 */
public interface ILoanApplicationForLargeService extends IBaseService<LoanApplicationForLargePojo> {
    /**
     * 大额申请提交
     * 未提交过则插入，已提交过则更新
     * @param application
     */
    public void addOrUpdate(LoanApplicationForLargePojo application, SysAuthInfoPojo authInfo);

    /**
     * 根据id查询大额申请信息
     * @param id
     * @return
     */
    public LoanApplicationForLargePojo selectById(Long id);
}
