package com.aoying.loan.cust.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import com.github.wxpay.sdk.WXPayConfig;

/**
 * 鏖鹰微信支付配置
 * @author nick
 */
@Configuration
@ConfigurationProperties(prefix = "wxPayCfgOfAoYing")
public class WxPayCfgOfAoYing extends WXPayConfig {

}
