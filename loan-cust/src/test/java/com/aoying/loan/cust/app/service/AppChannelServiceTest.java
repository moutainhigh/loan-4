package com.aoying.loan.cust.app.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.aoying.loan.common.base.test.BaseTest;
import com.aoying.loan.cust.app.pojo.AppChannelPojo;
import com.aoying.loan.cust.app.service.iservice.IAppChannelService;

/**
 * APP渠道表 Test
 * @author nick
 */
public class AppChannelServiceTest extends BaseTest{
	@Autowired
	private IAppChannelService appChannelService;
	
	/** 模拟HttpServletReqeust*/
	//private static MockHttpServletRequest request = new MockHttpServletRequest();

	/**
	 * 根据主键或唯一键查找数据
	 */
	@Test
	public void selectUnique() {
		AppChannelPojo a = new AppChannelPojo();
		a.setId(1L);
		a = appChannelService.selectUnique(a);
		logger.info("{}", a);
	}

	/**
	 * 根据条件查询记录
	 */
	@Test
	public void selectList() {
		AppChannelPojo a = new AppChannelPojo();
		a.setPageNum(1);
		a.setPageSize(3);
		List<AppChannelPojo> list = appChannelService.selectList(a);
		logger.info("记录总数：{}", a.getTotalRowCount());
		logger.info("{}", list);
		a.setPageNum(2);
		a.setPageSize(3);
		list = appChannelService.selectList(a);
		logger.info("记录总数：" + a.getTotalRowCount());
		logger.info("{}", list);
	}

	/**
	 * 插入一条数据
	 */
	@Test
	public void insert() {
		// AppChannelPojo a = new AppChannelPojo();
		// a.setCreateTime(new Timestamp(System.currentTimeMillis()));
		// int count = appChannelService.insert(a);
		// logger.info("count:" + count + ",id:" + a.getId());
	}

	/**
	 * 修改一条数据
	 */
	@Test
	public void update() {
		AppChannelPojo a = new AppChannelPojo();
		a.setId(1L);
// 		a.setModTime(new Timestamp(System.currentTimeMillis()));
		appChannelService.update(a);
	}

	/**
	 * 批量插入数据
	 */
	@Test
	public void insertList() {
		List<AppChannelPojo> list = new ArrayList<AppChannelPojo>();
		for (int i = 1; i <= 10; i++) {
			AppChannelPojo a = new AppChannelPojo();
			list.add(a);
		}
// 		appChannelService.insertList(list);
	}

	/**
	 * 批量修改数据
	 */
	@Test
	public void updateList() {
		List<AppChannelPojo> list = new ArrayList<AppChannelPojo>();
		for (int i = 5; i <= 10; i++) {
			AppChannelPojo a = new AppChannelPojo();
			a.setId(i + 0L);
			// a.setModTime(new Timestamp(System.currentTimeMillis()));
			list.add(a);
		}
		appChannelService.updateList(list);
	}

	/**
	 * 批量删除数据
	 */
	@Test
	public void deleteList() {
		List<AppChannelPojo> list = new ArrayList<AppChannelPojo>();
		for (int i = 8; i <= 10; i++) {
			AppChannelPojo a = new AppChannelPojo();
			a.setId(i + 0L);
			list.add(a);
		}
// 		appChannelService.deleteList(list);
	}
}
