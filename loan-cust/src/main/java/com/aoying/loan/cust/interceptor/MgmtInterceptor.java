package com.aoying.loan.cust.interceptor;

import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import com.aoying.loan.common.util.HttpTool;
import com.aoying.loan.mgmtservice.mgmt.pojo.User;
import com.aoying.loan.cust.sys.service.iservice.ISysAuthInfoService;
import com.aoying.loan.mgmtservice.mgmt.controller.UserControllerMgmt;

/**
 * Mgmt访问权限拦截器
 * @author nick
 */
@Component
public class MgmtInterceptor implements HandlerInterceptor {
	/** 日志对象 */
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ISysAuthInfoService sysAuthInfoService;
	@Autowired
	private UserControllerMgmt mgmtUserController;

	@Value("${sysCfg.isRelease}")
	private Boolean isRelease;

	/**
	 * 在业务处理器处理请求之前被调用
	 * 如果返回false:
	 *     从当前的拦截器往回执行所有拦截器的afterCompletion()，再退出拦截器链
	 * 如果返回true:
	 *     执行下一个拦截器，直到所有的拦截器都执行完毕，再执行被拦截的Controller然后进入拦截器链，
	 *     从最后一个拦截器往回执行所有的postHandle()，接着再从最后一个拦截器往回执行所有的afterCompletion()
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String reqURI = request.getRequestURI();
		String reqIP = HttpTool.getIpAddr(request);
		logger.info(">>>>>>>>>> MGMT IP {} 请求 {}?{}", reqIP, reqURI, request.getQueryString());

		// 记录header参数
		Enumeration enu = request.getHeaderNames();
		while (enu.hasMoreElements()) {
			String headerName = (String) enu.nextElement();
			String headerValue = request.getHeader(headerName);
			if ("content-type".equalsIgnoreCase(headerName) ||
					"x_admintoken".equalsIgnoreCase(headerName)) {
				logger.info(">>>>>>>>>>{}:{}", headerName, headerValue);
			} else {
				logger.debug(">>>>>>>>>>{}:{}", headerName, headerValue);
			}
		}

		// 校验签名
		if (isRelease && reqURI.contains("/mgmt/")) {
			sysAuthInfoService.checkSign(request);
		}

		// 校验是否登录
		if (reqURI.contains("Pro/")) {
			User user = mgmtUserController.checkLogin(request);
			logger.info(">>>>>>>>>> 用户 {}", user);
		}
		return true;
	}

	/**
	 * 在业务处理器处理请求之后被调用，生成视图之前执行的动作
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
	}

	/**
	 * 在DispatcherServlet完全处理完请求后被调用
	 * 当有拦截器抛出异常时,会从当前拦截器往回执行所有的拦截器的afterCompletion()
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}
}
