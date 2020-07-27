package com.aoying.loan.cust.loan.pojo;

import org.apache.commons.lang3.StringUtils;
import com.aoying.loan.common.base.pojo.BasePojo;

/**
 * 贷款产品表
 * @author nick
 */
/**
 * @apiDefine LoanProductPojo
 * @apiParam {String} [name] 产品名
 * @apiParam {String} [icon] 产品icon
 * @apiParam {String} [url] 产品跳转链接
 * @apiParam {Integer} [shortUrl] 是否产生短连接，0否，1是
 * @apiParam {String} [limitName] 最高额度显示名
 * @apiParam {String} [limitDisplay] 最高额度显示内容
 * @apiParam {Integer} [limitMin] 最低额度
 * @apiParam {Integer} [limit] 最高额度
 * @apiParam {String} [periodName] 期限显示名
 * @apiParam {String} [periodDisplay] 期限显示内容
 * @apiParam {Integer} [periodMin] 期限下限
 * @apiParam {Integer} [periodMax] 期限上限
 * @apiParam {String} [rateName] 利率显示名
 * @apiParam {String} [rateDisplay] 利率显示内容
 * @apiParam {Double} [rate] 利率
 * @apiParam {String} [describe] 描述
 * @apiParam {String} [labelStr] 标签，以逗号分隔
 * @apiParam {Long} [applyNum] 申请人数
 * @apiParam {Integer} [weight] 权重，0默认，1首页，2审核进度页，3报告详情页，4贷款列表页
 * @apiParam {Integer} [orderCode] 排序
 * @apiParam {Integer} [pv] 访问量/点击量
 * @apiParam {Integer} [status] 状态，0停用，1正常
 */
public class LoanProductPojo extends BasePojo {
	/** 序列化UID */
	private static final long serialVersionUID = 1L;
	/** 产品名 */
	private String name;
	/** 产品icon */
	private String icon;
	/** 产品跳转链接 */
	private String url;
	/** 是否产生短连接，0否，1是 */
	private Integer shortUrl;
	/** 最高额度显示名 */
	private String limitName;
	/** 最高额度显示内容 */
	private String limitDisplay;
	/** 最低额度 */
	private Integer limitMin;
	/** 最高额度 */
	private Integer limit;
	/** 期限显示名 */
	private String periodName;
	/** 期限显示内容 */
	private String periodDisplay;
	/** 期限下限 */
	private Integer periodMin;
	/** 期限上限 */
	private Integer periodMax;
	/** 利率显示名 */
	private String rateName;
	/** 利率显示内容 */
	private String rateDisplay;
	/** 利率 */
	private Double rate;
	/** 描述 */
	private String describe;
	/** 标签，以逗号分隔 */
	private String labelStr;
	/** 申请人数 */
	private Long applyNum;
	/** 显示位置，以逗号分隔，0默认，1首页，2审核进度页，3报告详情页，4贷款列表页 */
	private String weight;
	/** 是否可用，0不限制，1低阶报告可用，2高阶报告可用 */
	private Integer activable;
	/** 排序 */
	private Integer orderCode;
	/** 访问量/点击量 */
	private Integer pv;
	/** 状态，0无效，1上架，2下架 */
	private Integer status;


	/** 非数据库字段，最高额度上线 */
	private Integer limitMax;
	/** 非数据库字段，排序列名 */
	private String orderByName;
	/** 非数据库字段，排序类型，1人工排序，2热度排序 */
	private Integer orderByType;
	/** 非数据库字段，升序降序 */
	private Boolean orderByDesc;


	/** 非数据库字段，标签，数组形式*/
	private String[] label;

	
	/** @取得  产品名 */
	public String getName(){
		return name;
	}
	
	/** @设置  产品名 */
	public void setName(String name){
		this.name = name;
	}
	
	/** @取得  产品icon */
	public String getIcon(){
		return icon;
	}
	
	/** @设置  产品icon */
	public void setIcon(String icon){
		this.icon = icon;
	}
	
	/** @取得  产品跳转链接 */
	public String getUrl(){
		return url;
	}
	
