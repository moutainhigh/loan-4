package com.aoying.loan.cust.app.pojo;

import java.sql.Date;
import com.aoying.loan.common.base.pojo.BasePojo;

/**
 * @apiDefine AppChannelRecordPojo
 * @apiParam {Long} [channelId] 渠道ID
 * @apiParam {Double} [rate] 比例
 * @apiParam {Long} [registeredVisitsActual] 实际注册量
 * @apiParam {Long} [activationVisitsActual] 实际激活数
 * @apiParam {Long} [productVisitsActual] 实际产品访问量
 * @apiParam {Date} [calDate] 计算日期
 */
/**
 * APP渠道记录 Pojo
 * @author nick
 */
public class AppChannelRecordPojo extends BasePojo {
	/** 序列化UID */
	private static final long serialVersionUID = 1L;
	/** 渠道ID */
	private Long channelId;
	/** 比例 */
	private Double rate;
	/** 实际注册量 */
	private Long registeredVisitsActual;
	/** 实际激活数 */
	private Long activationVisitsActual;
	/** 实际产品访问量 */
	private Long productVisitsActual;
	/** 报告量折扣系数 */
	private Double reportRate;
	/** 实际报告量 */
	private Long reportVisitsActual;
	/** 计算日期 */
	private Date calDate;


	/** 非数据库字段，开始日期 */
	private Date beginDate;
	/** 非数据库字段，结束日期 */
	private Date endDate;
	/** 非数据库字段，注册量 */
	private Long registeredVisits;
	/** 非数据库字段，激活数 */
	private Long activationVisits;
	/** 非数据库字段，产品访问量 */
	private Long productVisits;
	/** 非数据库字段，报告量 */
	private Long reportVisits;
	/** 非数据库字段，显示实际访问量 */
	private Boolean showActual;

	
	/** @取得  渠道ID */
	public Long getChannelId(){
		return channelId;
	}
	
	/** @设置  渠道ID */
	public void setChannelId(Long channelId){
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

	/** 获取 实际注册量 */
	public Long getRegisteredVisitsActual() {
		return this.registeredVisitsActual;
	}

	/** 设置 实际注册量 */
	public void setRegisteredVisitsActual(Long registeredVisitsActual) {
		this.registeredVisitsActual = registeredVisitsActual;
	}

	/** 获取 实际激活数 */
	public Long getActivationVisitsActual() {
		return this.activationVisitsActual;
	}

	/** 设置 实际激活数 */
	public void setActivationVisitsActual(Long activationVisitsActual) {
		this.activationVisitsActual = activationVisitsActual;
	}

	/** 获取 实际产品访问量 */
	public Long getProductVisitsActual() {
		return this.productVisitsActual;
	}

	/** 设置 实际产品访问量 */
	public void setProductVisitsActual(Long productVisitsActual) {
		this.productVisitsActual = productVisitsActual;
	}

	/** 获取 报告量折扣系数 */
	public Double getReportRate() {
		return this.reportRate;
	}

	/** 设置 报告量折扣系数 */
	public void setReportRate(Double reportRate) {
		this.reportRate = reportRate;
	}

	/** 获取 实际报告量 */
	public Long getReportVisitsActual() {
		return this.reportVisitsActual;
	}

	/** 设置 实际报告量 */
	public void setReportVisitsActual(Long reportVisitsActual) {
		this.reportVisitsActual = reportVisitsActual;
	}
	
	/** @取得  计算日期 */
	public Date getCalDate(){
		return calDate;
	}
	
	/** @设置  计算日期 */
	public void setCalDate(Date calDate){
		this.calDate = calDate;
	}

	/** 获取 非数据库字段，开始日期 */
	public Date getBeginDate() {
		return this.beginDate;
	}

	/** 设置 非数据库字段，开始日期 */
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	/** 获取 非数据库字段，结束日期 */
	public Date getEndDate() {
		return this.endDate;
	}

	/** 设置 非数据库字段，结束日期 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/** 获取 非数据库字段，注册量 */
	public Long getRegisteredVisits() {
		return this.registeredVisits;
	}

	/** 设置 非数据库字段，注册量 */
	public void setRegisteredVisits(Long registeredVisits) {
		this.registeredVisits = registeredVisits;
	}

	/** 获取 非数据库字段，激活数 */
	public Long getActivationVisits() {
		return this.activationVisits;
	}

	/** 设置 非数据库字段，激活数 */
	public void setActivationVisits(Long activationVisits) {
		this.activationVisits = activationVisits;
	}

	/** 获取 非数据库字段，产品访问量 */
	public Long getProductVisits() {
		return this.productVisits;
	}

	/** 设置 非数据库字段，产品访问量 */
	public void setProductVisits(Long productVisits) {
		this.productVisits = productVisits;
	}

	/** 获取 非数据库字段，报告量 */
	public Long getReportVisits() {
		return this.reportVisits;
	}

	/** 设置 非数据库字段，报告量 */
	public void setReportVisits(Long reportVisits) {
		this.reportVisits = reportVisits;
	}

	/** 获取 非数据库字段，隐藏实际访问量 */
	public Boolean getShowActual() {
		return this.showActual;
	}

	/** 设置 非数据库字段，隐藏实际访问量 */
	public void setShowActual(Boolean showActual) {
		this.showActual = showActual;
	}
}
