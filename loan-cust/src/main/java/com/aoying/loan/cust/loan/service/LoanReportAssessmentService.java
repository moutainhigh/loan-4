package com.aoying.loan.cust.loan.service;

import java.sql.Timestamp;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSONObject;
import com.aoying.loan.common.base.service.BaseService;
import com.aoying.loan.common.constant.eenum.EReportStatus;
import com.aoying.loan.cust.loan.dao.LoanReportAssessmentDao;
import com.aoying.loan.cust.loan.pojo.LoanReportAssessmentPojo;
import com.aoying.loan.cust.loan.service.iservice.ILoanReportAssessmentService;

/**
 * 贷款报告之明镜 Service
 * @author nick
 */
@Service
public class LoanReportAssessmentService extends BaseService<LoanReportAssessmentPojo, LoanReportAssessmentDao> implements ILoanReportAssessmentService {
    /**
     * 明镜评估
     * @param custId
     * @param orderId
     * @param resStr
     */
    @Override
    public void add(Long custId, Long orderId, String resStr) {
        LoanReportAssessmentPojo ass = new LoanReportAssessmentPojo();
        ass.setCustId(custId);
        ass.setOrderId(orderId);
        ass.setCreateTime(new Timestamp(System.currentTimeMillis()));
        ass.setResultJson(resStr);
        ass.setStatus(EReportStatus.SUCCESS.getVal());

        // 明镜SDK响应结果解析
        logger.info("明镜SDK结果 {}", resStr);
        try {
            String succCode = "00000";
            JSONObject resObj = JSONObject.parseObject(resStr);
            if (succCode.equals(resObj.getString("responseCode"))) {
                ass.setStatus(EReportStatus.SUCCESS.getVal());
                ass.setTransId(resObj.getJSONObject("radarInfo").getString("trans_id"));
                ass.setLoanBlack(resObj.getJSONObject("radarInfo").getJSONObject("result_detail").getString("loan_black"));
                ass.setIntegrityBlack(resObj.getJSONObject("radarInfo").getJSONObject("result_detail").getString("integrity_black"));
                ass.setCheatBlack(resObj.getJSONObject("radarInfo").getJSONObject("result_detail").getString("cheat_black"));
            } else {
                ass.setStatus(EReportStatus.FAIL.getVal());
            }
        } catch (Exception e) {
            logger.error("明镜SDK响应结果解析异常", e);
        }

        dao.insert(ass);
    }

}
