package com.aoying.loan.cust.cust.service.iservice;

import java.io.IOException;
import com.aoying.loan.common.base.service.iservice.IBaseService;
import com.aoying.loan.common.constant.response.exception.DefineMsgException;
import com.aoying.loan.cust.cust.pojo.CustIdCardPojo;

/**
 * 用户实名表 IService
 * @author nick
 */
public interface ICustIdCardService extends IBaseService<CustIdCardPojo> {
    /**
     * 新增并认证实名
     * @param idCard
     * @return
     * @throws IOException
     * @throws DefineMsgException
     */
    CustIdCardPojo addAndAuthIdCard(CustIdCardPojo idCard) throws IOException, DefineMsgException;

    /**
     * 根据客户ID获取实名信息
     * @param custId
     * @return
     */
    CustIdCardPojo selectUniqueByCustId(Long custId);

    /**
     * 根据客户ID获取实名成功的信息
     * @param custId
     * @return
     */
    CustIdCardPojo selectSuccByCustId(Long custId);

    /**
     * 根据身份证获取实名成功的信息
     * @param idCardCode
     * @return
     */
    CustIdCardPojo selectSuccByIdCardCode(String idCardCode);
}
