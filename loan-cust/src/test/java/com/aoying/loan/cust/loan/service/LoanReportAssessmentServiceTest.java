package com.aoying.loan.cust.loan.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.aoying.loan.common.base.test.BaseTest;
import com.aoying.loan.cust.loan.pojo.LoanReportAssessmentPojo;
import com.aoying.loan.cust.loan.service.iservice.ILoanReportAssessmentService;

/**
 * 贷款报告之明镜 Test
 * @author nick
 */
public class LoanReportAssessmentServiceTest extends BaseTest{
	@Autowired
	private ILoanReportAssessmentService loanReportAssessmentService;
	
	/** 模拟HttpServletReqeust*/
	//private static MockHttpServletRequest request = new MockHttpServletRequest();

	/**
	 * 根据主键或唯一键查找数据
	 */
	@Test
	public void selectUnique() {
		LoanReportAssessmentPojo a = new LoanReportAssessmentPojo();
		a.setId(1L);
		a = loanReportAssessmentService.selectUnique(a);
		logger.info("{}", a);
	}

	/**
	 * 根据条件查询记录
	 */
	@Test
	public void selectList() {
		LoanReportAssessmentPojo a = new LoanReportAssessmentPojo();
		a.setPageNum(1);
		a.setPageSize(3);
		List<LoanReportAssessmentPojo> list = loanReportAssessmentService.selectList(a);
		logger.info("记录总数：{}", a.getTotalRowCount());
		logger.info("{}", list);
		a.setPageNum(2);
		a.setPageSize(3);
		list = loanReportAssessmentService.selectList(a);
		logger.info("记录总数：" + a.getTotalRowCount());
		logger.info("{}", list);
	}

	/**
	 * 插入一条数据
	 */
	@Test
	public void insert() {
		// LoanReportAssessmentPojo a = new LoanReportAssessmentPojo();
		// a.setCreateTime(new Timestamp(System.currentTimeMillis()));
		// int count = loanReportAssessmentService.insert(a);
		// logger.info("count:" + count + ",id:" + a.getId());
	}

	/**
	 * 修改一条数据
	 */
	@Test
	public void update() {
		LoanReportAssessmentPojo a = new LoanReportAssessmentPojo();
		a.setId(1L);
// 		a.setModTime(new Timestamp(System.currentTimeMillis()));
		loanReportAssessmentService.update(a);
	}

	/**
	 * 批量插入数据
	 */
	@Test
	public void insertList() {
		List<LoanReportAssessmentPojo> list = new ArrayList<LoanReportAssessmentPojo>();
		for (int i = 1; i <= 10; i++) {
			LoanReportAssessmentPojo a = new LoanReportAssessmentPojo();
			list.add(a);
		}
// 		loanReportAssessmentService.insertList(list);
	}

	/**
	 * 批量修改数据
	 */
	@Test
	public void updateList() {
		List<LoanReportAssessmentPojo> list = new ArrayList<LoanReportAssessmentPojo>();
		for (int i = 5; i <= 10; i++) {
			LoanReportAssessmentPojo a = new LoanReportAssessmentPojo();
			a.setId(i + 0L);
			// a.setModTime(new Timestamp(System.currentTimeMillis()));
			list.add(a);
		}
		loanReportAssessmentService.updateList(list);
	}

	/**
	 * 批量删除数据
	 */
	@Test
	public void deleteList() {
		List<LoanReportAssessmentPojo> list = new ArrayList<LoanReportAssessmentPojo>();
		for (int i = 8; i <= 10; i++) {
			LoanReportAssessmentPojo a = new LoanReportAssessmentPojo();
			a.setId(i + 0L);
			list.add(a);
		}
// 		loanReportAssessmentService.deleteList(list);
	}
}
