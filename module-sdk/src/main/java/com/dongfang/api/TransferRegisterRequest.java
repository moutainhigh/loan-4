package com.dongfang.api;

import com.aoying.module.sdk.base.BasePojo;

public class TransferRegisterRequest extends BasePojo {

    public int utmSource;

    public String encryptionData;


    public int getUtmSource() {
        return utmSource;
    }

    public void setUtmSource(int utmSource) {
        this.utmSource = utmSource;
    }

    public String getEncryptionData() {
        return encryptionData;
    }

    public void setEncryptionData(String encryptionData) {
        this.encryptionData = encryptionData;
    }

}
