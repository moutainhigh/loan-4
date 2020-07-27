package com.aoying.module.sdk.base;

import java.io.Serializable;
import com.alibaba.fastjson.JSON;

/**
 * 基类
 * @author nick
 */
public class BasePojo implements Serializable {
    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
