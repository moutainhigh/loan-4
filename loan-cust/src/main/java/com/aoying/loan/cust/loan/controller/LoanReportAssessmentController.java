package com.aoying.loan.cust.loan.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.aoying.loan.common.base.controller.BaseController;
import com.aoying.loan.common.base.pojo.ResponseData;
import com.aoying.loan.common.constant.response.exception.CustomMsgException;
import com.aoying.loan.common.constant.response.exception.DefineMsgException;
import com.aoying.loan.cust.cust.pojo.CustInfoPojo;
import com.aoying.loan.cust.cust.service.CustSessionService;
import com.aoying.loan.cust.loan.pojo.LoanReportAssessmentPojo;
import com.aoying.loan.cust.loan.service.iservice.ILoanReportAssessmentService;

/**
 * 贷款报告之明镜 Controller
 * @author nick
 */
@RestController
@RequestMapping("/loanReportAssessment")
public class LoanReportAssessmentController extends BaseController<LoanReportAssessmentPojo> {
    @Autowired
    private CustSessionService custSessionService;
    @Autowired
    private ILoanReportAssessmentService loanReportAssessmentService;

    /**
     * @api {post} /loanReportAssessment/api/addPro/v1 API明镜新增0724
     * @apiDescription 保存明镜SDK结果
     * @apiGroup loanReportAssessment
     *
     * @apiParam {String} [orderId] 订单ID
     * @apiParam {String} [resStr] 明镜评估JSON结果
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
    public ResponseData add(Long orderId, String resStr, HttpServletRequest request) throws CustomMsgException, DefineMsgException {
        CustInfoPojo currCust = custSessionService.getCurrentCust(request);
        loanReportAssessmentService.add(currCust.getId(), orderId, resStr);
        return ResponseData.succ(null);
    }
}
