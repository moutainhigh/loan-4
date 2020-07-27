package com.ds.api;

import com.aoying.module.sdk.base.BasePojo;

/**
 * @author nick
 */
public class DsRes extends BasePojo {
    private String code;

    private String msg;

    private DsResData data;

    private String resJson;

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DsResData getData() {
        return this.data;
    }

    public void setData(DsResData data) {
        this.data = data;
    }

    public String getResJson() {
        return this.resJson;
    }

    public void setResJson(String resJson) {
        this.resJson = resJson;
    }

    public enum ECode {
        SUCC("016_0000", "查询成功");

        private String val;
        private String name;

        ECode(String val, String name) {
            this.val = val;
            this.name = name;
        }

        public String getVal() {
            return val;
        }

        public String getName() {
            return name;
        }
    }
}
