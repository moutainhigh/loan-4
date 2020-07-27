package com.aoying.loan.cust.app.pojo;

import com.aoying.loan.common.base.pojo.BasePojo;

/**
 * @apiDefine AppBannerPojo
 * @apiParam {Integer} [name] 名称
 * @apiParam {Integer} [deviceType] 设备类型，1android，2ios，3pc，4webapp，5landing，10other
 * @apiParam {Integer} [position] 位置，1首页顶部
 * @apiParam {Integer} [type] 类型，1APP内链接，2外部H5链接
 * @apiParam {String} [imgUrl] 图片URL
 * @apiParam {String} [targetUrl] 点击后跳转URL
 * @apiParam {Integer} [orderCode] 排序，默认10，最多两位
 * @apiParam {Integer} [status] 状态，0作废，1正常
 */
/**
 * APP横幅广告表 Pojo
 * @author nick
 */
public class AppBannerPojo extends BasePojo {
	/** 序列化UID */
	private static final long serialVersionUID = 1L;
	/** 名称 */
	private String name;
	/** 设备类型，1android，2ios，3pc，4webapp，5landing，10other */
	private Integer deviceType;
	/** 位置，1首页顶部 */
	private Integer position;
	/** 类型，1APP内链接，2外部H5链接 */
	private Integer type;
	/** 图片URL */
	private String imgUrl;
	/** 点击后跳转URL */
	private String targetUrl;
	/** 排序 */
	private Integer orderCode;
	/** 状态，0作废，1正常 */
	private Integer status;


	/** 获取 设备类型，1android，2ios，3pc，4webapp，5landing，10other */
	public Integer getDeviceType() {
		return this.deviceType;
	}

	/** 设置 设备类型，1android，2ios，3pc，4webapp，5landing，10other */
	public void setDeviceType(Integer deviceType) {
		this.deviceType = deviceType;
	}

	/** 获取 位置，1首页顶部 */
	public Integer getPosition() {
		return this.position;
	}

	/** 设置 位置，1首页顶部 */
	public void setPosition(Integer position) {
		this.position = position;
	}

	/** @取得  类型，1APP内链接，2外部H5链接 */
	public Integer getType(){
		return type;
	}
	
	/** @设置  类型，1APP内链接，2外部H5链接 */
	public void setType(Integer type){
		this.type = type;
	}
	
	/** @取得  图片URL */
	public String getImgUrl(){
		return imgUrl;
	}
	
	/** @设置  图片URL */
	public void setImgUrl(String imgUrl){
		this.imgUrl = imgUrl;
	}
	
	/** @取得  点击后跳转URL */
	public String getTargetUrl(){
		return targetUrl;
	}
	
	/** @设置  点击后跳转URL */
	public void setTargetUrl(String targetUrl){
		this.targetUrl = targetUrl;
	}

	/** 获取 排序 */
	public Integer getOrderCode() {
		return this.orderCode;
	}

	/** 设置 排序 */
	public void setOrderCode(Integer orderCode) {
		this.orderCode = orderCode;
	}
	
	/** @取得  状态，0作废，1正常 */
	public Integer getStatus(){
		return status;
	}
	
	/** @设置  状态，0作废，1正常 */
	public void setStatus(Integer status){
		this.status = status;
	}

	/** 获取 名称 */
	public String getName() {
		return this.name;
	}

	/** 设置 名称 */
	public void setName(String name) {
		this.name = name;
	}

	public enum Position {
		HomeTop(1, "首页顶部"),
		AuditingPage(2, "审核页"),
		AuditRefusedPage(3, "审核失败页");

		private Integer val;
		private String name;

		Position(Integer val, String name) {
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
