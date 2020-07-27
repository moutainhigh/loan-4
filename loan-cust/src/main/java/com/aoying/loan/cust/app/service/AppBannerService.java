package com.aoying.loan.cust.app.service;

import org.springframework.stereotype.Service;
import com.aoying.loan.common.base.service.BaseService;
import com.aoying.loan.cust.app.dao.AppBannerDao;
import com.aoying.loan.cust.app.pojo.AppBannerPojo;
import com.aoying.loan.cust.app.service.iservice.IAppBannerService;

/**
 * APP横幅广告表 Service
 * @author nick
 */
@Service
public class AppBannerService extends BaseService<AppBannerPojo, AppBannerDao> implements IAppBannerService {

}
