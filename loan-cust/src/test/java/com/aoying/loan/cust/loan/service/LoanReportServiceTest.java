package com.aoying.loan.cust.loan.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.aoying.loan.common.base.test.BaseTest;
import com.aoying.loan.cust.loan.pojo.LoanReportPojo;
import com.aoying.loan.cust.loan.service.iservice.ILoanReportService;

/**
 * 贷款报告 Test
 * @author nick
 */
public class LoanReportServiceTest extends BaseTest{
	@Autowired
	private ILoanReportService loanReportService;
	
	/** 模拟HttpServletReqeust*/
	//private static MockHttpServletRequest request = new MockHttpServletRequest();

	/**
	 * 根据主键或唯一键查找数据
	 */
	@Test
	public void selectUnique() {
		LoanReportPojo a = new LoanReportPojo();
		a.setId(1L);
		a = loanReportService.selectUnique(a);
		logger.info("{}", a);
	}

	/**
	 * 根据条件查询记录
	 */
	@Test
	public void selectList() {
		LoanReportPojo a = new LoanReportPojo();
		a.setPageNum(1);
		a.setPageSize(3);
		List<LoanReportPojo> list = loanReportService.selectList(a);
		logger.info("记录总数：{}", a.getTotalRowCount());
		logger.info("{}", list);
		a.setPageNum(2);
		a.setPageSize(3);
		list = loanReportService.selectList(a);
		logger.info("记录总数：" + a.getTotalRowCount());
		logger.info("{}", list);
	}

	/**
	 * 插入一条数据
	 */
	@Test
	public void insert() {
		// LoanReportPojo a = new LoanReportPojo();
		// a.setCreateTime(new Timestamp(System.currentTimeMillis()));
		// int count = loanReportService.insert(a);
		// logger.info("count:" + count + ",id:" + a.getId());
	}

	/**
	 * 修改一条数据
	 */
	@Test
	public void update() {
		LoanReportPojo a = new LoanReportPojo();
		a.setId(1L);
// 		a.setModTime(new Timestamp(System.currentTimeMillis()));
		loanReportService.update(a);
	}

	/**
	 * 批量插入数据
	 */
	@Test
	public void insertList() {
		List<LoanReportPojo> list = new ArrayList<LoanReportPojo>();
		for (int i = 1; i <= 10; i++) {
			LoanReportPojo a = new LoanReportPojo();
			list.add(a);
		}
// 		loanReportService.insertList(list);
	}

	/**
	 * 批量修改数据
	 */
	@Test
	public void updateList() {
		List<LoanReportPojo> list = new ArrayList<LoanReportPojo>();
		for (int i = 5; i <= 10; i++) {
			LoanReportPojo a = new LoanReportPojo();
			a.setId(i + 0L);
			// a.setModTime(new Timestamp(System.currentTimeMillis()));
			list.add(a);
		}
		loanReportService.updateList(list);
	}

	/**
	 * 批量删除数据
	 */
	@Test
	public void deleteList() {
		List<LoanReportPojo> list = new ArrayList<LoanReportPojo>();
		for (int i = 8; i <= 10; i++) {
			LoanReportPojo a = new LoanReportPojo();
			a.setId(i + 0L);
			list.add(a);
		}
// 		loanReportService.deleteList(list);
	}
}
