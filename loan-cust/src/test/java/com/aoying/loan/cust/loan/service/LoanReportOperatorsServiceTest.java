package com.aoying.loan.cust.loan.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.aoying.loan.common.base.test.BaseTest;
import com.aoying.loan.cust.loan.pojo.LoanReportOperatorsPojo;
import com.aoying.loan.cust.loan.service.iservice.ILoanReportOperatorsService;

/**
 * 贷款报告之运营商 Test
 * @author nick
 */
public class LoanReportOperatorsServiceTest extends BaseTest{
	@Autowired
	private ILoanReportOperatorsService loanReportOperatorsService;
	
	/** 模拟HttpServletReqeust*/
	//private static MockHttpServletRequest request = new MockHttpServletRequest();

	/**
	 * 根据主键或唯一键查找数据
	 */
	@Test
	public void selectUnique() {
		LoanReportOperatorsPojo a = new LoanReportOperatorsPojo();
		a.setId(1L);
		a = loanReportOperatorsService.selectUnique(a);
		logger.info("{}", a);
	}

	/**
	 * 根据条件查询记录
	 */
	@Test
	public void selectList() {
		LoanReportOperatorsPojo a = new LoanReportOperatorsPojo();
		a.setPageNum(1);
		a.setPageSize(3);
		List<LoanReportOperatorsPojo> list = loanReportOperatorsService.selectList(a);
		logger.info("记录总数：{}", a.getTotalRowCount());
		logger.info("{}", list);
		a.setPageNum(2);
		a.setPageSize(3);
		list = loanReportOperatorsService.selectList(a);
		logger.info("记录总数：" + a.getTotalRowCount());
		logger.info("{}", list);
	}

	/**
	 * 插入一条数据
	 */
	@Test
	public void insert() {
		// LoanReportOperatorsPojo a = new LoanReportOperatorsPojo();
		// a.setCreateTime(new Timestamp(System.currentTimeMillis()));
		// int count = loanReportOperatorsService.insert(a);
		// logger.info("count:" + count + ",id:" + a.getId());
	}

	/**
	 * 修改一条数据
	 */
	@Test
	public void update() {
		LoanReportOperatorsPojo a = new LoanReportOperatorsPojo();
		a.setId(1L);
// 		a.setModTime(new Timestamp(System.currentTimeMillis()));
		loanReportOperatorsService.update(a);
	}

	/**
	 * 批量插入数据
	 */
	@Test
	public void insertList() {
		List<LoanReportOperatorsPojo> list = new ArrayList<LoanReportOperatorsPojo>();
		for (int i = 1; i <= 10; i++) {
			LoanReportOperatorsPojo a = new LoanReportOperatorsPojo();
			list.add(a);
		}
// 		loanReportOperatorsService.insertList(list);
	}

	/**
	 * 批量修改数据
	 */
	@Test
	public void updateList() {
		List<LoanReportOperatorsPojo> list = new ArrayList<LoanReportOperatorsPojo>();
		for (int i = 5; i <= 10; i++) {
			LoanReportOperatorsPojo a = new LoanReportOperatorsPojo();
			a.setId(i + 0L);
			// a.setModTime(new Timestamp(System.currentTimeMillis()));
			list.add(a);
		}
		loanReportOperatorsService.updateList(list);
	}

	/**
	 * 批量删除数据
	 */
	@Test
	public void deleteList() {
		List<LoanReportOperatorsPojo> list = new ArrayList<LoanReportOperatorsPojo>();
		for (int i = 8; i <= 10; i++) {
			LoanReportOperatorsPojo a = new LoanReportOperatorsPojo();
			a.setId(i + 0L);
			list.add(a);
		}
// 		loanReportOperatorsService.deleteList(list);
	}
}
