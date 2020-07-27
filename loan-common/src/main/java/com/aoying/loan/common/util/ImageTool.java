package com.aoying.loan.common.util;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Random;
import javax.imageio.ImageIO;

/**
 * 
 * @功能:图片工具包
 * @项目名:kyloanServer
 * @作者:wangjz
 * @日期:2016年3月25日下午4:18:25
 */
public final class ImageTool {

	private static final char[] randChars = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D',
			'E', 'F', 'G', 'H', 'P', 'Q', 'M', 'N' };

	private static final char[] randNums = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

	/**
	 * 产生随机数字、字母字符串
	 * 
	 * @param size
	 * @return
	 */
	public static char[] getCharArray(int size) {
		char[] arr = new char[size];
		Random ran = new Random();
		for (int i = 0; i < size; i++) {
			arr[i] = randChars[ran.nextInt(randChars.length)];
		}
		return arr;
	}

	/**
	 * 产生随机数字字符串
	 * @param size
	 * @return
	 */
	public static char[] getNumArray(int size) {
		char[] arr = new char[size];
		Random ran = new Random();
		for (int i = 0; i < size; i++) {
			arr[i] = randNums[ran.nextInt(randNums.length)];
		}
		return arr;
	}

	/**
	 * 产生一张空白的图片验证码
	 * 
	 * @param charCount 字符数
	 * @return
	 */
	public static BufferedImage createBlankVerifImage(int charCount) {
		return createBlankVerifImage(20 * charCount, 40);
	}

	/**
	 * 产生一张空白的图片验证码
	 * 
	 * @param width 图片宽度
	 * @param height 图片高度
	 * @return
	 */
	public static BufferedImage createBlankVerifImage(int width, int height) {
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics graphic = image.getGraphics();
		graphic.setColor(new Color(231, 231, 231));// Color.LIGHT_GRAY
		graphic.fillRect(0, 0, width, height);
		return image;
	}

	/**
	 * 产生一张图片验证码
	 * 
	 * @param chars 字符
	 * @return
	 */
	public static BufferedImage createRandVerifImage(char[] chars) {
		return createRandVerifImage(chars, 20 * chars.length, 40, 5, 30);
	}

	/**
	 * 产生一张图片验证码
	 * 
	 * @param chars 字符
	 * @param width 图片宽度
	 * @param height 图片高度
	 * @param lineCount 干扰线数量
	 * @param fontSize 字体大小
	 * @return
	 */
	public static BufferedImage createRandVerifImage(char[] chars, int width, int height, int lineCount, int fontSize) {
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics graphic = image.getGraphics();
		graphic.setColor(new Color(231, 231, 231));// Color.LIGHT_GRAY
		graphic.fillRect(0, 0, width, height);
		Random ran = new Random();
		// 画随机字符
		for (int i = 0; i < chars.length; i++) {
			graphic.setColor(new Color(ran.nextInt(156), ran.nextInt(156), ran.nextInt(156)));
			graphic.setFont(new Font("宋体", Font.ITALIC, fontSize));
			graphic.drawString(chars[i] + "", (i * width - 10) / chars.length, (height - fontSize) / 2 + fontSize - 5);
		}
		// 画干扰线
		for (int i = 0; i < lineCount; i++) {
			graphic.setColor(new Color(ran.nextInt(156), ran.nextInt(156), ran.nextInt(156)));
			graphic.drawLine(ran.nextInt(width), ran.nextInt(height), ran.nextInt(width), ran.nextInt(height));
		}
		return image;
	}

	/**
	 * 改变图像大小
	 * @param srcImgStream 原图
	 * @param outImgStream 输出图
	 * @param width 输出图宽度
	 * @param height 输出图高度
	 * @return
	 * @throws IOException
	 */
	public static boolean changeSize(InputStream srcImgStream, OutputStream outImgStream, int width, int height)
			throws IOException {

		Image img = ImageIO.read(srcImgStream);
		BufferedImage buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		buffImg.getGraphics().drawImage(img.getScaledInstance(width, height, Image.SCALE_SMOOTH), 0, 0, null);
		ImageIO.write(buffImg, "JPEG", outImgStream);
		img.flush();
		return true;
	}

	/**
	 * 合并图像
	 * @param outImgStream 输出图
	 * @param bigImgStream 要合并的大图
	 * @param smallImgStream 要合并的小图
	 * @param x 小图的x坐标
	 * @param y 小图的y坐标
	 * @param width 合并后小图的宽度
	 * @param height 合并后小图的高度
	 * @throws IOException
	 */
	public static void mergeImage(OutputStream outImgStream, InputStream bigImgStream, InputStream smallImgStream,
			int x, int y, int width, int height) throws IOException {
		try {
			BufferedImage bigImg = ImageIO.read(bigImgStream);
			BufferedImage smallImg = ImageIO.read(smallImgStream);

			Graphics g = bigImg.getGraphics();
			g.drawImage(smallImg, x, y, width, height, null);

			ImageIO.write(bigImg, "JPEG", outImgStream);
			bigImg.flush();
		} finally {
			if (bigImgStream != null) {
				bigImgStream.close();
			}
			if (smallImgStream != null) {
				smallImgStream.close();
			}
			if (outImgStream != null) {
				outImgStream.close();
			}
		}
	}

	/**
	 * 产生电子签名图片
	 * @param str
	 * @return
	 * @throws Exception
	 */
	public static BufferedImage createSignImage(String str) throws Exception {
		Font font=new Font("华文行楷", Font.BOLD, 100);
		int can=font.canDisplayUpTo(str);
		if (can>=0){
			System.out.println("字符串【"+str+"】包含无法显示的文字，使用宋体");
			font=new Font("宋体", Font.BOLD, 100);
			can=font.canDisplayUpTo(str);
			if (can>=0) {
				System.out.println("使用宋体后字符串【" + str + "】任然无法正常显示");
			}
		}
		return createTextImage(str,font,Color.BLACK,str.length()*127,str.length()*127);
	}

	/**
	 * 生成无背景的文字图片
	 * @param str 文字
	 * @param font 文字字体
	 * @param color 文字颜色
	 * @param width 图片宽度
	 * @param height 图片高度
	 * @return
	 * @throws Exception
	 */
	public static BufferedImage createTextImage(String str, Font font,Color color,Integer width, Integer height) throws Exception {
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = image.createGraphics();
//		g.setColor(Color.WHITE);
//		g.fillRect(0, 0, width, height);

		/** 增加下面的代码使得背景透明*/
		image = g.getDeviceConfiguration().createCompatibleImage(width, height, Transparency.TRANSLUCENT);
		g.dispose();
		g = image.createGraphics();
		/** 背景透明代码结束*/
		g.setColor(color);
		g.setFont(font);
		/** 用于获得垂直居中y */
		g.setClip(0, 0, width, height);
		Rectangle clip = g.getClipBounds();
		FontMetrics fm = g.getFontMetrics(font);
		int ascent = fm.getAscent();
		int descent = fm.getDescent();
		int y = (clip.height - (ascent + descent)) / 2 + ascent;
		/** 用于获得水平居中x */
		int textWidth=fm.stringWidth(str);
		int x = (clip.width - textWidth )/ 2;
		g.drawString(str, x, y);// 画出字符串
		g.dispose();
		return image;
	}

	public static void main(String[] args) throws Exception {
//		InputStream bigImgStream=new FileInputStream(new File("c:\\max.png"));
//		InputStream smallImgStream=new FileInputStream(new File("c:\\2.jpg"));
//		OutputStream outImgStream=new FileOutputStream(new File("c:\\out.jpg"));
//		mergeImage(outImgStream, bigImgStream, smallImgStream, 533, 793,  147,  70);

		ImageIO.write(createSignImage("黄庆喜"), "png", new File("D:\\a.png"));// 输出png图片
	}
}
