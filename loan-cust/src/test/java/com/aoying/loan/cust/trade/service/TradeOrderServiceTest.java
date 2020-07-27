package com.aoying.loan.cust.trade.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.aoying.loan.common.base.test.BaseTest;
import com.aoying.loan.cust.trade.pojo.TradeOrderPojo;
import com.aoying.loan.cust.trade.service.iservice.ITradeOrderService;
import com.github.wxpay.sdk.WXPay;

/**
 * 交易订单 Test
 * @author nick
 */
public class TradeOrderServiceTest extends BaseTest{
	@Autowired
	private WXPay wxPayApi;
	@Autowired
	private ITradeOrderService tradeOrderService;
	
	/** 模拟HttpServletReqeust*/
	//private static MockHttpServletRequest request = new MockHttpServletRequest();

	@Test
	public void checkSign() throws Exception {
		String wholeStr = "<xml><appid><![CDATA[wx28ddc709cc7e97b7]]></appid><bank_type><![CDATA[CFT]]></bank_type><cash_fee><![CDATA[1]]></cash_fee><fee_type><![CDATA[CNY]]></fee_type><is_subscribe><![CDATA[Y]]></is_subscribe><mch_id><![CDATA[1522729781]]></mch_id><nonce_str><![CDATA[aR4OqI3xd8SA5LTWmW7FnV2ajiIvJoks]]></nonce_str><openid><![CDATA[o3d6X046ClrStIL_DE1JjhfLeNKo]]></openid><out_trade_no><![CDATA[32c0fd738e1c493680cc14786d7eca3a]]></out_trade_no><result_code><![CDATA[SUCCESS]]></result_code><return_code><![CDATA[SUCCESS]]></return_code><sign><![CDATA[4E31C24E2E1EF4BA0BD1E57972ED995C51197E221AAD514F8EB561984820EA15]]></sign><time_end><![CDATA[20190510171951]]></time_end><total_fee>1</total_fee><trade_type><![CDATA[JSAPI]]></trade_type><transaction_id><![CDATA[4200000289201905107914586433]]></transaction_id></xml>";
		Map<String, String> map = wxPayApi.processResponseXml(wholeStr);
		System.out.println(map);
		System.out.println(wxPayApi.fillRequestDataForSign(map));
	}

	/**
	 * 根据主键或唯一键查找数据
	 */
	@Test
	public void selectUnique() {
		TradeOrderPojo a = new TradeOrderPojo();
		a.setId(1L);
		a = tradeOrderService.selectUnique(a);
		logger.info("{}", a);
	}

	/**
	 * 根据条件查询记录
	 */
	@Test
	public void selectList() {
		TradeOrderPojo a = new TradeOrderPojo();
		a.setPageNum(1);
		a.setPageSize(3);
		List<TradeOrderPojo> list = tradeOrderService.selectList(a);
		logger.info("记录总数：{}", a.getTotalRowCount());
		logger.info("{}", list);
		a.setPageNum(2);
		a.setPageSize(3);
		list = tradeOrderService.selectList(a);
		logger.info("记录总数：" + a.getTotalRowCount());
		logger.info("{}", list);
	}

	/**
	 * 插入一条数据
	 */
	@Test
	public void insert() {
		// TradeOrderPojo a = new TradeOrderPojo();
		// a.setCreateTime(new Timestamp(System.currentTimeMillis()));
		// int count = tradeOrderService.insert(a);
		// logger.info("count:" + count + ",id:" + a.getId());
	}

	/**
	 * 修改一条数据
	 */
	@Test
	public void update() {
		TradeOrderPojo a = new TradeOrderPojo();
		a.setId(1L);
// 		a.setModTime(new Timestamp(System.currentTimeMillis()));
		tradeOrderService.update(a);
	}

	/**
	 * 批量插入数据
	 */
	@Test
	public void insertList() {
		List<TradeOrderPojo> list = new ArrayList<TradeOrderPojo>();
		for (int i = 1; i <= 10; i++) {
			TradeOrderPojo a = new TradeOrderPojo();
			list.add(a);
		}
// 		tradeOrderService.insertList(list);
	}

	/**
	 * 批量修改数据
	 */
	@Test
	public void updateList() {
		List<TradeOrderPojo> list = new ArrayList<TradeOrderPojo>();
		for (int i = 5; i <= 10; i++) {
			TradeOrderPojo a = new TradeOrderPojo();
			a.setId(i + 0L);
			// a.setModTime(new Timestamp(System.currentTimeMillis()));
			list.add(a);
		}
		tradeOrderService.updateList(list);
	}

	/**
	 * 批量删除数据
	 */
	@Test
	public void deleteList() {
		List<TradeOrderPojo> list = new ArrayList<TradeOrderPojo>();
		for (int i = 8; i <= 10; i++) {
			TradeOrderPojo a = new TradeOrderPojo();
			a.setId(i + 0L);
			list.add(a);
		}
// 		tradeOrderService.deleteList(list);
	}
}
