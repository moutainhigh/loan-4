package com.aoying.loan.cust.api;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ds.api.DsApi;
import com.ds.api.DsRes;

/**
 * @author nick
 */
@Component
public class ThirdPartyApiDs {
    @Autowired
    private DsApi dsApi;

    public Map<String, Object> authIdCard(String idNo, String idName) throws IOException {
        Map<String, Object> result = new HashMap<String, Object>();

        DsRes res = dsApi.idCardAuth(idNo, idName);
        result.put("auth", "0".equals(res.getData().getRespCode()));
        result.put("json", res.getResJson());

        return result;
    }

    public Map<String, Object> operators(String idNo, String idName, String phone) throws IOException {
        Map<String, Object> result = new HashMap<String, Object>();

        DsRes resA = dsApi.operatorsAuth(idNo, idName, phone);
        result.put("auth", resA.getData().getRespCode());

        DsRes resL = dsApi.operatorsLength(phone);
        result.put("length", resL.getData().getOnlineTime());

        DsRes resS = dsApi.operatorsStatus(phone);
        result.put("status", resS.getData().getOnlineStatus());

        result.put("json", resA.getResJson() + resL.getResJson() + resS.getResJson());
        return result;
    }

    public Map<String, Object> report(String idNo, String idName, String phone) throws IOException {
        Map<String, Object> result = new HashMap<String, Object>();

        DsRes resKP = dsApi.keyPerson(idNo, idName);
        result.put("score", resKP.getData().getDetail().getScore());

        DsRes resB = dsApi.bin10(idNo, idName, phone);
        result.put("boolScore", resB.getData().getDetail().getBoolScore());

        result.put("json", resKP.getResJson() + resB.getResJson());
        return result;
    }
}
