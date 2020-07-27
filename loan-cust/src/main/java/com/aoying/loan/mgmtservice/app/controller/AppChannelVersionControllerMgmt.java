package com.aoying.loan.mgmtservice.app.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.aoying.loan.common.base.controller.BaseController;
import com.aoying.loan.common.base.pojo.ResponseData;
import com.aoying.loan.cust.app.pojo.AppChannelVersionPojo;
import com.aoying.loan.cust.app.service.iservice.IAppChannelVersionService;

/**
 * APP渠道版本关联表 Controller
 * @author nick
 */
@RestController
@RequestMapping("/appChannelVersion")
public class AppChannelVersionControllerMgmt extends BaseController<AppChannelVersionPojo> {
    @Autowired
    private IAppChannelVersionService appChannelVersionService;

    /**
     * @api {post} /appChannelVersion/mgmt/getListPub/v1 MGMT渠道版本列表0717
     * @apiGroup appChannelVersion
     *
     * @apiSuccess (成功响应) {String} reqResult 请求结果码、结果信息
     * @apiSuccessExample {json} 成功响应示例:
    {
    "data": [
    {
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
    {
    "channelId": 1,
    "createTime": 1563092523000,
    "createrId": -1,
    "createrName": "admin",
    "currVerId": 481,
    "id": 2,
    "status": 1
    }
    ],
    "reqResult": {
    "code": 1,
    "msg": "操作成功"
    }
    }
     */
    @RequestMapping("/mgmt/getListPub/v1")
    public ResponseData getList(AppChannelVersionPojo appChannelVersion) {
        List<AppChannelVersionPojo> list = appChannelVersionService.selectList(appChannelVersion);
        return ResponseData.succ(list);
    }

    /**
     * @api {post} /appChannelVersion/mgmt/getPro/v1 MGMT渠道版本单个0717
     * @apiGroup appChannelVersion
     *
     * @apiParam {Integer} id ID
     *
     * @apiSuccess (成功响应) {String} reqResult 请求结果码、结果信息
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
    @RequestMapping("/mgmt/getPro/v1")
    public ResponseData get(AppChannelVersionPojo appChannelVersion) {
        AppChannelVersionPojo pojo = appChannelVersionService.selectUnique(appChannelVersion);
        return ResponseData.succ(pojo);
    }

    /**
     * @api {post} /appChannelVersion/mgmt/addPro/v1 MGMT渠道版本新增0717
     * @apiGroup appChannelVersion
     *
     * @apiParam {Integer} [id] ID
     * @apiParam {Long} channelId 渠道Id
     * @apiParam {Long} currVerId 版本id
     * @apiParam {String} [downloadUrl] app下载地址
     * @apiParam {Integer} [auditStatus] 审核状态，1审核中，2审核通过
     * @apiParam {Integer} status 记录状态
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
    public ResponseData add(AppChannelVersionPojo appChannelVersion) {
        this.setCreater(appChannelVersion);
        appChannelVersionService.insert(appChannelVersion);
        return ResponseData.succ(null);
    }

    /**
     * @api {post} /appChannelVersion/mgmt/updatePro/v1 MGMT渠道版本更新0717
     * @apiGroup appChannelVersion
     *
     * @apiUse AppChannelVersionPojo
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
    public ResponseData update(AppChannelVersionPojo appChannelVersion) {
        this.setMod(appChannelVersion);
        appChannelVersionService.update(appChannelVersion);
        return ResponseData.succ(null);
    }
}
