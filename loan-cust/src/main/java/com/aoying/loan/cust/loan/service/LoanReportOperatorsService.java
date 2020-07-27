package com.aoying.loan.cust.loan.service;

import org.springframework.stereotype.Service;
import com.aoying.loan.common.base.service.BaseService;
import com.aoying.loan.cust.loan.dao.LoanReportOperatorsDao;
import com.aoying.loan.cust.loan.pojo.LoanReportOperatorsPojo;
import com.aoying.loan.cust.loan.service.iservice.ILoanReportOperatorsService;

/**
 * 贷款报告之运营商 Service
 * @author nick
 */
@Service
public class LoanReportOperatorsService extends BaseService<LoanReportOperatorsPojo, LoanReportOperatorsDao> implements ILoanReportOperatorsService {
}
