/** */
package com.aoying.loan.common.base.pojo;

import com.aoying.loan.common.util.StringTool;
import com.aoying.loan.common.util.encode.Encode;

/**
 * @功能:数据脱敏基础类
 * @项目名:dunningCommon
 * @作者:wangjz
 * @日期:2017年8月3日上午10:49:01
 * @说明：<pre></pre>
 */
public class BaseEncodePojo extends BasePojo {
	/** */
	private static final long serialVersionUID = 1L;

	/** 手机号码（未加密） */
	private String telNo;
	/** 手机号码（已加密） */
	private String telNoEnc;
	/** 手机号码（隐藏部分） */
	private String telNoHide;

	/** 手机号码（未加密） */
	private String custTelNo;
	/** 手机号码（已加密） */
	private String custTelNoEnc;

	/** 邮箱（未加密） */
	private String email;
	/** 邮箱（已加密） */
	private String emailEnc;

	/** 银行卡号码（未加密） */
	private String bankCardCode;
	/** 银行卡号码（已加密） */
	private String bankCardCodeEnc;

	/** 银行卡绑定的手机号（未加密） */
	private String bankCardTelNo;
	/** 银行卡绑定的手机号（已加密） */
	private String bankCardTelNoEnc;

	/** 身份证编号（未加密） */
	private String idCardCode;
	/** 身份证编号（已加密） */
	private String idCardCodeEnc;
	/** 身份证编号（隐藏部分） */
	private String idCardCodeHide;

	/** 身份证姓名（未加密） */
	private String idCardName;
	/** 身份证姓名（已加密） */
	private String idCardNameEnc;
	/** 身份证姓名（隐藏部分） */
	private String idCardNameHide;

	/** @取得 手机号码（未加密） */
	public String getCustTelNo() {
		return custTelNo;
	}

	/** @设置 手机号码（未加密） */
	public void setCustTelNo(String custTelNo) {
		this.custTelNo = custTelNo;
		this.custTelNoEnc = Encode.encodeTelNo(custTelNo);
	}

	/** @取得 手机号码（已加密） */
	public String getCustTelNoEnc() {
		return custTelNoEnc;
	}

	/** @设置 手机号码（已加密） */
	public void setCustTelNoEnc(String custTelNoEnc) {
		this.custTelNoEnc = custTelNoEnc;
		this.custTelNo = Encode.decodeTelNo(custTelNoEnc);
	}

	/** 获取 手机号码（隐藏部分） */
	public String getTelNoHide() {
		return this.telNoHide;
	}

	/** 设置 手机号码（隐藏部分） */
	public void setTelNoHide(String telNoHide) {
		this.telNoHide = StringTool.hiddenTelNo(Encode.decodeTelNo(telNoHide));
	}

	/** 获取 手机号码（未加密） */
	public String getTelNo() {
		return this.telNo;
	}

	/** 设置 手机号码（未加密） */
	public void setTelNo(String telNo) {
		this.telNo = telNo;
		this.telNoEnc = Encode.encodeTelNo(telNo);
	}

	/** 获取 手机号码（已加密） */
	public String getTelNoEnc() {
		return this.telNoEnc;
	}

	/** 设置 手机号码（已加密） */
	public void setTelNoEnc(String telNoEnc) {
		this.telNoEnc = telNoEnc;
		this.telNo = Encode.decodeTelNo(telNoEnc);
	}

	/** @取得 邮箱（未加密） */
	public String getEmail() {
		return email;
	}

	/** @设置 邮箱（未加密） */
	public void setEmail(String email) {
		this.email = email;
		this.emailEnc = Encode.encodeEmail(email);
	}

	/** @取得 邮箱（已加密） */
	public String getEmailEnc() {
		return emailEnc;
	}

	/** @设置 邮箱（已加密） */
	public void setEmailEnc(String emailEnc) {
		this.emailEnc = emailEnc;
		this.email = Encode.decodeEmail(emailEnc);
	}

