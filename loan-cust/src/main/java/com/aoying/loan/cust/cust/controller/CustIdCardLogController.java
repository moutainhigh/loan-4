package com.aoying.loan.cust.cust.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import com.aoying.loan.common.base.controller.BaseController;
import com.aoying.loan.cust.cust.pojo.CustIdCardLogPojo;
import com.aoying.loan.cust.cust.service.iservice.ICustIdCardLogService;

/**
 * 用户实名日志表 Controller
 * @author nick
 */
//@RestController
//@RequestMapping("/custIdCardLog")
public class CustIdCardLogController extends BaseController<CustIdCardLogPojo> {
    @Autowired
    private ICustIdCardLogService custIdCardService;
    
  	/**
	 * get
	 * @param custIdCard
	 * @param request
	 * @param response
	 */
//	@RequestMapping("/get")
	public void get(CustIdCardLogPojo custIdCard, HttpServletRequest request, HttpServletResponse response) {

	}
}
