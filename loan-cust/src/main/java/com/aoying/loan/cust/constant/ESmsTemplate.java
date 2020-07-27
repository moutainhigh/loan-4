package com.aoying.loan.cust.constant;

/**
 * 短信模版枚举
 * @author nick
 */
public enum ESmsTemplate {
    /** 审核拒绝 */
    AuditRefused(1, "您的资质不足未通过初审，更多拒绝原因请登录后查询。");

    /** 类型 */
    private Integer type;
    /** 短信模版 */
    private String template;

    ESmsTemplate(Integer type, String template) {
        this.type = type;
        this.template = template;
    }

    /** 获取 类型 */
    public Integer getType() {
        return this.type;
    }

    /** 获取 短信模版 */
    public String getTemplate() {
        return this.template;
    }

}
