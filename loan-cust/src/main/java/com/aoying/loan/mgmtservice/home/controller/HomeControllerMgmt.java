package com.aoying.loan.mgmtservice.home.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.aoying.loan.common.base.controller.BaseController;
import com.aoying.loan.common.base.pojo.BasePojo;
import com.aoying.loan.common.base.pojo.ResponseData;
import com.aoying.loan.cust.cust.service.iservice.ICustInfoService;
import com.aoying.loan.cust.loan.service.iservice.ILoanProductService;
import com.aoying.loan.cust.loan.service.iservice.ILoanReportService;

/**
 * 首页
 * @author nick
 */
@RestController
@RequestMapping("/home")
public class HomeControllerMgmt extends BaseController<BasePojo> {
    @Autowired
    private ICustInfoService custInfoService;
    @Autowired
    private ILoanReportService loanReportService;
    @Autowired
    private ILoanProductService loanProductService;

    /**
     * @apiVersion 2019.3.18
     * @api {post} /home/mgmt/getDataPro/v1 MGMT首页获取数据
     * @apiGroup home
     *
     * @apiSuccess (成功响应) {String} reqResult 请求结果码、结果信息
     * @apiSuccessExample {json} 成功响应示例:
    {
    "data": {
    "amount": {
    "total": "0",
    "today": "0"
    },
    "product": {
    "total": 4,
    "today": 3
    },
    "report": {
    "total": 1,
    "today": 0
    },
    "registration": {
    "total": 43,
    "today": 0
    }
    },
    "reqResult": {
    "code": 1,
    "msg": "操作成功"
    }
    }
     */
    @RequestMapping("/mgmt/getDataPro/v1")
    public ResponseData getData() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("today", "0");
        map.put("total", "0");

        Map<String, Map<String, String>> result = new HashMap<String, Map<String, String>>();
        result.put("registration", custInfoService.getRegistrationData());
        result.put("report", loanReportService.getReportData());
        result.put("amount", map);
        result.put("product", loanProductService.getProductData());

        return ResponseData.succ(result);
    }
}
