package com.aoying.loan.mgmtservice.app.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.aoying.loan.common.base.controller.BaseController;
import com.aoying.loan.common.base.pojo.ResponseData;
import com.aoying.loan.cust.app.pojo.AppVersionPojo;
import com.aoying.loan.cust.app.service.iservice.IAppVersionService;

/**
 * APP版本表 Controller
 * @author nick
 */
@RestController
@RequestMapping("/appVersion")
public class AppVersionControllerMgmt extends BaseController<AppVersionPojo> {
    @Autowired
    private IAppVersionService appVersionService;

    /**
     * @api {post} /appVersion/mgmt/getListPub/v1 MGMT版本列表0717
     * @apiGroup appVersion
     *
     * @apiSuccess (成功响应) {String} reqResult 请求结果码、结果信息
     * @apiSuccessExample {json} 成功响应示例:
    {
    "data": [
    {
    "createTime": 1563092469000,
    "createrId": -1,
    "createrName": "admin",
    "id": 100,
    "lowestVerId": 100,
    "lowestVerText": "v1.0.0",
    "status": 1,
    "verText": "v1.0.0"
    },
    {
    "createTime": 1563092469000,
    "createrId": -1,
    "createrName": "admin",
    "id": 481,
    "lowestVerId": 100,
    "lowestVerText": "v1.0.0",
    "status": 1,
    "verText": "v4.8.1"
    }
    ],
    "reqResult": {
    "code": 1,
    "msg": "操作成功"
    }
    }
     */
    @RequestMapping("/mgmt/getListPub/v1")
    public ResponseData getList(AppVersionPojo appVersion) {
        List<AppVersionPojo> list = appVersionService.selectList(appVersion);
        return ResponseData.succ(list);
    }

    /**
     * @api {post} /appVersion/mgmt/getPro/v1 MGMT版本单个0717
     * @apiGroup appVersion
     *
     * @apiParam {Integer} id ID
     *
     * @apiSuccess (成功响应) {String} reqResult 请求结果码、结果信息
     * @apiSuccessExample {json} 成功响应示例:
    {
    "data": {
    "createTime": 1563092469000,
    "createrId": -1,
    "createrName": "admin",
    "id": 100,
    "lowestVerId": 100,
    "lowestVerText": "v1.0.0",
    "status": 1,
    "verText": "v1.0.0"
    },
    "reqResult": {
    "code": 1,
    "msg": "操作成功"
    }
    }
     */
    @RequestMapping("/mgmt/getPro/v1")
    public ResponseData get(AppVersionPojo appVersion) {
        AppVersionPojo pojo = appVersionService.selectUnique(appVersion);
        return ResponseData.succ(pojo);
    }

    /**
     * @api {post} /appVersion/mgmt/addPro/v1 MGMT版本新增0717
     * @apiGroup appVersion
     *
     * @apiParam {Integer} [id] ID
     * @apiParam {String} verText 版本字符串
     * @apiParam {Long} [lowestVerId] 最低版本id
     * @apiParam {String} [lowestVerText] 最低版本字符串
     * @apiParam {String} [code] APP编号
     * @apiParam {String} [name] APP名称
     * @apiParam {String} [remark] 备注
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
    public ResponseData add(AppVersionPojo appVersion) {
        this.setCreater(appVersion);
        appVersionService.insert(appVersion);
        return ResponseData.succ(null);
    }

    /**
     * @api {post} /appVersion/mgmt/updatePro/v1 MGMT版本更新0717
     * @apiGroup appVersion
     *
     * @apiUse AppVersionPojo
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
    public ResponseData update(AppVersionPojo appVersion) {
        this.setMod(appVersion);
        appVersionService.update(appVersion);
        return ResponseData.succ(null);
    }
}
