/**
 * 
 */
package com.aoying.loan.common.util.captcha;

import com.aoying.loan.common.base.pojo.BasePojo;

/**
 * @功能:点选验证码图片坐标
 * @项目名:kyloanServer
 * @作者:jiawei.bao
 * @日期: 2017年10月20日下午1:59:59
 */
public class ClickPoint extends BasePojo implements Cloneable {
	/***/
	private static final long serialVersionUID = -5276048962542657928L;

	/** x坐标 */
	private int x;
	/** y坐标 */
	private int y;

	/**
	 * @取得 x坐标
	 */
	public int getX() {
		return x;
	}

	/**
	 * @设置 x坐标
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @取得 y坐标
	 */
	public int getY() {
		return y;
	}

	/**
	 * @设置 y坐标
	 */
	public void setY(int y) {
		this.y = y;
	}

}
