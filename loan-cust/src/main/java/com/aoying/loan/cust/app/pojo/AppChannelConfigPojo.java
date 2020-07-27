package com.aoying.loan.cust.app.pojo;

import com.aoying.loan.common.base.pojo.BasePojo;

/**
 * @apiDefine AppChannelConfigPojo
 * @apiParam {String} [channelId] 渠道ID
 * @apiParam {Double} [rate] 比例
 * @apiParam {Double} [reportRate] 报告量折扣系数
 * @apiParam {Integer} [status] 状态，0作废，1正常
 */
/**
 * APP渠道配置 Pojo
 * @author nick
 */
public class AppChannelConfigPojo extends BasePojo {
	/** 序列化UID */
	private static final long serialVersionUID = 1L;
	/** 渠道ID */
	private String channelId;
	/** 比例 */
	private Double rate;
	/** 报告量折扣系数 */
	private Double reportRate;
	/** 状态，0作废，1正常 */
	private Integer status;


	/** 非数据库字段，渠道名称 */
	private String channelName;


	/** @取得  渠道ID */
	public String getChannelId(){
		return channelId;
	}
	
	/** @设置  渠道ID */
	public void setChannelId(String channelId){
		this.channelId = channelId;
	}
	
	/** @取得  比例 */
	public Double getRate(){
		return rate;
	}
	
	/** @设置  比例 */
	public void setRate(Double rate){
		this.rate = rate;
	}

	/** 获取 报告量折扣系数 */
	public Double getReportRate() {
		return this.reportRate;
	}

	/** 设置 报告量折扣系数 */
	public void setReportRate(Double reportRate) {
		this.reportRate = reportRate;
	}
	
	/** @取得  状态，0作废，1正常 */
	public Integer getStatus(){
		return status;
	}
	
	/** @设置  状态，0作废，1正常 */
	public void setStatus(Integer status){
		this.status = status;
	}

	/** 获取 非数据库字段，渠道名称 */
	public String getChannelName() {
		return this.channelName;
	}

	/** 设置 非数据库字段，渠道名称 */
	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}
}
