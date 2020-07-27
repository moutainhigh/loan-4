package com.github.wxpay.sdk;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public abstract class WXPayConfig {
    private byte[] certData = null;

    /** App ID */
    private String appID;
    /** Mch ID */
    private String mchID;
    /** API 密钥 */
    private String key;
    /** 证书路径 */
    private String certPath;
    /** 域名 */
    private String domain;
    /** 通知地址 */
    private String notifyUrl;

    /**
     * 获取商户证书内容
     *
     * @return 商户证书内容
     */
    public InputStream getCertStream() throws IOException {
        if (certData == null) {
            String certFullPath = this.getClass().getResource(certPath).getPath();
            File file = new File(certFullPath);
            InputStream certStream = new FileInputStream(file);
            this.certData = new byte[(int) file.length()];
            certStream.read(this.certData);
            certStream.close();
        }
        ByteArrayInputStream certBis = new ByteArrayInputStream(this.certData);
        return certBis;
    }

    /**
     * 获取WXPayDomain, 用于多域名容灾自动切换
     * @return
     */
    public IWXPayDomain getWXPayDomain() {
        return new IWXPayDomain() {
            @Override
            public void report(String domain, long elapsedTimeMillis, Exception ex) {

            }

            @Override
            public DomainInfo getDomain(WXPayConfig config) {
                return new DomainInfo(domain, true);
            }
        };
    }

    /**
     * HTTP(S) 连接超时时间，单位毫秒
     *
     * @return
     */
    public int getHttpConnectTimeoutMs() {
        return 6*1000;
    }

    /**
     * HTTP(S) 读数据超时时间，单位毫秒
     *
     * @return
     */
    public int getHttpReadTimeoutMs() {
        return 8*1000;
    }

    /**
     * 是否自动上报。
     * 若要关闭自动上报，子类中实现该函数返回 false 即可。
     *
     * @return
     */
    public boolean shouldAutoReport() {
        return true;
    }

    /**
     * 进行健康上报的线程的数量
     *
     * @return
     */
    public int getReportWorkerNum() {
        return 6;
    }


    /**
     * 健康上报缓存消息的最大数量。会有线程去独立上报
     * 粗略计算：加入一条消息200B，10000消息占用空间 2000 KB，约为2MB，可以接受
     *
     * @return
     */
    public int getReportQueueMaxSize() {
        return 10000;
    }

    /**
     * 批量上报，一次最多上报多个数据
     *
     * @return
     */
    public int getReportBatchSize() {
        return 10;
    }


    /** 获取 App ID */
    public String getAppID() {
        return this.appID;
    }

    /** 设置 App ID */
    public void setAppID(String appID) {
        this.appID = appID;
    }

    /** 获取 Mch ID */
    public String getMchID() {
        return this.mchID;
    }

    /** 设置 Mch ID */
    public void setMchID(String mchID) {
        this.mchID = mchID;
    }

    /** 获取 API 密钥 */
    public String getKey() {
        return this.key;
    }

    /** 设置 API 密钥 */
    public void setKey(String key) {
        this.key = key;
    }

    /** 获取 证书路径 */
    public String getCertPath() {
        return this.certPath;
    }

    /** 设置 证书路径 */
    public void setCertPath(String certPath) {
        this.certPath = certPath;
    }

    /** 获取 域名 */
    public String getDomain() {
        return this.domain;
    }

    /** 设置 域名 */
    public void setDomain(String domain) {
        this.domain = domain;
    }

    /** 获取 通知地址 */
    public String getNotifyUrl() {
        return this.notifyUrl;
    }

    /** 设置 通知地址 */
    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }
}
