package com.aoying.loan.cust.app.service;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.aoying.loan.common.base.test.BaseTest;
import com.aoying.loan.cust.app.pojo.AppChannelRecordPojo;
import com.aoying.loan.cust.app.service.iservice.IAppChannelRecordService;

/**
 * APP渠道记录 Test
 * @author nick
 */
public class AppChannelRecordServiceTest extends BaseTest{
	@Autowired
	private IAppChannelRecordService appChannelRecordService;
	
	/** 模拟HttpServletReqeust*/
	//private static MockHttpServletRequest request = new MockHttpServletRequest();

	/**
	 * 根据主键或唯一键查找数据
	 */
	@Test
	public void selectUnique() {
		AppChannelRecordPojo a = new AppChannelRecordPojo();
		a.setId(1L);
		a = appChannelRecordService.selectUnique(a);
		logger.info("{}", a);
	}

	/**
	 * 根据条件查询记录
	 */
	@Test
	public void selectList() {
		AppChannelRecordPojo a = new AppChannelRecordPojo();
		a.setPageNum(1);
		a.setPageSize(3);
		List<AppChannelRecordPojo> list = appChannelRecordService.getList(a);
		logger.info("记录总数：{}", a.getTotalRowCount());
		logger.info("{}", list);
		a.setPageNum(2);
		a.setPageSize(3);
		list = appChannelRecordService.getList(a);
		logger.info("记录总数：" + a.getTotalRowCount());
		logger.info("{}", list);
	}

	/**
	 * 插入一条数据
	 */
	@Test
	public void insert() {
		// AppChannelRecordPojo a = new AppChannelRecordPojo();
		// a.setCreateTime(new Timestamp(System.currentTimeMillis()));
		// int count = appChannelRecordService.insert(a);
		// logger.info("count:" + count + ",id:" + a.getId());
	}

	/**
	 * 修改一条数据
	 */
	@Test
	public void update() {
		AppChannelRecordPojo a = new AppChannelRecordPojo();
		a.setId(1L);
// 		a.setModTime(new Timestamp(System.currentTimeMillis()));
		appChannelRecordService.update(a);
	}

	/**
	 * 批量插入数据
	 */
	@Test
	public void insertList() {
		List<AppChannelRecordPojo> list = new ArrayList<AppChannelRecordPojo>();
		for (int i = 1; i <= 10; i++) {
			AppChannelRecordPojo a = new AppChannelRecordPojo();
			list.add(a);
		}
// 		appChannelRecordService.insertList(list);
	}

	/**
	 * 批量修改数据
	 */
	@Test
	public void updateList() {
		List<AppChannelRecordPojo> list = new ArrayList<AppChannelRecordPojo>();
		for (int i = 5; i <= 10; i++) {
			AppChannelRecordPojo a = new AppChannelRecordPojo();
			a.setId(i + 0L);
			// a.setModTime(new Timestamp(System.currentTimeMillis()));
			list.add(a);
		}
		appChannelRecordService.updateList(list);
	}

	/**
	 * 批量删除数据
	 */
	@Test
	public void deleteList() {
		List<AppChannelRecordPojo> list = new ArrayList<AppChannelRecordPojo>();
		for (int i = 8; i <= 10; i++) {
			AppChannelRecordPojo a = new AppChannelRecordPojo();
			a.setId(i + 0L);
			list.add(a);
		}
// 		appChannelRecordService.deleteList(list);
	}
}
