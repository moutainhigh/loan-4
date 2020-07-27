package com.ds.api;

import com.aoying.module.sdk.base.BasePojo;

/**
 * @author nick
 */
public class DsResDataDetail extends BasePojo {
    private Double boolScore;

    private Double score;

    public Double getBoolScore() {
        return this.boolScore;
    }

    public void setBoolScore(Double boolScore) {
        this.boolScore = boolScore;
    }

    public Double getScore() {
        return this.score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}
