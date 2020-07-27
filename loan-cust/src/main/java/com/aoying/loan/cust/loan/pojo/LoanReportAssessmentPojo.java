package com.aoying.loan.cust.loan.pojo;

import com.aoying.loan.common.base.pojo.BaseEncodePojo;

/**
 * @apiDefine LoanReportAssessmentPojo
 * @apiParam {Long} [custId] 客户ID
 * @apiParam {Long} [orderId] 订单ID
 * @apiParam {Integer} [status] 状态
 * @apiParam {String} [transId] 交易编号
 * @apiParam {String} [resultJson] json结果
 * @apiParam {String} [errorCode] 接口错误码
 * @apiParam {String} [errorMsg] 接口错误信息
 * @apiParam {String} [loanBlack] 信贷明镜，Y命中，N未命中
 * @apiParam {String} [integrityBlack] 诚信明镜，Y命中，N未命中
 * @apiParam {String} [cheatBlack] 设备明镜，Y命中，N未命中
 */
/**
 * 贷款报告之明镜 Pojo
 * @author nick
 */
public class LoanReportAssessmentPojo extends BaseEncodePojo {
	/** 序列化UID */
	private static final long serialVersionUID = 1L;
	/** 客户ID */
	private Long custId;
	/** 订单ID */
	private Long orderId;
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
	/** 信贷明镜，Y命中，N未命中 */
	private String loanBlack;
	/** 诚信明镜，Y命中，N未命中 */
	private String integrityBlack;
	/** 设备明镜，Y命中，N未命中 */
	private String cheatBlack;

	
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
	
	/** @取得  信贷明镜，Y命中，N未命中 */
	public String getLoanBlack(){
		return loanBlack;
	}
	
	/** @设置  信贷明镜，Y命中，N未命中 */
	public void setLoanBlack(String loanBlack){
		this.loanBlack = loanBlack;
	}
	
	/** @取得  诚信明镜，Y命中，N未命中 */
	public String getIntegrityBlack(){
		return integrityBlack;
	}
	
	/** @设置  诚信明镜，Y命中，N未命中 */
	public void setIntegrityBlack(String integrityBlack){
		this.integrityBlack = integrityBlack;
	}
	
	/** @取得  设备明镜，Y命中，N未命中 */
	public String getCheatBlack(){
		return cheatBlack;
	}
	
	/** @设置  设备明镜，Y命中，N未命中 */
	public void setCheatBlack(String cheatBlack){
		this.cheatBlack = cheatBlack;
	}

}
