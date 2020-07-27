package com.aoying.loan.cust.trade.dao;

import org.springframework.stereotype.Repository;
import com.aoying.loan.common.base.dao.BaseDao;
import com.aoying.loan.cust.trade.pojo.TradeGoodsPojo;

/**
 * 交易商品 Dao
 * @author nick
 */
@Repository
public class TradeGoodsDao extends BaseDao<TradeGoodsPojo> {
    public int updateApplyNum() {
        return template.update(getFullMapperId("updateApplyNum"));
    }
}
