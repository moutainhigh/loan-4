package com.aoying.loan.cust.app.pojo;

import com.aoying.loan.common.base.pojo.BaseEncodePojo;

/**
 * @apiDefine AppFeedbackPojo
 * @apiParam {Long} [appId] APP ID
 * @apiParam {Integer} [kinds] 反馈分类
 * @apiParam {String} [name] 姓名
 * @apiParam {String} [content] 内容
 * @apiParam {String} [imgUrl] 图片(多张以,隔开)
 */
/**
 * APP反馈信息表 Pojo
 * @author nick
 */
public class AppFeedbackPojo extends BaseEncodePojo {
	/** 序列化UID */
	private static final long serialVersionUID = 1L;
	/** APP ID */
	private Long appId;
	/** 反馈分类 */
	private Integer kinds;
	/** 姓名 */
	private String name;
	/** 内容 */
	private String content;
	/** 图片(多张以,隔开) */
	private String imgUrl;

	
	/** @取得  APP ID */
	public Long getAppId(){
		return appId;
	}
	
	/** @设置  APP ID */
	public void setAppId(Long appId){
		this.appId = appId;
	}
	
	/** @取得  姓名 */
	public String getName(){
		return name;
	}
	
	/** @设置  姓名 */
	public void setName(String name){
		this.name = name;
	}
	
	/** @取得  反馈分类 */
	public Integer getKinds(){
		return kinds;
	}
	
	/** @设置  反馈分类 */
	public void setKinds(Integer kinds){
		this.kinds = kinds;
	}
	
	/** @取得  内容 */
	public String getContent(){
		return content;
	}
	
	/** @设置  内容 */
	public void setContent(String content){
		this.content = content;
	}
	
	/** @取得  图片(多张以,隔开) */
	public String getImgUrl(){
		return imgUrl;
	}
	
	/** @设置  图片(多张以,隔开) */
	public void setImgUrl(String imgUrl){
		this.imgUrl = imgUrl;
	}

}
