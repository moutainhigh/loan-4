package com.aoying.loan.mgmtservice.sys.controller;

import java.util.Map;
import java.util.TreeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.aoying.loan.common.base.controller.BaseController;
import com.aoying.loan.common.base.pojo.ResponseData;
import com.aoying.loan.common.util.EnumUtils;
import com.aoying.loan.cust.app.pojo.AppBannerPojo;
import com.aoying.loan.cust.loan.pojo.LoanApplicationPojo;
import com.aoying.loan.cust.loan.pojo.LoanProductPojo;
import com.aoying.loan.cust.sys.pojo.SysDictionaryPojo;
import com.aoying.loan.cust.sys.service.iservice.ISysDictionaryService;

/**
 * 字典表 Controller
 * @author nick
 */
@RestController
@RequestMapping("/sysDictionary")
public class SysDictionaryControllerMgmt extends BaseController<SysDictionaryPojo> {
    @Autowired
    private ISysDictionaryService sysDictionaryService;

	/**
	 * @api {post} /sysDictionary/mgmt/getEnumPub/v1 MGMT获取系统枚举
	 * @apiGroup sysDictionary
	 *
	 * @apiSuccess (成功响应) {String} reqResult 请求结果码、结果信息
	 * @apiSuccess (成功响应) {Object} data 请求结果数据
	 * @apiSuccessExample {json} 成功响应示例:
	{
	"data": {
	"Industry": {
	"1": "待业",
	"2": "学生",
	"3": "国企/事业单位/公务员",
	"4": "娱乐餐饮等服务业",
	"5": "制造业",
	"6": "其他"
	}
	},
	"reqResult": {
	"code": 1,
	"msg": "操作成功"
	}
	}
	 */
	@RequestMapping("/mgmt/getEnumPub/v1")
	public ResponseData getEnum() {
		Map<String, Object> enumAll = new TreeMap<String, Object>();

		enumAll.put("BannerPosition", EnumUtils.enumToMap(AppBannerPojo.Position.class));

		enumAll.put("ProductWeight", EnumUtils.enumToMap(LoanProductPojo.Weight.class));

		enumAll.put("Education", EnumUtils.enumToMap(LoanApplicationPojo.Education.class));
		enumAll.put("Industry", EnumUtils.enumToMap(LoanApplicationPojo.Industry.class));

		return ResponseData.succ(enumAll);
	}
}
