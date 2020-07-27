package com.aoying.loan.cust.cust.service;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.aoying.loan.common.base.service.BaseService;
import com.aoying.loan.common.constant.response.code.EResCodeCust;
import com.aoying.loan.common.constant.response.exception.DefineMsgException;
import com.aoying.loan.common.util.StringTool;
import com.aoying.loan.cust.api.ThirdPartyApiDs;
import com.aoying.loan.cust.cust.dao.CustIdCardDao;
import com.aoying.loan.cust.cust.pojo.CustIdCardLogPojo;
import com.aoying.loan.cust.cust.pojo.CustIdCardPojo;
import com.aoying.loan.cust.cust.service.iservice.ICustIdCardLogService;
import com.aoying.loan.cust.cust.service.iservice.ICustIdCardService;

/**
 * 用户实名表 Service
 * @author nick
 */
@Service
public class CustIdCardService extends BaseService<CustIdCardPojo, CustIdCardDao> implements ICustIdCardService {
    @Autowired
    private ThirdPartyApiDs thirdPartyApiDs;
    @Autowired
    private ICustIdCardLogService custIdCardLogService;

    @Value("${sysCfg.idCardAuthLimit}")
    private Integer idCardAuthLimit;

    /**
     * 新增并认证实名
     * 查询是否实名过，若实名过，则返回实名信息，若未实名或实名失败，则实名后返回实名信息
     * @param idCard
     * @return
     * @throws IOException
     * @throws DefineMsgException
     */
    @Override
    public CustIdCardPojo addAndAuthIdCard(CustIdCardPojo idCard) throws IOException, DefineMsgException {
        // 查询实名历史数据
         CustIdCardPojo history = this.selectUniqueByCustId(idCard.getCustId());

        if (history == null) {

            // 无历史数据
            this.authIdCard(idCard);

            // 保存校验结果
            this.addOrUpdateIdCard(idCard, true);
            custIdCardLogService.addIdCardLog(idCard);

        } else if (history.getStatus().equals(CustIdCardPojo.Status.FAIL.getVal())) {

            // 是否超过当日限制
            if (history.getAuthFailLastTime() != null &&
                    history.getAuthFailLastTime().getTime() > getTodayZero() &&
                    history.getAuthFailCount() >= idCardAuthLimit) {
                throw new DefineMsgException(EResCodeCust.svceErrAuthIdCardOverLimit);
            }

            // 有历史数据，但实名失败
            idCard.setId(history.getId());
            idCard.setAuthFailCount(history.getAuthFailCount());
            this.authIdCard(idCard);

            // 更新校验结果
            this.addOrUpdateIdCard(idCard, false);
            custIdCardLogService.addIdCardLog(idCard);

        } else if (history.getStatus().equals(CustIdCardPojo.Status.SUCC.getVal())) {

            // 有历史数据，且实名成功
            return history;

        }

        return idCard;
    }

    /**
     * 实名认证
     * @param idCard
     * @return
     * @throws Exception
     */
    public Boolean authIdCard(CustIdCardPojo idCard) throws IOException {
        Map<String, Object> auth = thirdPartyApiDs.authIdCard(idCard.getIdCardCode(), idCard.getIdCardName());

        // 解析结果
        idCard.setCheckMode(CustIdCardLogPojo.CheckMode.THIRDPARTY.getVal());
        idCard.setResultJson((String) auth.get("json"));
        if ((Boolean) auth.get("auth")) {
            idCard.setStatus(CustIdCardLogPojo.Status.SUCC.getVal());
            return true;
        } else {
            int count = idCard.getAuthFailCount() == null ? 0 : idCard.getAuthFailCount();
            idCard.setAuthFailCount(count + 1);
            idCard.setAuthFailLastTime(new Timestamp(System.currentTimeMillis()));
            idCard.setStatus(CustIdCardLogPojo.Status.FAIL.getVal());
            return false;
        }
    }

    /**
     * 获取今天零点
     * @return
     */
    private long getTodayZero() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime().getTime();
    }

    /**
     * 新增或保存实名数据
     * @param idCard
     * @param isNew true 新增，false 更新
     * @return
     */
    private int addOrUpdateIdCard(CustIdCardPojo idCard, boolean isNew) {
        if (idCard.getSex() == null) {
            idCard.setSex(StringTool.getSexByIdCardNo(idCard.getIdCardCode(), true));
        }
        if (idCard.getBirthday() == null) {
            idCard.setBirthday(StringTool.getBirthdayByIdCardNo(idCard.getIdCardCode(), true));
        }

        if (isNew) {
            idCard.setCreateTime(new Timestamp(System.currentTimeMillis()));
            return dao.insert(idCard);
        } else {
            return dao.update(idCard);
        }
    }

    /**
     * 根据客户ID获取实名信息
     * @param custId
     * @return
     */
    @Override
    public CustIdCardPojo selectUniqueByCustId(Long custId) {
        CustIdCardPojo pojo = new CustIdCardPojo();
        pojo.setCustId(custId);
        return dao.selectUnique(pojo);
    }

    /**
     * 根据客户ID获取实名成功的信息
     * @param custId
     * @return
     */
    @Override
    public CustIdCardPojo selectSuccByCustId(Long custId) {
        CustIdCardPojo pojo = new CustIdCardPojo();
        pojo.setCustId(custId);
        pojo.setStatus(CustIdCardPojo.Status.SUCC.getVal());
        return dao.selectUnique(pojo);
    }

    /**
     * 根据身份证获取实名成功的信息
     * @param idCardCode
     * @return
     */
    @Override
    public CustIdCardPojo selectSuccByIdCardCode(String idCardCode) {
        CustIdCardPojo pojo = new CustIdCardPojo();
        pojo.setIdCardCode(idCardCode);
        pojo.setStatus(CustIdCardPojo.Status.SUCC.getVal());
        return dao.selectUnique(pojo);
    }
}
