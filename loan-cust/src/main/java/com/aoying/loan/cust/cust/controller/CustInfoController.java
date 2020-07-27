/** */
package com.aoying.loan.cust.cust.controller;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.aoying.loan.common.base.controller.BaseController;
import com.aoying.loan.common.base.pojo.ResponseData;
import com.aoying.loan.common.constant.response.exception.DefineMsgException;
import com.aoying.loan.cust.cust.service.CustSessionService;
import com.aoying.loan.cust.constant.EVerfCodeAndSmsTemplate;
import com.aoying.loan.cust.cust.pojo.CustInfoPojo;
import com.aoying.loan.cust.cust.service.iservice.ICustInfoService;
import com.aoying.loan.cust.tool.service.VerfCodeService;

/**
 * @功能:【custinfo 用户信息表】controller
 * @项目名:loan-cust
 * @作者:nick
 * @日期:2018-11-30 10:53:19
 * @说明：<pre></pre>
 */
@RestController
@RequestMapping("/custInfo")
public class CustInfoController extends BaseController<CustInfoPojo> {
	@Autowired
	private VerfCodeService verfCodeService;
	@Autowired
	private CustSessionService custSessionService;
    @Autowired
    private ICustInfoService custInfoService;

	/**
	 * @api {post} /custInfo/api/registerPub/v1 API注册
	 * @apiGroup cust
	 *
	 * @apiParam {String} telNo 手机号码
	 * @apiParam {String} verfCode 短信验证码
	 * @apiUse CustInfoPojo
	 */
	@RequestMapping("/api/registerPub/v1")
	public ResponseData register(CustInfoPojo cust, String verfCode) throws Exception {
	    this.setDefaultVal(cust);

	    // 检查短信验证码
		verfCodeService.checkSmsVerfCode(EVerfCodeAndSmsTemplate.REGISTER.getType(), cust.getTelNo(), verfCode);

		// 先注册，然后登录并返回Token
		custInfoService.addRegister(cust);
		return ResponseData.succ(null);
	}

	/**
	 * @api {post} /custInfo/api/loginByPwdPub/v1 API通过密码登录
     * @apiDescription 若该用户未注册，则返回错误信息
	 * @apiGroup cust
	 *
	 * @apiParam {String} telNo 手机号码
	 * @apiParam {String} verfCode 短信验证码
	 * @apiUse CustInfoPojo
	 */
	@RequestMapping("/api/loginByPwdPub/v1")
	public ResponseData loginByPwd(CustInfoPojo cust) throws DefineMsgException {
		this.setDefaultVal(cust);

		// 若未注册则返回错误信息，否则登录并返回Token
		Map<String, Object> resData = custInfoService.addLoginByPwd(cust);
		return ResponseData.succ(resData);
	}

	/**
	 * @api {post} /custInfo/api/loginBySmsPub/v1 API通过短信登录
	 * @apiDescription 若该用户未注册，则默认注册然后返回登录信息
	 * @apiGroup cust
	 *
	 * @apiParam {String} telNo 手机号码
	 * @apiParam {String} verfCode 短信验证码
	 * @apiUse CustInfoPojo
	 */
	@RequestMapping("/api/loginBySmsPub/v1")
	public ResponseData loginBySms(CustInfoPojo cust, String verfCode) throws DefineMsgException {
		this.setDefaultVal(cust);

		// 检查短信验证码
		if ("18621599019,19916595663".contains(cust.getTelNo()) && "0313".equals(verfCode)) {
			// APP审核账号
		} else {
			verfCodeService.checkSmsVerfCode(EVerfCodeAndSmsTemplate.LOGIN.getType(), cust.getTelNo(), verfCode);
		}

		// 若未注册则先注册，否则登录并返回Token
		Map<String, Object> resData = custInfoService.addLoginBySms(cust);
		return ResponseData.succ(resData);
	}

	/**
	 * @api {post} /custInfo/api/getPro/v1 API获取用户信息0724
	 * @apiGroup cust
	 *
	 * @apiuse DefHeaderPro
	 *
	 * @apiSuccess (成功响应) {String} reqResult 请求结果码、结果信息
	 * @apiSuccess (成功响应) {Object} data 请求结果数据
	 * @apiSuccess (成功响应) {Object} data.idCardCodeHide 隐藏的身份证号
	 * @apiSuccess (成功响应) {Object} data.idCardNameHide 隐藏的姓名
	 * @apiSuccess (成功响应) {Object} data.idCardName 姓名
	 * @apiSuccess (成功响应) {Object} data.reportId 报告ID
	 * @apiSuccess (成功响应) {Object} data.optId 运营商报告ID
	 * @apiSuccess (成功响应) {Object} data.assId 明镜报告ID
	 * @apiSuccess (成功响应) {Object} data.agreement 同意协议，0未同意，1同意
	 */
	@RequestMapping("/api/getPro/v1")
	public ResponseData get(HttpServletRequest request) throws DefineMsgException {
		CustInfoPojo cust = custSessionService.getCurrentCust(request);
		CustInfoPojo resData = custInfoService.getById(cust);
		return ResponseData.succ(resData);
	}

	/**
	 * @api {post} /custInfo/api/agreementPro/v1 API同意协议0911
	 * @apiGroup cust
	 *
	 * @apiSuccess (成功响应) {String} reqResult 请求结果码、结果信息
	 */
	@RequestMapping("/api/agreementPro/v1")
	public ResponseData agreement(HttpServletRequest request) throws DefineMsgException {
		CustInfoPojo cust = custSessionService.getCurrentCust(request);
		CustInfoPojo custInfo = new CustInfoPojo();
		custInfo.setId(cust.getId());
		custInfo.setAgreement(1);
		custInfoService.update(custInfo);
		return ResponseData.succ(null);
	}

	/**
	 * @api {post} /custInfo/api/logoutPro/v1 API登出
	 * @apiGroup cust
	 *
	 * @apiUse CustInfoPojo
	 */
	@RequestMapping("/api/logoutPro/v1")
	public ResponseData logout(HttpServletRequest request) throws DefineMsgException {
		CustInfoPojo cust = custSessionService.getCurrentCust(request);
		if (cust != null) {
			custSessionService.removeCurrentCust(cust.getId(), cust.getAppId());
		}
		return ResponseData.succ(null);
	}

	/**
	 * 设置默认值
	 * @param cust
	 */
	private void setDefaultVal(CustInfoPojo cust) {
		if (cust.getDeviceType() == null) {
			cust.setDeviceType(10);
		}
		if (cust.getAppId() == null) {
			cust.setAppId(10L);
		}
		if (cust.getChannelId() == null) {
			cust.setChannelId(10L);
		}
	}
}
