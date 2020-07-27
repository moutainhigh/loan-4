/** */
package com.aoying.loan.common.task.base;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import com.alibaba.druid.util.StringUtils;

/**
 * @功能:定时任务部署者
 * @项目名:testCommonFun
 * @作者:wangjz
 * @日期:2017年4月12日上午9:52:26
 */
public class TaskScheduler extends SchedulerFactoryBean {
	/** 日志对象 */
	protected Logger logger = LogManager.getLogger(this.getClass());
	/** spring上下文环境 */
	private ApplicationContext applicationContext;
	/** 项目配置环境 */
	private Environment environment;

	/**
	 * @方法重写 将CronTriggerFactoryBean对象添加到Scheduler,相当于设置triggers属性
	 */
	@Override
	protected void registerJobsAndTriggers() throws SchedulerException {
		try {
			List<Trigger> triggerList = new ArrayList<Trigger>();
			Trigger trigger = null;
			// 获取spring环境中所有bean
			String[] beanNames = applicationContext.getBeanNamesForType(Object.class);
			for (String beanName : beanNames) {
				Class<?> clazz = applicationContext.getType(beanName);
				// 如果是Task注解，解析注解
				if (clazz.isAnnotationPresent(Task.class)) {
					Object bean = applicationContext.getBean(beanName);
					// 获取注解的值，判断是否可运行
					boolean runable = clazz.getAnnotation(Task.class).runable();
					if (runable) {
						Method[] methods = clazz.getMethods();
						for (Method method : methods) {
							// 判断方法上是否注解taskJob
							if (method.isAnnotationPresent(TaskJob.class)) {
								String cron = method.getAnnotation(TaskJob.class).cron();
								if (cron != null && cron.startsWith("${")) {
									cron = cron.replaceAll("\\$\\{", "").replaceAll("\\}", "");
									cron = this.environment.getProperty(cron);
								} else if (cron != null && cron.startsWith("#{")) {
									cron = cron.replaceAll("\\#\\{", "").replaceAll("\\}", "");
									cron = applicationContext.getBean(cron, String.class);
								}
								if (!StringUtils.isEmpty(cron)) {
									boolean isConcurrent = method.getAnnotation(TaskJob.class).isConcurrent();
									trigger = getTrigger(bean, beanName, method.getName(), cron, isConcurrent);
									triggerList.add(trigger);
									logger.warn("=====定时任务：" + beanName + "-" + method.getName() + "启用。=====");
								} else {
									logger.warn("=====================================================================");
									logger.warn("=====定时任务：" + beanName + "-" + method.getName() + "没有启用。=====");
									logger.warn("=====================================================================");
								}
							}
						}
					}

				}
			}
			if (triggerList.size() > 0) {
				this.setTriggers(triggerList.toArray(new Trigger[triggerList.size()]));
			}
			super.registerJobsAndTriggers();
		} catch (Exception ex) {
			throw new SchedulerException("定时任务初始化失败：" + ex.getMessage(), ex);
		}
	}

	/**
	 * 生成trigger
	 * 
	 * @param bean
	 * @param beanName
	 * @param methodName
	 * @param cron
	 * @param isConcurrent
	 */
	private Trigger getTrigger(Object bean, String beanName, String methodName, String cron , boolean isConcurrent) throws Exception {
		// 通过factory生成jobDetail
		MethodInvokingJobDetailFactoryBean jobDetailFactory = new MethodInvokingJobDetailFactoryBean();
		jobDetailFactory.setName(beanName + "_" + methodName + "_job");
		jobDetailFactory.setTargetObject(bean);
		jobDetailFactory.setTargetMethod(methodName);
		jobDetailFactory.afterPropertiesSet();
		jobDetailFactory.setConcurrent(isConcurrent);

		// 通过factory生成CronTrigger
		CronTriggerFactoryBean triggerFactory = new CronTriggerFactoryBean();
		triggerFactory.setName(beanName + "_" + methodName + "_trigger");
		triggerFactory.setJobDetail(jobDetailFactory.getObject());
		triggerFactory.setCronExpression(cron);
		triggerFactory.afterPropertiesSet();
		return triggerFactory.getObject();
	}

	/**
	 * @方法重写 获取spring上下文环境
	 */
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
		this.environment = applicationContext.getEnvironment();
		super.setApplicationContext(applicationContext);
	}

}
