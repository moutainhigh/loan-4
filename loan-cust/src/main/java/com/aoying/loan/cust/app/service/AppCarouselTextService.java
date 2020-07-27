package com.aoying.loan.cust.app.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aoying.loan.cust.app.pojo.AppCarouselTextPojo;
import com.aoying.loan.cust.loan.pojo.LoanProductPojo;
import com.aoying.loan.cust.loan.service.iservice.ILoanProductService;

/**
 * 轮播文字 Service
 * @author nick
 */
@Service
public class AppCarouselTextService {
    @Autowired
    private ILoanProductService loanProductService;

    /**
     * 获取轮播文字列表
     * @param condition
     * @return
     */
    public List<AppCarouselTextPojo> getList(AppCarouselTextPojo condition) {
        String[] firstname = {
                "赵", "钱", "孙", "李",
                "周", "吴", "郑", "王",
                "王", "王", "王", "赵",
                "赵", "赵", "李", "李",
                "李", "张", "张", "张",
                "陈", "徐", "卫", "蒋",
                "沈", "韩", "杨", "秦",
                "许", "何", "吕", "施"};
        String[] sex = {"先生", "女士"};
        String[] telNoPre = {
                "139", "138", "137", "137", "135",
                "159", "158", "152", "151", "150",
                "130", "131", "132", "155", "186",
                "133", "153", "189", "180", "150"};

        // 获取产品列表
        List<LoanProductPojo> products = loanProductService.selectList(new LoanProductPojo());

        // 设置默认每页数据条数
        int pageSize = 20;
        if (condition != null && condition.getPageSize() != null) {
            pageSize = condition.getPageSize();
        }

        // 产生随机数据
        Random r = new Random();
        List<AppCarouselTextPojo> list = new ArrayList<AppCarouselTextPojo>();
        for (int i = 0; i < pageSize; i++) {
            long time = System.currentTimeMillis() - r.nextInt(2*24*3600*1000); // 当前时间-随机数=近两天随机时间

            AppCarouselTextPojo pojo = new AppCarouselTextPojo();
            pojo.setTimestamp(new Timestamp(time));
            pojo.setName(firstname[r.nextInt(firstname.length)] + sex[r.nextInt(sex.length)]);
            pojo.setTelNo(telNoPre[r.nextInt(telNoPre.length)] + "****" + String.format("%04d", r.nextInt(10000)));
            pojo.setAmount((r.nextInt(9) + 2) * 500);
            pojo.setProductName(products.get(r.nextInt(products.size())).getName());
            list.add(pojo);
        }
        return list;
    }
}
