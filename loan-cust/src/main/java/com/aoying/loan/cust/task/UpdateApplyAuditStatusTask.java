package com.aoying.loan.cust.task;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import com.aoying.loan.common.task.base.Task;
import com.aoying.loan.common.task.base.TaskJob;
import com.aoying.loan.cust.constant.ESmsTemplate;
import com.aoying.loan.cust.loan.pojo.LoanApplicationPojo;
import com.aoying.loan.cust.loan.service.iservice.ILoanApplicationService;
import com.aoying.loan.cust.tool.service.iservice.ISmsSendService;

/**
 * 更新申请审核状态
 * @author nick
 */
@Task
public class UpdateApplyAuditStatusTask {
    /** 日志对象 */
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${taskCfg.updateApplyAuditStatusTask.min}")
    private Integer min;

    @Autowired
    private ISmsSendService smsSendService;
    @Autowired
    private ILoanApplicationService loanApplicationService;

    @TaskJob(cron = "${taskCfg.updateApplyAuditStatusTask.cron}")
    public void task() throws Exception {
        List<LoanApplicationPojo> list = loanApplicationService.updateAndGetApplyAuditRefused(min);
        logger.info("[定时任务] 拒绝{}分钟前的申请，共{}条数据，开始发送短信", min, list.size());

        for (LoanApplicationPojo p : list) {
            smsSendService.sendSms(p.getTelNo(), null, ESmsTemplate.AuditRefused.getTemplate());
        }
    }
}
