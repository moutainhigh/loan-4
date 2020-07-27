package com.aoying.loan.cust.cust.pojo;

import java.sql.Date;
import java.sql.Timestamp;
import com.aoying.loan.common.base.pojo.BaseEncodePojo;

/**
 * @apiDefine CustIdCardPojo
 * @apiParam {Long} [custId] 客户ID
 * @apiParam {Integer} [sex] 性别，1男，2女
 * @apiParam {Date} [birthday] 出生日期
 * @apiParam {Integer} [status] 状态，0无效，1实名成功，2实名失败
 * @apiParam {Integer} [authFailCount] 认证失败次数
 * @apiParam {Timestamp} [authFailLastTime] 最后一次认证失败时间
 */
/**
 * 用户实名表 Pojo
 * @author nick
 */
public class CustIdCardPojo extends BaseEncodePojo {
	/** 序列化UID */
	private static final long serialVersionUID = 1L;
	/** 客户ID */
	private Long custId;
	/** 性别，1男，2女 */
	private Integer sex;
	/** 出生日期 */
	private Date birthday;
	/** 状态，0无效，1实名成功，2实名失败 */
	private Integer status;
	/** 认证失败次数 */
	private Integer authFailCount;
	/** 最后一次认证失败时间 */
	private Timestamp authFailLastTime;


	/** 非数据库字段，校验方式，1历史数据校验，2第三方校验 */
	private Integer checkMode;
	/** 非数据库字段，第三方返回的Json */
	private String resultJson;

	
	/** @取得  客户ID */
	public Long getCustId(){
		return custId;
	}
	
	/** @设置  客户ID */
	public void setCustId(Long custId){
		this.custId = custId;
	}
	
	/** @取得  性别，1男，2女 */
	public Integer getSex(){
		return sex;
	}
	
	/** @设置  性别，1男，2女 */
	public void setSex(Integer sex){
		this.sex = sex;
	}
	
	/** @取得  出生日期 */
	public Date getBirthday(){
		return birthday;
	}
	
	/** @设置  出生日期 */
	public void setBirthday(Date birthday){
		this.birthday = birthday;
	}
	
	/** @取得  状态，0无效，1实名成功，2实名失败 */
	public Integer getStatus(){
		return status;
	}
	
	/** @设置  状态，0无效，1实名成功，2实名失败 */
	public void setStatus(Integer status){
		this.status = status;
	}
	
	/** @取得  认证失败次数 */
	public Integer getAuthFailCount(){
		return authFailCount;
	}
	
	/** @设置  认证失败次数 */
	public void setAuthFailCount(Integer authFailCount){
		this.authFailCount = authFailCount;
	}
	
	/** @取得  最后一次认证失败时间 */
	public Timestamp getAuthFailLastTime(){
		return authFailLastTime;
	}
	
	/** @设置  最后一次认证失败时间 */
	public void setAuthFailLastTime(Timestamp authFailLastTime){
		this.authFailLastTime = authFailLastTime;
	}

	/** 获取 校验方式，1历史数据校验，2第三方校验 */
	public Integer getCheckMode() {
		return this.checkMode;
	}

	/** 设置 校验方式，1历史数据校验，2第三方校验 */
	public void setCheckMode(Integer checkMode) {
		this.checkMode = checkMode;
	}

	/** 获取 非数据库字段，第三方返回的Json */
	public String getResultJson() {
		return this.resultJson;
	}

	/** 设置 非数据库字段，第三方返回的Json */
	public void setResultJson(String resultJson) {
		this.resultJson = resultJson;
	}

	public enum Status {
		/** 无效 */
		INVALID(0, "无效"),
		/** 实名成功 */
		SUCC(1, "实名成功"),
		/** 实名失败 */
		FAIL(2, "实名失败");

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
