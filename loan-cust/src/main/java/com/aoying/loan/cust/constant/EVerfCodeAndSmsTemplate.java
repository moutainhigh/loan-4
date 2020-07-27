package com.aoying.loan.cust.constant;

import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Stream;

/**
 * 短信验证码模版枚举
 * @author nick
 */
public enum EVerfCodeAndSmsTemplate {
    /** 注册验证码 */
    REGISTER(1, "您此次注册验证码为：{verfCode}，祝您使用愉快。", true),
    /** 登录验证码 */
    LOGIN(2, "您此次登录验证码为：{verfCode}，祝您使用愉快。", true),
    /** 报告查询 */
    REPORT(3, "您此次报告查询验证码为：{verfCode}，祝您使用愉快。", true),
    /** 大额落地页 */
    Large(4, "您此次操作验证码为：{verfCode}，祝您使用愉快。", false);

    /** 验证码类型 */
    private Integer type;
    /** 短信模版 */
    private String template;
    /** 是否使用图形验证码 */
    private Boolean picVerfCode;
    /** 所有状态 */
    private static Map<Integer, EVerfCodeAndSmsTemplate> statusMap;

    EVerfCodeAndSmsTemplate(Integer type, String template, Boolean picVerfCode) {
        this.type = type;
        this.template = template;
        this.picVerfCode = picVerfCode;
    }

    /**
     * 得到所有状态
     *
     * @return
     */
    public static Map<Integer, EVerfCodeAndSmsTemplate> getStatusMap() {
        if (statusMap == null) {
            Map<Integer, EVerfCodeAndSmsTemplate> map = new TreeMap<Integer, EVerfCodeAndSmsTemplate>();
            Stream.of(EVerfCodeAndSmsTemplate.values()).forEach(e -> map.put(e.getType(), e));
            statusMap = map;
        }
        return statusMap;
    }

    /** 获取 验证码类型 */
    public Integer getType() {
        return this.type;
    }

    /** 设置 验证码类型 */
    public void setType(Integer type) {
        this.type = type;
    }

    /** 获取 短信模版 */
    public String getTemplate() {
        return this.template;
    }

    /** 设置 短信模版 */
    public void setTemplate(String template) {
        this.template = template;
    }

    /** 获取 是否使用图形验证码 */
    public Boolean getPicVerfCode() {
        return this.picVerfCode;
    }

    /** 设置 是否使用图形验证码 */
    public void setPicVerfCode(Boolean picVerfCode) {
        this.picVerfCode = picVerfCode;
    }
}
