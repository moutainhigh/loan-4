package com.aoying.loan.cust.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import com.github.wxpay.sdk.WXPayConfig;

/**
 * 依炫微信支付配置
 * @author nick
 */
@Configuration
@ConfigurationProperties(prefix = "wxPayCfgOfYiXuan")
public class WxPayCfgOfYiXuan extends WXPayConfig {

}
