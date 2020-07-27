package com.aoying.loan.cust.loan.service.iservice;

import java.io.IOException;
import java.util.Map;
import com.aoying.loan.common.base.service.iservice.IBaseService;
import com.aoying.loan.common.constant.response.exception.DefineMsgException;
import com.aoying.loan.cust.loan.pojo.LoanReportPojo;

/**
 * 贷款报告 IService
 * @author nick
 */
public interface ILoanReportService extends IBaseService<LoanReportPojo> {
    /**
     * 检查是否需要更新报告
     * @param custId
     * @return
     */
    public Boolean checkUpdatable(Long custId);

    /**
     * 全景雷达
     * @param loanReport
     * @throws DefineMsgException
     * @throws IOException
     */
    public LoanReportPojo add(LoanReportPojo loanReport) throws DefineMsgException, IOException;

    /**
     * 首页报告数据
     * @return
     */
    public Map<String, String> getReportData();
}
