package com.aoying.loan.cust.app.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.aoying.loan.common.base.dao.BaseDao;
import com.aoying.loan.cust.app.pojo.AppChannelRecordPojo;

/**
 * APP渠道记录 Dao
 * @author nick
 */
@Repository
public class AppChannelRecordDao extends BaseDao<AppChannelRecordPojo> {
    /**
     * 对外渠道
     * @param appChannelRecord
     * @return
     */
    public List<AppChannelRecordPojo> getList(AppChannelRecordPojo appChannelRecord) {
        return this.selectList("getList", appChannelRecord);
    }

    public int updateRegVisits() {
        return this.template.update(getFullMapperId("updateRegVisits"));
    }

    public int updateActVisits() {
        return this.template.update(getFullMapperId("updateActVisits"));
    }

    public int updateProVisits() {
        return this.template.update(getFullMapperId("updateProVisits"));
    }

    public int updateReportVisits() {
        return this.template.update(getFullMapperId("updateReportVisits"));
    }

    public int insertByConfig() {
        return this.template.insert(getFullMapperId("insertByConfig"));
    }
}
