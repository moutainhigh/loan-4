package com.aoying.loan.cust.app.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.aoying.loan.common.base.service.BaseService;
import com.aoying.loan.cust.app.dao.AppChannelRecordDao;
import com.aoying.loan.cust.app.pojo.AppChannelRecordPojo;
import com.aoying.loan.cust.app.service.iservice.IAppChannelRecordService;

/**
 * APP渠道记录 Service
 * @author nick
 */
@Service
public class AppChannelRecordService extends BaseService<AppChannelRecordPojo, AppChannelRecordDao> implements IAppChannelRecordService {
    /**
     * 对外渠道
     * @param appChannelRecord
     * @return
     */
    @Override
    public List<AppChannelRecordPojo> getList(AppChannelRecordPojo appChannelRecord) {
        return dao.getList(appChannelRecord);
    }

    @Override
    public int updateRegVisits() {
        return dao.updateRegVisits();
    }

    @Override
    public int updateActVisits() {
        return dao.updateActVisits();
    }

    @Override
    public int updateProVisits() {
        return dao.updateProVisits();
    }

    @Override
    public int updateReportVisits() {
        return dao.updateReportVisits();
    }

    @Override
    public int insertByConfig() {
        return dao.insertByConfig();
    }
}
