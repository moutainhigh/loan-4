package com.aoying.loan.cust.loan.service;

import com.aoying.loan.common.base.service.BaseService;
import com.aoying.loan.common.constant.eenum.EStatus;
import com.aoying.loan.cust.loan.dao.LoanApplicationForLargeDao;
import com.aoying.loan.cust.loan.pojo.LoanApplicationForLargePojo;
import com.aoying.loan.cust.loan.service.iservice.ILoanApplicationForLargeService;
import com.aoying.loan.cust.sys.pojo.SysAuthInfoPojo;
import com.dongfang.api.DongFangApi;
import com.dongfang.api.DongFangIsRegisteredRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * 大额贷款申请 Service
 *
 * @author nick
 */
@Service
public class LoanApplicationForLargeService extends BaseService<LoanApplicationForLargePojo, LoanApplicationForLargeDao> implements ILoanApplicationForLargeService {

    @Autowired
    private DongFangApi dongFangApi;

    /**
     * 大额申请提交
     * 未提交过则插入，已提交过则更新
     *
     * @param application
     */
    @Override
    public void addOrUpdate(LoanApplicationForLargePojo application, SysAuthInfoPojo authInfo) {
        Long optId = authInfo == null ? 0L : authInfo.getId();
        String optName = authInfo == null ? "user" : authInfo.getAccount();

        // 创建者与手机号唯一约束
        application.setCreaterId(optId);
        LoanApplicationForLargePojo p = this.selectUnique(application);
        if (p == null) {
            application.setCreaterId(optId);
            application.setCreaterName(optName);
            application.setCreateTime(new Timestamp(System.currentTimeMillis()));
            application.setSubmitCode(LoanApplicationForLargePojo.ESubmitCode.DEFAULT.getStrVal());
            application.setStatus(EStatus.VALID.getVal());
            this.insert(application);
        } else {
            application.setId(p.getId());
            application.setModId(optId);
            application.setModName(optName);
            application.setModTime(new Timestamp(System.currentTimeMillis()));
            this.update(application);
        }
    }

    @Override
    public LoanApplicationForLargePojo selectById(Long id) {
        LoanApplicationForLargePojo p = new LoanApplicationForLargePojo();
        p.setId(id);
        return this.selectUnique(p);
    }

    @Override
    public void authAndAddUser(LoanApplicationForLargePojo application, Integer id) {
        switch (id) {
            case 1:
                // 1.查询用户是否存在
                DongFangIsRegisteredRes res = dongFangApi.isRegistered(application.getTelNo(), Timestamp.valueOf(LocalDateTime.now()).toString());
                if (!res.getIsRegistered()) {
                    // 2.用户存在则直接失败，用户不存在，则进行同步
                    DongFangIsRegisteredRes registerResult = dongFangApi.register(application.getTelNo());
                    if (registerResult.getIsRegistered()) {
                        logger.info("该手机号{}的用户已经注册", application.getTelNo());
                    } else {
                        logger.info("手机号{}的用户注册成功", application.getTelNo());
                    }
                }
                break;
            case 2:
                // 查询捷捷贷
                break;
            default:
                break;
        }

    }

}
