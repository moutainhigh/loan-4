package com.aoying.loan.cust.app.pojo;

import com.aoying.loan.common.base.pojo.BasePojo;

/**
 * @apiDefine AppChannelPojo
 * @apiParam {String} name 名称
 * @apiParam {String} [desc] 说明
 * @apiParam {String} [appUrl] APP下载链接
 * @apiParam {Integer} type 渠道类型，1APP渠道，2H5渠道
 * @apiParam {Integer} status 状态，0作废，1正常
 */
/**
 * APP渠道表 Pojo
 * @author nick
 */
public class AppChannelPojo extends BasePojo {
	/** 序列化UID */
	private static final long serialVersionUID = 1L;
	/** 名称 */
	private String name;
	/** 说明 */
	private String desc;
	/** APP下载链接 */
	private String appUrl;
	/** 渠道类型，同deviceType */
	private Integer type;
	/** 是否发布，0未发布，1已发布 */
	private Integer release;
	/** 显示模式，1列表，2卡片 */
	private Integer displayMode;
	/** 审核版本ID */
	private Long auditVerId;
	/** 最低版本ID */
	private Long lowestVerId;
	/** 最高版本ID */
	private Long highestVerId;
	/** 状态，0作废，1正常 */
	private Integer status;

	
	/** @取得  名称 */
	public String getName(){
		return name;
	}
	
	/** @设置  名称 */
	public void setName(String name){
		this.name = name;
	}
	
	/** @取得  说明 */
	public String getDesc(){
		return desc;
	}
	
	/** @设置  说明 */
	public void setDesc(String desc){
		this.desc = desc;
	}

	/** 获取 APP下载链接 */
	public String getAppUrl() {
		return this.appUrl;
	}

	/** 设置 APP下载链接 */
	public void setAppUrl(String appUrl) {
		this.appUrl = appUrl;
	}
	
	/** @取得  渠道类型，同deviceType */
	public Integer getType(){
		return type;
	}
	
	/** @设置  渠道类型，同deviceType */
	public void setType(Integer type){
		this.type = type;
	}

	/** 获取 是否发布，0未发布，1已发布 */
	public Integer getRelease() {
		return this.release;
	}

	/** 设置 是否发布，0未发布，1已发布 */
	public void setRelease(Integer release) {
		this.release = release;
	}

	/** 获取 显示模式，1列表，2卡片 */
	public Integer getDisplayMode() {
		return this.displayMode;
	}

	/** 设置 显示模式，1列表，2卡片 */
	public void setDisplayMode(Integer displayMode) {
		this.displayMode = displayMode;
	}

	/** 获取 审核版本ID */
	public Long getAuditVerId() {
		return this.auditVerId;
	}

	/** 设置 审核版本ID */
	public void setAuditVerId(Long auditVerId) {
		this.auditVerId = auditVerId;
	}

	/** 获取 最低版本ID */
	public Long getLowestVerId() {
		return this.lowestVerId;
	}

	/** 设置 最低版本ID */
	public void setLowestVerId(Long lowestVerId) {
		this.lowestVerId = lowestVerId;
	}

	/** 获取 最高版本ID */
	public Long getHighestVerId() {
		return this.highestVerId;
	}

	/** 设置 最高版本ID */
	public void setHighestVerId(Long highestVerId) {
		this.highestVerId = highestVerId;
	}

	/** @取得  状态，0作废，1正常 */
	public Integer getStatus(){
		return status;
	}
	
	/** @设置  状态，0作废，1正常 */
	public void setStatus(Integer status){
		this.status = status;
	}
}
