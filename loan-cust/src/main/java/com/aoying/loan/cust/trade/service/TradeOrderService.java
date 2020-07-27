package com.aoying.loan.cust.trade.service;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSON;
import com.aoying.loan.common.base.service.BaseService;
import com.aoying.loan.common.constant.response.exception.CustomMsgException;
import com.aoying.loan.cust.cust.pojo.CustInfoPojo;
import com.aoying.loan.cust.cust.service.iservice.ICustInfoService;
import com.aoying.loan.cust.loan.pojo.LoanReportAssessmentPojo;
import com.aoying.loan.cust.loan.pojo.LoanReportOperatorsPojo;
import com.aoying.loan.cust.loan.pojo.LoanReportPojo;
import com.aoying.loan.cust.loan.service.iservice.ILoanReportAssessmentService;
import com.aoying.loan.cust.loan.service.iservice.ILoanReportOperatorsService;
import com.aoying.loan.cust.loan.service.iservice.ILoanReportService;
import com.aoying.loan.cust.trade.dao.TradeOrderDao;
import com.aoying.loan.cust.trade.pojo.TradeGoodsPojo;
import com.aoying.loan.cust.trade.pojo.TradeOrderPojo;
import com.aoying.loan.cust.trade.service.iservice.ITradeGoodsService;
import com.aoying.loan.cust.trade.service.iservice.ITradeOrderService;
import com.github.wxpay.sdk.WXPay;

/**
 * 交易订单 Service
 * @author nick
 */
@Service
public class TradeOrderService extends BaseService<TradeOrderPojo, TradeOrderDao> implements ITradeOrderService {
    @Autowired
    private WXPay wxPayApi;
    @Autowired
    private ILoanReportOperatorsService loanReportOperatorsService;
    @Autowired
    private ILoanReportAssessmentService loanReportAssessmentService;
    @Autowired
    private ILoanReportService loanReportService;
    @Autowired
    private ITradeGoodsService tradeGoodsService;
    @Autowired
    private ICustInfoService custInfoService;

    /**
     * 新增订单
     * @param order
     * @return
     */
    @Override
    public TradeOrderPojo add(TradeOrderPojo order) throws Exception {
        // 获取商品
        TradeGoodsPojo goods = new TradeGoodsPojo();
        goods.setId(order.getGoodsId());
        goods.setStatus(TradeGoodsPojo.Status.VALID.getVal());
        goods = tradeGoodsService.selectUnique(goods);
        if (goods == null) {
            throw new CustomMsgException("该商品不存在或已下架");
        }

        // 新建订单
        Timestamp now = new Timestamp(System.currentTimeMillis());
        order.setTradeNo(UUID.randomUUID().toString().replace("-", "").toLowerCase());
        order.setGoodsId(goods.getId());
        order.setGoodsName(goods.getName());
        order.setGoodsAmount(goods.getDiscount());
        order.setCreateTime(now);
        order.setStatus(TradeOrderPojo.Status.UNPAID.getVal());

        if (order.getGoodsAmount() > 0) {
            // 金额大于零发起微信支付
            Map<String, String> resMap = this.doWxPay(order);
            order.setMwebUrl(resMap.get("mweb_url"));
            order.setPrepayId(resMap.get("prepay_id"));
            order.setCodeUrl(resMap.get("code_url"));
            order.setJsRequest(wxPayApi.fillRequestDataForJs(resMap.get("prepay_id")));

            order.setPayTime(now);
            order.setStatus(TradeOrderPojo.Status.PAYING.getVal());
        } else {
            // 金额不大于零直接支付完成
            order.setPayType(TradeOrderPojo.PayType.FREE.getVal());

            order.setPayTime(now);
            order.setStatus(TradeOrderPojo.Status.SUCC.getVal());
        }

        dao.insert(order);

        return order;
    }

    /**
     * 更新支付结果，用于支付结果返回后
     * @param map
     * @param isCallback
     * @return
     */
    @Override
    public TradeOrderPojo update(Map<String, String> map, boolean isCallback) throws Exception {
        // 根据商户订单号查找订单
        TradeOrderPojo order = new TradeOrderPojo();
        order.setTradeNo(map.get("out_trade_no"));
        order.setStatus(TradeOrderPojo.Status.PAYING.getVal());
        order = dao.selectUnique(order);
        if (order == null) { return null; }

        // 更新订单属性
        order.setQueryResult(JSON.toJSONString(map));
        order.setQueryTime(new Timestamp(System.currentTimeMillis()));

        if (isCallback) {
            if (wxPayApi.fillRequestDataForSign(map) && order.getGoodsAmount().equals(Integer.valueOf(map.get("total_fee")))) {
                order.setStatus(TradeOrderPojo.Status.SUCC.getVal());
            } else {
                logger.info("签名或金额不符");
            }
        } else {
            if ("SUCCESS".equals(map.get("trade_state"))) {
                order.setStatus(TradeOrderPojo.Status.SUCC.getVal());
            } else {
                order.setStatus(TradeOrderPojo.Status.FAIL.getVal());
            }
        }

        // 若支付成功
        if (TradeOrderPojo.Status.SUCC.getVal().equals(order.getStatus())) {
            // 更新vip过期时间
            if (order.getGoodsId() == 4) {
                CustInfoPojo c = new CustInfoPojo();
                c.setId(order.getCustId());
                c.setVipExpTime(new Timestamp(System.currentTimeMillis() + 365 * 24 * 3600 * 1000));
                custInfoService.update(c);
            }
        }

        // 更新订单信息
        dao.update(order);

        return order;
    }

