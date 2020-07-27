package com.aoying.loan.cust.app.service.iservice;

import com.aoying.loan.common.base.service.iservice.IBaseService;
import com.aoying.loan.cust.app.pojo.AppFeedbackPojo;

/**
 * APP反馈信息表 IService
 * @author nick
 */
public interface IAppFeedbackService extends IBaseService<AppFeedbackPojo> {
    /**
     * 新增反馈
     * @param appFeedback
     */
    void add(AppFeedbackPojo appFeedback);
}
