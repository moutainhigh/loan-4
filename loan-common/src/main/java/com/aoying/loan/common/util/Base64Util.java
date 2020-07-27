package com.aoying.loan.common.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.imageio.ImageIO;
import org.apache.commons.io.IOUtils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * Created by banhe@zealfi.com on 2016/11/21.
 */
@SuppressWarnings("restriction")
public class Base64Util {
	public static Map<String, Object> base64StringToImg(String base64String) throws IOException {
		ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<>();
		BASE64Decoder decoder = new BASE64Decoder();
		// Base64解码
		byte[] b = decoder.decodeBuffer(base64String);
		for (int i = 0; i < b.length; ++i) {
			if (b[i] < 0) {// 调整异常数据
				b[i] += 256;
			}
		}
		map.put("fileLength", b.length);
		map.put("inputStream", new ByteArrayInputStream(b));
		return map;
	}

	public static String imgToBase64String(InputStream is) {
		byte[] data = null;
		// 对字节数组Base64编码
		BASE64Encoder code = new BASE64Encoder();
		try {
			data = IOUtils.toByteArray(is);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		return code.encode(data);
	}

	/**
	 * 将BufferedImage格式转成Base64String
	 * @param bufferedImage
	 * @return
	 */
	public static String bufferedImageToBase64String(BufferedImage bufferedImage) {
		try {
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			ImageIO.write(bufferedImage, "jpg", outputStream);
			InputStream is = new ByteArrayInputStream(outputStream.toByteArray());
			return Base64Util.imgToBase64String(is);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
