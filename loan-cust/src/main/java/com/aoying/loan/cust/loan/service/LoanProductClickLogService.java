package com.aoying.loan.cust.loan.service;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import com.aoying.loan.common.base.service.BaseService;
import com.aoying.loan.cust.loan.dao.LoanProductClickLogDao;
import com.aoying.loan.cust.loan.pojo.LoanProductClickLogPojo;
import com.aoying.loan.cust.loan.service.iservice.ILoanProductClickLogService;

/**
 * 贷款产品点击日志 Service
 * @author nick
 */
@Service
public class LoanProductClickLogService extends BaseService<LoanProductClickLogPojo, LoanProductClickLogDao> implements ILoanProductClickLogService {
    /**
     * 获取所有统计数据
     * @param pojo
     * @return
     */
    @Override
    public List<Map<String, String>> getAll(LoanProductClickLogPojo pojo) {
        return dao.getAll(pojo);
    }

    /**
     * 获取渠道点击量
     * @param pojo
     * @return
     */
    @Override
    public List<Map<String, String>> getChClick(LoanProductClickLogPojo pojo) {
        return dao.getChClick(pojo);
    }

    /**
     * 获取产品点击量
     * @param pojo
     * @return
     */
    @Override
    public List<Map<String, String>> getProClick(LoanProductClickLogPojo pojo) {
        return dao.getProClick(pojo);
    }
}
