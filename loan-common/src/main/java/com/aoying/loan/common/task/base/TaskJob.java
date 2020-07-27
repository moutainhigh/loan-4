/** */
package com.aoying.loan.common.task.base;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @功能:
 * @项目名:testCommonFun
 * @作者:wangjz
 * @日期:2017年4月12日上午9:44:27
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TaskJob {
	/**
	 * 任务运行默认表达式
	 * 
	 * <pre>
	 * cron的值可以为：
	 * 	a) 0/1 * * * * ?:quartz默认表达式
	 *  b) #{com.zealfi.jumi.task.cron} :通过定义spring bean进行赋值
	 *  c) ${com.zealfi.jumi.task.cron} :通过properties配置进行赋值
	 * </pre>
	 * 
	 * @return
	 */
	String cron() default "";
	
	/**
	 * 设置是否允许并发,指定concurrent设为false，多个job不会并发运行 
	 */
	boolean isConcurrent() default false;
}
