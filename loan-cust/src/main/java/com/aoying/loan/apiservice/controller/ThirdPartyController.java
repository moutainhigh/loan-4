package com.aoying.loan.apiservice.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.aoying.loan.common.base.controller.BaseController;
import com.aoying.loan.common.base.pojo.ResponseData;
import com.aoying.loan.common.constant.response.exception.DefineMsgException;
import com.aoying.loan.common.util.HttpTool;
import com.aoying.loan.cust.loan.pojo.LoanApplicationForLargePojo;
import com.aoying.loan.cust.loan.service.iservice.ILoanApplicationForLargeService;
import com.aoying.loan.cust.sys.pojo.SysAuthInfoPojo;
import com.aoying.loan.cust.sys.service.iservice.ISysAuthInfoService;

/**
 * 大额贷款申请 Controller
 * @author nick
 */
@RestController
@RequestMapping("/thirdParty")
public class ThirdPartyController extends BaseController {
    @Autowired
    private ISysAuthInfoService sysAuthInfoService;
    @Autowired
    private ILoanApplicationForLargeService loanApplicationForLargeService;

    private SysAuthInfoPojo checkSign(HttpServletRequest request) throws DefineMsgException {
        String reqURI = request.getRequestURI();
        String reqIP = HttpTool.getIpAddr(request);
        logger.info(">>>>>>>>>> ThirdParty IP {} 请求 {}?{}", reqIP, reqURI, request.getQueryString());

        return sysAuthInfoService.checkSign(request);
    }

    @RequestMapping("/largeApplication/v1")
    public ResponseData largeApplication(LoanApplicationForLargePojo pojo,
                                         HttpServletRequest request) throws DefineMsgException {
        SysAuthInfoPojo authInfo = this.checkSign(request);

        loanApplicationForLargeService.addOrUpdate(pojo, authInfo);
        return ResponseData.succ(null);
    }
}
