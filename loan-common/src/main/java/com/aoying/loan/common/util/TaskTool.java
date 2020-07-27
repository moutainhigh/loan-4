package com.aoying.loan.common.util;

import java.sql.Timestamp;
import org.slf4j.Logger;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import com.aoying.loan.common.task.base.TaskStatus;

/**
 * 定时任务工具类
 * @author nick
 */
public class TaskTool {
	/** 日志对象 */
	private final Logger logger;
	/** 任务状态 */
	private TaskStatus taskStatus;

	/** 任务线程池 */
	private ThreadPoolTaskExecutor threadPool;
	/** 默认检查进度间隔时间 ,单位：毫秒 */
	private long sleep = 5000;

	/** 线程历史完成的数量 */
	private long historyFinishedCount = 0;

	/**
	 * 构造函数
	 * @param taskName
	 * @param limitCount
	 * @param logger
	 * @param threadPool
	 */
	public TaskTool(String taskName, int limitCount, Logger logger, ThreadPoolTaskExecutor threadPool) {
		this.taskStatus = new TaskStatus();
		this.taskStatus.setName(taskName);
		this.taskStatus.setLimitCount(limitCount);

		this.logger = logger;
		this.threadPool = threadPool;
	}

	/**
	 * 任务开始，默认程序已初始化完成
	 */
	public void taskBegin() {
		if (taskStatus.getRunning()) {
			logger.info("【定时任务：{}】：任务已在运行，本次跳过", taskStatus.getName());
		}

		taskStatus.setRunning(true);
		taskStatus.setStartTime(System.currentTimeMillis());
		logger.info("【定时任务：{}】：在 {} 开始... ",
				taskStatus.getName(), new Timestamp(taskStatus.getStartTime()).toString());

		// if (threadPool != null) {
		// threadPool.initialize();
		// }
	}

	/**
	 * 任务开始，需传入程序是否初始化完成的变量
	 * @param isAppInitFinished
	 */
	public void taskBegin(boolean isAppInitFinished) {
		if (!isAppInitFinished) {
			logger.info("【定时任务：{}】：程序初始化还未完成，本次跳过", taskStatus.getName());
			return;
		}

		this.taskBegin();
	}

	/**
	 * 任务结束
	 */
	public void taskEnd() {
		if (threadPool != null) {
			// threadPool.shutdown();
			historyFinishedCount = threadPool.getThreadPoolExecutor().getCompletedTaskCount();
		}

		taskStatus.setRunning(false);
		taskStatus.setEndTime(System.currentTimeMillis());
		logger.info("【定时任务：{}】：在 {} 完成，共处理{}条数据,花费时间：{}s",
				taskStatus.getName(), new Timestamp(taskStatus.getEndTime()).toString(),
				taskStatus.getFinishCount(), (taskStatus.getEndTime() - taskStatus.getStartTime()) / 1000);
	}

	/**
	 * 记录进度
	 * 
	 * @param totalToDoCount 需处理总数
	 * @param finishCount 已处理总数
	 * @param readyToDoCount 本次计划处理总数
	 */
	public void logProgress(long totalToDoCount, long finishCount, int readyToDoCount) {
		logger.info("【定时任务：" + taskStatus.getName() + "】：需处理总数：" + totalToDoCount + ",已处理总数：" + finishCount + ",本次计划处理总数："
				+ readyToDoCount);
	}


	/**
	 * 等待定时任务工作结束
	 * 
	 * @throws Exception
	 */
	public void waitWorkFinished(int finishCount) throws Exception {
		if (threadPool != null) {
			while (threadPool != null) {
				Thread.sleep(sleep);
				long completedTaskCount = threadPool.getThreadPoolExecutor().getCompletedTaskCount()
						- historyFinishedCount;
				long taskCount = threadPool.getThreadPoolExecutor().getTaskCount() - historyFinishedCount;

				if (taskCount > 0) {
					logger.info("【定时任务：" + taskStatus.getName() + "】：累计完成：" + finishCount + "条,当前进度："
							+ (completedTaskCount * 100 / taskCount) + "%。" + "{taskCount:" + taskCount + ",completed:"
							+ completedTaskCount + "}");
				}
				if (completedTaskCount >= taskCount) {
					break;
				}
			}
		} else {
			logger.info("【定时任务：" + taskStatus.getName() + "】：累计完成：" + finishCount + "条。");
		}
	}

	/**
	 * 记录信息
	 * @param msg
	 */
	public void info(String msg) {
		logger.info("【定时任务：{}】：{}", taskStatus.getName(), msg);
	}

	/**
	 * 记录错误
	 * @param msg
	 * @param e
	 */
	public void error(String msg, Exception e) {
		logger.error("【定时任务：" + taskStatus.getName() + "】：" + msg, e);
	}

	/**
	 * 获取每次限制的数量
	 * @return
	 */
	public Integer getLimitCount() {
		return taskStatus.getLimitCount();
	}
}
