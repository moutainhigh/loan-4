/** */
package com.aoying.loan.cust.cust.service.iservice;

import com.aoying.loan.common.base.service.iservice.IBaseService;
import com.aoying.loan.cust.cust.pojo.CustInfoPojo;
import com.aoying.loan.cust.cust.pojo.CustLoginLogPojo;

/**
 * @功能:【custloginlog 用户登陆日志】IService
 * @项目名:loan-cust
 * @作者:nick
 * @日期:2018-11-30 10:53:20
 * @说明：<pre></pre>
 */
public interface ICustLoginLogService extends IBaseService<CustLoginLogPojo> {
    void insertByCustInfo(CustInfoPojo cust);
}
