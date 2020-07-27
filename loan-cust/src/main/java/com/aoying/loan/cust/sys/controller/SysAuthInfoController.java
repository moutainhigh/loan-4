package com.aoying.loan.cust.sys.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import com.aoying.loan.cust.sys.pojo.SysAuthInfoPojo;
import com.aoying.loan.common.base.controller.BaseController;
import com.aoying.loan.cust.sys.service.iservice.ISysAuthInfoService;

/**
 * 系统访问认证信息 Controller
 * @author nick
 */
@RestController
@RequestMapping("/sysAuthInfo")
public class SysAuthInfoController extends BaseController<SysAuthInfoPojo> {
    @Autowired
    private ISysAuthInfoService sysAuthInfoService;
    
  	/**
	 * get
	 * @param sysAuthInfo
	 * @param request
	 * @param response
	 */
	@RequestMapping("/get")
	public void get(SysAuthInfoPojo sysAuthInfo, HttpServletRequest request, HttpServletResponse response) {

	}
}
