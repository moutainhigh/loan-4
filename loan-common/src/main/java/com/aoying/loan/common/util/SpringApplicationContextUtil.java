/**   
* @Title: SpringContextUtil.java 
* @Package com.zealfi.jumi.common.util 
* @Description: TODO
* @author A18ccms A18ccms_gmail_com   
* @date 2017年12月25日 下午1:37:26 
* @version V1.0   
*/
package com.aoying.loan.common.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @功能:
 * @项目名:jumiCommon
 * @作者:zhangbin@zealfi.com
 * @日期:2017年12月25日下午1:37:26
 * @说明:<pre></pre>
 */
@Component
public class SpringApplicationContextUtil implements ApplicationContextAware {
	
	/** 全局ApplicationContext */
	public static ApplicationContext applicationContext;

	/**
	 * 设置全局ApplicationContext
	 * @param applicationContext 全局applicationContext
	 * @throws BeansException 
	 * @see org.springframework.context.ApplicationContextAware#setApplicationContext(org.springframework.context.ApplicationContext)
	 */
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		SpringApplicationContextUtil.applicationContext = applicationContext;
	}
	
	/**
	 * 根据name返回bean的对象
	 * @param name bean名称
	 * @throws
	 * @return
	 */
	public static Object getBean(String name) {
		return applicationContext.getBean(name);
	}

	/**
	 * 根据name和类类型返回bean的对象
	 * @param name bean名称
	 * @param 指定的类类型
	 * @throws
	 * @return
	 */
	public static <T> T getBean(String name, Class<T> requiredType) {
		return applicationContext.getBean(name, requiredType);
	}

	/**
	 * 检查applicationContext是否包含有bean名称的对象
	 * @param name bean名称
	 * @throws
	 * @return
	 */
	public static boolean containsBean(String name) {
		return applicationContext.containsBean(name);
	}

	/**
	 * 检验bean是否是单例模式
	 * @param name bean名称
	 * @throws
	 * @return
	 */
	public static boolean isSingleton(String name) {
		return applicationContext.isSingleton(name);
	}

	/**
	 * 返回bean的类类型
	 * @param name
	 * @throws
	 * @return
	 */
	public static Class<? extends Object> getType(String name) {
		return applicationContext.getType(name);
	}

}
