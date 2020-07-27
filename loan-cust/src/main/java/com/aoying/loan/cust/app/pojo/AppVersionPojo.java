package com.aoying.loan.cust.app.pojo;

import com.aoying.loan.common.base.pojo.BasePojo;

/**
 * @apiDefine AppVersionPojo
 * @apiParam {String} [verText] 版本字符串
 * @apiParam {Long} [lowestVerId] 最低版本id
 * @apiParam {String} [lowestVerText] 最低版本字符串
 * @apiParam {String} [code] APP编号
 * @apiParam {String} [name] APP名称
 * @apiParam {String} [remark] 备注
 * @apiParam {Integer} [status] 记录状态
 */
/**
 * APP版本表 Pojo
 * @author nick
 */
public class AppVersionPojo extends BasePojo {
	/** 序列化UID */
	private static final long serialVersionUID = 1L;
	/** 版本字符串 */
	private String verText;
	/** 最低版本id */
	private Long lowestVerId;
	/** 最低版本字符串 */
	private String lowestVerText;
	/** APP编号 */
	private String code;
	/** APP名称 */
	private String name;
	/** 备注 */
	private String remark;
	/** 记录状态 */
	private Integer status;

	
	/** @取得  版本字符串 */
	public String getVerText(){
		return verText;
	}
	
	/** @设置  版本字符串 */
	public void setVerText(String verText){
		this.verText = verText;
	}
	
	/** @取得  最低版本id */
	public Long getLowestVerId(){
		return lowestVerId;
	}
	
	/** @设置  最低版本id */
	public void setLowestVerId(Long lowestVerId){
		this.lowestVerId = lowestVerId;
	}
	
	/** @取得  最低版本字符串 */
	public String getLowestVerText(){
		return lowestVerText;
	}
	
	/** @设置  最低版本字符串 */
	public void setLowestVerText(String lowestVerText){
		this.lowestVerText = lowestVerText;
	}
	
	/** @取得  APP编号 */
	public String getCode(){
		return code;
	}
	
	/** @设置  APP编号 */
	public void setCode(String code){
		this.code = code;
	}
	
	/** @取得  APP名称 */
	public String getName(){
		return name;
	}
	
	/** @设置  APP名称 */
	public void setName(String name){
		this.name = name;
	}
	
	/** @取得  备注 */
	public String getRemark(){
		return remark;
	}
	
	/** @设置  备注 */
	public void setRemark(String remark){
		this.remark = remark;
	}
	
	/** @取得  记录状态 */
	public Integer getStatus(){
		return status;
	}
	
	/** @设置  记录状态 */
	public void setStatus(Integer status){
		this.status = status;
	}

}
