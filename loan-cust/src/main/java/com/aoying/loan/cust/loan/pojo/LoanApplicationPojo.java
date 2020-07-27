package com.aoying.loan.cust.loan.pojo;

import java.sql.Timestamp;
import com.aoying.loan.common.base.pojo.BaseEncodePojo;

/**
 * @apiDefine LoanApplicationPojo
 * @apiParam {Long} [custId] 客户ID
 * @apiParam {Integer} [education] 学历，1初中及以下，2高中/职中/中专，3大学专科，4大学本科，5硕士及以上
 * @apiParam {Integer} [industry] 行业，1待业，2学生，3国企/事业单位/公务员，4娱乐餐饮等服务业，5制造业，6其他
 * @apiParam {Integer} [status] 状态，20审核中，21审核拒绝
 * @apiParam {Timestamp} [auditTime] 审核时间
 */
/**
 * 贷款申请 Pojo
 * @author nick
 */
public class LoanApplicationPojo extends BaseEncodePojo {
	/** 序列化UID */
	private static final long serialVersionUID = 1L;
	/** 客户ID */
	private Long custId;
	/** 贷款金额 */
	private Integer loanAmount;
	/** 贷款期限 */
	private Integer loanPeriod;
	/** 学历，1初中及以下，2高中/职中/中专，3大学专科，4大学本科，5硕士及以上 */
	private Integer education;
	/** 行业，1待业，2学生，3国企/事业单位/公务员，4娱乐餐饮等服务业，5制造业，6其他 */
	private Integer industry;
	/** 状态，20审核中，22审核拒绝 */
	private Integer status;
	/** 提交时间 */
	private Timestamp submitTime;
	/** 审核时间 */
	private Timestamp auditTime;

	
	/** @取得  客户ID */
	public Long getCustId(){
		return custId;
	}
	
	/** @设置  客户ID */
	public void setCustId(Long custId){
		this.custId = custId;
	}

	/** 获取 贷款金额 */
	public Integer getLoanAmount() {
		return this.loanAmount;
	}

	/** 设置 贷款金额 */
	public void setLoanAmount(Integer loanAmount) {
		this.loanAmount = loanAmount;
	}

	/** 获取 贷款期限 */
	public Integer getLoanPeriod() {
		return this.loanPeriod;
	}

	/** 设置 贷款期限 */
	public void setLoanPeriod(Integer loanPeriod) {
		this.loanPeriod = loanPeriod;
	}
	
	/** @取得  学历，1初中及以下，2高中/职中/中专，3大学专科，4大学本科，5硕士及以上 */
	public Integer getEducation(){
		return education;
	}
	
	/** @设置  学历，1初中及以下，2高中/职中/中专，3大学专科，4大学本科，5硕士及以上 */
	public void setEducation(Integer education){
		this.education = education;
	}
	
	/** @取得  行业，1待业，2学生，3国企/事业单位/公务员，4娱乐餐饮等服务业，5制造业，6其他 */
	public Integer getIndustry(){
		return industry;
	}
	
	/** @设置  行业，1待业，2学生，3国企/事业单位/公务员，4娱乐餐饮等服务业，5制造业，6其他 */
	public void setIndustry(Integer industry){
		this.industry = industry;
	}
	
	/** @取得  状态，20审核中，22审核拒绝 */
	public Integer getStatus(){
		return status;
	}
	
	/** @设置  状态，20审核中，22审核拒绝 */
	public void setStatus(Integer status){
		this.status = status;
	}

	/** 获取 提交时间 */
	public Timestamp getSubmitTime() {
		return this.submitTime;
	}

	/** 设置 提交时间 */
	public void setSubmitTime(Timestamp submitTime) {
		this.submitTime = submitTime;
	}

	/** @取得  审核时间 */
	public Timestamp getAuditTime(){
		return auditTime;
	}
	
	/** @设置  审核时间 */
	public void setAuditTime(Timestamp auditTime){
		this.auditTime = auditTime;
	}

	public enum Education {
		E1(1, "初中及以下"),
		E2(2, "高中/职中/中专"),
		E3(3, "大学专科"),
		E4(4, "大学本科"),
		E5(5, "硕士及以上");

		private Integer val;
		private String name;

		Education(Integer val, String name) {
			this.val = val;
			this.name = name;
		}

		public Integer getVal() {
			return val;
		}

		public String getName() {
			return name;
		}
	}

	public enum Industry {
		I1(1, "待业"),
		I2(2, "学生"),
		I3(3, "国企/事业单位/公务员"),
		I4(4, "娱乐餐饮等服务业"),
		E5(5, "制造业"),
		E6(6, "其他");

		private Integer val;
		private String name;

		Industry(Integer val, String name) {
			this.val = val;
			this.name = name;
		}

		public Integer getVal() {
			return val;
		}

		public String getName() {
			return name;
		}
	}

	public enum Status {
		EMPTY(0, "未填写"),
		TOBESUBMIT(10, "待提交"),
		AUDITING(20, "审核中"),
		SUCC(21, "审核通过"),
		FAIL(22, "审核拒绝");

		private Integer val;
		private String name;

		Status(Integer val, String name) {
			this.val = val;
			this.name = name;
		}

		public Integer getVal() {
			return val;
		}

		public String getName() {
			return name;
		}
	}

}
