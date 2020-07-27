package com.aoying.loan.cust.cust.pojo;

import java.sql.Date;
import java.sql.Timestamp;
import org.springframework.util.StringUtils;
import com.aoying.loan.common.base.pojo.BaseEncodePojo;

/**
 * 用户信息表
 * @author nick
 */
/**
 * @apiDefine CustInfoPojo
 * @apiParam {String} [name] 用户名
 * @apiParam {String} [headImg] 用户头像
 * @apiParam {String} [deviceId] 注册设备ID
 * @apiParam {Integer} [deviceType] 注册设备类型，1Android，2IOS，3PC，10其他
 * @apiParam {Long} [appId] 注册APP ID
 * @apiParam {Long} [channelId] 注册渠道ID
 * @apiParam {Date} [pwdErrDate] 密码输错日期
 * @apiParam {Integer} [pwdErrTimes] 密码输错次数
 * @apiParam {Integer} [telNoUpdateErrTimes] 手机号码修改失败次数
 * @apiParam {Integer} [status] 状态，0无效，1正常，2黑名单，3锁定
 */
public class CustInfoPojo extends BaseEncodePojo {
	/** 序列化UID */
	private static final long serialVersionUID = 1L;
	/** 登陆密码 */
	private String loginPwd;
	/** 微信openId */
	private String wxOpenId;
	/** 用户名 */
	private String name;
	/** 用户头像 */
	private String headImg;
	/** 注册设备ID */
	private String deviceId;
	/** 注册设备类型，1Android，2IOS，3PC，10其他 */
	private Integer deviceType;
	/** 注册APP ID */
	private Long appId;
	/** 注册渠道ID */
	private Long channelId;
	/** 第一次登录APP(包括webapp)的时间 */
	private Timestamp loginByAppTime;
	/** 密码输错日期 */
	private Date pwdErrDate;
	/** 密码输错次数 */
	private Integer pwdErrTimes;
	/** 手机号码修改失败次数 */
	private Integer telNoUpdateErrTimes;
	/** 状态，0无效，1正常，2黑名单，3锁定 */
	private Integer status;
	/** 同意协议，0未同意，1同意 */
	private Integer agreement;
	/** vip过期时间 */
	private Timestamp vipExpTime;


	/** 非数据库字段，是否vip */
	private Integer vip = 0;
	/** 非数据库字段，APP版本号 */
	private String appVerText;
	/** 非数据库字段，IP4、IP6地址 */
	private String ip;
	/** 非数据库字段，经度 */
	private Double lng;
	/** 非数据库字段，纬度 */
	private Double lat;
	/** 非数据库字段，登陆地址-省份name */
	private String provinceName;
	/** 非数据库字段，登陆地址-市name */
	private String cityName;
	/** 非数据库字段，登陆地址-区县name */
	private String countyName;
	/** 非数据库字段，登陆地址-详细地址 */
	private String address;
	/** 非数据库字段，身份证状态 */
	private Integer idCardStatus;
	/** 非数据库字段，申请信息状态 */
	private Integer informStatus;
	/** 非数据库字段，运营商报告状态 */
	private Integer optStatus;
	/** 非数据库字段，贷款申请状态 */
	private Integer applicationStatus;
	/** 非数据库字段，运营商报告ID */
	private String optId;
	/** 非数据库字段，明镜报告ID */
	private String assId;
	/** 非数据库字段，报告ID */
	private String reportId;
	/** 非数据库字段，获取微信OPENID用 */
	private String wxCode;

	/** 条件字段，开始时间 */
	private Timestamp createTimeBegin;
	/** 条件字段，结束时间 */
	private Timestamp createTimeEnd;
	/** 条件字段，以逗号分隔的渠道ID字符串 */
	private String chIdStr;
	/** 条件字段，渠道ID数组 */
	private String[] chIdArr = new String[]{};


	/** @取得  登陆密码 */
	public String getLoginPwd(){
		return loginPwd;
	}
	
	/** @设置  登陆密码 */
	public void setLoginPwd(String loginPwd){
		this.loginPwd = loginPwd;
	}

	/** 微信openId */
	public String getWxOpenId() {
		return this.wxOpenId;
	}

	/** 微信openId */
	public void setWxOpenId(String wxOpenId) {
		this.wxOpenId = wxOpenId;
	}

	/** @取得  用户名 */
	public String getName(){
		return name;
	}
	
	/** @设置  用户名 */
	public void setName(String name){
		this.name = name;
	}
	
