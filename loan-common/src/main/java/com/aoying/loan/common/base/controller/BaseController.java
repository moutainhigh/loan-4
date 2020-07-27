package com.aoying.loan.common.base.controller;

import java.sql.Timestamp;
import com.aoying.loan.common.base.pojo.BasePojo;

/**
 * @author nick
 */
public class BaseController<T extends BasePojo> extends AbsBaseController<T> {
    /**
     * 设置创建者
     * @param pojo
     */
    protected void setCreater(BasePojo pojo) {
        pojo.setCreaterId(-1L);
        pojo.setCreaterName("admin");
        pojo.setCreateTime(new Timestamp(System.currentTimeMillis()));
    }

    /**
     * 设置修改者
     * @param pojo
     */
    protected void setMod(BasePojo pojo) {
        pojo.setModId(-1L);
        pojo.setModName("admin");
        pojo.setModTime(new Timestamp(System.currentTimeMillis()));
    }
}
