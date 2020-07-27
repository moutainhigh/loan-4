package com.aoying.loan.cust.tool.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.aoying.loan.common.base.controller.BaseController;
import com.aoying.loan.cust.loan.service.iservice.ILoanProductService;

/**
 * 短链接
 * @author nick
 */
@RestController
public class ShortUrlController extends BaseController {
    @Autowired
    private ILoanProductService loanProductService;

    /**
     * @apiVersion 2019.3.3
     * @api {get} /u API随机跳转一个产品
     * @apiGroup shortUrl
     */
    @RequestMapping("/u")
    public void u(HttpServletResponse response) throws IOException {
        String url = loanProductService.getUrl();
        logger.info("随机重定向一个产品 {}", url);
        response.sendRedirect(url);
    }
}
