package com.aoying.loan.mgmtservice.loan.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.aoying.loan.common.base.controller.BaseController;
import com.aoying.loan.common.base.pojo.ResponseData;
import com.aoying.loan.cust.loan.pojo.LoanProductClickLogPojo;
import com.aoying.loan.cust.loan.service.iservice.ILoanProductClickLogService;

/**
 * 贷款产品点击日志 Controller
 * @author nick
 */
@RestController
@RequestMapping("/loanProductClickLog")
public class LoanProductClickLogControllerMgmt extends BaseController<LoanProductClickLogPojo> {
    @Autowired
    private ILoanProductClickLogService loanProductClickLogService;

	/**
	 * @apiVersion 2019.3.5
	 * @api {post} /loanProductClickLog/mgmt/getChClickPro/v1 MGMT获取渠道点击量
	 * @apiGroup loanProductClickLog
	 *
	 * @apiParam {Timestamp} createTimeBegin 开始时间
	 * @apiParam {Timestamp} createTimeEnd 结束时间
	 *
	 * @apiSuccess (成功响应) {String} reqResult 请求结果码、结果信息
	 * @apiSuccessExample {json} 成功响应示例:
	{
	"data": [
	{
	"uv": 4,
	"average": 1.5,
	"pv": 6,
	"name": "小米"
	},
	{
	"uv": 2,
	"average": 2,
	"pv": 4,
	"name": "谷歌"
	}
	],
	"reqResult": {
	"code": 1,
	"msg": "操作成功"
	}
	}
	 */
	@RequestMapping("/mgmt/getChClickPro/v1")
	public ResponseData getChClick(LoanProductClickLogPojo pojo) {
		List<Map<String, String>> list = loanProductClickLogService.getChClick(pojo);
		return ResponseData.succ(list);
	}

	/**
	 * @apiVersion 2019.3.5
	 * @api {post} /loanProductClickLog/mgmt/getProClickPro/v1 MGMT获取产品点击量
	 * @apiGroup loanProductClickLog
	 *
	 * @apiParam {Timestamp} createTimeBegin 开始时间
	 * @apiParam {Timestamp} createTimeEnd 结束时间
	 *
	 * @apiSuccess (成功响应) {String} reqResult 请求结果码、结果信息
	 * @apiSuccessExample {json} 成功响应示例:
	{
	"data": [
	{
	"uv": 1,
	"average": 2,
	"pv": 2,
	"name": "金银仓"
	},
	{
	"uv": 2,
	"average": 1,
	"pv": 2,
	"name": "金之家"
	}
	],
	"reqResult": {
	"code": 1,
	"msg": "操作成功"
	}
	}
	 */
	@RequestMapping("/mgmt/getProClickPro/v1")
	public ResponseData getProClick(LoanProductClickLogPojo pojo) {
		List<Map<String, String>> list = loanProductClickLogService.getProClick(pojo);
		return ResponseData.succ(list);
	}

	/**
	 * @apiVersion 2019.7.9
	 * @api {post} /loanProductClickLog/mgmt/getAllPro/v1 MGMT获取所有统计数据
	 * @apiGroup loanProductClickLog
	 *
	 * @apiParam {Timestamp} createTimeBegin 开始时间
	 * @apiParam {Timestamp} createTimeEnd 结束时间
	 *
	 * @apiSuccess (成功响应) {String} reqResult 请求结果码、结果信息
	 * @apiSuccess (成功响应) {Object} data 请求结果数据
	 * @apiSuccess (成功响应) {String} data.channel 渠道
	 * @apiSuccess (成功响应) {String} data.currRegister 当期注册数
	 * @apiSuccess (成功响应) {String} data.totalRegister 累计注册数
	 * @apiSuccess (成功响应) {String} data.currActivation 当日激活数
	 * @apiSuccess (成功响应) {String} data.totalActivation 累计激活数
	 * @apiSuccess (成功响应) {String} data.currVisitor 当日点击人数
	 * @apiSuccess (成功响应) {String} data.totalVisitor 累计点击人数
	 * @apiSuccess (成功响应) {String} data.currUv 当日UV数
	 * @apiSuccess (成功响应) {String} data.totalUv 累计UV数
	 * @apiSuccess (成功响应) {String} data.currReport 当日报告数
	 * @apiSuccess (成功响应) {String} data.totalReport 累计报告数
	 * @apiSuccessExample {json} 成功响应示例:
	{
	"data": [
	{
	"currVisitor": 4,
	"currUv": 10,
	"totalActivation": 0,
	"totalReport": 0,
	"channel": "腾讯(2)",
	"currRegister": 18,
	"totalRegister": 18,
	"totalUv": 10,
	"currReport": 0,
	"totalVisitor": 4,
	"currActivation": 0
	}
	],
	"reqResult": {
	"code": 1,
	"msg": "操作成功"
	}
	}
	 */
	@RequestMapping("/mgmt/getAllPro/v1")
	public ResponseData getAll(LoanProductClickLogPojo pojo) {
		List<Map<String, String>> list = loanProductClickLogService.getAll(pojo);
		return ResponseData.succ(list);
	}
}
