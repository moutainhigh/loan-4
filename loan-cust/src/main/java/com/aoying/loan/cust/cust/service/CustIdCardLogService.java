package com.aoying.loan.cust.cust.service;

import java.sql.Timestamp;
import org.springframework.stereotype.Service;
import com.aoying.loan.common.base.service.BaseService;
import com.aoying.loan.cust.cust.dao.CustIdCardLogDao;
import com.aoying.loan.cust.cust.pojo.CustIdCardLogPojo;
import com.aoying.loan.cust.cust.pojo.CustIdCardPojo;
import com.aoying.loan.cust.cust.service.iservice.ICustIdCardLogService;

/**
 * 用户实名日志表 Service
 * @author nick
 */
@Service
public class CustIdCardLogService extends BaseService<CustIdCardLogPojo, CustIdCardLogDao> implements ICustIdCardLogService {
    /**
     * 新增实名日志数据
     * @param idCard
     * @return
     */
    @Override
    public int addIdCardLog(CustIdCardPojo idCard) {
        CustIdCardLogPojo log = new CustIdCardLogPojo();
        log.setCustId(idCard.getCustId());
        log.setIdCardCode(idCard.getIdCardCode());
        log.setIdCardName(idCard.getIdCardName());
        log.setSex(idCard.getSex());
        log.setBirthday(idCard.getBirthday());
        log.setCreateTime(new Timestamp(System.currentTimeMillis()));
        log.setStatus(idCard.getStatus());
        log.setCheckMode(idCard.getCheckMode());
        log.setResultJson(idCard.getResultJson());
        return dao.insert(log);
    }
}
