/** */
package com.aoying.loan.cust.cust.service;

import java.sql.Date;
import java.sql.Timestamp;
import org.springframework.stereotype.Service;
import com.aoying.loan.common.base.service.BaseService;
import com.aoying.loan.cust.cust.dao.CustLoginLogDao;
import com.aoying.loan.cust.cust.pojo.CustInfoPojo;
import com.aoying.loan.cust.cust.pojo.CustLoginLogPojo;
import com.aoying.loan.cust.cust.service.iservice.ICustLoginLogService;

/**
 * @功能:【custloginlog 用户登陆日志】Service
 * @项目名:loan-cust
 * @作者:nick
 * @日期:2018-11-30 10:53:20
 * @说明：<pre></pre>
 */
@Service
public class CustLoginLogService extends BaseService<CustLoginLogPojo, CustLoginLogDao> implements ICustLoginLogService {
    @Override
    public void insertByCustInfo(CustInfoPojo cust) {
        CustLoginLogPojo loginLog = new CustLoginLogPojo();
        loginLog.setCustId(cust.getId());
        loginLog.setAppId(cust.getAppId());
        loginLog.setAppVerText(cust.getAppVerText());
        loginLog.setWxOpenId(cust.getWxOpenId());
        loginLog.setDeviceId(cust.getDeviceId());
        loginLog.setIp(cust.getIp());
        loginLog.setLng(cust.getLng());
        loginLog.setLat(cust.getLat());
        loginLog.setProvinceName(cust.getProvinceName());
        loginLog.setCityName(cust.getCityName());
        loginLog.setCountyName(cust.getCountyName());
        loginLog.setAddress(cust.getAddress());
        loginLog.setLoginDate(new Date(System.currentTimeMillis()));
        loginLog.setLoginTime(new Timestamp(System.currentTimeMillis()));
        this.insert(loginLog);
    }
}
