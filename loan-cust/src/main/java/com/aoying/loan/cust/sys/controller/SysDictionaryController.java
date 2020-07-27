package com.aoying.loan.cust.sys.controller;

import java.util.Map;
import java.util.TreeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.aoying.loan.common.base.controller.BaseController;
import com.aoying.loan.common.base.pojo.ResponseData;
import com.aoying.loan.common.util.EnumUtils;
import com.aoying.loan.cust.loan.pojo.LoanApplicationPojo;
import com.aoying.loan.cust.sys.pojo.SysDictionaryPojo;
import com.aoying.loan.cust.sys.service.iservice.ISysDictionaryService;

/**
 * 字典表 Controller
 * @author nick
 */
@RestController
@RequestMapping("/sysDictionary")
public class SysDictionaryController extends BaseController<SysDictionaryPojo> {
    @Autowired
    private ISysDictionaryService sysDictionaryService;

	/**
	 * @api {post} /sysDictionary/api/getPub/v1 API字典表获取单个
	 * @apiGroup sysDictionary
	 *
	 * @apiParam {Integer} [id] id，1-首页卡片(贷款申请)信息
	 * @apiParam {String} [code] 编码，homeCard-首页卡片(贷款申请)信息
	 *
	 * @apiSuccess (成功响应) {String} reqResult 请求结果码、结果信息
	 * @apiSuccess (成功响应) {Object} data 请求结果数据
	 * @apiSuccess (成功响应) {Object} data.jsonObj json对象
	 * @apiSuccess (成功响应) {Object} data.jsonStr json字符串
	 * @apiSuccessExample {json} 成功响应示例:
	{
	"data": {
	"code": "homeCard",
	"id": 1,
	"jsonObj": {
	"amount": "50000",
	"title": "最高可申请额度（元）",
	"desc": "三步申请，简单便捷"
	},
	"jsonStr": "{\"amount\":\"50000\",\"title\":\"最高可申请额度（元）\",\"desc\":\"三步申请，简单便捷\"}",
	"orderNo": 1,
	"remark": "首页卡片（贷款申请）",
	"status": 1
	},
	"reqResult": {
	"code": 1,
	"msg": "操作成功"
	}
	}
	 */
	@RequestMapping("/api/getPub/v1")
	public ResponseData get(SysDictionaryPojo sysDictionary) {
		SysDictionaryPojo result = sysDictionaryService.selectUnique(sysDictionary);
		return ResponseData.succ(result);
	}

	/**
	 * @api {post} /sysDictionary/api/getEnumPub/v1 API获取系统枚举
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
	@RequestMapping("/api/getEnumPub/v1")
	public ResponseData getEnum() {
		Map<String, Object> enumAll = new TreeMap<String, Object>();
		enumAll.put(LoanApplicationPojo.Education.class.getSimpleName(), EnumUtils.enumToMap(LoanApplicationPojo.Education.class));
		enumAll.put(LoanApplicationPojo.Industry.class.getSimpleName(), EnumUtils.enumToMap(LoanApplicationPojo.Industry.class));
		return ResponseData.succ(enumAll);
	}
}
