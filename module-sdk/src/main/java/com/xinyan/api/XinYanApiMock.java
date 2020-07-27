package com.xinyan.api;

import java.io.IOException;

/**
 * 新颜接口 模拟
 * @author nick
 */
public class XinYanApiMock extends XinYanApi {
    public XinYanApiMock(XinYanConfig xinYanConfig) {
        super(xinYanConfig);
    }

    @Override
    public XinYanRes creditRating(String transId, String tradeDate, String idNo, String idName) throws IOException {
        logger.info("[新颜] 模拟请求 {} {} {} {}", transId, tradeDate, idNo, idName);
        XinYanRes res = new XinYanRes();
        res.setSuccess(true);
        res.setData("{\"code\":\"0\",\"id_no\":\"f31d8cd60d75145253026edace7b4b3d\",\"versions\":\"1.3.0\",\"fee\":\"Y\",\"trade_no\":\"20190307151019220000006365578299\",\"trans_id\":\"f8677e22e29e443dbf286c3f85f75f68\",\"id_name\":\"a6e8e6c9eb71d3904b1c5298032ed3db\",\"result_detail\":{\"apply_report_detail\":{\"latest_query_time\":\"2018-06-27\",\"query_sum_count\":\"1\",\"apply_credibility\":\"50\",\"query_org_count\":\"1\",\"latest_six_month\":\"0\",\"query_cash_count\":\"0\",\"apply_score\":\"482\",\"latest_three_month\":\"0\",\"query_finance_count\":\"0\",\"latest_one_month\":\"0\"}},\"desc\":\"查询成功\"}");
        return res;
    }
}
