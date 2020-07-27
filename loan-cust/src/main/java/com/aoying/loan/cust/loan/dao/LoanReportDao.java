package com.aoying.loan.cust.loan.dao;

import java.util.Map;
import org.springframework.stereotype.Repository;
import com.aoying.loan.common.base.dao.BaseDao;
import com.aoying.loan.cust.loan.pojo.LoanReportPojo;

/**
 * 贷款报告 Dao
 * @author nick
 */
@Repository
public class LoanReportDao extends BaseDao<LoanReportPojo> {
    /**
     * 根据CustId查询今日报告次数
     * @param pojo
     * @return
     */
    public int selectTodayNumByCustId(LoanReportPojo pojo) {
        return this.template.selectOne(getFullMapperId("selectTodayNumByCustId"), pojo);
    }

    /**
     * 首页报告数据
     * @return
     */
    public Map<String, String> getReportData() {
        return this.template.selectOne(getFullMapperId("getReportData"));
    }
}
