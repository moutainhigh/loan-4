package com.aoying.loan.cust.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import com.xinyan.api.XinYanConfig;

/**
 * 新颜接口 配置
 * @author nick
 */
@Configuration
@ConfigurationProperties(prefix = "xinYanCfg")
public class XinYanCfg extends XinYanConfig {

}
