package com.xinyan.api;

import com.aoying.module.sdk.base.BasePojo;

/**
 * 新颜接口 业务响应参数类
 * @author nick
 */
public class XinYanResData extends BasePojo {
    /** 认证结果码 */
    private Integer code;
    /** 认证结果描述 */
    private String desc;
    /** 商户订单号 */
    private String trans_id;
    /** 交易流水号 */
    private String trade_no;
    /** 是否收费 */
    private String fee;

    /** 获取 认证结果码 */
    public Integer getCode() {
        return this.code;
    }

    /** 设置 认证结果码 */
    public void setCode(Integer code) {
        this.code = code;
    }

    /** 获取 认证结果描述 */
    public String getDesc() {
        return this.desc;
    }

    /** 设置 认证结果描述 */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /** 获取 商户订单号 */
    public String getTrans_id() {
        return this.trans_id;
    }

    /** 设置 商户订单号 */
    public void setTrans_id(String trans_id) {
        this.trans_id = trans_id;
    }

    /** 获取 交易流水号 */
    public String getTrade_no() {
        return this.trade_no;
    }

    /** 设置 交易流水号 */
    public void setTrade_no(String trade_no) {
        this.trade_no = trade_no;
    }

    /** 获取 是否收费 */
    public String getFee() {
        return this.fee;
    }

    /** 设置 是否收费 */
    public void setFee(String fee) {
        this.fee = fee;
    }

    public enum Code {
        /** 认证成功 */
        SUCC(0, "认证成功"),
        /** 认证信息不一致 */
        DIFF(1, "认证信息不一致"),
        /** 认证信息不存在 */
        NON_EXISTENT(2, "认证信息不存在"),
        /** 其他异常 */
        OTHER(9, "其他异常");

        private Integer val;
        private String name;

        Code(Integer val, String name) {
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
}
