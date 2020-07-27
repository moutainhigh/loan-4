package com.aoying.loan.common.constant.eenum;

/**
 * redis关键字
 * @author nick
 */
public enum ERedisCacheKey {

    /********************************************************************************************/
    /****************************************** 通用模块 *****************************************/
    /********************************************************************************************/

    /********************************************************************************************/
    /****************************************** 用户模块 *****************************************/
    /********************************************************************************************/

    /** 登录用户Token的redis前缀 */
    LOGIN_TOKEN("loginToken_", "登录用户Token的redis前缀"),
    /** 登录用户对象的redis前缀 */
    LOGIN_CUST("loginCust_", "登录用户对象的redis前缀"),
    /** 重复登录用户的redis前缀 */
    LOGIN_REPEAT("loginRepeat_", "重复登录用户的redis前缀"),

    /** 点选图片验证码的redis前缀 */
    VERF_CODE_OF_CLICK_PIC("verfCodeOfClickPic_", "点选图片验证码的redis前缀"),
    /** 静态图片验证码的redis前缀 */
    VERF_CODE_OF_STATIC_PIC("verfCodeOfStaticPic_", "静态图片验证码的redis前缀"),
    /** 短信验证码的redis前缀 */
    VERF_CODE_OF_SMS("verfCodeOfSms_", "短信验证码的redis前缀"),

    /********************************************************************************************/
    /****************************************** 管理后台 *****************************************/
    /********************************************************************************************/

    MGMT_USERS("mgmtUsers", "管理后台用户的redis关键字");

    private String val;
    private String name;

    ERedisCacheKey(String val, String name) {
        this.val = val;
        this.name = name;
    }

    public String getVal() {
        return val;
    }

    public String getName() {
        return name;
    }
}
