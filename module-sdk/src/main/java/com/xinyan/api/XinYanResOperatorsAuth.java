package com.xinyan.api;

/**
 * 新颜接口 运营商认证业务响应参数类
 * @author nick
 */
public class XinYanResOperatorsAuth extends XinYanResData {
    /** 在网时长 */
    private Integer length;
    /** 状态 */
    private Integer status;

    /** 获取 在网时长 */
    public Integer getLength() {
        return this.length;
    }

    /** 设置 在网时长 */
    public void setLength(Integer length) {
        this.length = length;
    }

    /** 获取 状态 */
    public Integer getStatus() {
        return this.status;
    }

    /** 设置 状态 */
    public void setStatus(Integer status) {
        this.status = status;
    }
}
