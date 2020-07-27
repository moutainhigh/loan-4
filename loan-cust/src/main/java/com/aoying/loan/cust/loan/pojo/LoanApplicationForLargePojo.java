package com.aoying.loan.cust.loan.pojo;

import java.sql.Timestamp;
import com.aoying.loan.common.base.pojo.BaseEncodePojo;

/**
 * @apiDefine LoanApplicationForLargePojo
 * @apiParam {String} telNo 手机号
 * @apiParam {String} [idCardCode] 身份证号
 * @apiParam {String} [idCardName] 姓名
 * @apiParam {String} [city] 城市
 * @apiParam {Integer} [sex] 性别，1男2女
 * @apiParam {Integer} [age] 年龄
 * @apiParam {String} [monthlyIncome] 月收入
 * @apiParam {String} [loanAmount] 贷款额度
 * @apiParam {Integer} [hasHouse] 是否有房，0无1有
 * @apiParam {Integer} [hasCar] 是否有车，0无1有
 * @apiParam {Integer} [hasInsurance] 是否有保单，0无1有
 * @apiParam {Integer} [hasAccumulationFund] 是否有公积金，0无1有
 * @apiParam {Integer} [hasSocialSecurity] 是否有社保，0无1有
 * @apiParam {String} [industry] 行业
 * @apiParam {String} [education] 学历
 * @apiParam {String} [loanPurpose] 贷款用途
 * @apiParam {String} [channelId] 渠道ID
 * @apiParam {String} [submitCode] 提交编码
 * @apiParam {Integer} [status] 状态，0作废，1正常
 * @apiParam {String} [remark] 备注
 */
/**
 * 大额贷款申请 Pojo
 * @author nick
 */
public class LoanApplicationForLargePojo extends BaseEncodePojo {
	/** 序列化UID */
	private static final long serialVersionUID = 1L;
	/** 城市 */
	private String city;
	/** 性别 */
	private Integer sex;
	/** 年龄 */
	private Integer age;
	/** 月收入 */
	private String monthlyIncome;
	/** 贷款额度 */
	private String loanAmount;
	/** 是否有房 */
	private Integer hasHouse;
	/** 是否有车 */
	private Integer hasCar;
	/** 是否有保单 */
	private Integer hasInsurance;
	/** 是否有公积金 */
	private Integer hasAccumulationFund;
	/** 是否有社保 */
	private Integer hasSocialSecurity;
	/** 行业 */
	private String industry;
	/** 工作 */
	private String education;
	/** 贷款用途 */
	private String loanPurpose;
	/** 渠道ID */
	private Long channelId;
	/** 提交编码 */
	private String submitCode;
	/** 状态，0作废，1正常 */
	private Integer status;
	/** 备注 */
	private String remark;


	/** 非数据库字段，创建时间开始 */
	private Timestamp createTimeBegin;
	/** 非数据库字段，创建时间结束 */
	private Timestamp createTimeEnd;

	
	/** @取得  城市 */
	public String getCity(){
		return city;
	}
	
	/** @设置  城市 */
	public void setCity(String city){
		this.city = city;
	}
	
	/** @取得  性别 */
	public Integer getSex(){
		return sex;
	}
	
	/** @设置  性别 */
	public void setSex(Integer sex){
		this.sex = sex;
	}
	
	/** @取得  年龄 */
	public Integer getAge(){
		return age;
	}
	
	/** @设置  年龄 */
	public void setAge(Integer age){
		this.age = age;
	}
	
	/** @取得  月收入 */
	public String getMonthlyIncome(){
		return monthlyIncome;
	}
	
	/** @设置  月收入 */
	public void setMonthlyIncome(String monthlyIncome){
		this.monthlyIncome = monthlyIncome;
	}
	
	/** @取得  贷款额度 */
	public String getLoanAmount(){
		return loanAmount;
	}
	
	/** @设置  贷款额度 */
	public void setLoanAmount(String loanAmount){
		this.loanAmount = loanAmount;
	}
	
	/** @取得  是否有房 */
	public Integer getHasHouse(){
		return hasHouse;
	}
	
