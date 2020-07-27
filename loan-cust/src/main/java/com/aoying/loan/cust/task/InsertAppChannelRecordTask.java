package com.aoying.loan.cust.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import com.aoying.loan.common.task.base.Task;
import com.aoying.loan.common.task.base.TaskJob;
import com.aoying.loan.cust.app.service.iservice.IAppChannelRecordService;

/**
 * 更新昨日对外渠道数据，插入今日对外渠道数据
 * @author nick
 */
@Task
public class InsertAppChannelRecordTask {
    /** 日志对象 */
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IAppChannelRecordService appChannelRecordService;

    @TaskJob(cron = "${taskCfg.insertAppChannelRecordTask.cron}")
    public void task() {
        try {
            int rows = appChannelRecordService.insertByConfig();
            logger.info("[定时任务] 插入对外渠道数据，插入{}行", rows);
        } catch (DuplicateKeyException e) {
            logger.error("[定时任务] 插入对外渠道数据重复 for key 'idx_appChannelRecord_calDate_channelId'");
        }
    }
}
