package com.aoying.loan.cust.loan.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aoying.loan.common.base.service.BaseService;
import com.aoying.loan.cust.loan.dao.LoanProductDao;
import com.aoying.loan.cust.loan.pojo.LoanProductClickLogPojo;
import com.aoying.loan.cust.loan.pojo.LoanProductPojo;
import com.aoying.loan.cust.loan.service.iservice.ILoanProductClickLogService;
import com.aoying.loan.cust.loan.service.iservice.ILoanProductService;

/**
 * 贷款产品表 Service
 * @author nick
 */
@Service
public class LoanProductService extends BaseService<LoanProductPojo, LoanProductDao> implements ILoanProductService {
    @Autowired
    private ILoanProductClickLogService loanProductClickLogService;

    /**
     * 获取贷款产品列表
     * @param loanProduct
     * @return
     */
    @Override
    public List<LoanProductPojo> getList(LoanProductPojo loanProduct) {
        return dao.selectList(loanProduct);
    }

    /**
     * 随机获取一个产品的URL
     * @return
     */
    @Override
    public String getUrl() {
        LoanProductPojo loanProduct = new LoanProductPojo();
        loanProduct.setShortUrl(LoanProductPojo.EShortUrl.YES.getVal());
        loanProduct.setStatus(LoanProductPojo.EStatus.NORMAL.getVal());
        List<LoanProductPojo> list = dao.selectList(loanProduct);

        Random random = new Random();
        int i = random.nextInt(list.size());
        return list.get(i).getUrl();
    }

    /**
     * 新增贷款产品
     * @param loanProduct
     * @return
     */
    @Override
    public int addProduct(LoanProductPojo loanProduct) {
        loanProduct.setOrderCode(0);
        loanProduct.setPv(0);

        Integer base = LoanProductPojo.OrderByType.getBase(loanProduct.getOrderByType());
        loanProduct.setOrderCode(base);

        loanProduct.setCreaterId(-1L);
        loanProduct.setCreaterName("admin");
        loanProduct.setCreateTime(new Timestamp(System.currentTimeMillis()));

        return this.insert(loanProduct);
    }

    /**
     * 增加点击量
     * @param id
     * @return
     */
    @Override
    public int addPv(Long id) {
        return dao.addPv(id);
    }

    /**
     * 增加点击量V2
     * @param pojo
     */
    @Override
    public void addPvV2(LoanProductClickLogPojo pojo) {
        pojo.setCreateTime(new Timestamp(System.currentTimeMillis()));
        loanProductClickLogService.insert(pojo);
        dao.addPv(pojo.getProductId());
    }

    /**
     * 更新贷款产品
     * @param loanProduct
     * @return
     */
    @Override
    public int updateProduct(LoanProductPojo loanProduct) {
        Integer base = LoanProductPojo.OrderByType.getBase(loanProduct.getOrderByType());
        loanProduct.setOrderCode(base);

        loanProduct.setModId(-1L);
        loanProduct.setModName("admin");
        loanProduct.setModTime(new Timestamp(System.currentTimeMillis()));

        return this.update(loanProduct);
    }

    /**
     * 更新排序
     * @param idsStr
     */
    @Override
    public void updateOrder(String idsStr) {
        List<LoanProductPojo> list = new ArrayList<LoanProductPojo>();
        String[] idsArr = idsStr.split(",");
        for (int i = 0; i < idsArr.length; i++) {
            LoanProductPojo p = new LoanProductPojo();
            p.setId(Long.parseLong(idsArr[i]));
            p.setOrderCode(LoanProductPojo.OrderByType.MANUAL.getOrderCodeBase() + idsArr.length - i);
            list.add(p);
        }
        dao.updateList(list);
    }

    /**
     * 更新申请人数，每次随机增加0～3人
     */
    @Override
    public int updateApplyNum() {
        return dao.updateApplyNum();
    }

    /**
     * 首页产品数据
     * @return
     */
    @Override
    public Map<String, String> getProductData() {
        return dao.getProductData();
    }
}