	/** @取得 银行卡号码（未加密） */
	public String getBankCardCode() {
		return bankCardCode;
	}

	/** @设置 银行卡号码（未加密） */
	public void setBankCardCode(String bankCardCode) {
		this.bankCardCode = bankCardCode;
		this.bankCardCodeEnc = Encode.encodeBankCardNo(bankCardCode);
	}

	/** @取得 银行卡号码（已加密） */
	public String getBankCardCodeEnc() {
		return bankCardCodeEnc;
	}

	/** @设置 银行卡号码（已加密） */
	public void setBankCardCodeEnc(String bankCardCodeEnc) {
		this.bankCardCodeEnc = bankCardCodeEnc;
		this.bankCardCode = Encode.decodeBankCardNo(bankCardCodeEnc);
	}

	/** @取得 银行卡绑定的手机号（未加密） */
	public String getBankCardTelNo() {
		return bankCardTelNo;
	}

	/** @设置 银行卡绑定的手机号（未加密） */
	public void setBankCardTelNo(String bankCardTelNo) {
		this.bankCardTelNo = bankCardTelNo;
		this.bankCardTelNoEnc = Encode.encodeTelNo(bankCardTelNo);
	}

	/** @取得 银行卡绑定的手机号（已加密） */
	public String getBankCardTelNoEnc() {
		return bankCardTelNoEnc;
	}

	/** @设置 银行卡绑定的手机号（已加密） */
	public void setBankCardTelNoEnc(String bankCardTelNoEnc) {
		this.bankCardTelNoEnc = bankCardTelNoEnc;
		this.bankCardTelNo = Encode.decodeTelNo(bankCardTelNoEnc);
	}

	/** @取得 身份证编号（未加密） */
	public String getIdCardCode() {
		return idCardCode;
	}

	/** @设置 身份证编号（未加密） */
	public void setIdCardCode(String idCardCode) {
		this.idCardCode = idCardCode;
		this.idCardCodeEnc = Encode.encodeIdCardNo(idCardCode);
	}

	/** @取得 身份证编号（已加密） */
	public String getIdCardCodeEnc() {
		return idCardCodeEnc;
	}

	/** @设置 身份证编号（已加密） */
	public void setIdCardCodeEnc(String idCardCodeEnc) {
		this.idCardCodeEnc = idCardCodeEnc;
		this.idCardCode = Encode.decodeIdCardNo(idCardCodeEnc);
	}

	/** 获取 身份证编号（隐藏部分） */
	public String getIdCardCodeHide() {
		return this.idCardCodeHide;
	}

	/** 设置 身份证编号（隐藏部分） */
	public void setIdCardCodeHide(String idCardCodeEnc) {
		this.idCardCodeHide = StringTool.hiddenIdCardCode42(Encode.decodeIdCardNo(idCardCodeEnc));
	}

	/** @取得 身份证姓名（未加密） */
	public String getIdCardName() {
		return idCardName;
	}

	/** @设置 身份证姓名（未加密） */
	public void setIdCardName(String idCardName) {
		this.idCardName = idCardName;
		this.idCardNameEnc = Encode.encodeName(idCardName);
	}

	/** @取得 身份证姓名（已加密） */
	public String getIdCardNameEnc() {
		return idCardNameEnc;
	}

	/** @设置 身份证姓名（已加密） */
	public void setIdCardNameEnc(String idCardNameEnc) {
		this.idCardNameEnc = idCardNameEnc;
		this.idCardName = Encode.decodeName(idCardNameEnc);
	}

	/** 获取 身份证姓名（隐藏部分） */
	public String getIdCardNameHide() {
		return this.idCardNameHide;
	}

	/** 设置 身份证姓名（隐藏部分） */
	public void setIdCardNameHide(String idCardNameEnc) {
		this.idCardNameHide = StringTool.hiddenIdCardName(Encode.decodeName(idCardNameEnc));
	}
}
