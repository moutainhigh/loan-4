package com.aoying.loan.cust.app.service;

import org.springframework.stereotype.Service;
import com.aoying.loan.common.base.service.BaseService;
import com.aoying.loan.cust.app.dao.AppChannelDao;
import com.aoying.loan.cust.app.pojo.AppChannelPojo;
import com.aoying.loan.cust.app.service.iservice.IAppChannelService;

/**
 * APP渠道表 Service
 * @author nick
 */
@Service
public class AppChannelService extends BaseService<AppChannelPojo, AppChannelDao> implements IAppChannelService {

}
