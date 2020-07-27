package com.aoying.loan.mgmtservice.app.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.aoying.loan.common.base.controller.BaseController;
import com.aoying.loan.common.base.pojo.ResponseData;
import com.aoying.loan.cust.app.pojo.AppChannelRecordPojo;
import com.aoying.loan.cust.app.service.iservice.IAppChannelRecordService;

/**
 * APP渠道记录 Controller
 * @author nick
 */
@RestController
@RequestMapping("/appChannelRecord")
public class AppChannelRecordControllerMgmt extends BaseController<AppChannelRecordPojo> {
    @Autowired
    private IAppChannelRecordService appChannelRecordService;

	/**
	 * @api {post} /appChannelRecord/mgmt/getListPro/v1 MGMT渠道数据对内(20190715)
	 * @apiGroup appChannelRecord
	 *
	 * @apiParam {Long} channelId 渠道ID
	 * @apiParam {Date} [beginDate] 开始日期
	 * @apiParam {Date} [endDate] 结束日期
	 * @apiParam {Integer} [pageNum] 第几页
	 * @apiParam {Integer} [pageSize] 每页条数
	 *
	 * @apiSuccess (成功响应) {String} reqResult 请求结果码、结果信息
	 * @apiSuccess (成功响应) {Object} data 请求结果数据
	 * @apiSuccess (成功响应) {Integer} data.registeredVisitsActual 实际注册量
	 * @apiSuccess (成功响应) {Integer} data.activationVisitsActual 实际激活数
	 * @apiSuccess (成功响应) {Integer} data.productVisitsActual 实际产品访问量
	 * @apiSuccess (成功响应) {Integer} data.reportVisitsActual 实际报告量
	 * @apiSuccess (成功响应) {Integer} data.registeredVisits 折扣注册量
	 * @apiSuccess (成功响应) {Integer} data.activationVisits 折扣激活数
	 * @apiSuccess (成功响应) {Integer} data.productVisits 折扣产品访问量
	 * @apiSuccess (成功响应) {Integer} data.reportVisits 折扣报告量
	 * @apiSuccessExample {json} 成功响应示例:
	{
	"data": [
	{
	"calDate": 1552406400000,
	"productVisits": 1600,
	"productVisitsActual": 2000,
	"rate": 0.8,
	"registeredVisits": 800,
	"registeredVisitsActual": 1000,
	"reportRate": 0.8,
	"reportVisits": 800,
	"reportVisitsActual": 1000
	},
	{
	"calDate": 1552492800000,
	"productVisits": 1600,
	"productVisitsActual": 2000,
	"rate": 0.8,
	"registeredVisits": 800,
	"registeredVisitsActual": 1000,
	"reportRate": 0.8,
	"reportVisits": 800,
	"reportVisitsActual": 1000
	}
	],
	"reqResult": {
	"code": 1,
	"msg": "操作成功"
	}
	}
	 */
	@RequestMapping("/mgmt/getListPro/v1")
	public ResponseData getList(AppChannelRecordPojo appChannelRecord) {
		if (appChannelRecord.getChannelId() == null) {
			return ResponseData.fail("请选择渠道");
		}
		
		appChannelRecord.setShowActual(true);
		List<AppChannelRecordPojo> list = appChannelRecordService.getList(appChannelRecord);
		return ResponseData.succ(list, appChannelRecord.getTotalRowCount());
	}

	/**
 	 * @api {post} /appChannelRecord/mgmt/getListPub/v1 MGMT渠道数据对外(20190715)
	 * @apiGroup appChannelRecord
	 *
	 * @apiParam {Long} channelId 渠道ID
	 * @apiParam {Date} [beginDate] 开始日期
	 * @apiParam {Date} [endDate] 结束日期
	 * @apiParam {Integer} [pageNum] 第几页
	 * @apiParam {Integer} [pageSize] 每页条数
	 *
	 * @apiSuccess (成功响应) {String} reqResult 请求结果码、结果信息
	 * @apiSuccess (成功响应) {Object} data 请求结果数据
	 * @apiSuccess (成功响应) {Integer} data.registeredVisits 折扣注册量
	 * @apiSuccess (成功响应) {Integer} data.activationVisits 折扣激活数
	 * @apiSuccess (成功响应) {Integer} data.productVisits 折扣产品访问量
	 * @apiSuccess (成功响应) {Integer} data.reportVisits 折扣报告量
	 * @apiSuccessExample {json} 成功响应示例:
	{
	"data": [
	{
	"calDate": 1552406400000,
	"productVisits": 1600,
	"registeredVisits": 800,
	"reportVisits": 800,
	},
	{
	"calDate": 1552492800000,
	"productVisits": 1600,
	"registeredVisits": 800,
	"reportVisits": 800,
	}
	],
	"reqResult": {
	"code": 1,
	"msg": "操作成功"
	}
	}
	 */
	@RequestMapping("/mgmt/getListPub/v1")
	public ResponseData getListPub(AppChannelRecordPojo appChannelRecord) {
		if (appChannelRecord.getChannelId() == null) {
			return ResponseData.fail("请选择渠道");
		}

		appChannelRecord.setShowActual(false);
		List<AppChannelRecordPojo> list = appChannelRecordService.getList(appChannelRecord);
		return ResponseData.succ(list, appChannelRecord.getTotalRowCount());
	}
}
