package com.aoying.loan.common.task.base;

import com.aoying.loan.common.util.JsonTool;

/**
 * 定时任务状态类
 * @author nick
 */
public class TaskStatus {
	/** 任务名称 */
	private String name;
	/** 开始时间 */
	private Long startTime;
	/** 结束时间 */
	private Long endTime;
	/** 是否正在运行 */
	private Boolean running = false;

	/** 每次限制的数量 */
	private Integer limitCount;
	/** 已处理的总数 */
	private Integer finishCount;
	/** 需处理的总数 */
	private Integer totalCount;

	/** 定时任务信息存放redis的key */
	private String key;
	/** 定时任务是否允许运行 */
	private Boolean enable;

	/**
	 * @方法重写
	 */
	@Override
	public String toString() {
		return JsonTool.getString(this);
	}


	/** 获取 任务名称 */
	public String getName() {
		return this.name;
	}

	/** 设置 任务名称 */
	public void setName(String name) {
		this.name = name;
	}

	/** 获取 开始时间 */
	public Long getStartTime() {
		return this.startTime;
	}

	/** 设置 开始时间 */
	public void setStartTime(Long startTime) {
		this.startTime = startTime;
	}

	/** 获取 结束时间 */
	public Long getEndTime() {
		return this.endTime;
	}

	/** 设置 结束时间 */
	public void setEndTime(Long endTime) {
		this.endTime = endTime;
	}

	/** 获取 是否正在运行 */
	public Boolean getRunning() {
		return this.running;
	}

	/** 设置 是否正在运行 */
	public void setRunning(Boolean running) {
		this.running = running;
	}

	/** 获取 每次限制的数量 */
	public Integer getLimitCount() {
		return this.limitCount;
	}

	/** 设置 每次限制的数量 */
	public void setLimitCount(Integer limitCount) {
		this.limitCount = limitCount;
	}

	/** 获取 已处理的总数 */
	public Integer getFinishCount() {
		return this.finishCount;
	}

	/** 设置 已处理的总数 */
	public void setFinishCount(Integer finishCount) {
		this.finishCount = finishCount;
	}

	/** 获取 需处理的总数 */
	public Integer getTotalCount() {
		return this.totalCount;
	}

	/** 设置 需处理的总数 */
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	/** 获取 定时任务信息存放redis的key */
	public String getKey() {
		return this.key;
	}

	/** 设置 定时任务信息存放redis的key */
	public void setKey(String key) {
		this.key = key;
	}

	/** 获取 定时任务是否允许运行 */
	public Boolean getEnable() {
		return this.enable;
	}

	/** 设置 定时任务是否允许运行 */
	public void setEnable(Boolean enable) {
		this.enable = enable;
	}
}
