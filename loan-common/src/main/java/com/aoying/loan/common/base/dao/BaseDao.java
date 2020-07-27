/** */
package com.aoying.loan.common.base.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import com.aoying.loan.common.base.pojo.BasePojo;

/**
 * @功能:druid数据库及事务配置
 * @项目名:dunningServer
 * @作者:wangjz
 * @日期:2017年8月2日下午5:50:42
 * @说明：<pre></pre>
 */
public class BaseDao<P extends BasePojo> extends AbsBaseDao<P> {

	/**
	 * @设置 单条sql操作模板
	 */
	@Autowired
	@Qualifier("masterDBSqlSessionTemplate")
	protected void setTemplate(SqlSessionTemplate template) {
		this.template = template;
	}

	/**
	 * @设置 批量sql操作模板
	 */
	@Autowired
	@Qualifier("masterDBSqlSessionBatchTemplate")
	protected void setBatchTemplate(SqlSessionTemplate batchTemplate) {
		this.batchTemplate = batchTemplate;
	}

}
