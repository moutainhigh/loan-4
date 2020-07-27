package com.aoying.loan.cust.loan.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.aoying.loan.common.base.test.BaseTest;
import com.aoying.loan.cust.loan.pojo.LoanApplicationPojo;
import com.aoying.loan.cust.loan.service.iservice.ILoanApplicationService;

/**
 * 贷款申请 Test
 * @author nick
 */
public class LoanApplicationServiceTest extends BaseTest{
	@Autowired
	private ILoanApplicationService loanApplicationService;
	
	/** 模拟HttpServletReqeust*/
	//private static MockHttpServletRequest request = new MockHttpServletRequest();

	/**
	 * 根据主键或唯一键查找数据
	 */
	@Test
	public void selectUnique() {
		LoanApplicationPojo a = new LoanApplicationPojo();
		a.setId(1L);
		a = loanApplicationService.selectUnique(a);
		logger.info("{}", a);
	}

	/**
	 * 根据条件查询记录
	 */
	@Test
	public void selectList() {
		LoanApplicationPojo a = new LoanApplicationPojo();
		a.setPageNum(1);
		a.setPageSize(3);
		List<LoanApplicationPojo> list = loanApplicationService.selectList(a);
		logger.info("记录总数：{}", a.getTotalRowCount());
		logger.info("{}", list);
		a.setPageNum(2);
		a.setPageSize(3);
		list = loanApplicationService.selectList(a);
		logger.info("记录总数：" + a.getTotalRowCount());
		logger.info("{}", list);
	}

	/**
	 * 插入一条数据
	 */
	@Test
	public void insert() {
		// LoanApplicationPojo a = new LoanApplicationPojo();
		// a.setCreateTime(new Timestamp(System.currentTimeMillis()));
		// int count = loanApplicationService.insert(a);
		// logger.info("count:" + count + ",id:" + a.getId());
	}

	/**
	 * 修改一条数据
	 */
	@Test
	public void update() {
		LoanApplicationPojo a = new LoanApplicationPojo();
		a.setId(1L);
// 		a.setModTime(new Timestamp(System.currentTimeMillis()));
		loanApplicationService.update(a);
	}

	/**
	 * 批量插入数据
	 */
	@Test
	public void insertList() {
		List<LoanApplicationPojo> list = new ArrayList<LoanApplicationPojo>();
		for (int i = 1; i <= 10; i++) {
			LoanApplicationPojo a = new LoanApplicationPojo();
			list.add(a);
		}
// 		loanApplicationService.insertList(list);
	}

	/**
	 * 批量修改数据
	 */
	@Test
	public void updateList() {
		List<LoanApplicationPojo> list = new ArrayList<LoanApplicationPojo>();
		for (int i = 5; i <= 10; i++) {
			LoanApplicationPojo a = new LoanApplicationPojo();
			a.setId(i + 0L);
			// a.setModTime(new Timestamp(System.currentTimeMillis()));
			list.add(a);
		}
		loanApplicationService.updateList(list);
	}

	/**
	 * 批量删除数据
	 */
	@Test
	public void deleteList() {
		List<LoanApplicationPojo> list = new ArrayList<LoanApplicationPojo>();
		for (int i = 8; i <= 10; i++) {
			LoanApplicationPojo a = new LoanApplicationPojo();
			a.setId(i + 0L);
			list.add(a);
		}
// 		loanApplicationService.deleteList(list);
	}
}
