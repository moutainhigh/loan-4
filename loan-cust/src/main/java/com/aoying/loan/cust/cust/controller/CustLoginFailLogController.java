/** */
package com.aoying.loan.cust.cust.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import com.aoying.loan.common.base.controller.BaseController;
import com.aoying.loan.cust.cust.pojo.CustLoginFailLogPojo;
import com.aoying.loan.cust.cust.service.iservice.ICustLoginFailLogService;

/**
 * @功能:【custloginfaillog 用户登陆失败日志】controller
 * @项目名:loan-cust
 * @作者:nick
 * @日期:2018-11-30 10:53:20
 * @说明：<pre></pre>
 */
//@RestController
//@RequestMapping("/custLoginFailLog")
public class CustLoginFailLogController extends BaseController<CustLoginFailLogPojo> {
	/** custloginfaillog 用户登陆失败日志service*/
    @Autowired
    private ICustLoginFailLogService custLoginFailLogService;
    
  	/**
	 * get
	 * @param custLoginFailLog
	 * @param request
	 * @param response
	 */
//	@RequestMapping("/get")
	public void get(CustLoginFailLogPojo custLoginFailLog, HttpServletRequest request, HttpServletResponse response) {

	}
}
