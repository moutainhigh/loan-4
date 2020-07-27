package com.xinyan.api;

/**
 * 新颜接口 配置
 * @author nick
 */
public class XinYanConfig {
    /** 新颜提供给商户的唯一编号 */
    private String memberId;
    /** 新颜提供给商户的唯一终端编号 */
    private String terminalId;
    /** 私钥路径 */
    private String pfxPath;
    /** 私钥密码 */
    private String pfxPwd;
    /** 域名 */
    private String domain;

    /** 获取 新颜提供给商户的唯一编号 */
    public String getMemberId() {
        return this.memberId;
    }

    /** 设置 新颜提供给商户的唯一编号 */
    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    /** 获取 新颜提供给商户的唯一终端编号 */
    public String getTerminalId() {
        return this.terminalId;
    }

    /** 设置 新颜提供给商户的唯一终端编号 */
    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    /** 获取 私钥路径 */
    public String getPfxPath() {
        return this.pfxPath;
    }

    /** 设置 私钥路径 */
    public void setPfxPath(String pfxPath) {
        this.pfxPath = pfxPath;
    }

    /** 获取 私钥密码 */
    public String getPfxPwd() {
        return this.pfxPwd;
    }

    /** 设置 私钥密码 */
    public void setPfxPwd(String pfxPwd) {
        this.pfxPwd = pfxPwd;
    }

    /** 获取 域名 */
    public String getDomain() {
        return this.domain;
    }

    /** 设置 域名 */
    public void setDomain(String domain) {
        this.domain = domain;
    }
}
