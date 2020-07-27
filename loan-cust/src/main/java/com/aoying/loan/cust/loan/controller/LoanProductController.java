package com.aoying.loan.cust.loan.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.aoying.loan.common.base.controller.BaseController;
import com.aoying.loan.common.base.pojo.ResponseData;
import com.aoying.loan.common.constant.response.exception.DefineMsgException;
import com.aoying.loan.cust.cust.pojo.CustInfoPojo;
import com.aoying.loan.cust.cust.service.CustSessionService;
import com.aoying.loan.cust.loan.pojo.LoanProductClickLogPojo;
import com.aoying.loan.cust.loan.pojo.LoanProductPojo;
import com.aoying.loan.cust.loan.service.iservice.ILoanProductService;

/**
 * 贷款产品表 controller
 * @author nick
 */
@RestController
@RequestMapping("/loanProduct")
public class LoanProductController extends BaseController<LoanProductPojo> {
	@Autowired
	private CustSessionService custSessionService;
    @Autowired
    private ILoanProductService loanProductService;

	/**
	 * @api {post} /loanProduct/api/getListPub/v1 API获取贷款产品列表
	 * @apiGroup loanProduct
	 *
	 * @apiParam {Integer} [limitMin] 最高额度下限
	 * @apiParam {Integer} [limitMax] 最高额度上线
	 * @apiParam {Integer} [periodMin] 期限下限
	 * @apiParam {Integer} [periodMax] 期限上限
	 * @apiParam {String} [orderByName] 排序列名，默认以顺序热度排序，支持的值'rate'
	 * @apiParam {Boolean} [orderByDesc] 是否降序，支持的值'true'、'false'
	 *
	 * @apiSuccess (成功响应) {String} reqResult 请求结果码、结果信息
	 * @apiSuccess (成功响应) {String} data 贷款产品list
	 * @apiSuccessExample {json} 成功响应示例:
	{
	"data": [
	{
	"applyNum": 32,
	"createTime": 1543593600000,
	"createrId": -1,
	"createrName": "admin",
	"describe": "2万口子，了解一下？",
	"icon": "http://res.51jiekuanwang.com/loanProduct/mr.png",
	"id": 2,
	"label": [
	"大额"
	],
	"labelStr": "大额",
	"limit": 50000,
	"limitDisplay": "5万",
	"limitName": "最高额度",
	"name": "米融",
	"orderCode": 2,
	"periodDisplay": "14天-2月",
	"periodMax": 60,
	"periodMin": 14,
	"periodName": "借款期限",
	"pv": 0,
	"rate": 0.1,
	"rateDisplay": "免息",
	"rateName": "日利率",
	"status": 1,
	"url": "https://0x7.me/soZ5",
	"weight": 1
	}
	],
	"reqResult": {
	"code": 1,
	"msg": "操作成功"
	}
	}
	 */
	/**
	 * @apiVersion 2019.6.18
	 * @api {post} /loanProduct/api/getListPub/v1 API获取贷款产品列表
	 * @apiGroup loanProduct
	 *
	 * @apiParam {Integer} [weight] 权重，0默认，1首页，2审核进度页，3报告详情页
	 * @apiParam {String} [labelStr] 标签
	 * @apiParam {Integer} [limitMin] 最高额度下限
	 * @apiParam {Integer} [limitMax] 最高额度上线
	 * @apiParam {Integer} [periodMin] 期限下限
	 * @apiParam {Integer} [periodMax] 期限上限
	 * @apiParam {String} [orderByName] 排序列名，默认以顺序热度排序，支持的值'rate'
	 * @apiParam {Boolean} [orderByDesc] 是否降序，支持的值'true'、'false'
	 *
	 * @apiSuccess (成功响应) {String} reqResult 请求结果码、结果信息
	 * @apiSuccess (成功响应) {String} data 贷款产品list
	 * @apiSuccessExample {json} 成功响应示例:
	{
	"data": [
	{
	"applyNum": 32,
	"createTime": 1543593600000,
	"createrId": -1,
	"createrName": "admin",
	"describe": "2万口子，了解一下？",
	"icon": "http://res.51jiekuanwang.com/loanProduct/mr.png",
	"id": 2,
	"label": [
	"大额"
	],
	"labelStr": "大额",
	"limit": 50000,
	"limitDisplay": "5万",
	"limitName": "最高额度",
	"name": "米融",
	"orderCode": 2,
	"periodDisplay": "14天-2月",
	"periodMax": 60,
	"periodMin": 14,
	"periodName": "借款期限",
	"pv": 0,
	"rate": 0.1,
	"rateDisplay": "免息",
	"rateName": "日利率",
	"status": 1,
	"url": "https://0x7.me/soZ5",
	"weight": 1
	}
	],
	"reqResult": {
	"code": 1,
	"msg": "操作成功"
	}
	}
	 */
	@RequestMapping("/api/getListPub/v1")
	public ResponseData getList(LoanProductPojo loanProduct) {
		loanProduct.setStatus(LoanProductPojo.EStatus.NORMAL.getVal());
		List<LoanProductPojo> productList = loanProductService.selectList(loanProduct);
		return ResponseData.succ(productList);
	}

