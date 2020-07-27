package com.aoying.loan.cust.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import com.github.wxpay.sdk.WXPayConfig;

/**
 * 布丁白卡微信支付配置
 * @author nick
 */
@Configuration
@ConfigurationProperties(prefix = "wxPayCfgOfBaiKa")
public class WxPayCfgOfBaiKa extends WXPayConfig {

}
