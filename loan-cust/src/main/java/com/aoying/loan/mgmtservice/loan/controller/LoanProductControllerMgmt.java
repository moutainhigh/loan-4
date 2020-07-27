package com.aoying.loan.mgmtservice.loan.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.aoying.loan.common.base.controller.BaseController;
import com.aoying.loan.common.base.pojo.ResponseData;
import com.aoying.loan.cust.loan.pojo.LoanProductPojo;
import com.aoying.loan.cust.loan.service.iservice.ILoanProductService;

/**
 * 贷款产品表 controller
 * @author nick
 */
@RestController
@RequestMapping("/loanProduct")
public class LoanProductControllerMgmt extends BaseController<LoanProductPojo> {
    @Autowired
    private ILoanProductService loanProductService;

	/**
	 * @api {post} /loanProduct/mgmt/getListPub/v1 MGMT贷款产品获取列表
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
	@RequestMapping("/mgmt/getListPub/v1")
	public ResponseData getList(LoanProductPojo loanProduct) {
		List<LoanProductPojo> productList = loanProductService.getList(loanProduct);
		return ResponseData.succ(productList);
	}

	/**
	 * @api {post} /loanProduct/mgmt/getPub/v1 MGMT贷款产品获取单个
	 * @apiGroup loanProduct
	 *
	 * @apiParam {Integer} id 产品ID
	 *
	 * @apiSuccess (成功响应) {String} reqResult 请求结果码、结果信息
	 * @apiSuccess (成功响应) {String} data 贷款产品
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
	@RequestMapping("/mgmt/getPub/v1")
	public ResponseData get(LoanProductPojo loanProduct) {
		LoanProductPojo product = loanProductService.selectUnique(loanProduct);
		return ResponseData.succ(product);
	}

	/**
	 * @apiVersion 2019.2.25
	 * @api {post} /loanProduct/mgmt/addPro/v1 MGMT贷款产品新增
	 * @apiGroup loanProduct
	 *
	 * @apiParam {String} [name] 产品名
	 * @apiParam {String} [icon] 产品icon
	 * @apiParam {String} [url] 产品跳转链接
	 * @apiParam {String} [limitName] 最高额度显示名
	 * @apiParam {String} [limitDisplay] 最高额度显示内容
	 * @apiParam {Integer} [limitMin] 最低额度
	 * @apiParam {Integer} [limit] 最高额度
	 * @apiParam {String} [periodName] 期限显示名
	 * @apiParam {String} [periodDisplay] 期限显示内容
	 * @apiParam {Integer} [periodMin] 期限下限
	 * @apiParam {Integer} [periodMax] 期限上限
	 * @apiParam {String} [rateName] 利率显示名
	 * @apiParam {String} [rateDisplay] 利率显示内容
	 * @apiParam {Double} [rate] 利率
	 * @apiParam {String} [describe] 描述
	 * @apiParam {String} [labelStr] 标签，以逗号分隔
	 * @apiParam {Long} [applyNum] 申请人数
	 * @apiParam {Integer} weight 权重，默认0，首页1
	 * @apiParam {Integer} orderByType 排序类型，1人工排序，2热度排序
	 * @apiParam {Integer} status 状态，0停用，1正常
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
	@RequestMapping("/mgmt/addPro/v1")
	public ResponseData add(LoanProductPojo loanProduct) {
		loanProductService.addProduct(loanProduct);
		return ResponseData.succ(null);
	}

	/**
	 * @apiVersion 2019.2.25
	 * @api {post} /loanProduct/mgmt/updatePro/v1 MGMT贷款产品更新
	 * @apiGroup loanProduct
	 *
	 * @apiParam {Integer} id 产品ID
	 * @apiParam {String} [name] 产品名
	 * @apiParam {String} [icon] 产品icon
	 * @apiParam {String} [url] 产品跳转链接
	 * @apiParam {String} [limitName] 最高额度显示名
	 * @apiParam {String} [limitDisplay] 最高额度显示内容
	 * @apiParam {Integer} [limitMin] 最低额度
	 * @apiParam {Integer} [limit] 最高额度
	 * @apiParam {String} [periodName] 期限显示名
	 * @apiParam {String} [periodDisplay] 期限显示内容
	 * @apiParam {Integer} [periodMin] 期限下限
	 * @apiParam {Integer} [periodMax] 期限上限
	 * @apiParam {String} [rateName] 利率显示名
	 * @apiParam {String} [rateDisplay] 利率显示内容
	 * @apiParam {Double} [rate] 利率
	 * @apiParam {String} [describe] 描述
	 * @apiParam {String} [labelStr] 标签，以逗号分隔
	 * @apiParam {Long} [applyNum] 申请人数
	 * @apiParam {Integer} [weight] 权重，默认0，首页1
	 * @apiParam {Integer} [orderByType] 排序类型，1人工排序，2热度排序
	 * @apiParam {Integer} [statu] 状态，0停用，1正常
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
	@RequestMapping("/mgmt/updatePro/v1")
	public ResponseData update(LoanProductPojo loanProduct) {
		loanProductService.updateProduct(loanProduct);
		return ResponseData.succ(null);
	}

	/**
	 * @api {post} /loanProduct/mgmt/updateOrderPro/v1 MGMT贷款产品更新顺序
	 * @apiGroup loanProduct
	 *
	 * @apiParam {Integer} idsStr 更新后排序的产品ID，以逗号分隔的字符串，如'2,3,1'表示更新后ID依次为2，3，1
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
	@RequestMapping("/mgmt/updateOrderPro/v1")
	public ResponseData updateOrder(String idsStr) {
		loanProductService.updateOrder(idsStr);
		return ResponseData.succ(null);
	}
}
