package com.xinyan.api;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.alibaba.fastjson.JSON;
import com.xinyan.api.rsa.RsaCodingUtil;
import com.xinyan.api.util.HttpUtils;
import com.xinyan.api.util.MD5Utils;
import com.xinyan.api.util.SecurityUtil;

/**
 * 新颜接口
 * @author nick
 */
public class XinYanApi {
	/** 日志对象 */
	protected static final Logger logger = LoggerFactory.getLogger(XinYanApi.class);

	private XinYanConfig xinYanConfig;

	public XinYanApi() {
	}

	public XinYanApi(XinYanConfig xinYanConfig) {
		this.xinYanConfig = xinYanConfig;
	}

	/**
	 * 运营商三要素认证和时长状态
	 * @param transId
	 * @param tradeDate
	 * @param idNo
	 * @param idName
	 * @param mobile
	 * @return
	 * @throws IOException
	 */
	public XinYanRes<XinYanResOperatorsAuth> operatorsAuth(String transId, String tradeDate, String idNo, String idName, String mobile) throws IOException {
		String url = "https://" + xinYanConfig.getDomain() + XinYanConstants.URL_OPERATORS_AUTH;

		// 业务参数
		Map<String, String> reqData = new HashMap<String, String>();
		reqData.put("trans_id", transId);
		reqData.put("trade_date", tradeDate);
		reqData.put("id_card", idNo.trim());
		reqData.put("name", idName.trim());
		reqData.put("mobile", mobile.trim());
		reqData.put("type", "ST_ON");
		String dataContent = this.encode(reqData);

		XinYanRes<XinYanResOperatorsAuth> resObj = this.doPost(url, dataContent);

		XinYanResOperatorsAuth dataObj = JSON.parseObject(resObj.getData(), XinYanResOperatorsAuth.class);
		resObj.setDataObj(dataObj);
		return resObj;
	}

	/**
	 * 实名认证
	 * @param transId
	 * @param tradeDate
	 * @param idNo
	 * @param idName
	 * @param isPhoto
	 * @throws IOException
	 */
	public XinYanRes<XinYanResIdCardAuth> idCardAuth(String transId, String tradeDate, String idNo, String idName, boolean isPhoto) throws IOException {
		String url = "https://" + xinYanConfig.getDomain() + XinYanConstants.URL_ID_CARD_AUTH;

		// 业务参数
		Map<String, String> reqData = new HashMap<String, String>();
		reqData.put("trans_id", transId);
		reqData.put("trade_date", tradeDate);
		reqData.put("id_card", idNo.trim());
		reqData.put("id_holder", idName.trim());
		reqData.put("is_photo", isPhoto?"photo":"noPhoto");
		String dataContent = this.encode(reqData);

		XinYanRes<XinYanResIdCardAuth> resObj = this.doPost(url, dataContent);

		XinYanResIdCardAuth dataObj = JSON.parseObject(resObj.getData(), XinYanResIdCardAuth.class);
		resObj.setDataObj(dataObj);
		return resObj;
	}

	/**
	 * 全景雷达
	 * @param transId
	 * @param tradeDate
	 * @param idNo
	 * @param idName
	 * @throws IOException
	 */
	public XinYanRes creditRating(String transId, String tradeDate, String idNo, String idName) throws IOException {
		String url = "https://" + xinYanConfig.getDomain() + XinYanConstants.URL_ZX_RADAR;

		// 业务参数
		Map<String, String> reqData = new HashMap<String, String>();
		reqData.put("trans_id", transId);
		reqData.put("trade_date", tradeDate);
		reqData.put("id_no", MD5Utils.encryptMD5(idNo.trim()));
		reqData.put("id_name", MD5Utils.encryptMD5(idName.trim()));
		reqData.put("phone_no", null);
		reqData.put("bankcard_no", null);
		String dataContent = this.encode(reqData);

		return this.doPost(url, dataContent);
	}

	/**
	 * 加密数据
	 * @param reqData
	 * @return
	 * @throws UnsupportedEncodingException
	 * @throws FileNotFoundException
	 */
	private String encode(Map<String, String> reqData) throws UnsupportedEncodingException, FileNotFoundException {
		reqData.put("member_id", xinYanConfig.getMemberId());
		reqData.put("terminal_id", xinYanConfig.getTerminalId());
		reqData.put("industry_type", "B25");// 参照文档传自己公司对应的行业参数
		reqData.put("versions", "1.3.0");

		String xmlOrJson = JSON.toJSONString(reqData);
		logger.info("[新颜] 业务参数明文:{}", xmlOrJson);

		// base64编码
		String base64str = SecurityUtil.Base64Encode(xmlOrJson);
		base64str=base64str.replaceAll("\r\n", "");//重要 避免出现换行空格符
		logger.info("[新颜] 业务参数base64:{}", base64str);

		// rsa加密
		String pfxPath = xinYanConfig.getPfxPath();
		File pfxfile = new File(pfxPath);
		if (!pfxfile.exists()) {
			logger.error("私钥文件不存在！");
			throw new RuntimeException("私钥文件不存在！");
		}
		String pfxpwd = xinYanConfig.getPfxPwd();// 私钥密码
		String dataContent = RsaCodingUtil.encryptByPriPfxFile(base64str, new FileInputStream(pfxfile), pfxpwd);
		logger.info("[新颜] 业务参数rsa加密:{}", dataContent);
		return dataContent;
	}

	/**
	 * 发送请求
	 * @param url
	 * @param dataContent
	 * @return
	 */
	private XinYanRes doPost(String url, String dataContent) {
		// 请求URL
		logger.info("[新颜] 请求URL:{}", url);

		// 请求头
		Map<String, String> headers = new HashMap<>();

		// 请求参数
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("member_id", xinYanConfig.getMemberId());
		params.put("terminal_id", xinYanConfig.getTerminalId());
		params.put("data_type", "json");
		params.put("data_content", dataContent);

		String resStr = HttpUtils.doPostByForm(url, headers, params);
		logger.info("[新颜] 请求返回:{}", resStr);

		if (resStr.isEmpty()) {
			logger.error("返回数据为空");
			throw new RuntimeException("返回数据为空");
		}

		XinYanRes resObj = JSON.parseObject(resStr, XinYanRes.class);
		resObj.setResJson(resStr);
		return resObj;
	}
}