	/**
	 * @api {post} /loanProduct/api/getPub/v1 API获取贷款产品
	 * @apiGroup loanProduct
	 *
	 * @apiParam {Integer} id 产品ID
	 *
	 * @apiSuccess (成功响应) {String} reqResult 请求结果码、结果信息
	 * @apiSuccess (成功响应) {Object} data 贷款产品
	 * @apiSuccess (成功响应) {Integer} data.activable 是否可用，0不限制，1低阶报告可用，2高阶报告可用
	 * @apiSuccessExample {json} 成功响应示例:
	{
	"data": {
	"applyNum": 32,
	"createTime": 1543593600000,
	"createrId": -1,
	"createrName": "admin",
	"describe": "2万口子，了解一下？",
	"icon": "http://res.51jiekuanwang.com/loanProduct/mr.png",
	"id": 2,
	"label": [
	"大额"
	],
	"labelStr": "大额",
	"limit": 50000,
	"limitDisplay": "5万",
	"limitName": "最高额度",
	"name": "米融",
	"orderCode": 2,
	"periodDisplay": "14天-2月",
	"periodMax": 60,
	"periodMin": 14,
	"periodName": "借款期限",
	"pv": 0,
	"rate": 0.1,
	"rateDisplay": "免息",
	"rateName": "日利率",
	"status": 1,
	"url": "https://0x7.me/soZ5",
	"weight": 1
	},
	"reqResult": {
	"code": 1,
	"msg": "操作成功"
	}
	}
	 */
	@RequestMapping("/api/getPub/v1")
	public ResponseData get(LoanProductPojo loanProduct) {
		loanProduct.setStatus(LoanProductPojo.EStatus.NORMAL.getVal());
		LoanProductPojo product = loanProductService.selectUnique(loanProduct);
		return ResponseData.succ(product);
	}

	/**
	 * @api {post} /loanProduct/api/addPvPro/v2 API增加点击量
	 * @apiGroup loanProduct
	 * @apiDescription 增加指定产品的点击量用于热度排序，每调用一次增加一次点击量
	 *
	 * @apiParam {Integer} id 产品ID
	 *
	 * @apiSuccess (成功响应) {String} reqResult 请求结果码、结果信息
	 * @apiSuccessExample {json} 成功响应示例:
	{
	"reqResult": {
	"code": 1,
	"msg": "操作成功"
	}
	}
	 */
	@RequestMapping("/api/addPvPro/v1")
	public ResponseData addPv(Long id) {
		loanProductService.addPv(id);
		return ResponseData.succ(null);
	}

	/**
	 * @apiVersion 2019.3.5
	 * @api {post} /loanProduct/api/addPvPro/v2 API增加点击量
	 * @apiGroup loanProduct
	 * @apiDescription 增加指定产品的点击量用于热度排序，每调用一次增加一次点击量
	 *
	 * @apiParam {Long} productId 产品ID
	 * @apiParam {Long} channelId 渠道ID
	 *
	 * @apiSuccess (成功响应) {String} reqResult 请求结果码、结果信息
	 * @apiSuccessExample {json} 成功响应示例:
	{
	"reqResult": {
	"code": 1,
	"msg": "操作成功"
	}
	}
	 */
	@RequestMapping("/api/addPvPro/v2")
	public ResponseData addPvV2(LoanProductClickLogPojo pojo, HttpServletRequest request) throws DefineMsgException {
		CustInfoPojo cust = custSessionService.getCurrentCust(request);
		pojo.setCustId(cust.getId());
		loanProductService.addPvV2(pojo);
		return ResponseData.succ(null);
	}
}
