package com.aoying.loan.cust.trade.pojo;

import java.sql.Timestamp;
import java.util.Map;
import com.aoying.loan.common.base.pojo.BaseEncodePojo;
import com.aoying.loan.cust.loan.pojo.LoanReportAssessmentPojo;
import com.aoying.loan.cust.loan.pojo.LoanReportOperatorsPojo;
import com.aoying.loan.cust.loan.pojo.LoanReportPojo;

/**
 * @apiDefine TradeOrderPojo
 * @apiParam {Long} [custId] 客户ID
 * @apiParam {String} [tradeNo] 订单号
 * @apiParam {Long} [goodsId] 商品ID
 * @apiParam {String} [goodsName] 商品名称
 * @apiParam {Double} [goodsAmount] 商品金额，单位分
 * @apiParam {Integer} [payType] 支付类型，1微信支付
 * @apiParam {Timestamp} [payTime] 支付时间
 * @apiParam {Timestamp} [queryTime] 支付结果回调/查询时间
 * @apiParam {Integer} [status] 状态，1待支付，2已发起支付待查询结果，3支付成功，4支付失败
 */
/**
 * 交易订单 Pojo
 * @author nick
 */
public class TradeOrderPojo extends BaseEncodePojo {
	/** 序列化UID */
	private static final long serialVersionUID = 1L;
	/** 客户ID */
	private Long custId;
	/** 订单号 */
	private String tradeNo;
	/** 商品ID */
	private Long goodsId;
	/** 商品名称 */
	private String goodsName;
	/** 商品金额，单位分 */
	private Integer goodsAmount;
	/** 商品明细ID，如贷款报告ID */
	private Long goodsDetailId;
	/** 支付类型，1微信支付 */
	private Integer payType;
	/** 支付时间 */
	private Timestamp payTime;
	/** 支付结果 */
	private String queryResult;
	/** 支付结果回调/查询时间 */
	private Timestamp queryTime;
	/** 状态，1待支付，2已发起支付待查询结果，3支付成功，4支付失败 */
	private Integer status;


	/** 非数据库字段，获取微信OPENID用 */
	private String wxCode;
	/** 非数据库字段，微信OPENID */
	private String wxOpenId;
	/** 非数据库字段，用户IP */
	private String createIp;
	/** 非数据库字段，支付跳转链接 */
	private String mwebUrl;
	/** 非数据库字段，预支付会话标识 */
	private String prepayId;
	/** 非数据库字段，二维码链接 */
	private String codeUrl;
	/** 非数据库字段，for公众号支付 */
	private Map<String, String> jsRequest;


	/** 非数据库字段，贷款报告之运营商 */
	private LoanReportOperatorsPojo operators;
	/** 非数据库字段，贷款报告之明镜 */
	private LoanReportAssessmentPojo assessment;
	/** 非数据库字段，贷款报告 */
	private LoanReportPojo report;


	/** @取得  客户ID */
	public Long getCustId(){
		return custId;
	}
	
	/** @设置  客户ID */
	public void setCustId(Long custId){
		this.custId = custId;
	}
	
	/** @取得  订单号 */
	public String getTradeNo(){
		return tradeNo;
	}
	
	/** @设置  订单号 */
	public void setTradeNo(String tradeNo){
		this.tradeNo = tradeNo;
	}
	
	/** @取得  商品ID */
	public Long getGoodsId(){
		return goodsId;
	}
	
	/** @设置  商品ID */
	public void setGoodsId(Long goodsId){
		this.goodsId = goodsId;
	}
	
	/** @取得  商品名称 */
	public String getGoodsName(){
		return goodsName;
	}
	
	/** @设置  商品名称 */
	public void setGoodsName(String goodsName){
		this.goodsName = goodsName;
	}
	
	/** @取得  商品金额，单位分 */
	public Integer getGoodsAmount(){
		return goodsAmount;
	}
	
	/** @设置  商品金额，单位分 */
	public void setGoodsAmount(Integer goodsAmount){
		this.goodsAmount = goodsAmount;
	}

	/** 获取 商品明细ID，如贷款报告ID */
	public Long getGoodsDetailId() {
		return this.goodsDetailId;
	}

	/** 设置 商品明细ID，如贷款报告ID */
	public void setGoodsDetailId(Long goodsDetailId) {
		this.goodsDetailId = goodsDetailId;
	}
	
	/** @取得  支付类型，1微信支付 */
	public Integer getPayType(){
		return payType;
	}
	
	/** @设置  支付类型，1微信支付 */
	public void setPayType(Integer payType){
		this.payType = payType;
	}
	
	/** @取得  支付时间 */
	public Timestamp getPayTime(){
		return payTime;
	}
	
