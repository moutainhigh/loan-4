package com.aoying.loan.cust.cust.dao;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import com.aoying.loan.common.base.dao.BaseDao;
import com.aoying.loan.cust.cust.pojo.CustInfoPojo;

/**
 * @功能:【custinfo 用户信息表】Dao
 * @项目名:loan-cust
 * @作者:nick
 * @日期:2018-11-30 10:53:19
 * @说明：<pre></pre>
 */
@Repository
public class CustInfoDao extends BaseDao<CustInfoPojo> {
    /**
     * 注册量按渠道查，每行一日期，每列一渠道
     * @param pojo
     * @return
     */
    public List<Map<String, String>> getRegByCh(CustInfoPojo pojo) {
        return this.template.selectList(getFullMapperId("getRegByCh"), pojo);
    }

    /**
     * 注册量所有渠道，每行一渠道，只有一列合计
     * @param pojo
     * @return
     */
    public List<Map<String, String>> getRegAll(CustInfoPojo pojo) {
        return this.template.selectList(getFullMapperId("getRegAll"), pojo);
    }

    /**
     * 首页注册数据
     * @return
     */
    public Map<String, String> getRegistrationData() {
        return this.template.selectOne(getFullMapperId("getRegistrationData"));
    }

    /**
     * 获取用户信息
     * @return
     */
    public CustInfoPojo getById(CustInfoPojo pojo) {
        return this.selectUnique("getById", pojo);
    }
}
