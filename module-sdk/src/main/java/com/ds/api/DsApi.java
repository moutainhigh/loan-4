package com.ds.api;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.alibaba.fastjson.JSON;
import com.ds.api.util.AesUtils;
import com.ds.api.util.HttpRequestUtils;
import com.ds.api.util.JacksonUtils;

/**
 * @author nick
 */
public class DsApi {
    /** 日志对象 */
    protected static final Logger logger = LoggerFactory.getLogger(DsApi.class);

    private DsConfig dsConfig;

    public DsApi() {
    }

    public DsApi(DsConfig dsConfig) {
        this.dsConfig = dsConfig;
    }

    public DsRes idCardAuth(String idNo, String idName) throws IOException {
        Map<String, Object> predata = new HashMap<>();
        predata.put("idName", idName);
        predata.put("idCard", idNo);

        predata.put("productCode", "110101");
        predata.put("subChannelName", dsConfig.getSubChannelName());
        predata.put("transId", String.valueOf(System.currentTimeMillis()));
        predata.put("memberId", dsConfig.getMemberId());

        return request(predata);
    }

    public DsRes keyPerson(String idNo, String idName) throws IOException {
        Map<String, Object> predata = new HashMap<>();
        predata.put("idName", idName);
        predata.put("idCard", idNo);

        predata.put("productCode", "1410");
        predata.put("subChannelName", dsConfig.getSubChannelName());
        predata.put("transId", String.valueOf(System.currentTimeMillis()));
        predata.put("memberId", dsConfig.getMemberId());

        return request(predata);
    }

    public DsRes operatorsAuth(String idNo, String idName, String phone) throws IOException {
        Map<String, Object> predata = new HashMap<>();
        predata.put("idName", idName);
        predata.put("idCard", idNo);
        predata.put("phone", phone);

        predata.put("productCode", "1207");
        predata.put("transId", String.valueOf(System.currentTimeMillis()));
        predata.put("memberId", dsConfig.getMemberId());

        return request(predata);
    }

    public DsRes operatorsLength(String phone) throws IOException {
        Map<String, Object> predata = new HashMap<>();
        predata.put("phone", phone);

        predata.put("productCode", "1202");
        predata.put("transId", String.valueOf(System.currentTimeMillis()));
        predata.put("memberId", dsConfig.getMemberId());

        return request(predata);
    }

    public DsRes operatorsStatus(String phone) throws IOException {
        Map<String, Object> predata = new HashMap<>();
        predata.put("phone", phone);

        predata.put("productCode", "1203");
        predata.put("transId", String.valueOf(System.currentTimeMillis()));
        predata.put("memberId", dsConfig.getMemberId());

        return request(predata);
    }

    public DsRes bin10(String idNo, String idName, String phone) throws IOException {
        Map<String, Object> predata = new HashMap<>();
        predata.put("idName", idName);
        predata.put("idCard", idNo);
        predata.put("phone", phone);

        predata.put("productCode", "3001");
        predata.put("transId", String.valueOf(System.currentTimeMillis()));
        predata.put("memberId", dsConfig.getMemberId());

        return request(predata);
    }

    private DsRes request(Map<String, Object> predata) throws IOException {
        String msgData = JacksonUtils.serialObject(predata);
        logger.info("[行列秩]参数:{}", msgData);

        byte[] data = AesUtils.encrypt(msgData.getBytes(), dsConfig.getKey().getBytes(), "ds");
        byte[] b64 = Base64.encodeBase64(data);
        char[] hex = Hex.encodeHex(b64);
        logger.debug("[行列秩]加密:{}", new String(hex));

//        byte[] hex2 = Hex.decodeHex(hex);
//        byte[] b64_2 = Base64.decodeBase64(hex2);
//        byte[] data2 = AesUtils.dencrypt(b64_2, dsConfig.getKey().getBytes(), "ds");
//        logger.debug("[行列秩]解密:{}", new String(data2));

        String signData = new String(hex);

        String postJson = "{\"memberId\":\"" + dsConfig.getMemberId() + "\",\"signData\":\"" + signData + "\"}";
        Long start=System.currentTimeMillis();
        String postResult = HttpRequestUtils.sendPostJson(dsConfig.getUrl(), postJson);
        Long end=System.currentTimeMillis();
        logger.info("[行列秩]调用耗时:{} {}", (end-start), postResult);

        DsRes res = JSON.parseObject(postResult, DsRes.class);
        res.setResJson(postResult);
        if (!DsRes.ECode.SUCC.getVal().equals(res.getCode())) {
            throw new RuntimeException("行列秩接口调用失败");
        }

        return res;
    }
}
