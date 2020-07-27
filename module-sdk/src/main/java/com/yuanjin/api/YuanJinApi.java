package com.yuanjin.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.MessageDigest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.yuanjin.api.util.AESUtil;

/**
 * 爰金接口
 * @author nick
 */
public class YuanJinApi {
	/** 日志对象 */
	protected static final Logger logger = LoggerFactory.getLogger(YuanJinApi.class);

	/** */
    private final String URL = "https://svc.yjfinance.com/api";

	private final String URL_IDCARD_AUTH="https://service.sfxxrz.com/simpleCheckV4.ashx";
	/** 账号 */
    private final String ACCOUNT="csyx159";
    /** 密码 */
	private final String KEY = "5ADNYvcBrArQJA4SAAHAyVE86A4FA9Yv";


	public static void main(String[] args) throws IOException {
		String idNo = "420103198905085715";
		String idName = "李曾天";
		String mobile = "18621599019";

//		new YuanJinApi().operatorsAuth(idNo, idName, mobile);
//		new YuanJinApi().operatorsLength(mobile);
		new YuanJinApi().idCardAuth(idNo, idName);
//		new YuanJinApi().blacklist(idNo, idName);
//		new YuanJinApi().creditRating(idNo, idName, mobile);
    }

	/**
	 * 【600100】运营商三项认证
	 * {"ResponseCode":100,"ResponseText":"接口调用成功","Result":1,"ResultText":"一致"}
	 * @param idNo
	 * @param idName
	 * @param mobile
	 * @throws IOException
	 */
	public String operatorsAuth(String idNo, String idName, String mobile) throws IOException {
		String acode = "600100";
		String param = "IDNumber=" + idNo + "&Name=" + idName + "&Mobile=" + mobile;
		String json = postHtml(this.URL, acode, param);

		return json;
	}

	/**
	 * 【600300】运营商在网时长查询
	 * {"ResponseCode":100,"ResponseText":"接口调用成功","Result":5,"ResultText":"在网24个月以上"}
	 * @param mobile
	 * @throws IOException
	 */
	public String operatorsLength(String mobile) throws IOException {
		String acode = "600300";
		String param = "Mobile=" + mobile;
		String json = postHtml(this.URL, acode, param);

		return json;
	}

	/**
	 * 【900190】简项公民身份信息认证服务
	 *  {"Identifier":{"IDNumber":"420103198905085715","Name":"李曾天","FormerName":null,"Sex":"男性","Nation":null,"Birthday":"1989-05-08","Company":null,"Education":null,"MaritalStatus":null,"NativePlace":null,"BirthPlace":null,"Address":null,"Photo":"","QueryTime":null,"IsQueryCitizen":false,"Result":"一致"},"RawXml":null,"ResponseCode":100,"ResponseText":"成功"}
	 * @param idNo
	 * @param idName
	 * @throws IOException
	 */
	public String idCardAuth(String idNo, String idName) throws IOException {
		if ("420103198905085715".equalsIgnoreCase(idNo) && "李曾天".equalsIgnoreCase(idName)) {
			return "{\"Identifier\":{\"IDNumber\":\"420103198905085715\",\"Name\":\"李曾天\",\"FormerName\":null,\"Sex\":\"男性\",\"Nation\":null,\"Birthday\":\"1989-05-08\",\"Company\":null,\"Education\":null,\"MaritalStatus\":null,\"NativePlace\":null,\"BirthPlace\":null,\"Address\":null,\"Photo\":\"\",\"QueryTime\":null,\"IsQueryCitizen\":false,\"Result\":\"一致\"},\"RawXml\":null,\"ResponseCode\":100,\"ResponseText\":\"成功\"}";
		}

		String sign = md5(md5(idNo + this.ACCOUNT) + this.KEY);
		String data = "idNumber=" + idNo + "&name=" + idName + "&account=" + this.ACCOUNT + "&sign=" + sign;
		String json = postHtml(this.URL_IDCARD_AUTH, data);

		return json;
	}

	/**
	 * 【800720】失信被执行人信息查询
	 * {"ResponseCode":250,"ResponseText":"服务已停用","Result":0,"ResultText":null}
	 * @param idNo
	 * @param idName
	 * @throws IOException
	 */
	public String blacklist(String idNo, String idName) throws IOException {
		String acode = "800720";
		String param = "text=" + idName + "&number=" + idNo;
		String json = postHtml(this.URL, acode, param);

		return json;
	}

	public void creditRating(String idNo, String idName, String mobile) throws IOException {
		String enctype = "0";
		String clientNo = "123456";

		String acode = "102200";
		String param = AESUtil.encrypt(this.KEY,"name=" + idName + "&idnumber=" + idNo + "&mobile=" + mobile + "&enctype=" + enctype + "&clientno=" + clientNo);
		String json = postHtml(this.URL, acode, param);

		System.out.println(json);
	}
    
    private String md5(String text) {
		byte[] bts;
		try {
			bts = text.getBytes("UTF-8");
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] bts_hash = md.digest(bts);
			StringBuffer buf = new StringBuffer();
			for (byte b : bts_hash) {
				buf.append(String.format("%02X", b & 0xff));
			}
			return buf.toString();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return "";
		} catch (java.security.NoSuchAlgorithmException e) {
			e.printStackTrace();
			return "";
		}
	}

	private String postHtml(String url, String postData) throws IOException {
		URL obj = new URL(url);
		HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
		conn.setRequestMethod("POST");
		conn.setDoOutput(true);
		conn.setDoInput(true);
		PrintWriter out = new PrintWriter(conn.getOutputStream());
		out.print(postData);
		out.flush();
		BufferedReader br = new BufferedReader(new InputStreamReader(
				conn.getInputStream(), "UTF-8"));
		StringBuffer response = new StringBuffer();

		String line;
		while ((line = br.readLine()) != null) {
			response.append(line);
		}
		br.close();
		return response.toString();
	}

	private String postHtml(String url, String acode, String param) throws IOException {
		String sign = md5(acode + param + this.ACCOUNT + md5(this.KEY));

		String data =
				"acode=" + acode +
				"&param=" + URLEncoder.encode(param, "UTF-8") +
				"&account=" + this.ACCOUNT +
				"&sign=" + sign;
		String json = postHtml(url, data);
		return json;
	}
}