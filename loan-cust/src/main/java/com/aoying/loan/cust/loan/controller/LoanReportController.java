package com.aoying.loan.cust.loan.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.aoying.loan.common.base.controller.BaseController;
import com.aoying.loan.common.base.pojo.ResponseData;
import com.aoying.loan.common.constant.response.code.EResCodeCust;
import com.aoying.loan.common.constant.response.exception.DefineMsgException;
import com.aoying.loan.cust.cust.pojo.CustIdCardPojo;
import com.aoying.loan.cust.cust.pojo.CustInfoPojo;
import com.aoying.loan.cust.cust.service.CustSessionService;
import com.aoying.loan.cust.cust.service.iservice.ICustIdCardService;
import com.aoying.loan.cust.loan.pojo.LoanReportOperatorsPojo;
import com.aoying.loan.cust.loan.pojo.LoanReportPojo;
import com.aoying.loan.cust.loan.service.iservice.ILoanReportOperatorsService;
import com.aoying.loan.cust.loan.service.iservice.ILoanReportService;

/**
 * 贷款报告 Controller
 * @author nick
 */
@RestController
@RequestMapping("/loanReport")
public class LoanReportController extends BaseController<LoanReportPojo> {
    @Autowired
    private CustSessionService custSessionService;
    @Autowired
    private ICustIdCardService custIdCardService;
    @Autowired
    private ILoanReportService loanReportService;
    @Autowired
    private ILoanReportOperatorsService loanReportOperatorsService;

    /**
     * @api {post} /loanReport/api/addPro/v1 API报告新增200416
     * @apiGroup loanReport
     *
     * @apiSuccess (成功响应) {String} reqResult 请求结果码、结果信息
     * @apiSuccess (成功响应) {Object} data 请求结果数据
     * @apiSuccessExample {json} 成功响应示例:
    {
    "data": {
    },
    "reqResult": {
    "code": 1,
    "msg": "操作成功"
    }
    }
     */
    @RequestMapping("/api/addPro/v1")
    public ResponseData add(LoanReportPojo loanReport, HttpServletRequest request) throws DefineMsgException, IOException {
        CustInfoPojo currCust = custSessionService.getCurrentCust(request);

        if (!loanReportService.checkUpdatable(currCust.getId())) {
            return ResponseData.succ("报告最近更新过，请过几日再试");
        }

        // 校验是否实名，若未实名返回实名认证失败，若已实名忽略前端实名数据
        CustIdCardPojo idCard = new CustIdCardPojo();
        idCard.setCustId(currCust.getId());
        CustIdCardPojo authIdCard = custIdCardService.addAndAuthIdCard(idCard);
        if (!CustIdCardPojo.Status.SUCC.getVal().equals(authIdCard.getStatus())) {
            return new ResponseData(EResCodeCust.svceErrAuthIdCardErr.getOptResult(logger));
        }

        // 新增报告
        loanReport.setCustId(currCust.getId());
        loanReport.setTelNo(currCust.getTelNo());
        loanReport.setIdCardCode(authIdCard.getIdCardCode());
        loanReport.setIdCardName(authIdCard.getIdCardName());
        LoanReportPojo result = loanReportService.add(loanReport);

        return ResponseData.succ(result);
    }

    /**
     * @api {post} /loanReport/api/getListPro/v1 API报告列表200416
     * @apiGroup loanReport
     * @apiDescription 获取当前登录者名下的贷款报告列表，可以使用分页参数
     *
     * @apiuse DefPage
     *
     * @apiSuccess (成功响应) {String} reqResult 请求结果码、结果信息
     * @apiSuccess (成功响应) {String} data 贷款列表
     * @apiSuccessExample {json} 成功响应示例:
    {
    "data": [
    {
    "custId": 4,
    "id": 1,
    "idCardName": "张三",
    "reportTime": 1547115111576,
    "status": 21
    },
    {
    "custId": 4,
    "id": 2,
    "idCardName": "张三",
    "reportTime": 1547115764219,
    "status": 21
    }
    ],
    "reqResult": {
    "code": 1,
    "msg": "操作成功"
    }
    }
     */
    @RequestMapping("/api/getListPro/v1")
    public ResponseData getList(LoanReportPojo loanReport, HttpServletRequest request) throws DefineMsgException {
        CustInfoPojo currCust = custSessionService.getCurrentCust(request);

        loanReport.setCustId(currCust.getId());
        List<LoanReportPojo> list = loanReportService.selectList(loanReport);

        return ResponseData.succ(list);
    }

