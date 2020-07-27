package com.aoying.loan.cust.trade.service.iservice;

import com.aoying.loan.common.base.service.iservice.IBaseService;
import com.aoying.loan.cust.trade.pojo.TradeGoodsPojo;

/**
 * 交易商品 IService
 * @author nick
 */
public interface ITradeGoodsService extends IBaseService<TradeGoodsPojo> {
    int updateApplyNum();
}
