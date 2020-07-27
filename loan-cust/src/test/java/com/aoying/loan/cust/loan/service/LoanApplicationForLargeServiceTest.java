package com.aoying.loan.cust.loan.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.aoying.loan.common.base.test.BaseTest;
import com.aoying.loan.cust.loan.pojo.LoanApplicationForLargePojo;
import com.aoying.loan.cust.loan.service.iservice.ILoanApplicationForLargeService;

/**
 * 大额贷款申请 Test
 * @author nick
 */
public class LoanApplicationForLargeServiceTest extends BaseTest{
	@Autowired
	private ILoanApplicationForLargeService loanApplicationForLargeService;
	
	/** 模拟HttpServletReqeust*/
	//private static MockHttpServletRequest request = new MockHttpServletRequest();

	/**
	 * 根据主键或唯一键查找数据
	 */
	@Test
	public void selectUnique() {
		LoanApplicationForLargePojo a = new LoanApplicationForLargePojo();
		a.setId(1L);
		a = loanApplicationForLargeService.selectUnique(a);
		logger.info("{}", a);
	}

	/**
	 * 根据条件查询记录
	 */
	@Test
	public void selectList() {
		LoanApplicationForLargePojo a = new LoanApplicationForLargePojo();
		a.setPageNum(1);
		a.setPageSize(3);
		List<LoanApplicationForLargePojo> list = loanApplicationForLargeService.selectList(a);
		logger.info("记录总数：{}", a.getTotalRowCount());
		logger.info("{}", list);
		a.setPageNum(2);
		a.setPageSize(3);
		list = loanApplicationForLargeService.selectList(a);
		logger.info("记录总数：" + a.getTotalRowCount());
		logger.info("{}", list);
	}

	/**
	 * 插入一条数据
	 */
	@Test
	public void insert() {
		// LoanApplicationForLargePojo a = new LoanApplicationForLargePojo();
		// a.setCreateTime(new Timestamp(System.currentTimeMillis()));
		// int count = loanApplicationForLargeService.insert(a);
		// logger.info("count:" + count + ",id:" + a.getId());
	}

	/**
	 * 修改一条数据
	 */
	@Test
	public void update() {
		LoanApplicationForLargePojo a = new LoanApplicationForLargePojo();
		a.setId(1L);
// 		a.setModTime(new Timestamp(System.currentTimeMillis()));
		loanApplicationForLargeService.update(a);
	}

	/**
	 * 批量插入数据
	 */
	@Test
	public void insertList() {
		List<LoanApplicationForLargePojo> list = new ArrayList<LoanApplicationForLargePojo>();
		for (int i = 1; i <= 10; i++) {
			LoanApplicationForLargePojo a = new LoanApplicationForLargePojo();
			list.add(a);
		}
// 		loanApplicationForLargeService.insertList(list);
	}

	/**
	 * 批量修改数据
	 */
	@Test
	public void updateList() {
		List<LoanApplicationForLargePojo> list = new ArrayList<LoanApplicationForLargePojo>();
		for (int i = 5; i <= 10; i++) {
			LoanApplicationForLargePojo a = new LoanApplicationForLargePojo();
			a.setId(i + 0L);
			// a.setModTime(new Timestamp(System.currentTimeMillis()));
			list.add(a);
		}
		loanApplicationForLargeService.updateList(list);
	}

	/**
	 * 批量删除数据
	 */
	@Test
	public void deleteList() {
		List<LoanApplicationForLargePojo> list = new ArrayList<LoanApplicationForLargePojo>();
		for (int i = 8; i <= 10; i++) {
			LoanApplicationForLargePojo a = new LoanApplicationForLargePojo();
			a.setId(i + 0L);
			list.add(a);
		}
// 		loanApplicationForLargeService.deleteList(list);
	}
}
