package com.aoying.loan.cust.loan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.aoying.loan.common.base.controller.BaseController;
import com.aoying.loan.common.base.pojo.ResponseData;
import com.aoying.loan.common.constant.response.exception.DefineMsgException;
import com.aoying.loan.cust.constant.EVerfCodeAndSmsTemplate;
import com.aoying.loan.cust.loan.pojo.LoanApplicationForLargePojo;
import com.aoying.loan.cust.loan.service.iservice.ILoanApplicationForLargeService;
import com.aoying.loan.cust.tool.service.VerfCodeService;

/**
 * 大额贷款申请 Controller
 * @author nick
 */
@RestController
@RequestMapping("/loanApplicationForLarge")
public class LoanApplicationForLargeController extends BaseController<LoanApplicationForLargePojo> {
    @Autowired
    private VerfCodeService verfCodeService;
    @Autowired
    private ILoanApplicationForLargeService loanApplicationForLargeService;

    /**
     * @api {post} /loanApplicationForLarge/api/submitPub/v1 API大额贷款申请提交0607
     * @apiGroup loanApplicationForLarge
     *
     * @apiParam {String} verfCode 短信验证码
     * @apiuse LoanApplicationForLargePojo
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
    @RequestMapping("/api/submitPub/v1")
    public ResponseData submit(LoanApplicationForLargePojo pojo, String verfCode) throws DefineMsgException {
        // 校验短信验证码
        verfCodeService.checkSmsVerfCode(EVerfCodeAndSmsTemplate.Large.getType(), pojo.getTelNo(), verfCode);

        loanApplicationForLargeService.addOrUpdate(pojo, null);
        return ResponseData.succ(null);
    }
}
