package com.aoying.loan.cust.loan.service.iservice;

import java.util.List;
import java.util.Map;
import com.aoying.loan.common.base.service.iservice.IBaseService;
import com.aoying.loan.cust.loan.pojo.LoanProductClickLogPojo;
import com.aoying.loan.cust.loan.pojo.LoanProductPojo;

/**
 * @功能:【loanproduct 贷款产品表】IService
 * @项目名:loan-cust
 * @作者:nick
 * @日期:2018-12-02 15:43:52
 * @说明：<pre></pre>
 */
public interface ILoanProductService extends IBaseService<LoanProductPojo> {
    /**
     * 获取贷款产品列表
     * @param loanProduct
     * @return
     */
    List<LoanProductPojo> getList(LoanProductPojo loanProduct);

    /**
     * 随机获取一个产品的URL
     * @return
     */
    String getUrl();

    /**
     * 新增贷款产品
     * @param loanProduct
     * @return
     */
    int addProduct(LoanProductPojo loanProduct);

    /**
     * 增加点击量
     * @param id
     * @return
     */
    int addPv(Long id);

    /**
     * 增加点击量V2
     * @param pojo
     */
    void addPvV2(LoanProductClickLogPojo pojo);

    /**
     * 更新贷款产品
     * @param loanProduct
     * @return
     */
    int updateProduct(LoanProductPojo loanProduct);

    /**
     * 更新排序
     * @param idsStr
     */
    void updateOrder(String idsStr);

    /**
     * 更新申请人数，每次随机增加0～3人
     */
    int updateApplyNum();

    /**
     * 首页产品数据
     * @return
     */
    Map<String, String> getProductData();
}
