package com.aoying.loan.cust.app.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.aoying.loan.common.base.test.BaseTest;
import com.aoying.loan.cust.app.pojo.AppChannelVersionPojo;
import com.aoying.loan.cust.app.service.iservice.IAppChannelVersionService;

/**
 * APP渠道版本关联表 Test
 * @author nick
 */
public class AppChannelVersionServiceTest extends BaseTest{
	@Autowired
	private IAppChannelVersionService appChannelVersionService;
	
	/** 模拟HttpServletReqeust*/
	//private static MockHttpServletRequest request = new MockHttpServletRequest();

	/**
	 * 根据主键或唯一键查找数据
	 */
	@Test
	public void selectUnique() {
		AppChannelVersionPojo a = new AppChannelVersionPojo();
		a.setId(1L);
		a = appChannelVersionService.selectUnique(a);
		logger.info("{}", a);
	}

	/**
	 * 根据条件查询记录
	 */
	@Test
	public void selectList() {
		AppChannelVersionPojo a = new AppChannelVersionPojo();
		a.setPageNum(1);
		a.setPageSize(3);
		List<AppChannelVersionPojo> list = appChannelVersionService.selectList(a);
		logger.info("记录总数：{}", a.getTotalRowCount());
		logger.info("{}", list);
		a.setPageNum(2);
		a.setPageSize(3);
		list = appChannelVersionService.selectList(a);
		logger.info("记录总数：" + a.getTotalRowCount());
		logger.info("{}", list);
	}

	/**
	 * 插入一条数据
	 */
	@Test
	public void insert() {
		// AppChannelVersionPojo a = new AppChannelVersionPojo();
		// a.setCreateTime(new Timestamp(System.currentTimeMillis()));
		// int count = appChannelVersionService.insert(a);
		// logger.info("count:" + count + ",id:" + a.getId());
	}

	/**
	 * 修改一条数据
	 */
	@Test
	public void update() {
		AppChannelVersionPojo a = new AppChannelVersionPojo();
		a.setId(1L);
// 		a.setModTime(new Timestamp(System.currentTimeMillis()));
		appChannelVersionService.update(a);
	}

	/**
	 * 批量插入数据
	 */
	@Test
	public void insertList() {
		List<AppChannelVersionPojo> list = new ArrayList<AppChannelVersionPojo>();
		for (int i = 1; i <= 10; i++) {
			AppChannelVersionPojo a = new AppChannelVersionPojo();
			list.add(a);
		}
// 		appChannelVersionService.insertList(list);
	}

	/**
	 * 批量修改数据
	 */
	@Test
	public void updateList() {
		List<AppChannelVersionPojo> list = new ArrayList<AppChannelVersionPojo>();
		for (int i = 5; i <= 10; i++) {
			AppChannelVersionPojo a = new AppChannelVersionPojo();
			a.setId(i + 0L);
			// a.setModTime(new Timestamp(System.currentTimeMillis()));
			list.add(a);
		}
		appChannelVersionService.updateList(list);
	}

	/**
	 * 批量删除数据
	 */
	@Test
	public void deleteList() {
		List<AppChannelVersionPojo> list = new ArrayList<AppChannelVersionPojo>();
		for (int i = 8; i <= 10; i++) {
			AppChannelVersionPojo a = new AppChannelVersionPojo();
			a.setId(i + 0L);
			list.add(a);
		}
// 		appChannelVersionService.deleteList(list);
	}
}
