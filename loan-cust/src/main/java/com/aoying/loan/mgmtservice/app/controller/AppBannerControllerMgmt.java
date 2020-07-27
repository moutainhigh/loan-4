package com.aoying.loan.mgmtservice.app.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.aoying.loan.common.base.controller.BaseController;
import com.aoying.loan.common.base.pojo.ResponseData;
import com.aoying.loan.common.constant.eenum.EStatus;
import com.aoying.loan.cust.app.pojo.AppBannerPojo;
import com.aoying.loan.cust.app.service.iservice.IAppBannerService;

/**
 * APP横幅广告表 Controller
 * @author nick
 */
@RestController
@RequestMapping("/appBanner")
public class AppBannerControllerMgmt extends BaseController<AppBannerPojo> {
    @Autowired
    private IAppBannerService appBannerService;

	/**
	 * @apiVersion 2019.3.18
	 * @api {post} /appBanner/mgmt/getListPro/v1 MGMT广告获取列表
	 * @apiGroup appBanner
	 *
	 * @apiParam {Integer} [deviceType] 设备类型，1android，2ios，3pc，4webapp，5landing，10other，默认4
	 * @apiParam {Integer} [position] 位置，1首页顶部，默认1
	 *
	 * @apiSuccess (成功响应) {String} reqResult 请求结果码、结果信息
	 * @apiSuccessExample {json} 成功响应示例:
	{
	"data": [
	{
	"createTime": 1552893697113,
	"createrId": -1,
	"createrName": "admin",
	"deviceType": 1,
	"id": 4,
	"imgUrl": "http://www.baidu.com",
	"modId": -1,
	"modName": "admin",
	"modTime": 1552895323803,
	"orderCode": 2,
	"position": 1,
	"status": 1,
	"type": 1
	},
	{
	"createTime": 1552895294583,
	"createrId": -1,
	"createrName": "admin",
	"deviceType": 1,
	"id": 5,
	"imgUrl": "http://www.baidu.com",
	"orderCode": 20,
	"position": 1,
	"status": 2,
	"targetUrl": "http://www.qq.com",
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
	public ResponseData getList(AppBannerPojo pojo) {
		List<AppBannerPojo> list = appBannerService.selectList(pojo);
		return ResponseData.succ(list);
	}

	/**
	 * @apiVersion 2019.3.18
	 * @api {post} /appBanner/mgmt/getPro/v1 MGMT广告获取单个
	 * @apiGroup appBanner
	 *
	 * @apiParam {Integer} id ID
	 *
	 * @apiSuccess (成功响应) {String} reqResult 请求结果码、结果信息
	 * @apiSuccessExample {json} 成功响应示例:
	{
	"data": {
	"createTime": 1548084988000,
	"createrId": -1,
	"createrName": "admin",
	"deviceType": 4,
	"id": 1,
	"imgUrl": "http://res.51jiekuanwang.com/banner/banner-loan-product.png",
	"orderCode": 10,
	"position": 1,
	"status": 1,
	"targetUrl": "http://payday-sc1.lkdjhls.cn/static/download.html?show=1&agentid=30153869",
	"type": 2
	},
	"reqResult": {
	"code": 1,
	"msg": "操作成功"
	}
	}
	 */
	@RequestMapping("/mgmt/getPro/v1")
	public ResponseData get(AppBannerPojo pojo) {
		AppBannerPojo result = appBannerService.selectUnique(pojo);
		return ResponseData.succ(result);
	}

	/**
	 * @apiVersion 2019.3.18
	 * @api {post} /appBanner/mgmt/addPro/v1 MGMT广告新增
	 * @apiGroup appBanner
	 *
	 * @apiParam {Integer} [name] 名称
	 * @apiParam {Integer} deviceType 设备类型，1android，2ios，3pc，4webapp，5landing，10other
	 * @apiParam {Integer} position 位置，1首页顶部
	 * @apiParam {Integer} type 类型，1APP内链接，2外部H5链接
	 * @apiParam {String} imgUrl 图片URL
	 * @apiParam {String} [targetUrl] 点击后跳转URL
	 * @apiParam {Integer} [orderCode] 排序，默认10，最多两位
	 * @apiParam {Integer} [status] 状态，0作废，1正常，2删除
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
	public ResponseData add(AppBannerPojo pojo) {
		this.setCreater(pojo);
		if (pojo.getOrderCode() == null) { pojo.setOrderCode(10); }
		if (pojo.getStatus() == null) { pojo.setStatus(EStatus.VALID.getVal()); }
		appBannerService.insert(pojo);
		return ResponseData.succ(null);
	}

	/**
	 * @apiVersion 2019.3.18
	 * @api {post} /appBanner/mgmt/updatePro/v1 MGMT广告更新
	 * @apiGroup appBanner
	 *
	 * @apiParam {Integer} id ID
	 * @apiParam {Integer} [name] 名称
	 * @apiParam {Integer} [deviceType] 设备类型，1android，2ios，3pc，4webapp，5landing，10other
	 * @apiParam {Integer} [position] 位置，1首页顶部
	 * @apiParam {Integer} [type] 类型，1APP内链接，2外部H5链接
	 * @apiParam {String} [imgUrl] 图片URL
	 * @apiParam {String} [targetUrl] 点击后跳转URL
	 * @apiParam {Integer} [orderCode] 排序，默认10，最多两位
	 * @apiParam {Integer} [status] 状态，0作废，1正常，2删除
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
	public ResponseData update(AppBannerPojo pojo) {
		this.setMod(pojo);
		appBannerService.update(pojo);
		return ResponseData.succ(null);
	}
}
