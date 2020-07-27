package com.aoying.loan.cust.loan.service;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import com.aoying.loan.common.base.service.BaseService;
import com.aoying.loan.common.constant.eenum.EReportStatus;
import com.aoying.loan.common.constant.response.exception.DefineMsgException;
import com.aoying.loan.cust.api.ThirdPartyApiDs;
import com.aoying.loan.cust.cust.pojo.CustInfoPojo;
import com.aoying.loan.cust.cust.service.iservice.ICustInfoService;
import com.aoying.loan.cust.loan.dao.LoanReportDao;
import com.aoying.loan.cust.loan.pojo.LoanReportOperatorsPojo;
import com.aoying.loan.cust.loan.pojo.LoanReportPojo;
import com.aoying.loan.cust.loan.service.iservice.ILoanReportOperatorsService;
import com.aoying.loan.cust.loan.service.iservice.ILoanReportService;

/**
 * 贷款报告 Service
 * @author nick
 */
@Service
public class LoanReportService extends BaseService<LoanReportPojo, LoanReportDao> implements ILoanReportService {
    @Autowired
    private ThirdPartyApiDs thirdPartyApiDs;
    @Autowired
    private ILoanReportOperatorsService loanReportOperatorsService;
    @Autowired
    private ICustInfoService custInfoService;

    @Value("${sysCfg.loanReportUpdateLimit}")
    private Long loanReportUpdateLimit;

    /**
     * 检查是否需要更新报告
     * @param custId
     * @return
     */
    @Override
    public Boolean checkUpdatable(Long custId) {
        Long now = System.currentTimeMillis();
        Long before = now - loanReportUpdateLimit;

        // 非会员或会员过期不能更新报告
        CustInfoPojo cust = new CustInfoPojo();
        cust.setId(custId);
        cust = custInfoService.selectUnique(cust);
        if (cust == null || cust.getVipExpTime() == null ||
                new Timestamp(now).after(cust.getVipExpTime())) { return false; }

        // 限定时间间隔内，不更新报告
        LoanReportPojo rpt = new LoanReportPojo();
        rpt.setCustId(custId);
        rpt = dao.selectUnique(rpt);
        if (rpt != null && new Timestamp(before).before(rpt.getCreateTime())) { return false; }

        return true;
    }

    /**
     * 全景雷达
     * @param loanReport
     * @throws DefineMsgException
     * @throws IOException
     */
    @Override
    public LoanReportPojo add(LoanReportPojo loanReport) throws DefineMsgException, IOException {
        Assert.notNull(loanReport.getCustId(), "用户信息缺失");
        Assert.notNull(loanReport.getTelNo(), "手机号缺失");
        Assert.notNull(loanReport.getIdCardCode(), "姓名缺失");
        Assert.notNull(loanReport.getIdCardName(), "身份证号缺失");

        Long now = System.currentTimeMillis();

        Map<String, Object> reportMap = thirdPartyApiDs.report(loanReport.getIdCardCode(), loanReport.getIdCardName(), loanReport.getTelNo());
        loanReport.setCreateTime(new Timestamp(now));
        loanReport.setReportJson((String) reportMap.get("json"));
        loanReport.setResultScore((Double) reportMap.get("score"));
        loanReport.setResultBoolScore((Double) reportMap.get("boolScore"));
        loanReport.setStatus(EReportStatus.SUCCESS.getVal());

        Map<String, Object> optMap = thirdPartyApiDs.operators(loanReport.getIdCardCode(), loanReport.getIdCardName(), loanReport.getTelNo());
        LoanReportOperatorsPojo opt = new LoanReportOperatorsPojo();
        opt.setCustId(loanReport.getCustId());
        opt.setIdCardName(loanReport.getIdCardName());
        opt.setIdCardCode(loanReport.getIdCardCode());
        opt.setTelNo(loanReport.getTelNo());
        opt.setCreateTime(new Timestamp(now));
        opt.setResultJson((String) optMap.get("json"));
        opt.setResultCode((Integer) optMap.get("auth"));
        opt.setResultLength((Integer) optMap.get("length"));
        opt.setResultStatus((Integer) optMap.get("status"));
        opt.setStatus(EReportStatus.SUCCESS.getVal());

        dao.insert(loanReport);

        opt.setReportId(loanReport.getId());
        loanReportOperatorsService.insert(opt);

        loanReport.setOperators(opt);
        return loanReport;
    }

    /**
     * 首页报告数据
     * @return
     */
    @Override
    public Map<String, String> getReportData() {
        return dao.getReportData();
    }
}
