package com.aoying.loan.cust.sys.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.aoying.loan.common.base.test.BaseTest;
import com.aoying.loan.cust.sys.pojo.SysDictionaryPojo;
import com.aoying.loan.cust.sys.service.iservice.ISysDictionaryService;

/**
 * 字典表 Test
 * @author nick
 */
public class SysDictionaryServiceTest extends BaseTest{
	@Autowired
	private ISysDictionaryService sysDictionaryService;
	
	/** 模拟HttpServletReqeust*/
	//private static MockHttpServletRequest request = new MockHttpServletRequest();

	/**
	 * 根据主键或唯一键查找数据
	 */
	@Test
	public void selectUnique() {
		SysDictionaryPojo a = new SysDictionaryPojo();
		a.setId(1L);
		a = sysDictionaryService.selectUnique(a);
		logger.info("{}", a);
	}

	/**
	 * 根据条件查询记录
	 */
	@Test
	public void selectList() {
		SysDictionaryPojo a = new SysDictionaryPojo();
		a.setPageNum(1);
		a.setPageSize(3);
		List<SysDictionaryPojo> list = sysDictionaryService.selectList(a);
		logger.info("记录总数：{}", a.getTotalRowCount());
		logger.info("{}", list);
		a.setPageNum(2);
		a.setPageSize(3);
		list = sysDictionaryService.selectList(a);
		logger.info("记录总数：" + a.getTotalRowCount());
		logger.info("{}", list);
	}

	/**
	 * 插入一条数据
	 */
	@Test
	public void insert() {
		// SysDictionaryPojo a = new SysDictionaryPojo();
		// a.setCreateTime(new Timestamp(System.currentTimeMillis()));
		// int count = sysDictionaryService.insert(a);
		// logger.info("count:" + count + ",id:" + a.getId());
	}

	/**
	 * 修改一条数据
	 */
	@Test
	public void update() {
		SysDictionaryPojo a = new SysDictionaryPojo();
		a.setId(1L);
// 		a.setModTime(new Timestamp(System.currentTimeMillis()));
		sysDictionaryService.update(a);
	}

	/**
	 * 批量插入数据
	 */
	@Test
	public void insertList() {
		List<SysDictionaryPojo> list = new ArrayList<SysDictionaryPojo>();
		for (int i = 1; i <= 10; i++) {
			SysDictionaryPojo a = new SysDictionaryPojo();
			list.add(a);
		}
// 		sysDictionaryService.insertList(list);
	}

	/**
	 * 批量修改数据
	 */
	@Test
	public void updateList() {
		List<SysDictionaryPojo> list = new ArrayList<SysDictionaryPojo>();
		for (int i = 5; i <= 10; i++) {
			SysDictionaryPojo a = new SysDictionaryPojo();
			a.setId(i + 0L);
			// a.setModTime(new Timestamp(System.currentTimeMillis()));
			list.add(a);
		}
		sysDictionaryService.updateList(list);
	}

	/**
	 * 批量删除数据
	 */
	@Test
	public void deleteList() {
		List<SysDictionaryPojo> list = new ArrayList<SysDictionaryPojo>();
		for (int i = 8; i <= 10; i++) {
			SysDictionaryPojo a = new SysDictionaryPojo();
			a.setId(i + 0L);
			list.add(a);
		}
// 		sysDictionaryService.deleteList(list);
	}
}
