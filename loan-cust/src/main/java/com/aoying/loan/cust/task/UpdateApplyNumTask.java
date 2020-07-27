package com.aoying.loan.cust.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.aoying.loan.common.task.base.Task;
import com.aoying.loan.common.task.base.TaskJob;
import com.aoying.loan.cust.loan.service.iservice.ILoanProductService;
import com.aoying.loan.cust.trade.service.iservice.ITradeGoodsService;

/**
 * 更新申请人数，每次随机增加0～3人
 * @author nick
 */
@Task
public class UpdateApplyNumTask {
    /** 日志对象 */
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ILoanProductService loanProductService;
    @Autowired
    private ITradeGoodsService tradeGoodsService;

    @TaskJob(cron = "${taskCfg.updateApplyNumTask.cron}")
    public void task() {
        int num = loanProductService.updateApplyNum();
        logger.info("[定时任务] 更新产品申请人数，影响{}个产品", num);

        num = tradeGoodsService.updateApplyNum();
        logger.info("[定时任务] 更新商品购买人数，影响{}个商品", num);
    }
}
