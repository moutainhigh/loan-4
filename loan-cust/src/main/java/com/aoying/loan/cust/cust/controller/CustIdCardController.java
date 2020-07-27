package com.aoying.loan.cust.cust.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.aoying.loan.common.base.controller.BaseController;
import com.aoying.loan.common.base.pojo.ResponseData;
import com.aoying.loan.common.constant.response.code.EResCodeCommon;
import com.aoying.loan.common.constant.response.code.EResCodeCust;
import com.aoying.loan.common.constant.response.exception.DefineMsgException;
import com.aoying.loan.cust.cust.pojo.CustIdCardPojo;
import com.aoying.loan.cust.cust.pojo.CustInfoPojo;
import com.aoying.loan.cust.cust.service.CustSessionService;
import com.aoying.loan.cust.cust.service.iservice.ICustIdCardService;

/**
 * 用户实名表 Controller
 * @author nick
 */
@RestController
@RequestMapping("/custIdCard")
public class CustIdCardController extends BaseController<CustIdCardPojo> {
	@Autowired
	private CustSessionService custSessionService;
    @Autowired
    private ICustIdCardService custIdCardService;

	/**
	 * @api {post} /custIdCard/api/addAndAuthPro/v1 API实名认证
	 * @apiGroup custIdCard
	 *
	 * @apiParam {String} idCardName 身份证姓名
	 * @apiParam {String} idCardCode 身份证号码
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
	@RequestMapping("/api/addAndAuthPro/v1")
	public ResponseData addAndAuth(CustIdCardPojo idCard, HttpServletRequest request) throws DefineMsgException, IOException {
		CustInfoPojo currCust = custSessionService.getCurrentCust(request);

		idCard.setCustId(currCust.getId());
		CustIdCardPojo authIdCard = custIdCardService.addAndAuthIdCard(idCard);

		if (authIdCard != idCard) {
			return new ResponseData(EResCodeCust.svceErrAuthIdCardAlready.getOptResult(logger));
		}

		if (authIdCard.getStatus().equals(CustIdCardPojo.Status.SUCC.getVal())) {
			return new ResponseData(EResCodeCommon.svceRigOptSuccess.getOptResult(logger));
		} else {
			return new ResponseData(EResCodeCust.svceErrAuthIdCardErr.getOptResult(logger));
		}
	}
}
