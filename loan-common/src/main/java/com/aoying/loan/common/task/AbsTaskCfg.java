package com.aoying.loan.common.task;

import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor.AbortPolicy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import com.aoying.loan.common.task.base.TaskScheduler;
import com.aoying.loan.common.util.ObjectTool;

/**
 * @功能:
 * @项目名:dunningCommon
 * @作者:chuxu
 * @日期:2017年11月20日下午3:34:18
 */
public abstract class AbsTaskCfg {
	/** 定时任务线程池配置 */
	private Map<String, Object> theadPoolCfg;
	/** 日志 */
	protected Logger logger = LogManager.getLogger(this.getClass());

	/**
	 * 得到BaseRedisDao
	 * 
	 * @return
	 */
	public abstract ThreadPoolTaskExecutor getTaskThreadPool() throws Exception;
	
	public abstract TaskScheduler getTaskScheduler(ThreadPoolTaskExecutor taskThreadPool) throws Exception;

	public ThreadPoolTaskExecutor generateTaskThreadPool() throws Exception {
		logger.info("====================配置定时任务线程池===================");
		ThreadPoolTaskExecutor taskThreadPool = new ThreadPoolTaskExecutor();
		ObjectTool.setValue(taskThreadPool, theadPoolCfg);
		taskThreadPool.setRejectedExecutionHandler(new AbortPolicy());
		logger.info("定时任务线程池ThreadPoolTaskExecutor创建成功");
		return taskThreadPool;
	}

	public TaskScheduler generateTaskScheduler(ThreadPoolTaskExecutor taskThreadPool) throws Exception {
		logger.info("====================定时任务线程池ThreadPoolTaskExecutor创建成功===================");
		TaskScheduler taskScheduler = new TaskScheduler();
		taskScheduler.setTaskExecutor(taskThreadPool);
		return taskScheduler;
	}

	/**
	 * @取得 定时任务线程池配置
	 */
	public Map<String, Object> getTheadPoolCfg() {
		return theadPoolCfg;
	}

	/**
	 * @设置 定时任务线程池配置
	 */
	public void setTheadPoolCfg(Map<String, Object> theadPoolCfg) {
		this.theadPoolCfg = theadPoolCfg;
	}
}
