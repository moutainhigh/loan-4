/** */
package com.aoying.loan.cust.cust.service.iservice;

import java.util.List;
import java.util.Map;
import com.aoying.loan.common.base.service.iservice.IBaseService;
import com.aoying.loan.common.constant.response.exception.DefineMsgException;
import com.aoying.loan.cust.cust.pojo.CustInfoPojo;

/**
 * @功能:【custinfo 用户信息表】IService
 * @项目名:loan-cust
 * @作者:nick
 * @日期:2018-11-30 10:53:19
 * @说明：<pre></pre>
 */
public interface ICustInfoService extends IBaseService<CustInfoPojo> {
    void addRegister(CustInfoPojo registerCust) throws Exception;

    Map<String, Object> addLoginByPwd(CustInfoPojo cust) throws DefineMsgException;

    Map<String, Object> addLoginBySms(CustInfoPojo cust) throws DefineMsgException;

    /**
     * 注册量按渠道查，每行一日期，每列一渠道
     * @param pojo
     * @return
     */
    List<Map<String, String>> getRegByCh(CustInfoPojo pojo);

    /**
     * 注册量所有渠道，每行一渠道，只有一列合计
     * @param pojo
     * @return
     */
    List<Map<String, String>> getRegAll(CustInfoPojo pojo);

    /**
     * 首页注册数据
     * @return
     */
    Map<String, String> getRegistrationData();

    /**
     * 获取用户信息
     * @return
     */
    CustInfoPojo getById(CustInfoPojo pojo);
}
