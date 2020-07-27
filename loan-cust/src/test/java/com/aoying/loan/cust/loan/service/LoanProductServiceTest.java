package com.aoying.loan.cust.loan.service;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.aoying.loan.common.base.test.BaseTest;
import com.aoying.loan.cust.loan.pojo.LoanProductPojo;
import com.aoying.loan.cust.loan.service.iservice.ILoanProductService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoanProductServiceTest extends BaseTest {
	@Autowired
	private ILoanProductService loanProductService;
	
	@Test
	public void selectList() {
		LoanProductPojo product = new LoanProductPojo();
		List<LoanProductPojo> list = loanProductService.selectList(product);
		logger.info("{}", list);
	}

	@Test
	public void updateApplyNum() {
		loanProductService.updateApplyNum();
	}
}
