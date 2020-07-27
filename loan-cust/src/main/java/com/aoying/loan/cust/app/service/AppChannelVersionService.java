package com.aoying.loan.cust.app.service;

import org.springframework.stereotype.Service;
import com.aoying.loan.common.base.service.BaseService;
import com.aoying.loan.cust.app.dao.AppChannelVersionDao;
import com.aoying.loan.cust.app.pojo.AppChannelVersionPojo;
import com.aoying.loan.cust.app.service.iservice.IAppChannelVersionService;

/**
 * APP渠道版本关联表 Service
 * @author nick
 */
@Service
public class AppChannelVersionService extends BaseService<AppChannelVersionPojo, AppChannelVersionDao> implements IAppChannelVersionService {

}
