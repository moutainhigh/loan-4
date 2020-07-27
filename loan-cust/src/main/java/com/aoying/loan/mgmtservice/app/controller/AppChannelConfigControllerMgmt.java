package com.aoying.loan.mgmtservice.app.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.aoying.loan.common.base.controller.BaseController;
import com.aoying.loan.common.base.pojo.ResponseData;
import com.aoying.loan.common.constant.eenum.EStatus;
import com.aoying.loan.cust.app.pojo.AppChannelConfigPojo;
import com.aoying.loan.cust.app.service.iservice.IAppChannelConfigService;

/**
 * APP渠道配置 Controller
 * @author nick
 */
@RestController
@RequestMapping("/appChannelConfig")
public class AppChannelConfigControllerMgmt extends BaseController<AppChannelConfigPojo> {
    @Autowired
    private IAppChannelConfigService appChannelConfigService;

	/**
	 * @apiVersion 2019.3.15
	 * @api {post} /appChannelConfig/mgmt/getListPro/v1 MGMT渠道关联获取列表
	 * @apiGroup appChannelConfig
	 *
	 * @apiSuccess (成功响应) {String} reqResult 请求结果码、结果信息
	 * @apiSuccessExample {json} 成功响应示例:
	{
	"data": [
	{
	"channelId": "1",
	"channelName": "百度",
	"createTime": 1552713179247,
	"createrId": -1,
	"createrName": "admin",
	"id": 1,
	"modId": -1,
	"modName": "admin",
	"modTime": 1552713179247,
	"rate": 0.6,
	"reportRate": 0.6,
	"status": 1
	},
	{
	"channelId": "2",
	"channelName": "腾讯",
	"createTime": 1552713185113,
	"createrId": -1,
	"createrName": "admin",
	"id": 2,
	"modId": -1,
	"modName": "admin",
	"modTime": 1552713226988,
	"rate": 0.8,
	"reportRate": 0.6,
	"status": 1
	}
	],
	"reqResult": {
	"code": 1,
	"msg": "操作成功"
	}
	}
	 */
	@RequestMapping("/mgmt/getListPro/v1")
	public ResponseData getList(AppChannelConfigPojo appChannelConfig) {
		List<AppChannelConfigPojo> list = appChannelConfigService.selectList(appChannelConfig);
		return ResponseData.succ(list);
	}

	/**
	 * @apiVersion 2019.3.15
	 * @api {post} /appChannelConfig/mgmt/getPro/v1 MGMT渠道关联获取单个
	 * @apiGroup appChannelConfig
	 *
	 * @apiParam {Integer} id ID
	 *
	 * @apiSuccess (成功响应) {String} reqResult 请求结果码、结果信息
	 * @apiSuccessExample {json} 成功响应示例:
	{
	"data": {
	"channelId": "2",
	"channelName": "腾讯",
	"createTime": 1552713185113,
	"createrId": -1,
	"createrName": "admin",
	"id": 2,
	"modId": -1,
	"modName": "admin",
	"modTime": 1552713226988,
	"rate": 0.8,
	"reportRate": 0.6,
	"status": 1
	},
	"reqResult": {
	"code": 1,
	"msg": "操作成功"
	}
	}
	 */
	@RequestMapping("/mgmt/getPro/v1")
	public ResponseData get(AppChannelConfigPojo appChannelConfig) {
		AppChannelConfigPojo pojo = appChannelConfigService.selectUnique(appChannelConfig);
		return ResponseData.succ(pojo);
	}

	/**
	 * @apiVersion 2019.3.15
	 * @api {post} /appChannelConfig/mgmt/addPro/v1 MGMT渠道关联新增
	 * @apiGroup appChannelConfig
	 *
	 * @apiParam {String} channelId 渠道ID
	 * @apiParam {Double} rate 比例
	 * @apiParam {Double} reportRate 报告量折扣系数
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
	public ResponseData add(AppChannelConfigPojo appChannelConfig) {
		this.setCreater(appChannelConfig);
		this.setMod(appChannelConfig);
		appChannelConfig.setStatus(EStatus.VALID.getVal());
		appChannelConfigService.insert(appChannelConfig);
		return ResponseData.succ(null);
	}

	/**
	 * @apiVersion 2019.3.15
	 * @api {post} /appChannelConfig/mgmt/updatePro/v1 MGMT渠道关联更新
	 * @apiGroup appChannelConfig
	 *
	 * @apiParam {Integer} id ID
	 * @apiUse AppChannelConfigPojo
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
	public ResponseData update(AppChannelConfigPojo appChannelConfig) {
		this.setMod(appChannelConfig);
		appChannelConfigService.update(appChannelConfig);
		return ResponseData.succ(null);
	}
}