	/** @设置  产品跳转链接 */
	public void setUrl(String url){
		this.url = url;
	}

	/** 获取 是否产生短连接，0否，1是 */
	public Integer getShortUrl() {
		return this.shortUrl;
	}

	/** 设置 是否产生短连接，0否，1是 */
	public void setShortUrl(Integer shortUrl) {
		this.shortUrl = shortUrl;
	}
	
	/** @取得  最高额度显示名 */
	public String getLimitName(){
		return limitName;
	}
	
	/** @设置  最高额度显示名 */
	public void setLimitName(String limitName){
		this.limitName = limitName;
	}

	/** 获取 最高额度显示内容 */
	public String getLimitDisplay() {
		return this.limitDisplay;
	}

	/** 设置 最高额度显示内容 */
	public void setLimitDisplay(String limitDisplay) {
		this.limitDisplay = limitDisplay;
	}

	/** 获取 最低额度 */
	public Integer getLimitMin() {
		return this.limitMin;
	}

	/** 设置 最低额度 */
	public void setLimitMin(Integer limitMin) {
		this.limitMin = limitMin;
	}
	
	/** @取得  最高额度 */
	public Integer getLimit(){
		return limit;
	}
	
	/** @设置  最高额度 */
	public void setLimit(Integer limit){
		this.limit = limit;
	}
	
	/** @取得  期限显示名 */
	public String getPeriodName(){
		return periodName;
	}
	
	/** @设置  期限显示名 */
	public void setPeriodName(String periodName){
		this.periodName = periodName;
	}

	/** 获取 期限显示内容 */
	public String getPeriodDisplay() {
		return this.periodDisplay;
	}

	/** 设置 期限显示内容 */
	public void setPeriodDisplay(String periodDisplay) {
		this.periodDisplay = periodDisplay;
	}
	
	/** @取得  期限下限 */
	public Integer getPeriodMin(){
		return periodMin;
	}
	
	/** @设置  期限下限 */
	public void setPeriodMin(Integer periodMin){
		this.periodMin = periodMin;
	}
	
	/** @取得  期限上限 */
	public Integer getPeriodMax(){
		return periodMax;
	}
	
	/** @设置  期限上限 */
	public void setPeriodMax(Integer periodMax){
		this.periodMax = periodMax;
	}
	
	/** @取得  利率显示名 */
	public String getRateName(){
		return rateName;
	}
	
	/** @设置  利率显示名 */
	public void setRateName(String rateName){
		this.rateName = rateName;
	}

	/** 获取 利率显示内容 */
	public String getRateDisplay() {
		return this.rateDisplay;
	}

	/** 设置 利率显示内容 */
	public void setRateDisplay(String rateDisplay) {
		this.rateDisplay = rateDisplay;
	}
	
	/** @取得  利率 */
	public Double getRate(){
		return rate;
	}
	
	/** @设置  利率 */
	public void setRate(Double rate){
		this.rate = rate;
	}

	/** @取得  描述 */
	public String getDescribe(){
		return describe;
	}
	
	/** @设置  描述 */
	public void setDescribe(String describe){
		this.describe = describe;
	}
	
	/** @取得  标签，以逗号分隔 */
	public String getLabelStr(){
		return labelStr;
	}
	
	/** @设置  标签，以逗号分隔 */
	public void setLabelStr(String labelStr){
		this.labelStr = labelStr;
		this.label = labelStr.split(",");
	}
	
	/** @取得  申请人数 */
	public Long getApplyNum(){
		return applyNum;
	}
	
	/** @设置  申请人数 */
	public void setApplyNum(Long applyNum){
		this.applyNum = applyNum;
	}
	
	/** @取得  显示位置，以逗号分隔，0默认，1首页，2审核进度页，3报告详情页，4贷款列表页 */
	public String getWeight(){
		return weight;
	}
	
	/** @设置  显示位置，以逗号分隔，0默认，1首页，2审核进度页，3报告详情页，4贷款列表页 */
	public void setWeight(String weight){
		this.weight = weight;
	}

