package com.aoying.loan.cust.loan.service;

import java.sql.Timestamp;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import com.aoying.loan.common.base.service.BaseService;
import com.aoying.loan.common.constant.response.exception.CustomMsgException;
import com.aoying.loan.cust.cust.pojo.CustInfoPojo;
import com.aoying.loan.cust.cust.service.iservice.ICustInfoService;
import com.aoying.loan.cust.loan.dao.LoanApplicationDao;
import com.aoying.loan.cust.loan.pojo.LoanApplicationPojo;
import com.aoying.loan.cust.loan.service.iservice.ILoanApplicationService;

/**
 * 贷款申请 Service
 * @author nick
 */
@Service
public class LoanApplicationService extends BaseService<LoanApplicationPojo, LoanApplicationDao> implements ILoanApplicationService {
    @Autowired
    private ICustInfoService custInfoService;

    /**
     * 提交贷款申请，修改数据状态
     * @param cust
     * @return
     */
    @Override
    public void updateSubmit(CustInfoPojo cust) throws CustomMsgException {
        CustInfoPojo currCust = custInfoService.getById(cust);
        if (StringUtils.isEmpty(currCust.getIdCardName())) {
            throw new CustomMsgException("请先完成身份认证");
        }
//        if (currCust.getOptId() == null) {
//            throw new CustomMsgException("请先完成运营商认证");
//        }
        if (!LoanApplicationPojo.Status.TOBESUBMIT.getVal().equals(currCust.getApplicationStatus())) {
            throw new CustomMsgException("请先填写申请信息");
        }

        LoanApplicationPojo pojo = new LoanApplicationPojo();
        pojo.setCustId(currCust.getId());
        pojo.setSubmitTime(new Timestamp(System.currentTimeMillis()));
        pojo.setStatus(LoanApplicationPojo.Status.AUDITING.getVal());
        dao.updateSubmit(pojo);
    }

    /**
     * 新增贷款申请
     * @param application
     * @return
     * @throws CustomMsgException
     */
    @Override
    public LoanApplicationPojo add(LoanApplicationPojo application) throws CustomMsgException {
        // 插入贷款申请
        application.setStatus(LoanApplicationPojo.Status.TOBESUBMIT.getVal());
        application.setCreateTime(new Timestamp(System.currentTimeMillis()));
        try {
            dao.insert(application);
        } catch (DuplicateKeyException dk) {
            throw new CustomMsgException("您已申请过");
        }
        return application;
    }

    /**
     * 拒绝指定时间之前的申请，并返回用户手机号
     * @param min
     * @return
     */
    @Override
    public List<LoanApplicationPojo> updateAndGetApplyAuditRefused(Integer min) {
        Long now = System.currentTimeMillis();

        LoanApplicationPojo pojo = new LoanApplicationPojo();
        pojo.setAuditTime(new Timestamp(now));
        pojo.setSubmitTime(new Timestamp(now - min * 60 * 1000));

        dao.updateApplyAuditRefused(pojo);

        return dao.getApplyAuditRefused(pojo);
    }
}
