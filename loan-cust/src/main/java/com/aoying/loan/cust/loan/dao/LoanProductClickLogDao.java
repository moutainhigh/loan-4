package com.aoying.loan.cust.loan.dao;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import com.aoying.loan.common.base.dao.BaseDao;
import com.aoying.loan.cust.loan.pojo.LoanProductClickLogPojo;

/**
 * 贷款产品点击日志 Dao
 * @author nick
 */
@Repository
public class LoanProductClickLogDao extends BaseDao<LoanProductClickLogPojo> {
    /**
     * 获取所有统计数据
     * @param pojo
     * @return
     */
    public List<Map<String, String>> getAll(LoanProductClickLogPojo pojo) {
        return this.template.selectList(getFullMapperId("getAll"), pojo);
    }

    /**
     * 获取渠道点击量
     * @param pojo
     * @return
     */
    public List<Map<String, String>> getChClick(LoanProductClickLogPojo pojo) {
        return this.template.selectList(getFullMapperId("getChClick"), pojo);
    }

    /**
     * 获取产品点击量
     * @param pojo
     * @return
     */
    public List<Map<String, String>> getProClick(LoanProductClickLogPojo pojo) {
        return this.template.selectList(getFullMapperId("getProClick"), pojo);
    }
}
