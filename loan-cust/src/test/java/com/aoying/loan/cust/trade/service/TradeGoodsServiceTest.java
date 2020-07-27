package com.aoying.loan.cust.trade.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.aoying.loan.common.base.test.BaseTest;
import com.aoying.loan.cust.trade.pojo.TradeGoodsPojo;
import com.aoying.loan.cust.trade.service.iservice.ITradeGoodsService;

/**
 * 交易商品 Test
 * @author nick
 */
public class TradeGoodsServiceTest extends BaseTest{
	@Autowired
	private ITradeGoodsService tradeGoodsService;
	
	/** 模拟HttpServletReqeust*/
	//private static MockHttpServletRequest request = new MockHttpServletRequest();

	/**
	 * 根据主键或唯一键查找数据
	 */
	@Test
	public void selectUnique() {
		TradeGoodsPojo a = new TradeGoodsPojo();
		a.setId(1L);
		a = tradeGoodsService.selectUnique(a);
		logger.info("{}", a);
	}

	/**
	 * 根据条件查询记录
	 */
	@Test
	public void selectList() {
		TradeGoodsPojo a = new TradeGoodsPojo();
		a.setPageNum(1);
		a.setPageSize(3);
		List<TradeGoodsPojo> list = tradeGoodsService.selectList(a);
		logger.info("记录总数：{}", a.getTotalRowCount());
		logger.info("{}", list);
		a.setPageNum(2);
		a.setPageSize(3);
		list = tradeGoodsService.selectList(a);
		logger.info("记录总数：" + a.getTotalRowCount());
		logger.info("{}", list);
	}

	/**
	 * 插入一条数据
	 */
	@Test
	public void insert() {
		// TradeGoodsPojo a = new TradeGoodsPojo();
		// a.setCreateTime(new Timestamp(System.currentTimeMillis()));
		// int count = tradeGoodsService.insert(a);
		// logger.info("count:" + count + ",id:" + a.getId());
	}

	/**
	 * 修改一条数据
	 */
	@Test
	public void update() {
		TradeGoodsPojo a = new TradeGoodsPojo();
		a.setId(1L);
// 		a.setModTime(new Timestamp(System.currentTimeMillis()));
		tradeGoodsService.update(a);
	}

	/**
	 * 批量插入数据
	 */
	@Test
	public void insertList() {
		List<TradeGoodsPojo> list = new ArrayList<TradeGoodsPojo>();
		for (int i = 1; i <= 10; i++) {
			TradeGoodsPojo a = new TradeGoodsPojo();
			list.add(a);
		}
// 		tradeGoodsService.insertList(list);
	}

	/**
	 * 批量修改数据
	 */
	@Test
	public void updateList() {
		List<TradeGoodsPojo> list = new ArrayList<TradeGoodsPojo>();
		for (int i = 5; i <= 10; i++) {
			TradeGoodsPojo a = new TradeGoodsPojo();
			a.setId(i + 0L);
			// a.setModTime(new Timestamp(System.currentTimeMillis()));
			list.add(a);
		}
		tradeGoodsService.updateList(list);
	}

	/**
	 * 批量删除数据
	 */
	@Test
	public void deleteList() {
		List<TradeGoodsPojo> list = new ArrayList<TradeGoodsPojo>();
		for (int i = 8; i <= 10; i++) {
			TradeGoodsPojo a = new TradeGoodsPojo();
			a.setId(i + 0L);
			list.add(a);
		}
// 		tradeGoodsService.deleteList(list);
	}
}
