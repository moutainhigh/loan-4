package com.aoying.loan.cust.cust.service.iservice;

import com.aoying.loan.common.base.service.iservice.IBaseService;
import com.aoying.loan.cust.cust.pojo.CustIdCardLogPojo;
import com.aoying.loan.cust.cust.pojo.CustIdCardPojo;

/**
 * 用户实名日志表 IService
 * @author nick
 */
public interface ICustIdCardLogService extends IBaseService<CustIdCardLogPojo> {
    /**
     * 新增实名日志数据
     * @param idCard
     * @return
     */
    int addIdCardLog(CustIdCardPojo idCard);
}
