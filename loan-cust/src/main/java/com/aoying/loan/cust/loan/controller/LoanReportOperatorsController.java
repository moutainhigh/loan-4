package com.aoying.loan.cust.loan.controller;

import java.sql.Timestamp;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.aoying.loan.common.base.controller.BaseController;
import com.aoying.loan.common.base.pojo.ResponseData;
import com.aoying.loan.common.constant.eenum.EReportStatus;
import com.aoying.loan.common.constant.response.exception.CustomMsgException;
import com.aoying.loan.common.constant.response.exception.DefineMsgException;
import com.aoying.loan.cust.cust.pojo.CustInfoPojo;
import com.aoying.loan.cust.cust.service.CustSessionService;
import com.aoying.loan.cust.loan.pojo.LoanReportOperatorsPojo;
import com.aoying.loan.cust.loan.service.iservice.ILoanReportOperatorsService;

/**
 * 贷款报告之运营商 Controller
 * @author nick
 */
@RestController
@RequestMapping("/loanReportOperators")
public class LoanReportOperatorsController extends BaseController<LoanReportOperatorsPojo> {
    @Autowired
    private CustSessionService custSessionService;
    @Autowired
    private ILoanReportOperatorsService loanReportOperatorsService;

    /**
     * @api {post} /loanReportOperators/api/addPro/v1 API运营商认证200416
     * @apiDescription 调用运营商认证接口，并保存认证结果
     * @apiGroup loanReportOperators
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
    public ResponseData add(LoanReportOperatorsPojo operatorsPojo, HttpServletRequest request) throws CustomMsgException, DefineMsgException {
        CustInfoPojo currCust = custSessionService.getCurrentCust(request);

        operatorsPojo.setCustId(currCust.getId());
        operatorsPojo.setReportId(-1L);
        operatorsPojo.setStatus(EReportStatus.SUCCESS.getVal());
        operatorsPojo.setCreateTime(new Timestamp(System.currentTimeMillis()));
        loanReportOperatorsService.insert(operatorsPojo);
        return ResponseData.succ(null);
    }
}
