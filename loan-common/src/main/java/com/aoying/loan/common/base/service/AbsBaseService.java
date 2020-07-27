package com.aoying.loan.common.base.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.aoying.loan.common.base.dao.AbsBaseDao;
import com.aoying.loan.common.base.pojo.BasePojo;
import com.aoying.loan.common.base.service.iservice.IBaseService;

/**
 * Service 抽象类
 * @author nick
 * @param <P>
 * @param <D>
 */
public abstract class AbsBaseService< P extends BasePojo,D extends AbsBaseDao<P>> implements IBaseService< P> {

	/** 日志 */
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	/** dao工具 */
	protected D dao;

	/**
	 * @设置 dao工具
	 */
	protected abstract void setDao(D dao);

	/**
	 * 根据主键或唯一键查找数据
	 * 
	 * @param p
	 * @return
	 */
	@Override
	public P selectUnique(P p) {
		return dao.selectUnique(p);
	}
	
	/**
	 * 根据条件查询记录
	 * 
	 * @param p
	 * @return
	 */
	@Override
	public List<P> selectList(P p) {
		return dao.selectList(p);
	}

	/**
	 * 插入一条数据
	 * 
	 * @param p
	 * @return
	 */
	@Override
	public int insert(P p) {
		return dao.insert(p);
	}

	/**
	 * 修改一条数据
	 * 
	 * @param p
	 * @return
	 */
	@Override
	public int update(P p) {
		return dao.update(p);
	}

	/**
	 * 批量插入数据
	 * 
	 * @param list
	 * @return
	 */
	@Override
	public int insertList(List<P> list) {
		return dao.insertList(list);
	}

	/**
	 * 批量修改数据
	 * 
	 * @param list
	 * @return
	 */
	@Override
	public int updateList(List<P> list) {
		return dao.updateList(list);
	}

}
