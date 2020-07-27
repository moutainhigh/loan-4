package com.aoying.loan.cust.app.pojo;

import java.sql.Timestamp;
import com.aoying.loan.common.base.pojo.BasePojo;

/**
 * 轮播文字 Pojo
 * @author nick
 */
public class AppCarouselTextPojo extends BasePojo {
    /** 时间 */
    private Timestamp timestamp;
    /** 姓名 */
    private String name;
    /** 电话 */
    private String telNo;
    /** 金额 */
    private Integer amount;
    /** 产品名称 */
    private String productName;

    /** 获取 时间 */
    public Timestamp getTimestamp() {
        return this.timestamp;
    }

    /** 设置 时间 */
    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    /** 获取 姓名 */
    public String getName() {
        return this.name;
    }

    /** 设置 姓名 */
    public void setName(String name) {
        this.name = name;
    }

    /** 获取 电话 */
    public String getTelNo() {
        return this.telNo;
    }

    /** 设置 电话 */
    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    /** 获取 金额 */
    public Integer getAmount() {
        return this.amount;
    }

    /** 设置 金额 */
    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    /** 获取 产品名称 */
    public String getProductName() {
        return this.productName;
    }

    /** 设置 产品名称 */
    public void setProductName(String productName) {
        this.productName = productName;
    }
}
