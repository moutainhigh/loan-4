package com.aoying.loan.cust.app.service;

import java.sql.Timestamp;
import org.springframework.stereotype.Service;
import com.aoying.loan.common.base.service.BaseService;
import com.aoying.loan.cust.app.dao.AppFeedbackDao;
import com.aoying.loan.cust.app.pojo.AppFeedbackPojo;
import com.aoying.loan.cust.app.service.iservice.IAppFeedbackService;

/**
 * APP反馈信息表 Service
 * @author nick
 */
@Service
public class AppFeedbackService extends BaseService<AppFeedbackPojo, AppFeedbackDao> implements IAppFeedbackService {
    /**
     * 新增反馈
     * @param appFeedback
     */
    @Override
    public void add(AppFeedbackPojo appFeedback) {
        if (appFeedback.getAppId() == null) {
            appFeedback.setAppId(10L);
        }
        appFeedback.setCreateTime(new Timestamp(System.currentTimeMillis()));
        this.insert(appFeedback);
    }
}
