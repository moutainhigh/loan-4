package com.aoying.loan.cust.loan.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.aoying.loan.common.base.dao.BaseDao;
import com.aoying.loan.cust.loan.pojo.LoanApplicationPojo;

/**
 * 贷款申请 Dao
 * @author nick
 */
@Repository
public class LoanApplicationDao extends BaseDao<LoanApplicationPojo> {
    /**
     * 提交贷款申请，修改数据状态
     * @param pojo
     * @return
     */
    public int updateSubmit(LoanApplicationPojo pojo) {
        return this.template.update(getFullMapperId("updateSubmit"), pojo);
    }

    /**
     * 拒绝指定时间之前的申请
     * @param pojo
     * @return
     */
    public int updateApplyAuditRefused(LoanApplicationPojo pojo) {
        return this.template.update(getFullMapperId("updateApplyAuditRefused"), pojo);

    }

    /**
     * 获取被拒绝申请的用户手机号
     * @param pojo
     * @return
     */
    public List<LoanApplicationPojo> getApplyAuditRefused(LoanApplicationPojo pojo) {
        return this.template.selectList(getFullMapperId("getApplyAuditRefused"), pojo);
    }
}
