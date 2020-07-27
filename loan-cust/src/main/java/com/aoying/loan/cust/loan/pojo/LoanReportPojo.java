package com.aoying.loan.cust.loan.pojo;

import java.sql.Timestamp;
import com.aoying.loan.common.base.pojo.BaseEncodePojo;

/**
 * @apiDefine LoanReportPojo
 * @apiParam {Long} [custId] 客户ID
 * @apiParam {Integer} [status] 状态
 * @apiParam {String} [reportJson] 报告结果
 */
/**
 * 贷款报告 Pojo
 * @author nick
 */
public class LoanReportPojo extends BaseEncodePojo {
	/** 序列化UID */
	private static final long serialVersionUID = 1L;
	/** 客户ID */
	private Long custId;
	/** 订单ID */
	private Long orderId;
	/** 状态 */
	private Integer status;
	/** 报告编号，新颜接口trans_id字段 */
	private String reportNo;
	/** 报告查询时间，新颜接口trade_date字段，格式：yyyyMMddHHmmss */
	private Timestamp reportTime;
	/** 报告结果 */
	private String reportJson;
	/** 新颜接口错误码 */
	private String errorCode;
	/** 新颜接口错误信息 */
	private String errorMsg;
	/** Score */
	private Double resultScore;
	/** BoolScore */
	private Double resultBoolScore;


	/** 非数据库字段，贷款报告之运营商 */
	private LoanReportOperatorsPojo operators;


	/** @取得  客户ID */
	public Long getCustId(){
		return custId;
	}
	
	/** @设置  客户ID */
	public void setCustId(Long custId){
		this.custId = custId;
	}

	/** @取得  订单ID */
	public Long getOrderId(){
		return orderId;
	}

	/** @设置  订单ID */
	public void setOrderId(Long orderId){
		this.orderId = orderId;
	}
	
	/** @取得  状态 */
	public Integer getStatus(){
		return status;
	}
	
	/** @设置  状态 */
	public void setStatus(Integer status){
		this.status = status;
	}

	/** 获取 报告编号，新颜接口trans_id字段 */
	public String getReportNo() {
		return this.reportNo;
	}

	/** 设置 报告编号，新颜接口trans_id字段 */
	public void setReportNo(String reportNo) {
		this.reportNo = reportNo;
	}

	/** 获取 报告查询时间，新颜接口trade_date字段，格式：yyyyMMddHHmmss */
	public Timestamp getReportTime() {
		return this.reportTime;
	}

	/** 设置 报告查询时间，新颜接口trade_date字段，格式：yyyyMMddHHmmss */
	public void setReportTime(Timestamp reportTime) {
		this.reportTime = reportTime;
	}

	/** @取得  报告结果 */
	public String getReportJson(){
		return reportJson;
	}
	
	/** @设置  报告结果 */
	public void setReportJson(String reportJson){
		this.reportJson = reportJson;
	}

	/** 获取 新颜接口错误码 */
	public String getErrorCode() {
		return this.errorCode;
	}

	/** 设置 新颜接口错误码 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	/** 获取 新颜接口错误信息 */
	public String getErrorMsg() {
		return this.errorMsg;
	}

	/** 设置 新颜接口错误信息 */
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	/** 获取 Score */
	public Double getResultScore() {
		return this.resultScore;
	}

	/** 设置 Score */
	public void setResultScore(Double resultScore) {
		this.resultScore = resultScore;
	}

	/** 获取 BoolScore */
	public Double getResultBoolScore() {
		return this.resultBoolScore;
	}

	/** 设置 BoolScore */
	public void setResultBoolScore(Double resultBoolScore) {
		this.resultBoolScore = resultBoolScore;
	}

	/** 获取 非数据库字段，贷款报告之运营商 */
	public LoanReportOperatorsPojo getOperators() {
		return this.operators;
	}

	/** 设置 非数据库字段，贷款报告之运营商 */
	public void setOperators(LoanReportOperatorsPojo operators) {
		this.operators = operators;
	}
}
