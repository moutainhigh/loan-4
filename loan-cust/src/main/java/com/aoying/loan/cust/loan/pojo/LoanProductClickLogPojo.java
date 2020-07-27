package com.aoying.loan.cust.loan.pojo;

import java.sql.Timestamp;
import com.aoying.loan.common.base.pojo.BasePojo;

/**
 * @apiDefine LoanProductClickLogPojo
 * @apiParam {Long} [productId] 产品ID
 * @apiParam {Long} [channelId] 渠道ID
 * @apiParam {Long} [custId] 客户ID
 */
/**
 * 贷款产品点击日志 Pojo
 * @author nick
 */
public class LoanProductClickLogPojo extends BasePojo {
	/** 序列化UID */
	private static final long serialVersionUID = 1L;
	/** 产品ID */
	private Long productId;
	/** 渠道ID */
	private Long channelId;
	/** 客户ID */
	private Long custId;


	/** 条件字段，开始时间 */
	private Timestamp createTimeBegin;
	/** 条件字段，结束时间 */
	private Timestamp createTimeEnd;

	
	/** @取得  产品ID */
	public Long getProductId(){
		return productId;
	}
	
	/** @设置  产品ID */
	public void setProductId(Long productId){
		this.productId = productId;
	}
	
	/** @取得  渠道ID */
	public Long getChannelId(){
		return channelId;
	}
	
	/** @设置  渠道ID */
	public void setChannelId(Long channelId){
		this.channelId = channelId;
	}
	
	/** @取得  客户ID */
	public Long getCustId(){
		return custId;
	}
	
	/** @设置  客户ID */
	public void setCustId(Long custId){
		this.custId = custId;
	}

	/** 获取 条件字段，开始时间 */
	public Timestamp getCreateTimeBegin() {
		return this.createTimeBegin;
	}

	/** 设置 条件字段，开始时间 */
	public void setCreateTimeBegin(Timestamp createTimeBegin) {
		this.createTimeBegin = createTimeBegin;
	}

	/** 获取 条件字段，结束时间 */
	public Timestamp getCreateTimeEnd() {
		return this.createTimeEnd;
	}

	/** 设置 条件字段，结束时间 */
	public void setCreateTimeEnd(Timestamp createTimeEnd) {
		this.createTimeEnd = createTimeEnd;
	}
}
