package com.aoying.loan.cust.cust.dao;

import org.springframework.stereotype.Repository;
import com.aoying.loan.common.base.dao.BaseDao;
import com.aoying.loan.cust.cust.pojo.CustIdCardLogPojo;

/**
 * 用户实名日志表 Dao
 * @author nick
 */
@Repository
public class CustIdCardLogDao extends BaseDao<CustIdCardLogPojo> {
    /**
     * 根据CustId查询今日实名校验次数
     * @param pojo
     * @return
     */
    public int selectTodayNumByCustId(CustIdCardLogPojo pojo) {
        return this.template.selectOne(getFullMapperId("selectTodayNumByCustId"), pojo);
    }

    /**
     * 根据IdCardCode查询一条成功的数据
     * @param pojo
     * @return
     */
    public CustIdCardLogPojo selectSuccOneByIdCardCode(CustIdCardLogPojo pojo) {
        return this.template.selectOne(getFullMapperId("selectSuccOneByIdCardCode"), pojo);
    }
}
