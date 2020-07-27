package com.ds.api;

/**
 * @author nick
 */
public class DsConfig {
    /** 行列秩请求地址 */
    private String url;
    /** 行列秩分配密钥 */
    private String key;
    /** 行列秩分配渠道号 */
    private String memberId;
    /** 行列秩分配商户名称 */
    private String subChannelName;

    /** 获取 行列秩请求地址 */
    public String getUrl() {
        return this.url;
    }

    /** 设置 行列秩请求地址 */
    public void setUrl(String url) {
        this.url = url;
    }

    /** 获取 行列秩分配密钥 */
    public String getKey() {
        return this.key;
    }

    /** 设置 行列秩分配密钥 */
    public void setKey(String key) {
        this.key = key;
    }

    /** 获取 行列秩分配渠道号 */
    public String getMemberId() {
        return this.memberId;
    }

    /** 设置 行列秩分配渠道号 */
    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    /** 获取 行列秩分配商户名称 */
    public String getSubChannelName() {
        return this.subChannelName;
    }

    /** 设置 行列秩分配商户名称 */
    public void setSubChannelName(String subChannelName) {
        this.subChannelName = subChannelName;
    }
}
