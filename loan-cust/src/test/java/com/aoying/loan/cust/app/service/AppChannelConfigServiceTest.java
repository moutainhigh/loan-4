package com.aoying.loan.cust.app.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.aoying.loan.common.base.test.BaseTest;
import com.aoying.loan.cust.app.pojo.AppChannelConfigPojo;
import com.aoying.loan.cust.app.service.iservice.IAppChannelConfigService;

/**
 * APP渠道配置 Test
 * @author nick
 */
public class AppChannelConfigServiceTest extends BaseTest{
	@Autowired
	private IAppChannelConfigService appChannelConfigService;
	
	/** 模拟HttpServletReqeust*/
	//private static MockHttpServletRequest request = new MockHttpServletRequest();

	/**
	 * 根据主键或唯一键查找数据
	 */
	@Test
	public void selectUnique() {
		AppChannelConfigPojo a = new AppChannelConfigPojo();
		a.setId(1L);
		a = appChannelConfigService.selectUnique(a);
		logger.info("{}", a);
	}

	/**
	 * 根据条件查询记录
	 */
	@Test
	public void selectList() {
		AppChannelConfigPojo a = new AppChannelConfigPojo();
		a.setPageNum(1);
		a.setPageSize(3);
		List<AppChannelConfigPojo> list = appChannelConfigService.selectList(a);
		logger.info("记录总数：{}", a.getTotalRowCount());
		logger.info("{}", list);
		a.setPageNum(2);
		a.setPageSize(3);
		list = appChannelConfigService.selectList(a);
		logger.info("记录总数：" + a.getTotalRowCount());
		logger.info("{}", list);
	}

	/**
	 * 插入一条数据
	 */
	@Test
	public void insert() {
		// AppChannelConfigPojo a = new AppChannelConfigPojo();
		// a.setCreateTime(new Timestamp(System.currentTimeMillis()));
		// int count = appChannelConfigService.insert(a);
		// logger.info("count:" + count + ",id:" + a.getId());
	}

	/**
	 * 修改一条数据
	 */
	@Test
	public void update() {
		AppChannelConfigPojo a = new AppChannelConfigPojo();
		a.setId(1L);
// 		a.setModTime(new Timestamp(System.currentTimeMillis()));
		appChannelConfigService.update(a);
	}

	/**
	 * 批量插入数据
	 */
	@Test
	public void insertList() {
		List<AppChannelConfigPojo> list = new ArrayList<AppChannelConfigPojo>();
		for (int i = 1; i <= 10; i++) {
			AppChannelConfigPojo a = new AppChannelConfigPojo();
			list.add(a);
		}
// 		appChannelConfigService.insertList(list);
	}

	/**
	 * 批量修改数据
	 */
	@Test
	public void updateList() {
		List<AppChannelConfigPojo> list = new ArrayList<AppChannelConfigPojo>();
		for (int i = 5; i <= 10; i++) {
			AppChannelConfigPojo a = new AppChannelConfigPojo();
			a.setId(i + 0L);
			// a.setModTime(new Timestamp(System.currentTimeMillis()));
			list.add(a);
		}
		appChannelConfigService.updateList(list);
	}

	/**
	 * 批量删除数据
	 */
	@Test
	public void deleteList() {
		List<AppChannelConfigPojo> list = new ArrayList<AppChannelConfigPojo>();
		for (int i = 8; i <= 10; i++) {
			AppChannelConfigPojo a = new AppChannelConfigPojo();
			a.setId(i + 0L);
			list.add(a);
		}
// 		appChannelConfigService.deleteList(list);
	}
}
