package com.aoying.loan.cust.app.controller;

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
public class AppVersionController extends BaseController<AppVersionPojo> {
    @Autowired
    private IAppVersionService appVersionService;

    /**
     * @api {post} /appVersion/api/getLastPro/v1 API获取最新版本0908
     * @apiGroup appVersion
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
    @RequestMapping("/api/getLastPro/v1")
    public ResponseData get(AppVersionPojo appVersion) {
        List<AppVersionPojo> list = appVersionService.selectList(appVersion);
        return ResponseData.succ(list.get(0));
    }
}
