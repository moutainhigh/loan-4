package com.aoying.loan.common.base.service;

import org.springframework.beans.factory.annotation.Autowired;
import com.aoying.loan.common.base.dao.AbsBaseDao;
import com.aoying.loan.common.base.pojo.BasePojo;

/**
 * Service 基类
 * @author nick
 * @param <P>
 * @param <D>
 */
public class BaseService<P extends BasePojo, D extends AbsBaseDao<P>> extends AbsBaseService<P, D> {
	/**
	 * @设置 dao工具
	 */
	@Autowired
	@Override
	protected void setDao(D dao) {
		this.dao = dao;
	}

}
