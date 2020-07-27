package com.aoying.loan.cust.app.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.aoying.loan.common.base.controller.BaseController;
import com.aoying.loan.common.base.pojo.ResponseData;
import com.aoying.loan.common.constant.eenum.EDeviceType;
import com.aoying.loan.common.constant.eenum.EStatus;
import com.aoying.loan.cust.app.pojo.AppBannerPojo;
import com.aoying.loan.cust.app.service.iservice.IAppBannerService;

/**
 * APP横幅广告表 Controller
 * @author nick
 */
@RestController
@RequestMapping("/appBanner")
public class AppBannerController extends BaseController<AppBannerPojo> {
    @Autowired
    private IAppBannerService appBannerService;

	/**
	 * @api {post} /appBanner/api/getListPub/v1 API获取Banner列表
	 * @apiGroup appBanner
	 *
	 * @apiParam {Integer} [deviceType] 设备类型，1android，2ios，3pc，4webapp，5landing，10other，默认4
	 * @apiParam {Integer} [position] 位置，1首页顶部，2审核页，3审核失败页，默认1
	 *
	 * @apiSuccess (成功响应) {String} reqResult 请求结果码、结果信息
	 * @apiSuccess (成功响应) {Integer} type 类型，1APP内链接，2外部H5链接
	 * @apiSuccess (成功响应) {String} imgUrl 图片URL
	 * @apiSuccess (成功响应) {String} targetUrl 点击后跳转URL
	 * @apiSuccessExample {json} 成功响应示例:
	{
	"data": [
	{
	"createTime": 1547946326000,
	"createrId": -1,
	"createrName": "admin",
	"id": 1,
	"imgUrl": "https://www.baidu.com",
	"status": 1,
	"targetUrl": "https://www.baidu.com",
	"type": 1
	}
	],
	"reqResult": {
	"code": 1,
	"msg": "操作成功"
	}
	}
	 */
	@RequestMapping("/api/getListPub/v1")
	public ResponseData getList(AppBannerPojo appBanner) {
		if (appBanner.getDeviceType() == null) { appBanner.setDeviceType(EDeviceType.PHONE.getVal()); }
		if (appBanner.getPosition() == null) { appBanner.setPosition(AppBannerPojo.Position.HomeTop.getVal()); }
		appBanner.setStatus(EStatus.VALID.getVal());
		List<AppBannerPojo> list = appBannerService.selectList(appBanner);
		return ResponseData.succ(list);
	}
}
