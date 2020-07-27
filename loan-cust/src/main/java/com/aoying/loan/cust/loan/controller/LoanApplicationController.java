package com.aoying.loan.cust.loan.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.aoying.loan.common.base.controller.BaseController;
import com.aoying.loan.common.base.pojo.ResponseData;
import com.aoying.loan.common.constant.response.exception.CustomMsgException;
import com.aoying.loan.common.constant.response.exception.DefineMsgException;
import com.aoying.loan.cust.cust.pojo.CustInfoPojo;
import com.aoying.loan.cust.cust.service.CustSessionService;
import com.aoying.loan.cust.loan.pojo.LoanApplicationPojo;
import com.aoying.loan.cust.loan.service.iservice.ILoanApplicationService;

/**
 * 贷款申请 Controller
 * @author nick
 */
@RestController
@RequestMapping("/loanApplication")
public class LoanApplicationController extends BaseController<LoanApplicationPojo> {
	@Autowired
	private CustSessionService custSessionService;
    @Autowired
    private ILoanApplicationService loanApplicationService;

	/**
	 * @api {post} /loanApplication/api/getPro/v1 API贷款申请获取单个
	 * @apiGroup loanApplication
	 *
	 * @apiSuccess (成功响应) {String} reqResult 请求结果码、结果信息
	 * @apiSuccess (成功响应) {Object} data 请求结果数据
	 * @apiSuccess (成功响应) {Integer} data.loanAmount 贷款金额
	 * @apiSuccess (成功响应) {Integer} data.loanPeriod 贷款期限
	 * @apiSuccess (成功响应) {Integer} data.education 学历，1初中及以下，2高中/职中/中专，3大学专科，4大学本科，5硕士及以上
	 * @apiSuccess (成功响应) {Integer} data.industry 行业，1待业，2学生，3国企/事业单位/公务员，4娱乐餐饮等服务业，5制造业，6其他
	 * @apiSuccess (成功响应) {Integer} data.status 状态，20审核中，22审核拒绝
	 * @apiSuccessExample {json} 成功响应示例:
	{
	"data": {
	"createTime": 1560851954177,
	"custId": 7,
	"education": 1,
	"id": 1,
	"industry": 1,
	"status": 20
	},
	"reqResult": {
	"code": 1,
	"msg": "操作成功"
	}
	}
	 */
	@RequestMapping("/api/getPro/v1")
	public ResponseData get(LoanApplicationPojo loanApplication, HttpServletRequest request) throws DefineMsgException {
		CustInfoPojo currCust = custSessionService.getCurrentCust(request);
		loanApplication.setCustId(currCust.getId());

		LoanApplicationPojo result = loanApplicationService.selectUnique(loanApplication);
		return ResponseData.succ(result);
	}

	/**
	 * @api {post} /loanApplication/api/submitPro/v1 API贷款申请提交0724
	 * @apiGroup loanApplication
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
	@RequestMapping("/api/submitPro/v1")
	public ResponseData submit(HttpServletRequest request) throws DefineMsgException, CustomMsgException {
		CustInfoPojo currCust = custSessionService.getCurrentCust(request);
		loanApplicationService.updateSubmit(currCust);
		return ResponseData.succ(null);
	}

	/**
	 * @api {post} /loanApplication/api/addPro/v1 API贷款申请新增0724
	 * @apiGroup loanApplication
	 *
	 * @apiParam {Integer} [loanAmount] 贷款金额
	 * @apiParam {Integer} [loanPeriod] 贷款期限
	 * @apiParam {Integer} [education] 学历，1初中及以下，2高中/职中/中专，3大学专科，4大学本科，5硕士及以上
	 * @apiParam {Integer} [industry] 行业，1待业，2学生，3国企/事业单位/公务员，4娱乐餐饮等服务业，5制造业，6其他
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
	@RequestMapping("/api/addPro/v1")
	public ResponseData add(LoanApplicationPojo loanApplication, HttpServletRequest request) throws DefineMsgException, CustomMsgException {
		CustInfoPojo currCust = custSessionService.getCurrentCust(request);
		loanApplication.setCustId(currCust.getId());

		loanApplicationService.add(loanApplication);
		return ResponseData.succ(null);
	}

	/**
	 * @api {post} /loanApplication/api/updatePro/v1 API贷款申请更新0724
	 * @apiGroup loanApplication
	 *
	 * @apiParam {Integer} [loanAmount] 贷款金额
	 * @apiParam {Integer} [loanPeriod] 贷款期限
	 * @apiParam {Integer} [education] 学历，1初中及以下，2高中/职中/中专，3大学专科，4大学本科，5硕士及以上
	 * @apiParam {Integer} [industry] 行业，1待业，2学生，3国企/事业单位/公务员，4娱乐餐饮等服务业，5制造业，6其他
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
	@RequestMapping("/api/updatePro/v1")
	public ResponseData update(LoanApplicationPojo loanApplication, HttpServletRequest request) throws DefineMsgException {
		LoanApplicationPojo pojo = new LoanApplicationPojo();

		CustInfoPojo currCust = custSessionService.getCurrentCust(request);
		pojo.setCustId(currCust.getId());

		pojo.setLoanAmount(loanApplication.getLoanAmount());
		pojo.setLoanPeriod(loanApplication.getLoanPeriod());
		pojo.setEducation(loanApplication.getEducation());
		pojo.setIndustry(loanApplication.getIndustry());

		loanApplicationService.update(pojo);
		return ResponseData.succ(null);
	}
}
