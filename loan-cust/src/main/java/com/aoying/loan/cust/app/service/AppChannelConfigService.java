package com.aoying.loan.cust.app.service;

import org.springframework.stereotype.Service;
import com.aoying.loan.common.base.service.BaseService;
import com.aoying.loan.cust.app.dao.AppChannelConfigDao;
import com.aoying.loan.cust.app.pojo.AppChannelConfigPojo;
import com.aoying.loan.cust.app.service.iservice.IAppChannelConfigService;

/**
 * APP渠道配置 Service
 * @author nick
 */
@Service
public class AppChannelConfigService extends BaseService<AppChannelConfigPojo, AppChannelConfigDao> implements IAppChannelConfigService {

}
