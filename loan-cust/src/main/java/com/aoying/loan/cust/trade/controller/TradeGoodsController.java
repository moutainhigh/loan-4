package com.aoying.loan.cust.trade.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.aoying.loan.common.base.controller.BaseController;
import com.aoying.loan.common.base.pojo.ResponseData;
import com.aoying.loan.cust.trade.pojo.TradeGoodsPojo;
import com.aoying.loan.cust.trade.service.iservice.ITradeGoodsService;

/**
 * 交易商品 Controller
 * @author nick
 */
@RestController
@RequestMapping("/tradeGoods")
public class TradeGoodsController extends BaseController<TradeGoodsPojo> {
    @Autowired
    private ITradeGoodsService tradeGoodsService;

	/**
	 * @api {post} /tradeGoods/api/getListPub/v1 API获取交易商品列表
	 * @apiGroup tradeGoods
	 *
	 * @apiSuccess (成功响应) {String} reqResult 请求结果码、结果信息
	 * @apiuse TradeGoodsPojoSuccess
	 * @apiSuccessExample {json} 成功响应示例:
	{
	"data": [
	{
	"amount": 3000,
	"btnText": "立即检测",
	"createTime": 1548831800000,
	"createrId": -1,
	"createrName": "admin",
	"description": "99%的多头借贷用户会被拒贷",
	"discount": 0,
	"displayText": "限时免费获取",
	"id": 1,
	"name": "网贷多头检测",
	"num": 51200,
	"numText": "5.1万次诊断",
	"status": 1
	},
	{
	"btnText": "即将上线",
	"createTime": 1548831800000,
	"createrId": -1,
	"createrName": "admin",
	"description": "99%的黑名单用户会被拒贷",
	"id": 2,
	"name": "黑名单风险检测",
	"num": 0,
	"status": 2
	},
	{
	"btnText": "即将上线",
	"createTime": 1548831800000,
	"createrId": -1,
	"createrName": "admin",
	"description": "99%的通话风险用户会被拒贷",
	"id": 3,
	"name": "通话风险检测",
	"num": 0,
	"status": 2
	}
	],
	"reqResult": {
	"code": 1,
	"msg": "操作成功"
	}
	}
	 */
	@RequestMapping("/api/getListPub/v1")
	public ResponseData getList(TradeGoodsPojo tradeGoods) {
		List<TradeGoodsPojo> list = tradeGoodsService.selectList(tradeGoods);
		return ResponseData.succ(list);
	}

	/**
	 * @api {post} /tradeGoods/api/getPub/v1 API获取交易商品
	 * @apiGroup tradeGoods
	 *
	 * @apiParam {Integer} id 商品ID
	 *
	 * @apiSuccess (成功响应) {String} reqResult 请求结果码、结果信息
	 * @apiuse TradeGoodsPojoSuccess
	 * @apiSuccessExample {json} 成功响应示例:
	{
	"data": {
	"amount": 3000,
	"btnText": "立即检测",
	"createTime": 1548831800000,
	"createrId": -1,
	"createrName": "admin",
	"description": "99%的多头借贷用户会被拒贷",
	"discount": 0,
	"displayText": "限时免费获取",
	"id": 1,
	"name": "网贷多头检测",
	"num": 51200,
	"numText": "5.1万次诊断",
	"status": 1
	},
	"reqResult": {
	"code": 1,
	"msg": "操作成功"
	}
	}
	 */
	@RequestMapping("/api/getPub/v1")
	public ResponseData get(TradeGoodsPojo tradeGoods) {
		TradeGoodsPojo goods = tradeGoodsService.selectUnique(tradeGoods);
		return ResponseData.succ(goods);
	}
}
