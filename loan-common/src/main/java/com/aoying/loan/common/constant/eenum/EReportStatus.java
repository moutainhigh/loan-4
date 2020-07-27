package com.aoying.loan.common.constant.eenum;

/**
 * Status 枚举
 * @author nick
 */
public enum EReportStatus {
    TO_BE_QUERY(10, "待查询"),
    SUCCESS(21, "查询成功"),
    FAIL(22, "查询失败");

    private Integer val;
    private String name;

    EReportStatus(Integer val, String name) {
        this.val = val;
        this.name = name;
    }

    public Integer getVal() {
        return val;
    }

    public String getName() {
        return name;
    }
}