	/** @取得  用户头像 */
	public String getHeadImg(){
		return headImg;
	}
	
	/** @设置  用户头像 */
	public void setHeadImg(String headImg){
		this.headImg = headImg;
	}
	
	/** @取得  注册设备ID */
	public String getDeviceId(){
		return deviceId;
	}
	
	/** @设置  注册设备ID */
	public void setDeviceId(String deviceId){
		this.deviceId = deviceId;
	}
	
	/** @取得  注册设备类型，1Android，2IOS，3PC，10其他 */
	public Integer getDeviceType(){
		return deviceType;
	}
	
	/** @设置  注册设备类型，1Android，2IOS，3PC，10其他 */
	public void setDeviceType(Integer deviceType){
		this.deviceType = deviceType;
	}
	
	/** @取得  注册APP ID */
	public Long getAppId(){
		return appId;
	}
	
	/** @设置  注册APP ID */
	public void setAppId(Long appId){
		this.appId = appId;
	}
	
	/** @取得  注册渠道ID */
	public Long getChannelId(){
		return channelId;
	}
	
	/** @设置  注册渠道ID */
	public void setChannelId(Long channelId){
		this.channelId = channelId;
	}

	/** 获取 第一次登录APP(包括webapp)的时间 */
	public Timestamp getLoginByAppTime() {
		return this.loginByAppTime;
	}

	/** 设置 第一次登录APP(包括webapp)的时间 */
	public void setLoginByAppTime(Timestamp loginByAppTime) {
		this.loginByAppTime = loginByAppTime;
	}
	
	/** @取得  密码输错日期 */
	public Date getPwdErrDate(){
		return pwdErrDate;
	}
	
	/** @设置  密码输错日期 */
	public void setPwdErrDate(Date pwdErrDate){
		this.pwdErrDate = pwdErrDate;
	}
	
	/** @取得  密码输错次数 */
	public Integer getPwdErrTimes(){
		return pwdErrTimes;
	}
	
	/** @设置  密码输错次数 */
	public void setPwdErrTimes(Integer pwdErrTimes){
		this.pwdErrTimes = pwdErrTimes;
	}
	
	/** @取得  手机号码修改失败次数 */
	public Integer getTelNoUpdateErrTimes(){
		return telNoUpdateErrTimes;
	}
	
	/** @设置  手机号码修改失败次数 */
	public void setTelNoUpdateErrTimes(Integer telNoUpdateErrTimes){
		this.telNoUpdateErrTimes = telNoUpdateErrTimes;
	}
	
	/** @取得  状态，0无效，1正常，2黑名单，3锁定 */
	public Integer getStatus(){
		return status;
	}
	
	/** @设置  状态，0无效，1正常，2黑名单，3锁定 */
	public void setStatus(Integer status){
		this.status = status;
	}

	/** 获取 同意协议，0未同意，1同意 */
	public Integer getAgreement() {
		return this.agreement;
	}

	/** 设置 同意协议，0未同意，1同意 */
	public void setAgreement(Integer agreement) {
		this.agreement = agreement;
	}

	/** 获取 vip过期时间 */
	public Timestamp getVipExpTime() {
		return this.vipExpTime;
	}

	/** 设置 vip过期时间 */
	public void setVipExpTime(Timestamp vipExpTime) {
		this.vipExpTime = vipExpTime;
		if (vipExpTime.getTime() >= System.currentTimeMillis()) {
			this.vip = 1;
		}
	}

	/** 获取 非数据库字段，是否vip */
	public Integer getVip() {
		return this.vip;
	}

	/** 设置 非数据库字段，是否vip */
	public void setVip(Integer vip) {
		this.vip = vip;
	}

	/** 获取 非数据库字段，APP版本号 */
	public String getAppVerText() {
		return this.appVerText;
	}

	/** 设置 非数据库字段，APP版本号 */
	public void setAppVerText(String appVerText) {
		this.appVerText = appVerText;
	}

	/** 获取 非数据库字段，IP4、IP6地址 */
	public String getIp() {
		return this.ip;
	}

	/** 设置 非数据库字段，IP4、IP6地址 */
	public void setIp(String ip) {
		this.ip = ip;
	}

	/** 获取 非数据库字段，经度 */
	public Double getLng() {
		return this.lng;
	}

	/** 设置 非数据库字段，经度 */
	public void setLng(Double lng) {
		this.lng = lng;
	}

	/** 获取 非数据库字段，纬度 */
	public Double getLat() {
		return this.lat;
	}