    /**
     * 更新并获取单个
     * @param cust
     * @param order
     * @return
     */
    @Override
    public TradeOrderPojo updateAndGet(CustInfoPojo cust, TradeOrderPojo order) throws Exception {
        order.setCustId(cust.getId());
        TradeOrderPojo result = dao.selectUnique(order);

        // 若状态为"已发起支付待查询结果"，则调用微信接口更新
        if (result != null && TradeOrderPojo.Status.PAYING.getVal().equals(result.getStatus())) {
            Map<String, String> resMap = this.queryWxPay(result);
            this.update(resMap, false);
        }

        return dao.selectUnique(order);
    }

    /**
     * 更新并获取列表，仅更新最新的一个
     * @param cust
     * @param order
     * @return
     */
    @Override
    public List<TradeOrderPojo> updateAndGetList(CustInfoPojo cust, TradeOrderPojo order) throws Exception {
        order.setCustId(cust.getId());
        List<TradeOrderPojo> result = dao.selectList(order);

        // 若最新的一个状态为"已发起支付待查询结果"，则调用微信接口更新
        if (CollectionUtils.isNotEmpty(result) && TradeOrderPojo.Status.PAYING.getVal().equals(result.get(0).getStatus())) {
            Map<String, String> resMap = this.queryWxPay(result.get(0));
            this.update(resMap, false);
        }

        return dao.selectList(order);
    }

    /**
     * 获取订单详情，包括运营商、明镜SDK、全景雷达报告
     * @param order
     */
    @Override
    public void getDetail(TradeOrderPojo order) {
        LoanReportOperatorsPojo opt = new LoanReportOperatorsPojo();
        opt.setCustId(order.getCustId());
        opt.setOrderId(order.getId());
        opt = loanReportOperatorsService.selectUnique(opt);
        order.setOperators(opt);

        LoanReportAssessmentPojo ass = new LoanReportAssessmentPojo();
        ass.setCustId(order.getCustId());
        ass.setOrderId(order.getId());
        ass = loanReportAssessmentService.selectUnique(ass);
        order.setAssessment(ass);

        LoanReportPojo rpt = new LoanReportPojo();
        rpt.setCustId(order.getCustId());
        rpt.setOrderId(order.getId());
        rpt = loanReportService.selectUnique(rpt);
        order.setReport(rpt);
    }

    /**
     * 微信支付下单
     * @param order
     * @return
     * @throws CustomMsgException
     */
    private Map<String, String> doWxPay(TradeOrderPojo order) throws CustomMsgException {
        Map<String, String> reqData = new HashMap<String, String>();
        // 商品描述
        reqData.put("body", order.getGoodsName());
        // 商户订单号
        reqData.put("out_trade_no", order.getTradeNo());
        // 总金额
        reqData.put("total_fee", order.getGoodsAmount().toString());
        // 终端IP
        reqData.put("spbill_create_ip", order.getCreateIp());
        // 交易类型
        reqData.put("trade_type", TradeOrderPojo.PayType.getPayType(order.getPayType()).getTradeType());

        if (TradeOrderPojo.PayType.WXJS.getVal().equals(order.getPayType())) {
            reqData.put("openid", order.getWxOpenId());
        }

        Map<String, String> resData = null;
        try {
            logger.info("[微信支付] 统一下单接口请求 {}", reqData);
            resData = wxPayApi.unifiedOrder(reqData);
            logger.info("[微信支付] 统一下单接口响应 {}", resData);
        } catch (Exception e) {
            logger.error("[微信支付] 统一下单接口异常", e);
            throw new CustomMsgException("发起微信支付失败");
        }

        if (!"SUCCESS".equals(resData.get("return_code")) ||
                !"SUCCESS".equals(resData.get("result_code"))) {
            throw new CustomMsgException("发起微信支付失败");
        }

        return resData;
    }

    /**
     * 微信支付查询
     * @param order
     * @return
     * @throws CustomMsgException
     */
    private Map<String, String> queryWxPay(TradeOrderPojo order) throws CustomMsgException {
        Map<String, String> reqData = new HashMap<String, String>();
        reqData.put("out_trade_no", order.getTradeNo());

        Map<String, String> resData = null;
        try {
            logger.info("[微信支付] 查询订单接口请求 {}", reqData);
            resData = wxPayApi.orderQuery(reqData);
            logger.info("[微信支付] 查询订单接口响应 {}", resData);
        } catch (Exception e) {
            logger.error("[微信支付] 查询订单接口异常", e);
            throw new CustomMsgException("查询微信支付结果失败");
        }

        if (!"SUCCESS".equals(resData.get("return_code")) ||
                !"SUCCESS".equals(resData.get("result_code"))) {
            throw new CustomMsgException("查询微信支付结果失败");
        }

        return resData;
    }
}
