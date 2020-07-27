package com.aoying.loan.cust.cust.pojo;

import java.sql.Date;
import java.sql.Timestamp;
import com.aoying.loan.common.base.pojo.BaseEncodePojo;

/**
 * 用户登陆失败日志
 * @author nick
 */
/**
 * @apiDefine CustLoginFailLogPojo
 * @apiParam {Long} [custId] 用户ID
 * @apiParam {Long} [appId] APP ID
 * @apiParam {String} [appVerText] APP版本号
 * @apiParam {String} [wxOpenId] 微信openId
 * @apiParam {String} [deviceId] 注册设备ID
 * @apiParam {String} [ip] IP4、IP6地址
 * @apiParam {Double} [lng] 经度
 * @apiParam {Double} [lat] 纬度
 * @apiParam {String} [provinceName] 登陆地址-省份name
 * @apiParam {String} [cityName] 登陆地址-市name
 * @apiParam {String} [countyName] 登陆地址-区县name
 * @apiParam {String} [address] 登陆地址-详细地址
 * @apiParam {Date} [loginDate] 登陆日期
 * @apiParam {Timestamp} [loginTime] 登陆时间
 */
public class CustLoginFailLogPojo extends BaseEncodePojo {
	/** 序列化UID */
	private static final long serialVersionUID = 1L;
	/** 用户ID */
	private Long custId;
	/** APP ID */
	private Long appId;
	/** APP版本号 */
	private String appVerText;
	/** 微信openId */
	private String wxOpenId;
	/** 注册设备ID */
	private String deviceId;
	/** IP4、IP6地址 */
	private String ip;
	/** 经度 */
	private Double lng;
	/** 纬度 */
	private Double lat;
	/** 登陆地址-省份name */
	private String provinceName;
	/** 登陆地址-市name */
	private String cityName;
	/** 登陆地址-区县name */
	private String countyName;
	/** 登陆地址-详细地址 */
	private String address;
	/** 登陆日期 */
	private Date loginDate;
	/** 登陆时间 */
	private Timestamp loginTime;

	
	/** @取得  用户ID */
	public Long getCustId(){
		return custId;
	}
	
	/** @设置  用户ID */
	public void setCustId(Long custId){
		this.custId = custId;
	}
	
	/** @取得  APP ID */
	public Long getAppId(){
		return appId;
	}
	
	/** @设置  APP ID */
	public void setAppId(Long appId){
		this.appId = appId;
	}
	
	/** @取得  APP版本号 */
	public String getAppVerText(){
		return appVerText;
	}
	
	/** @设置  APP版本号 */
	public void setAppVerText(String appVerText){
		this.appVerText = appVerText;
	}
	
	/** @取得  微信openId */
	public String getWxOpenId(){
		return wxOpenId;
	}
	
	/** @设置  微信openId */
	public void setWxOpenId(String wxOpenId){
		this.wxOpenId = wxOpenId;
	}
	
	/** @取得  注册设备ID */
	public String getDeviceId(){
		return deviceId;
	}
	
	/** @设置  注册设备ID */
	public void setDeviceId(String deviceId){
		this.deviceId = deviceId;
	}
	
	/** @取得  IP4、IP6地址 */
	public String getIp(){
		return ip;
	}
	
	/** @设置  IP4、IP6地址 */
	public void setIp(String ip){
		this.ip = ip;
	}
	
	/** @取得  经度 */
	public Double getLng(){
		return lng;
	}
	
	/** @设置  经度 */
	public void setLng(Double lng){
		this.lng = lng;
	}
	
	/** @取得  纬度 */
	public Double getLat(){
		return lat;
	}
	
	/** @设置  纬度 */
	public void setLat(Double lat){
		this.lat = lat;
	}
	
	/** @取得  登陆地址-省份name */
	public String getProvinceName(){
		return provinceName;
	}
	
	/** @设置  登陆地址-省份name */
	public void setProvinceName(String provinceName){
		this.provinceName = provinceName;
	}
	
	/** @取得  登陆地址-市name */
	public String getCityName(){
		return cityName;
	}
	
	/** @设置  登陆地址-市name */
	public void setCityName(String cityName){
		this.cityName = cityName;
	}
	
	/** @取得  登陆地址-区县name */
	public String getCountyName(){
		return countyName;
	}
	
	/** @设置  登陆地址-区县name */
	public void setCountyName(String countyName){
		this.countyName = countyName;
	}
	
	/** @取得  登陆地址-详细地址 */
	public String getAddress(){
		return address;
	}
	
	/** @设置  登陆地址-详细地址 */
	public void setAddress(String address){
		this.address = address;
	}
	
	/** @取得  登陆日期 */
	public Date getLoginDate(){
		return loginDate;
	}
	
	/** @设置  登陆日期 */
	public void setLoginDate(Date loginDate){
		this.loginDate = loginDate;
	}
	
	/** @取得  登陆时间 */
	public Timestamp getLoginTime(){
		return loginTime;
	}
	
	/** @设置  登陆时间 */
	public void setLoginTime(Timestamp loginTime){
		this.loginTime = loginTime;
	}

}
