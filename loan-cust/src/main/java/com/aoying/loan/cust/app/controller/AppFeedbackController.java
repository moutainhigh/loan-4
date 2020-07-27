package com.aoying.loan.cust.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.aoying.loan.common.base.pojo.ResponseData;
import com.aoying.loan.cust.app.pojo.AppFeedbackPojo;
import com.aoying.loan.cust.app.service.iservice.IAppFeedbackService;
import com.aoying.loan.common.base.controller.BaseController;

/**
 * APP反馈信息表 Controller
 * @author nick
 */
@RestController
@RequestMapping("/appFeedback")
public class AppFeedbackController extends BaseController<AppFeedbackPojo> {
    @Autowired
    private IAppFeedbackService appFeedbackService;

	/**
	 * @api {post} /appFeedback/api/addPub/v1 API新增反馈信息
	 * @apiGroup app
	 *
	 * @apiUse AppFeedbackPojo
	 */
	@RequestMapping("/api/addPub/v1")
	public ResponseData add(AppFeedbackPojo appFeedback) {
		appFeedbackService.add(appFeedback);
		return ResponseData.succ(null);
	}
}
