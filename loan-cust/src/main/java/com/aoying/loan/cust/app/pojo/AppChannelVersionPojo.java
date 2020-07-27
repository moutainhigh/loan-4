package com.aoying.loan.cust.app.pojo;

import com.aoying.loan.common.base.pojo.BasePojo;

/**
 * @apiDefine AppChannelVersionPojo
 * @apiParam {Long} [channelId] 渠道Id
 * @apiParam {Long} [currVerId] 版本id
 * @apiParam {String} [downloadUrl] app下载地址
 * @apiParam {Integer} [auditStatus] 审核状态，1审核中，2审核通过
 * @apiParam {Integer} [status] 记录状态
 */
/**
 * APP渠道版本关联表 Pojo
 * @author nick
 */
public class AppChannelVersionPojo extends BasePojo {
	/** 序列化UID */
	private static final long serialVersionUID = 1L;
	/** 渠道Id */
	private Long channelId;
	/** 版本id */
	private Long currVerId;
	/** app下载地址 */
	private String downloadUrl;
	/** 审核状态，1审核中，2审核通过 */
	private Integer auditStatus;
	/** 记录状态 */
	private Integer status;


	/** 非数据库字段，渠道 */
	private AppChannelPojo channel;
	/** 非数据库字段，版本 */
	private AppVersionPojo version;

	
	/** @取得  渠道Id */
	public Long getChannelId(){
		return channelId;
	}
	
	/** @设置  渠道Id */
	public void setChannelId(Long channelId){
		this.channelId = channelId;
	}
	
	/** @取得  版本id */
	public Long getCurrVerId(){
		return currVerId;
	}
	
	/** @设置  版本id */
	public void setCurrVerId(Long currVerId){
		this.currVerId = currVerId;
	}
	
	/** @取得  app下载地址 */
	public String getDownloadUrl(){
		return downloadUrl;
	}
	
	/** @设置  app下载地址 */
	public void setDownloadUrl(String downloadUrl){
		this.downloadUrl = downloadUrl;
	}
	
	/** @取得  审核状态，1审核中，2审核通过 */
	public Integer getAuditStatus(){
		return auditStatus;
	}
	
	/** @设置  审核状态，1审核中，2审核通过 */
	public void setAuditStatus(Integer auditStatus){
		this.auditStatus = auditStatus;
	}
	
	/** @取得  记录状态 */
	public Integer getStatus(){
		return status;
	}
	
	/** @设置  记录状态 */
	public void setStatus(Integer status){
		this.status = status;
	}

	/** 获取 非数据库字段，渠道 */
	public AppChannelPojo getChannel() {
		return this.channel;
	}

	/** 设置 非数据库字段，渠道 */
	public void setChannel(AppChannelPojo channel) {
		this.channel = channel;
	}

	/** 获取 非数据库字段，版本 */
	public AppVersionPojo getVersion() {
		return this.version;
	}

	/** 设置 非数据库字段，版本 */
	public void setVersion(AppVersionPojo version) {
		this.version = version;
	}
}
