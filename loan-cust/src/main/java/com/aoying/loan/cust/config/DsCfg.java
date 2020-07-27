package com.aoying.loan.cust.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import com.ds.api.DsConfig;

/**
 * @author nick
 */
@Configuration
@ConfigurationProperties(prefix = "dsCfg")
public class DsCfg extends DsConfig {
}
