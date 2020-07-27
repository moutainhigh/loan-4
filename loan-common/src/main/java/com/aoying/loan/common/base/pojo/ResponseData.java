/**
 * 
 */
package com.aoying.loan.common.base.pojo;

import java.io.Serializable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.aoying.loan.common.constant.response.code.EResCodeCommon;
import com.aoying.loan.common.util.JsonTool;


/**
 * @功能: request请求返回的数据
 * @项目名:kyloanServer
 * @作者:wangjz
 * @日期:2016年3月21日下午2:26:34
 */
public class ResponseData<T> implements Serializable {
	/**  */
	private static final long serialVersionUID = -6146242610931501695L;
	/** 日志对象 */
	protected static final Logger logger = LoggerFactory.getLogger(ResponseData.class);
	/** 请求结果 */
	private OptResult reqResult;
	/** 数据 */
	private T data;
	/** 查询总记录数 */
	private Long total;

	/**
	 * @构造方法
	 */
	public ResponseData() {
		super();
	}

	/**
	 * @构造方法
	 * @param reqResult
	 */
	public ResponseData(OptResult reqResult) {
		super();
		this.reqResult = reqResult;
	}

	/**
	 * @构造方法
	 * @param reqResult
	 * @param data
	 */
	public ResponseData(OptResult reqResult, T data) {
		super();
		this.reqResult = reqResult;
		this.data = data;
	}

	/**
	 * 构造函数
	 * 
	 * @param reqResult
	 * @param data
	 * @param total
	 */
	public ResponseData(OptResult reqResult, T data, Long total) {
		super();
		this.reqResult = reqResult;
		this.data = data;
		this.total = total;
	}

	/**
	 * 操作成功
	 * @param data
	 * @param <T>
	 * @return
	 */
	public static <T> ResponseData succ(T data) {
		OptResult info = EResCodeCommon.svceRigOptSuccess.getOptResult(logger);
		return new ResponseData<T>(info, data);
	}

	/**
	 * 操作成功
	 * @param data
	 * @param total
	 * @param <T>
	 * @return
	 */
	public static <T> ResponseData succ(T data, Long total) {
		OptResult info = EResCodeCommon.svceRigOptSuccess.getOptResult(logger);
		return new ResponseData<T>(info, data, total);
	}

	/**
	 * 操作失败
	 * @param msg
	 * @param <T>
	 * @return
	 */
	public static <T> ResponseData fail(String msg) {
		OptResult info = new OptResult(-1, msg);
		return new ResponseData<T>(info, null);
	}

	/**
	 * 操作失败
	 * @param msg
	 * @param data
	 * @param <T>
	 * @return
	 */
	public static <T> ResponseData fail(String msg, T data) {
		OptResult info = new OptResult(-1, msg);
		return new ResponseData<T>(info, data);
	}

	/**
	 * @取得 请求结果
	 */
	public OptResult getReqResult() {
		return reqResult;
	}

	/**
	 * @设置 请求结果
	 */
	public void setReqResult(OptResult reqResult) {
		this.reqResult = reqResult;
	}

	/**
	 * @取得 数据
	 */
	public T getData() {
		return data;
	}

	/**
	 * @设置 数据
	 */
	public void setData(T data) {
		this.data = data;
	}

	/**
	 * @取得 查询总记录数
	 */
	public Long getTotal() {
		return total;
	}

	/**
	 * @设置 查询总记录数
	 */
	public void setTotal(Long total) {
		this.total = total;
	}

	/**
	 * @方法重写
	 */
	@Override
	public String toString() {
		return JsonTool.getString(this);
	}

}
