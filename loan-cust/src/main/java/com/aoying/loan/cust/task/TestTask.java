package com.aoying.loan.cust.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.aoying.loan.common.task.base.Task;
import com.aoying.loan.common.task.base.TaskJob;

/**
 * 测试定时任务
 * @author nick
 */
@Task
public class TestTask {
	/** 日志对象 */
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	private static long i1 = 0;
//	@TaskJob(cron = "0/10 * * * * ?")
	public void work1() {
		logger.info("work1: {}", ++i1);
	}

	private static long i2 = 0;
	@TaskJob(cron = "${taskCfg.testTask.cron}")
	public void work2() {
		logger.info("work2: {}", ++i2);
	}
}
