package com.aoying.loan.cust.trade.service;

import org.springframework.stereotype.Service;
import com.aoying.loan.common.base.service.BaseService;
import com.aoying.loan.cust.trade.dao.TradeGoodsDao;
import com.aoying.loan.cust.trade.pojo.TradeGoodsPojo;
import com.aoying.loan.cust.trade.service.iservice.ITradeGoodsService;

/**
 * 交易商品 Service
 * @author nick
 */
@Service
public class TradeGoodsService extends BaseService<TradeGoodsPojo, TradeGoodsDao> implements ITradeGoodsService {
    @Override
    public int updateApplyNum() {
        return dao.updateApplyNum();
    }
}
