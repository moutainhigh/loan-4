/** */
package com.aoying.loan.cust.cust.service;

import java.sql.Date;
import java.sql.Timestamp;
import org.springframework.stereotype.Service;
import com.aoying.loan.common.base.service.BaseService;
import com.aoying.loan.cust.cust.dao.CustLoginFailLogDao;
import com.aoying.loan.cust.cust.pojo.CustInfoPojo;
import com.aoying.loan.cust.cust.pojo.CustLoginFailLogPojo;
import com.aoying.loan.cust.cust.service.iservice.ICustLoginFailLogService;

/**
 * @功能:【custloginfaillog 用户登陆失败日志】Service
 * @项目名:loan-cust
 * @作者:nick
 * @日期:2018-11-30 10:53:20
 * @说明：<pre></pre>
 */
@Service
public class CustLoginFailLogService extends BaseService<CustLoginFailLogPojo, CustLoginFailLogDao> implements ICustLoginFailLogService {
    @Override
    public void insertByCustInfo(CustInfoPojo cust) {
        CustLoginFailLogPojo loginLog = new CustLoginFailLogPojo();
        loginLog.setCustId(cust.getId());
        loginLog.setAppId(cust.getAppId());
        loginLog.setTelNo(cust.getTelNo());
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
