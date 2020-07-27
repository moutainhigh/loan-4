package com.aoying.loan.cust.tool.controller;

import java.io.BufferedReader;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.aoying.loan.common.base.controller.BaseController;
import com.aoying.loan.common.base.pojo.ResponseData;
import com.aoying.loan.cust.loan.service.iservice.ILoanReportService;
import com.aoying.loan.cust.tool.service.iservice.ISmsSendService;
import com.aoying.loan.cust.trade.service.iservice.ITradeOrderService;
import com.github.wxpay.sdk.WXPay;

/**
 * 第三方回调 Controller
 * @author nick
 */
@RestController
public class CallbackController extends BaseController {
    @Autowired
    private ISmsSendService smsSendService;
    @Autowired
    private WXPay wxPayApi;
    @Autowired
    private ITradeOrderService tradeOrderService;
    @Autowired
    private ILoanReportService loanReportService;

    @RequestMapping("/msg/sms1086/api/callback/v1")
    public ResponseData callback() {
        return null;
    }

    /**
     * 微信支付结果通知
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/wx/pay/notify")
    public void wxPayNotify(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 获取body中的xml字符串
        BufferedReader br = request.getReader();
        String str, wholeStr = "";
        while((str = br.readLine()) != null){
            wholeStr += str;
        }
        logger.info("[微信支付] 支付结果通知 {}", wholeStr);

        // 将xml解析成map
        Map<String, String> map = wxPayApi.processResponseXml(wholeStr);
        logger.info("[微信支付] 支付结果通知 {}", map);

        // 更新订单
        tradeOrderService.update(map, true);

        // 返回xml响应
        String result =
                "<xml>\n" +
                "  <return_code><![CDATA[SUCCESS]]></return_code>\n" +
                "  <return_msg><![CDATA[OK]]></return_msg>\n" +
                "</xml>";
        response.setHeader("content-type", "application/xml;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(result);
    }
}
