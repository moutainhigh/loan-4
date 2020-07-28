package com.aoying.loan.mgmtservice.loan.controller;

import java.util.List;

import com.ds.api.util.HttpRequestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.aoying.loan.common.base.controller.BaseController;
import com.aoying.loan.common.base.pojo.ResponseData;
import com.aoying.loan.cust.loan.pojo.LoanApplicationForLargePojo;
import com.aoying.loan.cust.loan.service.iservice.ILoanApplicationForLargeService;

/**
 * 大额贷款申请 Controller
 * @author nick
 */
@RestController
@RequestMapping("/loanApplicationForLarge")
public class LoanApplicationForLargeControllerMgmt extends BaseController<LoanApplicationForLargePojo> {
    @Autowired
    private ILoanApplicationForLargeService loanApplicationForLargeService;

    /**
     * @api {post} /loanApplicationForLarge/mgmt/getListPro/v1 MGMT大额获取列表0628
     * @apiGroup loanApplicationForLarge
     *
     * @apiParam {Timestamp} [createTimeBegin] 创建时间开始
     * @apiParam {Timestamp} [createTimeEnd] 创建时间结束
     * @apiParam {String} [channelId] 渠道ID
     * @apiParam {String} [city] 城市
     * @apiParam {String} [submitCode] 提交编码
     *
     * @apiSuccess (成功响应) {String} reqResult 请求结果码、结果信息
     * @apiSuccessExample {json} 成功响应示例:
    {
    "data": [
    {
    }
    ],
    "reqResult": {
    "code": 1,
    "msg": "操作成功"
    }
    }
     */
    @RequestMapping("/mgmt/getListPro/v1")
    public ResponseData getList(LoanApplicationForLargePojo pojo) {
        List<LoanApplicationForLargePojo> result = loanApplicationForLargeService.selectList(pojo);
        return ResponseData.succ(result);
    }

    /**
     * @api {post} /loanApplicationForLarge/mgmt/getPro/v1 MGMT大额获取单个0628
     * @apiGroup loanApplicationForLarge
     *
     * @apiParam {Long} id ID
     *
     * @apiSuccess (成功响应) {String} reqResult 请求结果码、结果信息
     * @apiSuccessExample {json} 成功响应示例:
    {
    "data": [
    {
    }
    ],
    "reqResult": {
    "code": 1,
    "msg": "操作成功"
    }
    }
     */
    @RequestMapping("/mgmt/getPro/v1")
    public ResponseData get(LoanApplicationForLargePojo pojo) {
        LoanApplicationForLargePojo result = loanApplicationForLargeService.selectUnique(pojo);
        return ResponseData.succ(result);
    }

    /**
     * @api {post} /loanApplicationForLarge/mgmt/updatePro/v1 MGMT大额更新0628
     * @apiGroup loanApplicationForLarge
     *
     * @apiUse LoanApplicationForLargePojo
     *
     * @apiSuccess (成功响应) {String} reqResult 请求结果码、结果信息
     * @apiSuccessExample {json} 成功响应示例:
    {
    "reqResult": {
    "code": 1,
    "msg": "操作成功"
    }
    }
     */
    @RequestMapping("/mgmt/updatePro/v1")
    public ResponseData update(LoanApplicationForLargePojo pojo) {
        loanApplicationForLargeService.update(pojo);
        return ResponseData.succ(null);
    }

    /**
     * @api {post} /loanApplicationForLarge/mgmt/sendPro/v1 MGMT大额送件0628
     * @apiGroup loanApplicationForLarge
     *
     * @apiParam {Long} ids ID数组
     * @apiParam {Long} id 送件机构
     *
     * @apiSuccess (成功响应) {String} reqResult 请求结果码、结果信息
     * @apiSuccessExample {json} 成功响应示例:
    {
    "reqResult": {
    "code": 1,
    "msg": "操作成功"
    }
    }
     */
    @RequestMapping("/mgmt/sendPro/dfrz/v1")
    public ResponseData sendDf(List<Long> ids) {
        for (Long id : ids){
            LoanApplicationForLargePojo pojo = loanApplicationForLargeService.selectById(id);
            // 1.查询用户是否存在

            // 2.用户存在则直接失败，用户不存在，则进行同步
        }
        return ResponseData.succ(null);
    }

    @RequestMapping("/mgmt/sendPro/jjd/v1")
    public ResponseData sendJjd(List<Long> ids) {
        return ResponseData.succ(null);
    }
}
