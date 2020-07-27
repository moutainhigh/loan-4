package com.aoying.loan.cust.sys.pojo;

import java.util.Map;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.aoying.loan.common.base.pojo.BasePojo;

/**
 * @apiDefine SysDictionaryPojo
 * @apiParam {String} [code] 编码
 * @apiParam {String} [jsonStr] json字符串
 * @apiParam {Integer} [orderNo] 排序
 * @apiParam {Integer} [status] 状态，0无效，1正常
 * @apiParam {String} [remark] 备注
 */
/**
 * 字典表 Pojo
 * @author nick
 */
public class SysDictionaryPojo extends BasePojo {
	/** 序列化UID */
	private static final long serialVersionUID = 1L;
	/** 编码 */
	private String code;
	/** json字符串 */
	private String jsonStr;
	/** 排序 */
	private Integer orderNo;
	/** 状态，0无效，1正常 */
	private Integer status;
	/** 备注 */
	private String remark;


	/** jsonMap */
	private Map<String,String> jsonObj;

	
	/** @取得  编码 */
	public String getCode(){
		return code;
	}
	
	/** @设置  编码 */
	public void setCode(String code){
		this.code = code;
	}
	
	/** @取得  json字符串 */
	public String getJsonStr(){
		return jsonStr;
	}
	
	/** @设置  json字符串 */
	public void setJsonStr(String jsonStr){
		this.jsonStr = jsonStr;
		this.jsonObj = JSON.parseObject(jsonStr, new TypeReference<Map<String,String>>(){});
	}
	
	/** @取得  排序 */
	public Integer getOrderNo(){
		return orderNo;
	}
	
	/** @设置  排序 */
	public void setOrderNo(Integer orderNo){
		this.orderNo = orderNo;
	}
	
	/** @取得  状态，0无效，1正常 */
	public Integer getStatus(){
		return status;
	}
	
	/** @设置  状态，0无效，1正常 */
	public void setStatus(Integer status){
		this.status = status;
	}
	
	/** @取得  备注 */
	public String getRemark(){
		return remark;
	}
	
	/** @设置  备注 */
	public void setRemark(String remark){
		this.remark = remark;
	}

	/** 获取 jsonMap */
	public Map<String, String> getJsonObj() {
		return this.jsonObj;
	}

	/** 设置 jsonMap */
	public void setJsonObj(Map<String, String> jsonMap) {
		this.jsonObj = jsonMap;
		this.jsonStr = JSON.toJSONString(jsonMap);
	}
}
