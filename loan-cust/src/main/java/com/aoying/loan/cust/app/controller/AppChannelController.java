package com.aoying.loan.cust.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.aoying.loan.common.base.controller.BaseController;
import com.aoying.loan.common.base.pojo.ResponseData;
import com.aoying.loan.cust.app.pojo.AppChannelPojo;
import com.aoying.loan.cust.app.service.iservice.IAppChannelService;

/**
 * APP渠道表 Controller
 * @author nick
 */
@RestController
@RequestMapping("/appChannel")
public class AppChannelController extends BaseController<AppChannelPojo> {
    @Autowired
    private IAppChannelService appChannelService;

	/**
	 * @apiVersion 2019.5.21
	 * @api {post} /appChannel/api/getPub/v1 API渠道获取单个
	 * @apiGroup appChannel
	 *
	 * @apiParam {Integer} id ID
	 *
	 * @apiSuccess (成功响应) {String} reqResult 请求结果码、结果信息
	 * @apiSuccessExample {json} 成功响应示例:
	{
	"data": {
	"appUrl": "http://www.baidu.com",
	"createTime": 1551682841145,
	"createrId": -1,
	"createrName": "admin",
	"desc": "qudsldfj",
	"id": 2,
	"name": "安卓",
	"status": 1,
	"type": 1
	},
	"reqResult": {
	"code": 1,
	"msg": "操作成功"
	}
	}
	 */
	/**
	 * @apiVersion 2019.6.18
	 * @api {post} /appChannel/api/getPub/v1 API渠道获取单个
	 * @apiGroup appChannel
	 *
	 * @apiParam {Integer} id ID
	 *
	 * @apiSuccess (成功响应) {String} reqResult 请求结果码、结果信息
	 * @apiSuccess (成功响应) {Object} data 请求结果数据
	 * @apiSuccess (成功响应) {Integer} data.release 是否发布，0未发布，1已发布
	 * @apiSuccess (成功响应) {Integer} data.displayMode 显示模式，1列表，2卡片
	 * @apiSuccessExample {json} 成功响应示例:
	{
	"data": {
	"appUrl": "http://www.baidu.com",
	"createTime": 1551682841145,
	"createrId": -1,
	"createrName": "admin",
	"desc": "qudsldfj",
	"id": 2,
	"name": "安卓",
	"status": 1,
	"type": 1,
	"release": 1,
	"displayMode": 1
	},
	"reqResult": {
	"code": 1,
	"msg": "操作成功"
	}
	}
	 */
	@RequestMapping("/api/getPub/v1")
	public ResponseData get(AppChannelPojo appChannel) {
		AppChannelPojo pojo = appChannelService.selectUnique(appChannel);
		return ResponseData.succ(pojo);
	}
}
