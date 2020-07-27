package com.aoying.loan.cust.thirdparty.api;

import java.io.IOException;
import java.util.Map;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.aoying.loan.common.base.test.BaseTest;
import com.aoying.loan.cust.api.ThirdPartyApiDs;
import com.ds.api.DsApi;
import com.ds.api.DsRes;

/**
 * @author nick
 */
public class DsApiTest extends BaseTest {
    @Autowired
    private DsApi dsApi;
    @Autowired
    private ThirdPartyApiDs thirdPartyApiDs;

    private String idNo = "420103198905085715";
    private String idName = "李曾天";
    private String phone = "18621599019";

    @Test
    public void testIdCard() throws IOException {
        Map<String, Object> result = thirdPartyApiDs.authIdCard(idNo, idName);
        logger.info("authIdCard >>>> {}", result);
    }

    @Test
    public void testOperators() throws IOException {
        Map<String, Object> result = thirdPartyApiDs.operators(idNo, idName, phone);
        logger.info("operators >>>> {}", result);
    }

    @Test
    public void testReport() throws IOException {
        Map<String, Object> result = thirdPartyApiDs.report(idNo, idName, phone);
        logger.info("report >>>> {}", result);
    }

    @Test
    public void testIdCardAuth() throws IOException {
        DsRes result = dsApi.idCardAuth(idNo, idName);
        logger.info("idCardAuth >>>> {}", result);
    }

    @Test
    public void testKeyPerson() throws IOException {
        DsRes result = dsApi.keyPerson(idNo, idName);
        logger.info("keyPerson >>>> {}", result);
    }

    @Test
    public void testOperatorsAuth() throws IOException {
        DsRes result = dsApi.operatorsAuth(idNo, idName, phone);
        logger.info("operatorsAuth >>>> {}", result);
    }

    @Test
    public void testOperatorsLength() throws IOException {
        DsRes result = dsApi.operatorsLength(phone);
        logger.info("operatorsLength >>>> {}", result);
    }

    @Test
    public void testOperatorsStatus() throws IOException {
        DsRes result = dsApi.operatorsStatus(phone);
        logger.info("operatorsStatus >>>> {}", result);
    }

    @Test
    public void testBin10() throws IOException {
        DsRes result = dsApi.bin10(idNo, idName, phone);
        logger.info("bin10 >>>> {}", result);
    }
}