    /**
     * @api {post} /loanReport/api/getPro/v1 API报告单个200416
     * @apiGroup loanReport
     * @apiDescription 报告结果请参考第三方接口 <https://docs.xinyan.com/docs/credit-all-v3?token=q07JyRoP8w23>
     *
     * @apiParam {Integer} id 贷款报告ID
     *
     * @apiSuccess (成功响应) {String} reqResult 请求结果码、结果信息
     * @apiSuccess (成功响应) {String} data 贷款报告对象，注意reportJson是String类型
     * @apiSuccessExample {json} 成功响应示例:
    {
    "data": {
    "createTime": 1547118559094,
    "custId": 4,
    "id": 3,
    "idCardCode": "522627199205133333",
    "idCardName": "张三",
    "reportJson": "{\"code\":\"0\",\"id_no\":\"9e3fba8b7dba9d59ef5075971d198fe3\",\"versions\":\"1.3.0\",\"fee\":\"Y\",\"trade_no\":\"20190110190919988000000074424631\",\"trans_id\":\"2e98b51fdc2c48e5b47756a81dc71d44\",\"id_name\":\"615db57aa314529aaa0fbe95b3e95bd3\",\"result_detail\":{\"current_report_detail\":{\"consfin_credit_limit\":\"8900\",\"loans_org_count\":\"20\",\"consfin_avg_limit\":\"8645\",\"loans_product_count\":\"22\",\"consfin_org_count\":\"11\",\"loans_max_limit\":\"4500\",\"loans_credibility\":\"77\",\"consfin_product_count\":\"14\",\"consfin_max_limit\":\"15600\",\"consfin_credibility\":\"79\",\"loans_credit_limit\":\"2100\",\"loans_avg_limit\":\"1815\"},\"behavior_report_detail\":{\"loans_count\":\"78\",\"loans_long_time\":\"361\",\"consfin_org_count\":\"11\",\"loans_cash_count\":\"20\",\"latest_six_month\":\"15\",\"history_fail_fee\":\"55\",\"latest_three_month\":\"7\",\"latest_one_month_fail\":\"4\",\"latest_one_month\":\"1\",\"loans_latest_time\":\"2018-05-09\",\"latest_one_month_suc\":\"0\",\"history_suc_fee\":\"88\",\"loans_org_count\":\"31\",\"loans_credibility\":\"89\",\"loans_score\":\"611\",\"loans_overdue_count\":\"3\",\"loans_settle_count\":\"77\"},\"apply_report_detail\":{\"latest_query_time\":\"2018-09-01\",\"query_sum_count\":\"42\",\"apply_credibility\":\"73\",\"query_org_count\":\"23\",\"latest_six_month\":\"33\",\"query_cash_count\":\"4\",\"apply_score\":\"498\",\"latest_three_month\":\"32\",\"query_finance_count\":\"17\",\"latest_one_month\":\"5\"}},\"desc\":\"查询成功\"}",
    "reportNo": "2e98b51fdc2c48e5b47756a81dc71d44",
    "reportTime": 1547118559143,
    "status": 21,
    "telNo": "15012345678"
    },
    "reqResult": {
    "code": 1,
    "msg": "操作成功"
    }
    }
     */
    @RequestMapping("/api/getPro/v1")
    public ResponseData get(LoanReportPojo loanReport, HttpServletRequest request) throws DefineMsgException {
        CustInfoPojo currCust = custSessionService.getCurrentCust(request);

        loanReport.setCustId(currCust.getId());
        LoanReportPojo report = loanReportService.selectUnique(loanReport);

        if (report != null) {
            LoanReportOperatorsPojo opt = new LoanReportOperatorsPojo();
            opt.setCustId(currCust.getId());
            opt.setReportId(report.getId());
            opt = loanReportOperatorsService.selectUnique(opt);
            report.setOperators(opt);
        }

        return ResponseData.succ(report);
    }
}
