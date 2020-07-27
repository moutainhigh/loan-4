package com.aoying.loan.cust.loan.pojo;

import com.aoying.loan.common.base.pojo.BaseEncodePojo;

/**
 * @apiDefine LoanReportOperatorsPojo
 * @apiParam {Long} [custId] 客户ID
 * @apiParam {Long} [orderId] 订单ID
 * @apiParam {Integer} [status] 状态
 * @apiParam {String} [transId] 交易编号
 * @apiParam {String} [resultJson] json结果
 * @apiParam {String} [errorCode] 接口错误码
 * @apiParam {String} [errorMsg] 接口错误信息
 * @apiParam {Integer} [resultLength] 手机在网时长
 * @apiParam {Integer} [resultStatus] 手机状态
 */
/**
 * 贷款报告之运营商 Pojo
 * @author nick
 */
public class LoanReportOperatorsPojo extends BaseEncodePojo {
	/** 序列化UID */
	private static final long serialVersionUID = 1L;
	/** 客户ID */
	private Long custId;
	/** 订单ID */
	private Long orderId;
	/** 报告ID */
	private Long reportId;
	/** 状态 */
	private Integer status;
	/** 交易编号 */
	private String transId;
	/** json结果 */
	private String resultJson;
	/** 接口错误码 */
	private String errorCode;
	/** 接口错误信息 */
	private String errorMsg;
	/** 认证结果码 */
	private Integer resultCode;
	/** 手机在网时长 */
	private Integer resultLength;
	/** 手机状态 */
	private Integer resultStatus;

	
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

	/** 获取 报告ID */
	public Long getReportId() {
		return this.reportId;
	}

	/** 设置 报告ID */
	public void setReportId(Long reportId) {
		this.reportId = reportId;
	}
	
	/** @取得  状态 */
	public Integer getStatus(){
		return status;
	}
	
	/** @设置  状态 */
	public void setStatus(Integer status){
		this.status = status;
	}
	
	/** @取得  交易编号 */
	public String getTransId(){
		return transId;
	}
	
	/** @设置  交易编号 */
	public void setTransId(String transId){
		this.transId = transId;
	}
	
	/** @取得  json结果 */
	public String getResultJson(){
		return resultJson;
	}
	
	/** @设置  json结果 */
	public void setResultJson(String resultJson){
		this.resultJson = resultJson;
	}
	
	/** @取得  接口错误码 */
	public String getErrorCode(){
		return errorCode;
	}
	
	/** @设置  接口错误码 */
	public void setErrorCode(String errorCode){
		this.errorCode = errorCode;
	}
	
	/** @取得  接口错误信息 */
	public String getErrorMsg(){
		return errorMsg;
	}
	
	/** @设置  接口错误信息 */
	public void setErrorMsg(String errorMsg){
		this.errorMsg = errorMsg;
	}

	/** 获取 认证结果码 */
	public Integer getResultCode() {
		return this.resultCode;
	}

	/** 设置 认证结果码 */
	public void setResultCode(Integer resultCode) {
		this.resultCode = resultCode;
	}
	
	/** @取得  手机在网时长 */
	public Integer getResultLength(){
		return resultLength;
	}
	
	/** @设置  手机在网时长 */
	public void setResultLength(Integer resultLength){
		this.resultLength = resultLength;
	}
	
	/** @取得  手机状态 */
	public Integer getResultStatus(){
		return resultStatus;
	}
	
	/** @设置  手机状态 */
	public void setResultStatus(Integer resultStatus){
		this.resultStatus = resultStatus;
	}

}