	/** @设置  是否有房 */
	public void setHasHouse(Integer hasHouse){
		this.hasHouse = hasHouse;
	}
	
	/** @取得  是否有车 */
	public Integer getHasCar(){
		return hasCar;
	}
	
	/** @设置  是否有车 */
	public void setHasCar(Integer hasCar){
		this.hasCar = hasCar;
	}
	
	/** @取得  是否有保单 */
	public Integer getHasInsurance(){
		return hasInsurance;
	}
	
	/** @设置  是否有保单 */
	public void setHasInsurance(Integer hasInsurance){
		this.hasInsurance = hasInsurance;
	}
	
	/** @取得  是否有公积金 */
	public Integer getHasAccumulationFund(){
		return hasAccumulationFund;
	}
	
	/** @设置  是否有公积金 */
	public void setHasAccumulationFund(Integer hasAccumulationFund){
		this.hasAccumulationFund = hasAccumulationFund;
	}
	
	/** @取得  是否有社保 */
	public Integer getHasSocialSecurity(){
		return hasSocialSecurity;
	}
	
	/** @设置  是否有社保 */
	public void setHasSocialSecurity(Integer hasSocialSecurity){
		this.hasSocialSecurity = hasSocialSecurity;
	}
	
	/** @取得  行业 */
	public String getIndustry(){
		return industry;
	}
	
	/** @设置  行业 */
	public void setIndustry(String industry){
		this.industry = industry;
	}
	
	/** @取得  工作 */
	public String getEducation(){
		return education;
	}
	
	/** @设置  工作 */
	public void setEducation(String education){
		this.education = education;
	}
	
	/** @取得  贷款用途 */
	public String getLoanPurpose(){
		return loanPurpose;
	}
	
	/** @设置  贷款用途 */
	public void setLoanPurpose(String loanPurpose){
		this.loanPurpose = loanPurpose;
	}

	/** 获取 渠道ID */
	public Long getChannelId() {
		return this.channelId;
	}

	/** 设置 渠道ID */
	public void setChannelId(Long channelId) {
		this.channelId = channelId;
	}
	
	/** @取得  提交编码 */
	public String getSubmitCode(){
		return submitCode;
	}
	
	/** @设置  提交编码 */
	public void setSubmitCode(String submitCode){
		this.submitCode = submitCode;
	}
	
	/** @取得  状态，0作废，1正常 */
	public Integer getStatus(){
		return status;
	}
	
	/** @设置  状态，0作废，1正常 */
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

	/** 获取 非数据库字段，创建时间开始 */
	public Timestamp getCreateTimeBegin() {
		return this.createTimeBegin;
	}

	/** 设置 非数据库字段，创建时间开始 */
	public void setCreateTimeBegin(Timestamp createTimeBegin) {
		this.createTimeBegin = createTimeBegin;
	}

	/** 获取 非数据库字段，创建时间结束 */
	public Timestamp getCreateTimeEnd() {
		return this.createTimeEnd;
	}

	/** 设置 非数据库字段，创建时间结束 */
	public void setCreateTimeEnd(Timestamp createTimeEnd) {
		this.createTimeEnd = createTimeEnd;
	}

	public enum ESubmitCode {
		DEFAULT(0, 0, "0", "%1","待送件"),
		DFRZ(1, 1, "1", "%1_", "东方融资"),
		JJD(2, 2, "10", "%1__", "捷捷贷")
		,X(3, 4, "100", "%1___", "X")
		;

		/** 位数 */
		private Integer index;
		/** 十进制数值 */
		private Integer val;
		/** 二进制数值 */
		private String strVal;
		/** SQL查询语句 */
		private String sqlVal;
		/** 名称 */
		private String name;

		ESubmitCode(Integer index, Integer val, String strVal, String sqlVal, String name) {
			this.index = index;
			this.val = val;
			this.strVal = strVal;
			this.sqlVal = sqlVal;
			this.name = name;
		}

		public Integer getIndex() {
			return index;
		}

		public Integer getVal() {
			return val;
		}

		public String getStrVal() {
			return strVal;
		}

		public String getSqlVal() {
			return sqlVal;
		}

		public String getName() {
			return name;
		}
	}
}
