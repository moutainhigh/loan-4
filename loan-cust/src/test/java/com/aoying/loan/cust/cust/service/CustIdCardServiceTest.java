package com.aoying.loan.cust.cust.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.aoying.loan.common.base.test.BaseTest;
import com.aoying.loan.cust.cust.pojo.CustIdCardPojo;
import com.aoying.loan.cust.cust.service.iservice.ICustIdCardService;

/**
 * 用户实名表 Test
 * @author nick
 */
public class CustIdCardServiceTest extends BaseTest{
	@Autowired
	private ICustIdCardService custIdCardService;
	
	/** 模拟HttpServletReqeust*/
	//private static MockHttpServletRequest request = new MockHttpServletRequest();

	/**
	 * 根据主键或唯一键查找数据
	 */
	@Test
	public void selectUnique() {
		CustIdCardPojo a = new CustIdCardPojo();
		a.setId(1L);
		a = custIdCardService.selectUnique(a);
		logger.info("{}", a);
	}

	/**
	 * 根据条件查询记录
	 */
	@Test
	public void selectList() {
		CustIdCardPojo a = new CustIdCardPojo();
		a.setPageNum(1);
		a.setPageSize(3);
		List<CustIdCardPojo> list = custIdCardService.selectList(a);
		logger.info("记录总数：{}", a.getTotalRowCount());
		logger.info("{}", list);
		a.setPageNum(2);
		a.setPageSize(3);
		list = custIdCardService.selectList(a);
		logger.info("记录总数：" + a.getTotalRowCount());
		logger.info("{}", list);
	}

	/**
	 * 插入一条数据
	 */
	@Test
	public void insert() {
		// CustIdCardPojo a = new CustIdCardPojo();
		// a.setCreateTime(new Timestamp(System.currentTimeMillis()));
		// int count = custIdCardService.insert(a);
		// logger.info("count:" + count + ",id:" + a.getId());
	}

	/**
	 * 修改一条数据
	 */
	@Test
	public void update() {
		CustIdCardPojo a = new CustIdCardPojo();
		a.setId(1L);
// 		a.setModTime(new Timestamp(System.currentTimeMillis()));
		custIdCardService.update(a);
	}

	/**
	 * 批量插入数据
	 */
	@Test
	public void insertList() {
		List<CustIdCardPojo> list = new ArrayList<CustIdCardPojo>();
		for (int i = 1; i <= 10; i++) {
			CustIdCardPojo a = new CustIdCardPojo();
			list.add(a);
		}
// 		custIdCardService.insertList(list);
	}

	/**
	 * 批量修改数据
	 */
	@Test
	public void updateList() {
		List<CustIdCardPojo> list = new ArrayList<CustIdCardPojo>();
		for (int i = 5; i <= 10; i++) {
			CustIdCardPojo a = new CustIdCardPojo();
			a.setId(i + 0L);
			// a.setModTime(new Timestamp(System.currentTimeMillis()));
			list.add(a);
		}
		custIdCardService.updateList(list);
	}

	/**
	 * 批量删除数据
	 */
	@Test
	public void deleteList() {
		List<CustIdCardPojo> list = new ArrayList<CustIdCardPojo>();
		for (int i = 8; i <= 10; i++) {
			CustIdCardPojo a = new CustIdCardPojo();
			a.setId(i + 0L);
			list.add(a);
		}
// 		custIdCardService.deleteList(list);
	}
}
