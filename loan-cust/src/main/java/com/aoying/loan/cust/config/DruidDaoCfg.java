package com.aoying.loan.cust.config;

import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.interceptor.TransactionInterceptor;
import com.aoying.loan.common.config.mysql.AbsBaseDruidDaoCfg;

/**
 * MySQL配置
 * @author nick
 */
@Configuration
@ConfigurationProperties(prefix = "masterDB.dbCfg")
public class DruidDaoCfg extends AbsBaseDruidDaoCfg {
	/**
	 * 得到数据源
	 * @return
	 * @throws Exception
	 */
	@Bean(name = "masterDBDataSource", initMethod = "init", destroyMethod = "close")
	@Override
	public DataSource getDataSource() throws Exception {
		return super.generateDataSource();
	}

	/**
	 * 创建mybatis SqlSessionFactory
	 * @param dataSource
	 * @return
	 * @throws Exception
	 */
	@Bean(name = "masterDBSqlSessionFactory")
	@Override
	public SqlSessionFactory getSqlSessionFactory(@Qualifier("masterDBDataSource") DataSource dataSource)
			throws Exception {
		return super.generateSqlSessionFactory(dataSource);
	}

	/**
	 * 得到单条sql语句操作模板
	 * @param sqlSessionFactory
	 * @return
	 */
	@Bean(name = "masterDBSqlSessionTemplate")
	@Override
	public SqlSessionTemplate getSqlSessionTemplate(
			@Qualifier("masterDBSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
		return super.generateSqlSessionTemplate(sqlSessionFactory);
	}

	/**
	 * 得到批量sql操作模板
	 * @param sqlSessionFactory
	 * @return
	 */
	@Bean(name = "masterDBSqlSessionBatchTemplate")
	@Override
	public SqlSessionTemplate getSqlSessionBatchTemplate(
			@Qualifier("masterDBSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
		return super.generateSqlSessionBatchTemplate(sqlSessionFactory);
	}

	/**
	 * 事务管理
	 * @param dataSource
	 * @return
	 */
	@Bean(name = "masterDBTxManager")
	@Override
	public PlatformTransactionManager getTransactionManager(@Qualifier("masterDBDataSource") DataSource dataSource) {
		return super.generateTransactionManager(dataSource);
	}

	/**
	 * 事务用在哪些方法拦截器
	 * @param txManager
	 * @return
	 */
	@Bean(name = "masterDBTxInterceptor")
	@Override
	public TransactionInterceptor getTransactionInterceptor(
			@Qualifier("masterDBTxManager") PlatformTransactionManager txManager) {
		return super.generateTransactionInterceptor(txManager);
	}

	/**
	 * 事务用在哪些类上
	 * @param interceptor
	 * @return
	 */
	@Bean(name = "masterDBTxAop")
	@Override
	public DefaultPointcutAdvisor getTransactionDefaultPointcutAdvisor(
			@Qualifier("masterDBTxInterceptor") TransactionInterceptor interceptor) {
		return super.generateTransactionDefaultPointcutAdvisor(interceptor);
	}

}
