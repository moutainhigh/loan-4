/** */
package com.aoying.loan.common.task.base;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.stereotype.Component;

/**
 * @功能:标记定时任务注解
 * @项目名:testCommonFun
 * @作者:wangjz
 * @日期:2017年4月12日上午9:33:26
 * 
 * @说明：@Component让task被spring识别，相当于task继承component
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface Task {
	/**
	 * 是否可运行
	 * 
	 * @return
	 */
	boolean runable() default true;
}