	/** 获取 是否可用，0不限制，1低阶报告可用，2高阶报告可用 */
	public Integer getActivable() {
		return this.activable;
	}

	/** 设置 是否可用，0不限制，1低阶报告可用，2高阶报告可用 */
	public void setActivable(Integer activable) {
		this.activable = activable;
	}

	/** 获取 排序 */
	public Integer getOrderCode() {
		return this.orderCode;
	}

	/** 设置 排序 */
	public void setOrderCode(Integer orderCode) {
		this.orderCode = orderCode;
	}

	/** 获取 访问量/点击量 */
	public Integer getPv() {
		return this.pv;
	}

	/** 设置 访问量/点击量 */
	public void setPv(Integer pv) {
		this.pv = pv;
	}
	
	/** @取得  状态，0无效，1上架，2下架 */
	public Integer getStatus(){
		return status;
	}
	
	/** @设置  状态，0无效，1上架，2下架 */
	public void setStatus(Integer status){
		this.status = status;
	}

	/** 获取 非数据库字段，最高额度上线 */
	public Integer getLimitMax() {
		return this.limitMax;
	}

	/** 设置 非数据库字段，最高额度上线 */
	public void setLimitMax(Integer limitMax) {
		this.limitMax = limitMax;
	}

	/** 获取 非数据库字段，排序列名 */
	public String getOrderByName() {
		return this.orderByName;
	}

	/** 设置 非数据库字段，排序列名 */
	public void setOrderByName(String orderByName) {
		this.orderByName = orderByName;
	}

	/** 获取 非数据库字段，排序类型，1人工排序，2热度排序 */
	public Integer getOrderByType() {
		return this.orderByType;
	}

	/** 设置 非数据库字段，排序类型，1人工排序，2热度排序 */
	public void setOrderByType(Integer orderByType) {
		this.orderByType = orderByType;
	}

	/** 获取 非数据库字段，升序降序 */
	public Boolean getOrderByDesc() {
		return this.orderByDesc;
	}

	/** 设置 非数据库字段，升序降序 */
	public void setOrderByDesc(Boolean orderByDesc) {
		this.orderByDesc = orderByDesc;
	}

	/** 获取 非数据库字段，标签，数组形式*/
	public String[] getLabel() {
		return this.label;
	}

	/** 设置 非数据库字段，标签，数组形式*/
	public void setLabel(String[] label) {
		this.label = label;
		this.labelStr = StringUtils.join(label, ",");
	}

	public enum OrderByType {
		MANUAL(1, "人工排序", 10000),
		PV(2, "热度排序", 0);

		private Integer val;
		private String name;
		/** 排序基础值 */
		private Integer orderCodeBase;

		OrderByType(Integer val, String name, Integer orderCodeBase) {
			this.val = val;
			this.name = name;
			this.orderCodeBase = orderCodeBase;
		}

		/**
		 * 获取排序基础值
		 * @param val
		 * @return
		 */
		public static Integer getBase(Integer val) {
			OrderByType[] vals = OrderByType.values();
			for (OrderByType v : vals) {
				if (v.getVal().equals(val)) {
					return v.getOrderCodeBase();
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

		public Integer getOrderCodeBase() {
			return orderCodeBase;
		}
	}

	public enum Weight {
		HomePage(1, "首页"),
		AuditPage(2, "审核进度页"),
		ReportPage(3, "报告详情页"),
		ProductPage(4, "贷款列表页");

		private Integer val;
		private String name;

		Weight(Integer val, String name) {
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

	public enum EActivable {
		NoLimit(0, "不限制"),
		LowReport(1, "低阶报告可用"),
		HightReport(2, "高阶报告可用");

		private Integer val;
		private String name;

		EActivable(Integer val, String name) {
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

	public enum EStatus {
		INVALID(0, "无效"),
		NORMAL(1, "上架"),
		HIDE(2, "下架");

		private Integer val;
		private String name;

		EStatus(Integer val, String name) {
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

	public enum EShortUrl {
		NO(0, "否"),
		YES(1, "是");

		private Integer val;
		private String name;

		EShortUrl(Integer val, String name) {
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
