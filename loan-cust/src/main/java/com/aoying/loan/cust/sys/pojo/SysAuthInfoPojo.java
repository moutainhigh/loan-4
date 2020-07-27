package com.aoying.loan.cust.sys.pojo;

import java.sql.Timestamp;
import com.aoying.loan.common.base.pojo.BasePojo;

/**
 * 系统访问认证信息
 * @author nick
 */
/**
 * @apiDefine SysAuthInfoPojo
 * @apiParam {String} [account] 账号
 * @apiParam {String} [secret] 密钥
 * @apiParam {Integer} [type] 账户类型
 * @apiParam {String} [user] 使用者
 * @apiParam {String} [remark] 备注
 * @apiParam {Timestamp} [expirTime] 过期时间
 * @apiParam {Integer} [status] 状态，0停用，1正常
 */
public class SysAuthInfoPojo extends BasePojo {
	/** 序列化UID */
	private static final long serialVersionUID = 1L;
	/** 账号 */
	private String account;
	/** 密钥 */
	private String secret;
	/** 账户类型 */
	private Integer type;
	/** 使用者 */
	private String user;
	/** 备注 */
	private String remark;
	/** 过期时间 */
	private Timestamp expirTime;
	/** 状态，0停用，1正常 */
	private Integer status;

	public enum EType {
		ALL(0, "所有类型", ""),
		API(1, "API接口", "/api/"),
		MGMT(2, "MGMT接口", "/mgmt/"),
		THIRDPARTY(3, "第三方接口", "/thirdParty/");

		private Integer val;
		private String name;
		private String path;

		EType(Integer val, String name, String path) {
			this.val = val;
			this.name = name;
			this.path = path;
		}

		/** 根据val获取枚举类型 */
		public static EType getType(Integer val) {
			EType[] types = EType.values();
			for (EType t : types) {
				if (t.getVal().equals(val)) {
					return t;
				}
			}
			return null;
		}

		public Integer getVal() {
			return val;
		}

		public String getName() {
			return name;
		}

		public String getPath() {
			return path;
		}
	}

	/** 获取账户类型枚举值 */
	public EType getEType() {
		return EType.getType(this.type);
	}

	/** @取得  账号 */
	public String getAccount(){
		return account;
	}
	
	/** @设置  账号 */
	public void setAccount(String account){
		this.account = account;
	}
	
	/** @取得  密钥 */
	public String getSecret(){
		return secret;
	}
	
	/** @设置  密钥 */
	public void setSecret(String secret){
		this.secret = secret;
	}
	
	/** @取得  账户类型 */
	public Integer getType(){
		return type;
	}
	
	/** @设置  账户类型 */
	public void setType(Integer type){
		this.type = type;
	}
	
	/** @取得  使用者 */
	public String getUser(){
		return user;
	}
	
	/** @设置  使用者 */
	public void setUser(String user){
		this.user = user;
	}
	
	/** @取得  备注 */
	public String getRemark(){
		return remark;
	}
	
	/** @设置  备注 */
	public void setRemark(String remark){
		this.remark = remark;
	}
	
	/** @取得  过期时间 */
	public Timestamp getExpirTime(){
		return expirTime;
	}
	
	/** @设置  过期时间 */
	public void setExpirTime(Timestamp expirTime){
		this.expirTime = expirTime;
	}
	
	/** @取得  状态，0停用，1正常 */
	public Integer getStatus(){
		return status;
	}
	
	/** @设置  状态，0停用，1正常 */
	public void setStatus(Integer status){
		this.status = status;
	}

}
