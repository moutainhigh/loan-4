package com.aoying.loan.cust.app.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.aoying.loan.common.base.test.BaseTest;
import com.aoying.loan.cust.app.pojo.AppBannerPojo;
import com.aoying.loan.cust.app.service.iservice.IAppBannerService;

/**
 * APP横幅广告表 Test
 * @author nick
 */
public class AppBannerServiceTest extends BaseTest{
	@Autowired
	private IAppBannerService appBannerService;
	
	/** 模拟HttpServletReqeust*/
	//private static MockHttpServletRequest request = new MockHttpServletRequest();

	/**
	 * 根据主键或唯一键查找数据
	 */
	@Test
	public void selectUnique() {
		AppBannerPojo a = new AppBannerPojo();
		a.setId(1L);
		a = appBannerService.selectUnique(a);
		logger.info("{}", a);
	}

	/**
	 * 根据条件查询记录
	 */
	@Test
	public void selectList() {
		AppBannerPojo a = new AppBannerPojo();
		a.setPageNum(1);
		a.setPageSize(3);
		List<AppBannerPojo> list = appBannerService.selectList(a);
		logger.info("记录总数：{}", a.getTotalRowCount());
		logger.info("{}", list);
		a.setPageNum(2);
		a.setPageSize(3);
		list = appBannerService.selectList(a);
		logger.info("记录总数：" + a.getTotalRowCount());
		logger.info("{}", list);
	}

	/**
	 * 插入一条数据
	 */
	@Test
	public void insert() {
		// AppBannerPojo a = new AppBannerPojo();
		// a.setCreateTime(new Timestamp(System.currentTimeMillis()));
		// int count = appBannerService.insert(a);
		// logger.info("count:" + count + ",id:" + a.getId());
	}

	/**
	 * 修改一条数据
	 */
	@Test
	public void update() {
		AppBannerPojo a = new AppBannerPojo();
		a.setId(1L);
// 		a.setModTime(new Timestamp(System.currentTimeMillis()));
		appBannerService.update(a);
	}

	/**
	 * 批量插入数据
	 */
	@Test
	public void insertList() {
		List<AppBannerPojo> list = new ArrayList<AppBannerPojo>();
		for (int i = 1; i <= 10; i++) {
			AppBannerPojo a = new AppBannerPojo();
			list.add(a);
		}
// 		appBannerService.insertList(list);
	}

	/**
	 * 批量修改数据
	 */
	@Test
	public void updateList() {
		List<AppBannerPojo> list = new ArrayList<AppBannerPojo>();
		for (int i = 5; i <= 10; i++) {
			AppBannerPojo a = new AppBannerPojo();
			a.setId(i + 0L);
			// a.setModTime(new Timestamp(System.currentTimeMillis()));
			list.add(a);
		}
		appBannerService.updateList(list);
	}

	/**
	 * 批量删除数据
	 */
	@Test
	public void deleteList() {
		List<AppBannerPojo> list = new ArrayList<AppBannerPojo>();
		for (int i = 8; i <= 10; i++) {
			AppBannerPojo a = new AppBannerPojo();
			a.setId(i + 0L);
			list.add(a);
		}
// 		appBannerService.deleteList(list);
	}
}
