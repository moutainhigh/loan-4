package com.aoying.loan.cust.loan.service.iservice;

import java.util.List;
import java.util.Map;
import com.aoying.loan.common.base.service.iservice.IBaseService;
import com.aoying.loan.cust.loan.pojo.LoanProductClickLogPojo;

/**
 * 贷款产品点击日志 IService
 * @author nick
 */
public interface ILoanProductClickLogService extends IBaseService<LoanProductClickLogPojo> {
    /**
     * 获取所有统计数据
     * @param pojo
     * @return
     */
    public List<Map<String, String>> getAll(LoanProductClickLogPojo pojo);

    /**
     * 获取渠道点击量
     * @param pojo
     * @return
     */
    public List<Map<String, String>> getChClick(LoanProductClickLogPojo pojo);

    /**
     * 获取产品点击量
     * @param pojo
     * @return
     */
    public List<Map<String, String>> getProClick(LoanProductClickLogPojo pojo);
}
