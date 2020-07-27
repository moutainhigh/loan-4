package com.aoying.loan.mgmtservice.cust.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.aoying.loan.common.base.controller.BaseController;
import com.aoying.loan.common.base.pojo.ResponseData;
import com.aoying.loan.cust.cust.pojo.CustInfoPojo;
import com.aoying.loan.cust.cust.service.iservice.ICustInfoService;

/**
 * 用户信息表 controller
 * @author nick
 */
@RestController
@RequestMapping("/custInfo")
public class CustInfoControllerMgmt extends BaseController<CustInfoPojo> {
    @Autowired
    private ICustInfoService custInfoService;

	/**
	 * @apiVersion 2019.3.5
	 * @api {post} /custInfo/mgmt/getRegByChPro/v1 MGMT注册量按渠道查
	 * @apiGroup custInfo
	 *
	 * @apiParam {Timestamp} createTimeBegin 开始时间
	 * @apiParam {Timestamp} createTimeEnd 结束时间
	 * @apiParam {String} [chIdStr] 以逗号分隔的渠道ID字符串
	 *
	 * @apiSuccess (成功响应) {String} reqResult 请求结果码、结果信息
	 * @apiSuccessExample {json} 成功响应示例:
	{
	"data": [
	{
	"date": "合计",
	"sum": 22,
	"ch10": 7
	},
	{
	"date": "2019-02-28",
	"sum": 1,
	"ch10": 0
	},
	{
	"date": "2019-02-26",
	"sum": 1,
	"ch10": 0
	}
	],
	"reqResult": {
	"code": 1,
	"msg": "操作成功"
	}
	}
	 */
	@RequestMapping("/mgmt/getRegByChPro/v1")
	public ResponseData getRegByCh(CustInfoPojo pojo) {
		List<Map<String, String>> list = custInfoService.getRegByCh(pojo);
		return ResponseData.succ(list);
	}

	/**
	 * @apiVersion 2019.3.5
	 * @api {post} /custInfo/mgmt/getRegAllPro/v1 MGMT注册量
	 * @apiGroup custInfo
	 *
	 * @apiParam {Timestamp} createTimeBegin 开始时间
	 * @apiParam {Timestamp} createTimeEnd 结束时间
	 *
	 * @apiSuccess (成功响应) {String} reqResult 请求结果码、结果信息
	 * @apiSuccessExample {json} 成功响应示例:
	{
	"data": [
	{
	"name": "合计",
	"sum": 22
	},
	{
	"name": "百度",
	"sum": 11
	}
	],
	"reqResult": {
	"code": 1,
	"msg": "操作成功"
	}
	}
	 */
	@RequestMapping("/mgmt/getRegAllPro/v1")
	public ResponseData getRegAll(CustInfoPojo pojo) {
		List<Map<String, String>> list = custInfoService.getRegAll(pojo);
		return ResponseData.succ(list);
	}
}
