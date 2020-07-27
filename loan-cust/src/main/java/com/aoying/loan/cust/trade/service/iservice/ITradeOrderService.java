package com.aoying.loan.cust.trade.service.iservice;

import java.util.List;
import java.util.Map;
import com.aoying.loan.common.base.service.iservice.IBaseService;
import com.aoying.loan.cust.cust.pojo.CustInfoPojo;
import com.aoying.loan.cust.trade.pojo.TradeOrderPojo;

/**
 * 交易订单 IService
 * @author nick
 */
public interface ITradeOrderService extends IBaseService<TradeOrderPojo> {
    /**
     * 新增订单
     * @param order
     * @return
     */
    public TradeOrderPojo add(TradeOrderPojo order) throws Exception;

    /**
     * 更新支付结果，用于支付结果返回后
     * @param map
     * @param isCallback
     * @return
     */
    public TradeOrderPojo update(Map<String, String> map, boolean isCallback) throws Exception;

    /**
     * 更新支付结果并获取单个
     * @param cust
     * @param order
     * @return
     */
    public TradeOrderPojo updateAndGet(CustInfoPojo cust, TradeOrderPojo order) throws Exception;

    /**
     * 更新支付结果并获取列表，仅更新最后一个
     * @param cust
     * @param order
     * @return
     */
    public List<TradeOrderPojo> updateAndGetList(CustInfoPojo cust, TradeOrderPojo order) throws Exception;

    /**
     * 获取订单详情，包括运营商、明镜SDK、全景雷达报告
     * @param order
     */
    public void getDetail(TradeOrderPojo order);
}
