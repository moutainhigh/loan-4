package com.aoying.loan.cust.trade.pojo;

import org.springframework.util.StringUtils;
import com.aoying.loan.common.base.pojo.BasePojo;

/**
 * @apiDefine TradeGoodsPojo
 * @apiParam {String} [name] 商品名称
 * @apiParam {String} [description] 商品描述
 * @apiParam {String} [num] 次数
 * @apiParam {String} [numText] 次数显示文字
 * @apiParam {String} [btnText] 按钮显示文字
 * @apiParam {String} [displayText] 前端显示文字，主要用于支付按钮
 * @apiParam {Integer} [amount] 原价，单位分
 * @apiParam {Integer} [discount] 折后价，单位分
 * @apiParam {Integer} [status] 状态，0作废，1正常，2即将上线
 */
/**
 * @apiDefine TradeGoodsPojoSuccess
 * @apiSuccess (成功响应) {String} name 商品名称
 * @apiSuccess (成功响应) {String} description 商品描述
 * @apiSuccess (成功响应) {String} num 次数
 * @apiSuccess (成功响应) {String} numText 次数显示文字，若为空则不返回该字段
 * @apiSuccess (成功响应) {String} btnText 按钮显示文字
 * @apiSuccess (成功响应) {String} displayText 前端显示文字，主要用于支付按钮
 * @apiSuccess (成功响应) {Integer} amount 原价，单位分
 * @apiSuccess (成功响应) {Integer} discount 折后价，单位分
 * @apiSuccess (成功响应) {Integer} status 状态，0作废，1正常，2即将上线
 */
/**
 * 交易商品 Pojo
 * @author nick
 */
public class TradeGoodsPojo extends BasePojo {
	/** 序列化UID */
	private static final long serialVersionUID = 1L;
	/** 商品名称 */
	private String name;
	/** 商品描述 */
	private String description;
	/** 次数 */
	private Long num;
	/** 次数显示文字 */
	private String numText;
	/** 按钮显示文字 */
	private String btnText;
	/** 按钮显示文字数组，以逗号分隔 */
	private String btnTextStr;
	/** 前端显示文字，主要用于支付按钮 */
	private String displayText;
	/** icon url */
	private String iconUrl;
	/** 跳转URL，以逗号分隔 */
	private String targetUrlStr;
	/** H5跳转URL，以逗号分隔 */
	private String targetH5Str;
	/** 原价，单位分 */
	private Integer amount;
	/** 折后价，单位分 */
	private Integer discount;
	/** 状态，0作废，1正常，2即将上线 */
	private Integer status;
	/** 备用字段1 */
	private String field1;
	/** 备用字段2 */
	private String field2;
	/** 备用字段3 */
	private String field3;
	/** 备用字段4 */
	private String field4;


	/** @取得  商品名称 */
	public String getName(){
		return name;
	}
	
	/** @设置  商品名称 */
	public void setName(String name){
		this.name = name;
	}

	/** 获取 商品描述 */
	public String getDescription() {
		return this.description;
	}

	/** 设置 商品描述 */
	public void setDescription(String description) {
		this.description = description;
	}

	/** 获取 次数 */
	public Long getNum() {
		return this.num;
	}

	/** 设置 次数 */
	public void setNum(Long num) {
		this.num = num;
	}

	/** 获取 次数显示文字 */
	public String getNumText() {
		if (StringUtils.isEmpty(this.numText)) { return null; }
		String text = this.num < 10000 ? this.num.toString() : String.format("%.1f万", this.num / 10000.0);
		text += this.numText;
		return text;
	}

	/** 设置 次数显示文字 */
	public void setNumText(String numText) {
		this.numText = numText;
	}

	/** 获取 按钮显示文字 */
	public String getBtnText() {
		return this.btnText;
	}

	/** 设置 按钮显示文字 */
	public void setBtnText(String btnText) {
		this.btnText = btnText;
	}

	/** 获取 按钮显示文字数组，以逗号分隔 */
	public String getBtnTextStr() {
		return this.btnTextStr;
	}

	/** 设置 按钮显示文字数组，以逗号分隔 */
	public void setBtnTextStr(String btnTextStr) {
		this.btnTextStr = btnTextStr;
	}

	public String[] getBtnTextArr() {
		if (StringUtils.isEmpty(this.btnTextStr)) { return null; }
		return this.btnTextStr.split(",");
	}

	/** @取得  前端显示文字，主要用于支付按钮 */
	public String getDisplayText(){
		return displayText;
	}
	
	/** @设置  前端显示文字，主要用于支付按钮 */
	public void setDisplayText(String displayText){
		this.displayText = displayText;
	}

	/** 获取 icon url */
	public String getIconUrl() {
		return this.iconUrl;
	}

	/** 设置 icon url */
	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}

	/** 获取 跳转URL，以逗号分隔 */
	public String getTargetUrlStr() {
		return this.targetUrlStr;
	}

	/** 设置 跳转URL，以逗号分隔 */
	public void setTargetUrlStr(String targetUrlStr) {
		this.targetUrlStr = targetUrlStr;
	}

	public String[] getTargetUrlArr() {
		if (StringUtils.isEmpty(this.targetUrlStr)) { return null; }
		return this.targetUrlStr.split(",");
	}

	/** 获取 H5跳转URL，以逗号分隔 */
	public String getTargetH5Str() {
		return this.targetH5Str;
	}

	/** 设置 H5跳转URL，以逗号分隔 */
	public void setTargetH5Str(String targetH5Str) {
		this.targetH5Str = targetH5Str;
	}

	public String[] getTargetH5Arr() {
		if (StringUtils.isEmpty(this.targetH5Str)) { return null; }
		return this.targetH5Str.split(",");
	}

	/** @取得  原价，单位分 */
	public Integer getAmount(){
		return amount;
	}
	
	/** @设置  原价，单位分 */
	public void setAmount(Integer amount){
		this.amount = amount;
	}
	
	/** @取得  折后价，单位分 */
	public Integer getDiscount(){
		return discount;
	}
	
	/** @设置  折后价，单位分 */
	public void setDiscount(Integer discount){
		this.discount = discount;
	}
	
	/** @取得  状态，0作废，1正常，2即将上线 */
	public Integer getStatus(){
		return status;
	}
	
	/** @设置  状态，0作废，1正常，2即将上线 */
	public void setStatus(Integer status){
		this.status = status;
	}

	/** 获取 备用字段1 */
	public String getField1() {
		return this.field1;
	}

	/** 设置 备用字段1 */
	public void setField1(String field1) {
		this.field1 = field1;
	}

	/** 获取 备用字段2 */
	public String getField2() {
		return this.field2;
	}

	/** 设置 备用字段2 */
	public void setField2(String field2) {
		this.field2 = field2;
	}

	/** 获取 备用字段3 */
	public String getField3() {
		return this.field3;
	}

	/** 设置 备用字段3 */
	public void setField3(String field3) {
		this.field3 = field3;
	}

	/** 获取 备用字段4 */
	public String getField4() {
		return this.field4;
	}

	/** 设置 备用字段4 */
	public void setField4(String field4) {
		this.field4 = field4;
	}

	public enum Status {
		/** 无效 */
		INVALID(0, "无效"),
		/** 正常 */
		VALID(1, "正常"),
		/** 即将上线 */
		COMING_SOON(2, "即将上线");

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
