package com.dongfang.api;

public class User{
    public String cityName;
    public String cellPhoneNumber;
    public String realName;
    public Integer loanAmount;
    public int utmSource;
    public String timeStamp;
    public String signature;
    public String utmChildSource;

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCellPhoneNumber() {
        return cellPhoneNumber;
    }

    public void setCellPhoneNumber(String cellPhoneNumber) {
        this.cellPhoneNumber = cellPhoneNumber;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Integer getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(Integer loanAmount) {
        this.loanAmount = loanAmount;
    }

    public int getUtmSource() {
        return utmSource;
    }

    public void setUtmSource(int utmSource) {
        this.utmSource = utmSource;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getUtmChildSource() {
        return utmChildSource;
    }

    public void setUtmChildSource(String utmChildSource) {
        this.utmChildSource = utmChildSource;
    }

}

