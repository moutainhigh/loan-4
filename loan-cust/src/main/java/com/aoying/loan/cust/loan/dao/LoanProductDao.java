/** */
package com.aoying.loan.cust.loan.dao;

import java.util.Map;
import org.springframework.stereotype.Repository;
import com.aoying.loan.common.base.dao.BaseDao;
import com.aoying.loan.cust.loan.pojo.LoanProductPojo;

/**
 * @功能:【loanproduct 贷款产品表】Dao
 * @项目名:loan-cust
 * @作者:nick
 * @日期:2018-12-02 15:43:52
 * @说明：<pre></pre>
 */
@Repository
public class LoanProductDao extends BaseDao<LoanProductPojo> {
    /**
     * 更新申请人数，每次随机增加0～3人
     */
    public int updateApplyNum() {
        return template.update(getFullMapperId("updateApplyNum"));
    }

    /**
     * 增加点击量
     * @param id
     * @return
     */
    public int addPv(Long id) {
        return template.update(getFullMapperId("addPv"), id);
    }

    /**
     * 首页产品数据
     * @return
     */
    public Map<String, String> getProductData() {
        return template.selectOne(getFullMapperId("getProductData"));
    }
}
