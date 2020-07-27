package com.aoying.loan.mgmtservice.app.controller;

import java.util.List;
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
public class AppChannelControllerMgmt extends BaseController<AppChannelPojo> {
    @Autowired
    private IAppChannelService appChannelService;

	/**
	 * @apiVersion 2019.3.4
	 * @api {post} /appChannel/mgmt/getListPro/v1 MGMT渠道获取列表
	 * @apiGroup appChannel
	 *
	 * @apiSuccess (成功响应) {String} reqResult 请求结果码、结果信息
	 * @apiSuccessExample {json} 成功响应示例:
	{
	"data": [
	{
	"appUrl": "http://www.baidu.com",
	"createTime": 1551682855479,
	"createrId": -1,
	"createrName": "admin",
	"desc": "qudsldfj",
	"id": 3,
	"name": "安卓",
	"status": 1,
	"type": 1
	}
	],
	"reqResult": {
	"code": 1,
	"msg": "操作成功"
	}
	}
	 */
	@RequestMapping("/mgmt/getListPro/v1")
	public ResponseData getList(AppChannelPojo appChannel) {
		List<AppChannelPojo> list = appChannelService.selectList(appChannel);
		return ResponseData.succ(list);
	}

	/**
	 * @apiVersion 2019.3.4
	 * @api {post} /appChannel/mgmt/getPro/v1 MGMT渠道获取单个
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
	@RequestMapping("/mgmt/getPro/v1")
	public ResponseData get(AppChannelPojo appChannel) {
		AppChannelPojo pojo = appChannelService.selectUnique(appChannel);
		return ResponseData.succ(pojo);
	}

	/**
	 * @apiVersion 2019.3.4
	 * @api {post} /appChannel/mgmt/addPro/v1 MGMT渠道新增
	 * @apiGroup appChannel
	 *
	 * @apiParam {Integer} [id] ID
	 * @apiUse AppChannelPojo
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
	public ResponseData add(AppChannelPojo appChannel) {
		this.setCreater(appChannel);
		appChannelService.insert(appChannel);
		return ResponseData.succ(null);
	}

	/**
	 * @apiVersion 2019.3.4
	 * @api {post} /appChannel/mgmt/updatePro/v1 MGMT渠道更新
	 * @apiGroup appChannel
	 *
	 * @apiUse AppChannelPojo
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
	public ResponseData update(AppChannelPojo appChannel) {
		this.setMod(appChannel);
		appChannelService.update(appChannel);
		return ResponseData.succ(null);
	}
}