	/** 设置 非数据库字段，纬度 */
	public void setLat(Double lat) {
		this.lat = lat;
	}

	/** 获取 非数据库字段，登陆地址-省份name */
	public String getProvinceName() {
		return this.provinceName;
	}

	/** 设置 非数据库字段，登陆地址-省份name */
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	/** 获取 非数据库字段，登陆地址-市name */
	public String getCityName() {
		return this.cityName;
	}

	/** 设置 非数据库字段，登陆地址-市name */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	/** 获取 非数据库字段，登陆地址-区县name */
	public String getCountyName() {
		return this.countyName;
	}

	/** 设置 非数据库字段，登陆地址-区县name */
	public void setCountyName(String countyName) {
		this.countyName = countyName;
	}

	/** 获取 非数据库字段，登陆地址-详细地址 */
	public String getAddress() {
		return this.address;
	}

	/** 设置 非数据库字段，登陆地址-详细地址 */
	public void setAddress(String address) {
		this.address = address;
	}

	/** 获取 非数据库字段，身份证状态 */
	public Integer getIdCardStatus() {
		this.idCardStatus = this.getIdCardNameEnc() == null ? 0 : 1;
		return this.idCardStatus;
	}

	/** 设置 非数据库字段，身份证状态 */
	public void setIdCardStatus(Integer idCardStatus) {
		this.idCardStatus = idCardStatus;
	}

	/** 获取 非数据库字段，申请信息状态 */
	public Integer getInformStatus() {
		this.informStatus = new Integer(10).equals(this.getApplicationStatus()) ? 1 : 0;
		return this.informStatus;
	}

	/** 设置 非数据库字段，申请信息状态 */
	public void setInformStatus(Integer informStatus) {
		this.informStatus = informStatus;
	}

	/** 获取 非数据库字段，运营商报告状态 */
	public Integer getOptStatus() {
		this.optStatus = this.getOptId() == null ? 0 : 1;
		return this.optStatus;
	}

	/** 设置 非数据库字段，运营商报告状态 */
	public void setOptStatus(Integer optStatus) {
		this.optStatus = optStatus;
	}

	/** 获取 非数据库字段，贷款申请状态 */
	public Integer getApplicationStatus() {
		return this.applicationStatus;
	}

	/** 设置 非数据库字段，贷款申请状态 */
	public void setApplicationStatus(Integer applicationStatus) {
		this.applicationStatus = applicationStatus;
	}

	/** 获取 非数据库字段，运营商报告ID */
	public String getOptId() {
		return this.optId;
	}

	/** 设置 非数据库字段，运营商报告ID */
	public void setOptId(String optId) {
		this.optId = optId;
	}

	/** 获取 非数据库字段，明镜报告ID */
	public String getAssId() {
		return this.assId;
	}

	/** 设置 非数据库字段，明镜报告ID */
	public void setAssId(String assId) {
		this.assId = assId;
	}

	/** 获取 非数据库字段，报告ID */
	public String getReportId() {
		return this.reportId;
	}

	/** 设置 非数据库字段，报告ID */
	public void setReportId(String reportId) {
		this.reportId = reportId;
	}

	/** 获取 非数据库字段，获取微信OPENID用 */
	public String getWxCode() {
		return this.wxCode;
	}

	/** 设置 非数据库字段，获取微信OPENID用 */
	public void setWxCode(String wxCode) {
		this.wxCode = wxCode;
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
		if (createTimeEnd == null) { return; }
		Long time = createTimeEnd.getTime();
		time -= (time + 8*3600*1000) % (24*3600*1000); // 当前日期零点
		time += (24*3600*1000 - 1); // 当前日期23:59:59
		this.createTimeEnd = new Timestamp(time);
	}

	/** 获取 条件字段，以逗号分隔的渠道ID字符串 */
	public String getChIdStr() {
		return this.chIdStr;
	}

	/** 设置 条件字段，以逗号分隔的渠道ID字符串 */
	public void setChIdStr(String chIdStr) {
		if (StringUtils.isEmpty(chIdStr)) { return; }
		this.chIdStr = chIdStr;
		this.chIdArr = chIdStr.split(",");
	}

	/** 获取 条件字段，渠道ID数组 */
	public String[] getChIdArr() {
		return this.chIdArr;
	}

	/** 设置 条件字段，渠道ID数组 */
	public void setChIdArr(String[] chIdArr) {
		this.chIdArr = chIdArr;
	}
}
