package com.aoying.loan.cust.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.aoying.loan.common.task.base.Task;
import com.aoying.loan.common.task.base.TaskJob;
import com.aoying.loan.cust.app.service.iservice.IAppChannelRecordService;

/**
 * 更新昨日对外渠道数据，插入今日对外渠道数据
 * @author nick
 */
@Task
public class UpdateAppChannelRecordTask {
    /** 日志对象 */
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IAppChannelRecordService appChannelRecordService;

    @TaskJob(cron = "${taskCfg.updateAppChannelRecordTask.cron}")
    public void task() {
        int rows = appChannelRecordService.updateRegVisits();
        logger.info("[定时任务] 更新对外渠道数据，更新注册数{}行", rows);

        rows = appChannelRecordService.updateActVisits();
        logger.info("[定时任务] 更新对外渠道数据，更新激活数{}行", rows);

        rows = appChannelRecordService.updateProVisits();
        logger.info("[定时任务] 更新对外渠道数据，更新产品数{}行", rows);

        rows = appChannelRecordService.updateReportVisits();
        logger.info("[定时任务] 更新对外渠道数据，更新报告数{}行", rows);
    }
}
