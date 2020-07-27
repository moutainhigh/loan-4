package com.aoying.loan.cust.app.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.aoying.loan.common.base.test.BaseTest;
import com.aoying.loan.cust.app.pojo.AppVersionPojo;
import com.aoying.loan.cust.app.service.iservice.IAppVersionService;

/**
 * APP版本表 Test
 * @author nick
 */
public class AppVersionServiceTest extends BaseTest{
	@Autowired
	private IAppVersionService appVersionService;
	
	/** 模拟HttpServletReqeust*/
	//private static MockHttpServletRequest request = new MockHttpServletRequest();

	/**
	 * 根据主键或唯一键查找数据
	 */
	@Test
	public void selectUnique() {
		AppVersionPojo a = new AppVersionPojo();
		a.setId(1L);
		a = appVersionService.selectUnique(a);
		logger.info("{}", a);
	}

	/**
	 * 根据条件查询记录
	 */
	@Test
	public void selectList() {
		AppVersionPojo a = new AppVersionPojo();
		a.setPageNum(1);
		a.setPageSize(3);
		List<AppVersionPojo> list = appVersionService.selectList(a);
		logger.info("记录总数：{}", a.getTotalRowCount());
		logger.info("{}", list);
		a.setPageNum(2);
		a.setPageSize(3);
		list = appVersionService.selectList(a);
		logger.info("记录总数：" + a.getTotalRowCount());
		logger.info("{}", list);
	}

	/**
	 * 插入一条数据
	 */
	@Test
	public void insert() {
		// AppVersionPojo a = new AppVersionPojo();
		// a.setCreateTime(new Timestamp(System.currentTimeMillis()));
		// int count = appVersionService.insert(a);
		// logger.info("count:" + count + ",id:" + a.getId());
	}

	/**
	 * 修改一条数据
	 */
	@Test
	public void update() {
		AppVersionPojo a = new AppVersionPojo();
		a.setId(1L);
// 		a.setModTime(new Timestamp(System.currentTimeMillis()));
		appVersionService.update(a);
	}

	/**
	 * 批量插入数据
	 */
	@Test
	public void insertList() {
		List<AppVersionPojo> list = new ArrayList<AppVersionPojo>();
		for (int i = 1; i <= 10; i++) {
			AppVersionPojo a = new AppVersionPojo();
			list.add(a);
		}
// 		appVersionService.insertList(list);
	}

	/**
	 * 批量修改数据
	 */
	@Test
	public void updateList() {
		List<AppVersionPojo> list = new ArrayList<AppVersionPojo>();
		for (int i = 5; i <= 10; i++) {
			AppVersionPojo a = new AppVersionPojo();
			a.setId(i + 0L);
			// a.setModTime(new Timestamp(System.currentTimeMillis()));
			list.add(a);
		}
		appVersionService.updateList(list);
	}

	/**
	 * 批量删除数据
	 */
	@Test
	public void deleteList() {
		List<AppVersionPojo> list = new ArrayList<AppVersionPojo>();
		for (int i = 8; i <= 10; i++) {
			AppVersionPojo a = new AppVersionPojo();
			a.setId(i + 0L);
			list.add(a);
		}
// 		appVersionService.deleteList(list);
	}
}
