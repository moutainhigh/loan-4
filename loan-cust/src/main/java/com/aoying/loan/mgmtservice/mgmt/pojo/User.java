package com.aoying.loan.mgmtservice.mgmt.pojo;

import com.aoying.loan.common.base.pojo.BasePojo;

/**
 * 后台管理用户
 * @author nick
 */
public class User extends BasePojo {
    /** 账号 */
    private String account;
    /** 密码 */
    private String password;
    /** 凭证 */
    private String token;
    /** 密码错误次数 */
    private Integer pwdErrTimes = 0;

    public User() {
    }

    public User(String account, String password) {
        this.account = account;
        this.password = password;
    }

    /** 获取 账号 */
    public String getAccount() {
        return this.account;
    }

    /** 设置 账号 */
    public void setAccount(String account) {
        this.account = account;
    }

    /** 获取 密码 */
    public String getPassword() {
        return this.password;
    }

    /** 设置 密码 */
    public void setPassword(String password) {
        this.password = password;
    }

    /** 获取 凭证 */
    public String getToken() {
        return this.token;
    }

    /** 设置 凭证 */
    public void setToken(String token) {
        this.token = token;
    }

    /** 获取 密码错误次数 */
    public Integer getPwdErrTimes() {
        return this.pwdErrTimes;
    }

    /** 设置 密码错误次数 */
    public void setPwdErrTimes(Integer pwdErrTimes) {
        this.pwdErrTimes = pwdErrTimes;
    }
}
