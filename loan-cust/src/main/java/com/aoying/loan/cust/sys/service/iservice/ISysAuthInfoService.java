package com.aoying.loan.cust.sys.service.iservice;

import javax.servlet.http.HttpServletRequest;
import com.aoying.loan.common.base.service.iservice.IBaseService;
import com.aoying.loan.common.constant.response.exception.DefineMsgException;
import com.aoying.loan.cust.sys.pojo.SysAuthInfoPojo;

/**
 * 系统访问认证信息 IService
 * @author nick
 */
public interface ISysAuthInfoService extends IBaseService<SysAuthInfoPojo> {
    /**
     * 校验签名
     * @param request
     * @throws DefineMsgException
     */
    SysAuthInfoPojo checkSign(HttpServletRequest request) throws DefineMsgException;
}
