package com.aoying.loan.cust.loan.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.aoying.loan.common.base.test.BaseTest;
import com.aoying.loan.cust.loan.pojo.LoanProductClickLogPojo;
import com.aoying.loan.cust.loan.service.iservice.ILoanProductClickLogService;

/**
 * 贷款产品点击日志 Test
 * @author nick
 */
public class LoanProductClickLogServiceTest extends BaseTest{
	@Autowired
	private ILoanProductClickLogService loanProductClickLogService;
	
	/** 模拟HttpServletReqeust*/
	//private static MockHttpServletRequest request = new MockHttpServletRequest();

	/**
	 * 根据主键或唯一键查找数据
	 */
	@Test
	public void selectUnique() {
		LoanProductClickLogPojo a = new LoanProductClickLogPojo();
		a.setId(1L);
		a = loanProductClickLogService.selectUnique(a);
		logger.info("{}", a);
	}

	/**
	 * 根据条件查询记录
	 */
	@Test
	public void selectList() {
		LoanProductClickLogPojo a = new LoanProductClickLogPojo();
		a.setPageNum(1);
		a.setPageSize(3);
		List<LoanProductClickLogPojo> list = loanProductClickLogService.selectList(a);
		logger.info("记录总数：{}", a.getTotalRowCount());
		logger.info("{}", list);
		a.setPageNum(2);
		a.setPageSize(3);
		list = loanProductClickLogService.selectList(a);
		logger.info("记录总数：" + a.getTotalRowCount());
		logger.info("{}", list);
	}

	/**
	 * 插入一条数据
	 */
	@Test
	public void insert() {
		// LoanProductClickLogPojo a = new LoanProductClickLogPojo();
		// a.setCreateTime(new Timestamp(System.currentTimeMillis()));
		// int count = loanProductClickLogService.insert(a);
		// logger.info("count:" + count + ",id:" + a.getId());
	}

	/**
	 * 修改一条数据
	 */
	@Test
	public void update() {
		LoanProductClickLogPojo a = new LoanProductClickLogPojo();
		a.setId(1L);
// 		a.setModTime(new Timestamp(System.currentTimeMillis()));
		loanProductClickLogService.update(a);
	}

	/**
	 * 批量插入数据
	 */
	@Test
	public void insertList() {
		List<LoanProductClickLogPojo> list = new ArrayList<LoanProductClickLogPojo>();
		for (int i = 1; i <= 10; i++) {
			LoanProductClickLogPojo a = new LoanProductClickLogPojo();
			list.add(a);
		}
// 		loanProductClickLogService.insertList(list);
	}

	/**
	 * 批量修改数据
	 */
	@Test
	public void updateList() {
		List<LoanProductClickLogPojo> list = new ArrayList<LoanProductClickLogPojo>();
		for (int i = 5; i <= 10; i++) {
			LoanProductClickLogPojo a = new LoanProductClickLogPojo();
			a.setId(i + 0L);
			// a.setModTime(new Timestamp(System.currentTimeMillis()));
			list.add(a);
		}
		loanProductClickLogService.updateList(list);
	}

	/**
	 * 批量删除数据
	 */
	@Test
	public void deleteList() {
		List<LoanProductClickLogPojo> list = new ArrayList<LoanProductClickLogPojo>();
		for (int i = 8; i <= 10; i++) {
			LoanProductClickLogPojo a = new LoanProductClickLogPojo();
			a.setId(i + 0L);
			list.add(a);
		}
// 		loanProductClickLogService.deleteList(list);
	}
}
