package com.aoying.loan.cust.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.aoying.loan.common.base.controller.BaseController;
import com.aoying.loan.common.base.pojo.ResponseData;
import com.aoying.loan.cust.app.pojo.AppChannelPojo;
import com.aoying.loan.cust.app.pojo.AppChannelVersionPojo;
import com.aoying.loan.cust.app.pojo.AppVersionPojo;
import com.aoying.loan.cust.app.service.iservice.IAppChannelService;
import com.aoying.loan.cust.app.service.iservice.IAppChannelVersionService;
import com.aoying.loan.cust.app.service.iservice.IAppVersionService;

/**
 * APP渠道版本关联表 Controller
 * @author nick
 */
@RestController
@RequestMapping("/appChannelVersion")
public class AppChannelVersionController extends BaseController<AppChannelVersionPojo> {
    @Autowired
    private IAppChannelVersionService appChannelVersionService;
    @Autowired
    private IAppChannelService appChannelService;
    @Autowired
    private IAppVersionService appVersionService;

    /**
     * @api {post} /appChannelVersion/api/getPub/v1 API渠道版本信息0714
     * @apiGroup appChannelVersion
     *
     * @apiParam {Long} channelId 渠道Id
     * @apiParam {Long} [currVerId] 版本id，V1.0.0为100，V4.8.1为481
     *
     * @apiSuccess (成功响应) {String} reqResult 请求结果码、结果信息
     * @apiSuccess (成功响应) {Object} data 请求结果数据
     * @apiSuccess (成功响应) {Object} data.downloadUrl app下载地址
     * @apiSuccess (成功响应) {Object} data.auditStatus 审核状态，1审核中，2审核通过
     * @apiSuccess (成功响应) {Object} data.channel 渠道信息
     * @apiSuccess (成功响应) {Integer} data.channel.auditVerId 审核版本ID
     * @apiSuccess (成功响应) {Integer} data.channel.lowestVerId 最低版本ID
     * @apiSuccess (成功响应) {Integer} data.channel.highestVerId 最高版本ID
     * @apiSuccess (成功响应) {Object} data.version 版本信息
     * @apiSuccessExample {json} 成功响应示例:
    {
    "data": {
    "auditStatus": 1,
    "channelId": 1,
    "createTime": 1563092523000,
    "createrId": -1,
    "createrName": "admin",
    "currVerId": 100,
    "downloadUrl": "http://www.baidu.com",
    "id": 1,
    "status": 1
    },
    "reqResult": {
    "code": 1,
    "msg": "操作成功"
    }
    }
     */
	@RequestMapping("/api/getPub/v1")
	public ResponseData get(AppChannelVersionPojo appChannelVersion) {
        // 获取渠道信息
        AppChannelPojo channel = new AppChannelPojo();
        channel.setId(appChannelVersion.getChannelId());
        channel = appChannelService.selectUnique(channel);

        if (appChannelVersion.getCurrVerId() == null) {
            appChannelVersion.setCurrVerId(channel.getHighestVerId());
        }

        // 获取版本信息
        AppVersionPojo version = new AppVersionPojo();
        version.setId(appChannelVersion.getCurrVerId());
        version = appVersionService.selectUnique(version);

        // 获取关联信息
        AppChannelVersionPojo pojo = appChannelVersionService.selectUnique(appChannelVersion);
        if (pojo == null) { pojo = new AppChannelVersionPojo(); }

        // 设置版本渠道
        pojo.setVersion(version);
        pojo.setChannel(channel);

        return ResponseData.succ(pojo);
    }
}
