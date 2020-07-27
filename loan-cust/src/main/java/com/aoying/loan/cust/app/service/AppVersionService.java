package com.aoying.loan.cust.app.service;

import org.springframework.stereotype.Service;
import com.aoying.loan.common.base.service.BaseService;
import com.aoying.loan.cust.app.dao.AppVersionDao;
import com.aoying.loan.cust.app.pojo.AppVersionPojo;
import com.aoying.loan.cust.app.service.iservice.IAppVersionService;

/**
 * APP版本表 Service
 * @author nick
 */
@Service
public class AppVersionService extends BaseService<AppVersionPojo, AppVersionDao> implements IAppVersionService {

}
