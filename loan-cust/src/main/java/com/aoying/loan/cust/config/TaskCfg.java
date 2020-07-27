package com.aoying.loan.cust.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import com.aoying.loan.common.task.AbsTaskCfg;
import com.aoying.loan.common.task.base.TaskScheduler;

/**
 * 定时任务配置
 * @author nick
 */
@Configuration
@ConfigurationProperties(prefix = "taskCfg")
public class TaskCfg extends AbsTaskCfg {
	/**
	 * 得到taskScheduler实例
	 * @方法重写
	 * @return
	 * @throws Exception
	 */
	@Bean(name = "taskThreadPool")
	@Override
	public ThreadPoolTaskExecutor getTaskThreadPool() throws Exception {
		return this.generateTaskThreadPool();
	}

	@Bean(name = "taskScheduler")
	@Override
	public TaskScheduler getTaskScheduler(@Qualifier("taskThreadPool") ThreadPoolTaskExecutor taskThreadPool)
			throws Exception {
		return this.generateTaskScheduler(taskThreadPool);
	}
}
