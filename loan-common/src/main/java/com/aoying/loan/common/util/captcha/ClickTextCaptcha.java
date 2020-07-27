/**
 * 
 */
package com.aoying.loan.common.util.captcha;

import java.awt.*;
import java.util.List;
import com.aoying.loan.common.base.pojo.BasePojo;

/**
 * @功能:点选验证码图片坐标
 * @项目名:kyloanServer
 * @作者:jiawei.bao
 * @日期: 2017年10月20日下午1:59:59
 */
public class ClickTextCaptcha extends BasePojo implements Cloneable {
	/***/
	private static final long serialVersionUID = -5276048962542657928L;

	/** 存放随机文字 */
	private String[] words;
	/** 长方形集合 */
	private List<Rectangle> rectangles;
	/** 生成后的图片(base64) */
	private String imgBase64;

	/**
	 * @取得 存放随机文字
	 */
	public String[] getWords() {
		return words;
	}

	/**
	 * @设置 存放随机文字
	 */
	public void setWords(String[] words) {
		this.words = words;
	}

	/**
	 * @取得 长方形集合
	 */
	public List<Rectangle> getRectangles() {
		return rectangles;
	}

	/**
	 * @设置 长方形集合
	 */
	public void setRectangles(List<Rectangle> rectangles) {
		this.rectangles = rectangles;
	}

	/**
	 * @取得 生成后的图片(base64)
	 */
	public String getImgBase64() {
		return imgBase64;
	}

	/**
	 * @设置 生成后的图片(base64)
	 */
	public void setImgBase64(String imgBase64) {
		this.imgBase64 = imgBase64;
	}

}
