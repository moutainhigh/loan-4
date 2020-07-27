package com.aoying.loan.common.constant.eenum;

/**
 * APP ID 枚举
 * @author nick
 */
public enum EAppId {
    /** 默认 */
    DEFAULT(10, "默认");

    private Integer val;
    private String name;

    EAppId(Integer val, String name) {
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