	/** @设置  支付时间 */
	public void setPayTime(Timestamp payTime){
		this.payTime = payTime;
	}

	/** 获取 支付结果 */
	public String getQueryResult() {
		return this.queryResult;
	}

	/** 设置 支付结果 */
	public void setQueryResult(String queryResult) {
		this.queryResult = queryResult;
	}

	/** @取得  支付结果回调/查询时间 */
	public Timestamp getQueryTime(){
		return queryTime;
	}
	
	/** @设置  支付结果回调/查询时间 */
	public void setQueryTime(Timestamp queryTime){
		this.queryTime = queryTime;
	}
	
	/** @取得  状态，1待支付，2已发起支付待查询结果，3支付成功，4支付失败 */
	public Integer getStatus(){
		return status;
	}
	
	/** @设置  状态，1待支付，2已发起支付待查询结果，3支付成功，4支付失败 */
	public void setStatus(Integer status){
		this.status = status;
	}

	/** 获取 非数据库字段，获取微信OPENID用 */
	public String getWxCode() {
		return this.wxCode;
	}

	/** 设置 非数据库字段，获取微信OPENID用 */
	public void setWxCode(String wxCode) {
		this.wxCode = wxCode;
	}

	/** 获取 非数据库字段，微信OPENID */
	public String getWxOpenId() {
		return this.wxOpenId;
	}

	/** 设置 非数据库字段，微信OPENID */
	public void setWxOpenId(String wxOpenId) {
		this.wxOpenId = wxOpenId;
	}

	/** 获取 非数据库字段，用户IP */
	public String getCreateIp() {
		return this.createIp;
	}

	/** 设置 非数据库字段，用户IP */
	public void setCreateIp(String createIp) {
		this.createIp = createIp;
	}

	/** 获取 非数据库字段，支付跳转链接 */
	public String getMwebUrl() {
		return this.mwebUrl;
	}

	/** 设置 非数据库字段，支付跳转链接 */
	public void setMwebUrl(String mwebUrl) {
		this.mwebUrl = mwebUrl;
	}

	/** 获取 非数据库字段，预支付会话标识 */
	public String getPrepayId() {
		return this.prepayId;
	}

	/** 设置 非数据库字段，预支付会话标识 */
	public void setPrepayId(String prepayId) {
		this.prepayId = prepayId;
	}

	/** 获取 非数据库字段，二维码链接 */
	public String getCodeUrl() {
		return this.codeUrl;
	}

	/** 设置 非数据库字段，二维码链接 */
	public void setCodeUrl(String codeUrl) {
		this.codeUrl = codeUrl;
	}

	/** 获取 非数据库字段，for公众号支付 */
	public Map<String, String> getJsRequest() {
		return this.jsRequest;
	}

	/** 设置 非数据库字段，for公众号支付 */
	public void setJsRequest(Map<String, String> jsRequest) {
		this.jsRequest = jsRequest;
	}

	/** 获取 非数据库字段，贷款报告之运营商 */
	public LoanReportOperatorsPojo getOperators() {
		return this.operators;
	}

	/** 设置 非数据库字段，贷款报告之运营商 */
	public void setOperators(LoanReportOperatorsPojo operators) {
		this.operators = operators;
	}

	/** 获取 非数据库字段，贷款报告之明镜 */
	public LoanReportAssessmentPojo getAssessment() {
		return this.assessment;
	}

	/** 设置 非数据库字段，贷款报告之明镜 */
	public void setAssessment(LoanReportAssessmentPojo assessment) {
		this.assessment = assessment;
	}

	/** 获取 非数据库字段，贷款报告 */
	public LoanReportPojo getReport() {
		return this.report;
	}

	/** 设置 非数据库字段，贷款报告 */
	public void setReport(LoanReportPojo report) {
		this.report = report;
	}

	public enum PayType {
		FREE(0, "免费", ""),
		WXH5(1, "微信H5支付", "MWEB"),
		WXJS(2, "微信公众号支付", "JSAPI");

		private Integer val;
		private String name;
		private String tradeType;

		PayType(Integer val, String name, String tradeType) {
			this.val = val;
			this.name = name;
			this.tradeType = tradeType;
		}

		public static PayType getPayType(Integer type) {
			for(PayType t : PayType.values()) {
				if (t.getVal().equals(type)) {
					return t;
				}
			}
			return PayType.FREE;
		}

		public Integer getVal() {
			return val;
		}

		public String getName() {
			return name;
		}

		public String getTradeType() {
			return tradeType;
		}
	}

	public enum Status {
		UNPAID(1, "待支付"),
		PAYING(2, "已发起支付待查询结果"),
		SUCC(21, "支付成功"),
		FAIL(22, "支付失败");

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
