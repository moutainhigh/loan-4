/** */
package com.aoying.loan.cust.cust.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import com.aoying.loan.common.base.controller.BaseController;
import com.aoying.loan.cust.cust.pojo.CustLoginLogPojo;
import com.aoying.loan.cust.cust.service.iservice.ICustLoginLogService;

/**
 * @功能:【custloginlog 用户登陆日志】controller
 * @项目名:loan-cust
 * @作者:nick
 * @日期:2018-11-30 10:53:20
 * @说明：<pre></pre>
 */
//@RestController
//@RequestMapping("/custLoginLog")
public class CustLoginLogController extends BaseController<CustLoginLogPojo> {
	/** custloginlog 用户登陆日志service*/
    @Autowired
    private ICustLoginLogService custLoginLogService;
    
  	/**
	 * get
	 * @param custLoginLog
	 * @param request
	 * @param response
	 */
//	@RequestMapping("/get")
	public void get(CustLoginLogPojo custLoginLog, HttpServletRequest request, HttpServletResponse response) {

	}
}
