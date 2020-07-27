package com.ds.api;

import com.aoying.module.sdk.base.BasePojo;

/**
 * @author nick
 */
public class DsResData extends BasePojo {
    private String tradeNo;

    private String respCode;

    private String respDesc;

    private String idName;

    private String idCard;

    private String phone;

    private String onlineTime;

    private String onlineStatus;

    private DsResDataDetail detail;

    public String getTradeNo() {
        return this.tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public String getRespCode() {
        return this.respCode;
    }

    public void setRespCode(String respCode) {
        this.respCode = respCode;
    }

    public String getRespDesc() {
        return this.respDesc;
    }

    public void setRespDesc(String respDesc) {
        this.respDesc = respDesc;
    }

    public String getIdName() {
        return this.idName;
    }

    public void setIdName(String idName) {
        this.idName = idName;
    }

    public String getIdCard() {
        return this.idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOnlineTime() {
        return this.onlineTime;
    }

    public void setOnlineTime(String onlineTime) {
        this.onlineTime = onlineTime;
    }

    public String getOnlineStatus() {
        return this.onlineStatus;
    }

    public void setOnlineStatus(String onlineStatus) {
        this.onlineStatus = onlineStatus;
    }

    public DsResDataDetail getDetail() {
        return this.detail;
    }

    public void setDetail(DsResDataDetail detail) {
        this.detail = detail;
    }
}
