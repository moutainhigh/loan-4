package com.aoying.loan.cust.trade.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.aoying.loan.common.base.controller.BaseController;
import com.aoying.loan.common.base.pojo.ResponseData;
import com.aoying.loan.cust.cust.pojo.CustInfoPojo;
import com.aoying.loan.cust.cust.service.CustSessionService;
import com.aoying.loan.cust.cust.service.iservice.ICustIdCardService;
import com.aoying.loan.cust.tool.service.VerfCodeService;
import com.aoying.loan.cust.trade.pojo.TradeOrderPojo;
import com.aoying.loan.cust.trade.service.iservice.ITradeOrderService;

/**
 * 交易订单 Controller
 * @author nick
 */
@RestController
@RequestMapping("/tradeOrder")
public class TradeOrderController extends BaseController<TradeOrderPojo> {
	@Autowired
	private VerfCodeService verfCodeService;
	@Autowired
	private CustSessionService custSessionService;
    @Autowired
	private ICustIdCardService custIdCardService;
    @Autowired
    private ITradeOrderService tradeOrderService;

    /**
     * @api {post} /tradeOrder/api/addPro/v1 API订单新增0816
     * @apiGroup tradeOrder
     *
     * @apiParam {String} goodsId 商品ID
     * @apiParam {String} idCardName 身份证姓名
     * @apiParam {String} idCardCode 身份证号码
     * @apiParam {String} telNo 手机号
     * @apiParam {String} payType 支付类型，0免费，1微信H5，2微信公众号
     * @apiParam {String} [wxCode] 换取微信OPENID
     *
     * @apiSuccess (成功响应) {String} reqResult 请求结果码、结果信息
     * @apiSuccess (成功响应) {String} mweb_url 支付跳转链接
     * @apiSuccess (成功响应) {String} prepay_id 预支付交易会话标识
     * @apiSuccessExample {json} 成功响应示例:
    {
    "data": {
    "mweb_url": "https://wx.tenpay.com/cgi-bin/mmpayweb-bin/checkmweb?prepay_id=wx091455451564649759d317641344631379&package=411065888",
    "prepay_id": "wx201411101639507cbf6ffd8b0779950874",
    "jsRequest": {
    "appId":"wx2421b1c4370ec43b",     //公众号名称，由商户传入
    "timeStamp":"1395712654",         //时间戳，自1970年以来的秒数
    "nonceStr":"e61463f8efa94090b1f366cccfbbb444", //随机串
    "package":"prepay_id=u802345jgfjsdfgsdg888",
    "signType":"MD5",         //微信签名方式：
    "paySign":"70EA570631E4BB79628FBCA90534C63FF7FADD89" //微信签名
    }
    },
    "reqResult": {
    "code": 1,
    "msg": "操作成功"
    }
    }
     */
    @RequestMapping("/api/addPro/v1")
    public ResponseData add(TradeOrderPojo order, String verfCode, HttpServletRequest request) throws Exception {
        CustInfoPojo currCust = custSessionService.getCurrentCust(request);

        // 检查短信验证码
//        verfCodeService.checkSmsVerfCode(EVerfCodeAndSmsTemplate.REPORT.getType(), order.getTelNo(), verfCode);

        // 校验是否实名，若未实名先实名再查询，若已实名忽略前端实名数据
//        CustIdCardPojo idCard = new CustIdCardPojo();
//        idCard.setCustId(currCust.getId());
//        idCard.setIdCardCode(order.getIdCardCode());
//        idCard.setIdCardName(order.getIdCardName());
//        CustIdCardPojo authIdCard = custIdCardService.addAndAuthIdCard(idCard);
//        if (!authIdCard.getStatus().equals(CustIdCardPojo.Status.SUCC.getVal())) {
//            return new ResponseData(EResCodeCust.svceErrAuthIdCardErr.getOptResult(logger));
//        }

        // 新增订单
        order.setCustId(currCust.getId());
        order.setCreateIp(currCust.getIp());
        order.setWxOpenId(currCust.getWxOpenId());
//        order.setIdCardCode(authIdCard.getIdCardCode());
//        order.setIdCardName(authIdCard.getIdCardName());
        TradeOrderPojo result = tradeOrderService.add(order);

        return ResponseData.succ(result);
    }

    /**
     * @api {post} /tradeOrder/api/getPro/v3 API订单单个200416
	 * @apiDescription 更新支付结果，并获取单个订单
     * @apiGroup tradeOrder
     *
     * @apiParam {Integer} id 订单ID
     *
     * @apiSuccess (成功响应) {String} reqResult 请求结果码、结果信息
     * @apiSuccess (成功响应) {Object} data
     * @apiSuccess (成功响应) {Object} data.operators 运营商
     * @apiSuccess (成功响应) {Object} data.assessment 明镜
     * @apiSuccess (成功响应) {Object} data.report 全景雷达
     * @apiSuccessExample {json} 成功响应示例:
    {
    "data": {
    },
    "reqResult": {
    "code": 1,
    "msg": "操作成功"
    }
    }
     */
    @RequestMapping("/api/getPro/v3")
    public ResponseData getV3(TradeOrderPojo tradeOrder, HttpServletRequest request) throws Exception {
        CustInfoPojo currCust = custSessionService.getCurrentCust(request);

        // 更新/查询支付结果
        TradeOrderPojo result = tradeOrderService.updateAndGet(currCust, tradeOrder);

        // 支付失败
        if (!TradeOrderPojo.Status.SUCC.getVal().equals(result.getStatus())) {
            return ResponseData.fail("支付失败", result);
        }

        // 查询报告详情
        tradeOrderService.getDetail(result);

        return ResponseData.succ(result);
    }

    /**
     * @api {post} /tradeOrder/api/getListPro/v3 API订单列表200416
	 * @apiDescription 更新支付结果，并获取订单列表，仅更新最近一个订单
	 * @apiGroup tradeOrder
     *
     * @apiSuccess (成功响应) {String} reqResult 请求结果码、结果信息
	 * @apiSuccess (成功响应) {Object} data 请求结果数据
	 * @apiSuccessExample {json} 成功响应示例:
    {
    "data": {
    },
    "reqResult": {
    "code": 1,
    "msg": "操作成功"
    }
    }
     */
    @RequestMapping("/api/getListPro/v3")
    public ResponseData getListV3(TradeOrderPojo tradeOrder, HttpServletRequest request) throws Exception {
        CustInfoPojo currCust = custSessionService.getCurrentCust(request);
        List<TradeOrderPojo> result = tradeOrderService.updateAndGetList(currCust, tradeOrder);
        return ResponseData.succ(result);
    }
}
