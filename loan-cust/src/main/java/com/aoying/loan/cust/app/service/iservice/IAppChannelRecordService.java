package com.aoying.loan.cust.app.service.iservice;

import java.util.List;
import com.aoying.loan.common.base.service.iservice.IBaseService;
import com.aoying.loan.cust.app.pojo.AppChannelRecordPojo;

/**
 * APP渠道记录 IService
 * @author nick
 */
public interface IAppChannelRecordService extends IBaseService<AppChannelRecordPojo> {
    /**
     * 对外渠道
     * @param appChannelRecord
     * @return
     */
    List<AppChannelRecordPojo> getList(AppChannelRecordPojo appChannelRecord);

    int updateRegVisits();

    int updateActVisits();

    int updateProVisits();

    int updateReportVisits();

    int insertByConfig();
}
