package com.aoying.loan.cust.thirdparty.api;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.UUID;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.aoying.loan.common.base.test.BaseTest;
import com.xinyan.api.XinYanApi;
import com.xinyan.api.XinYanRes;

/**
 * @author nick
 */
public class XinYanApiTest extends BaseTest {
    @Autowired
    private XinYanApi xinYanApi;

    private String transId = UUID.randomUUID().toString().replace("-", "");
    private String tradeDate = new SimpleDateFormat("yyyyMMddHHmmss").format(System.currentTimeMillis());

    private String idNo = "420103198905085715";
    private String idName = "李曾天";
    private String mobile = "18621599019";

    @Test
    public void testXinYanOperatorsAuth() throws IOException {
        XinYanRes result = xinYanApi.operatorsAuth(transId, tradeDate, idNo, idName, mobile);
        logger.info("运营商>>>> {}", result);
    }

    @Test
    public void idCardAuth() throws IOException {
        XinYanRes result = xinYanApi.idCardAuth(transId, tradeDate, idNo, idName, false);
        logger.info("实名认证>>>> {}", result);
    }

    @Test
    public void test() throws IOException {
        XinYanRes result = xinYanApi.creditRating(transId, tradeDate, idNo, idName);
        logger.info("全景雷达>>>> {}", result);
    }
}
