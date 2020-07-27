package com.aoying.loan.cust.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.aoying.loan.common.config.redis.AbsBaseRedisCfg;
import com.aoying.loan.common.config.redis.BaseRedisDao;

/**
 * Redis配置
 */
@Configuration
@ConfigurationProperties(prefix = "masterDB.redisCfg")
public class RedisDaoCfg extends AbsBaseRedisCfg {

	/** 默认保存dbIndex */
	public final int defaultDBIIndex = 1;
	/** 队列保存dbIndex */
	public final int queueDBIndex = 2;

	/**
	 * 默认保存 缓存
	 * @return
	 * @throws Exception
	 */
	@Bean(name = "baseRedisDaoDef")
	@Override
	public BaseRedisDao getBaseRedisDao() throws Exception {
		return this.generateBaseRedisDao(defaultDBIIndex);
	}

	/**
	 * 默认队列缓存
	 * @return
	 * @throws Exception
	 */
	@Bean(name = "baseRedisDaoDBCache")
	public BaseRedisDao getBaseRedisDao6() throws Exception {
		return this.generateBaseRedisDao(queueDBIndex);
	}

}
