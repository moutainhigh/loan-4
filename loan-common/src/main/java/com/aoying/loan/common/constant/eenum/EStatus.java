package com.aoying.loan.common.constant.eenum;

/**
 * Status 枚举
 * @author nick
 */
public enum EStatus {
    /** 无效 */
    INVALID(0, "无效"),
    /** 正常 */
    VALID(1, "正常"),
    /** 逻辑删除 */
    DELETE(2, "逻辑删除");

    private Integer val;
    private String name;

    EStatus(Integer val, String name) {
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
