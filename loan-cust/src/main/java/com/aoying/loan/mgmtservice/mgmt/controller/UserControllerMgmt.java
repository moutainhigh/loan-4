package com.aoying.loan.mgmtservice.mgmt.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.aoying.loan.common.base.controller.BaseController;
import com.aoying.loan.common.base.pojo.ResponseData;
import com.aoying.loan.common.config.redis.BaseRedisDao;
import com.aoying.loan.common.constant.eenum.ERedisCacheKey;
import com.aoying.loan.common.constant.response.code.EResCodeCommon;
import com.aoying.loan.common.constant.response.exception.CustomMsgException;
import com.aoying.loan.common.constant.response.exception.DefineMsgException;
import com.aoying.loan.common.util.HttpTool;
import com.aoying.loan.mgmtservice.mgmt.pojo.User;

/**
 * @author nick
 */
@RestController
@RequestMapping("/mgmtUser")
public class UserControllerMgmt extends BaseController {
    private String tokenName = "X_AdminToken";

    private List<User> users;

    @Autowired
    @Qualifier("baseRedisDaoDef")
    private BaseRedisDao baseRedisDao;

    /**
     * redis-cli
     * select 1
     * get mgmtUsers
     * set mgmtUsers "[{\"account\":\"lzt\",\"password\":\"lzt@aoying\",\"pwdErrTimes\":0},{\"account\":\"xx\",\"password\":\"123654Abc\",\"pwdErrTimes\":0},{\"account\":\"bjw\",\"password\":\"bjw@aoying\",\"pwdErrTimes\":0,\"token\":\"B088129EE1604F0E998D4B78DFFA5038\"},{\"account\":\"shj\",\"password\":\"shj@aoying\",\"pwdErrTimes\":0,\"token\":\"FAA61141E92140418587284330722BD0\"}]"
     */
    @PostConstruct
    private void init() {
        users = baseRedisDao.getList(ERedisCacheKey.MGMT_USERS.getVal(), User.class);
        if (users == null) {
            users = new ArrayList<User>();
            users.add(new User("lzt", "tt923@aoying"));
            users.add(new User("xx", "xx@aoying"));
            users.add(new User("bjw", "bjw@aoying"));
            users.add(new User("shj", "shj@aoying"));
            users.add(new User("fal", "fal@aoying"));
            baseRedisDao.saveOrUpdate(ERedisCacheKey.MGMT_USERS.getVal(), users);
        }
        logger.info("初始化管理后台用户 {}", users);
    }

    /**
     * @api {post} /mgmtUser/mgmt/loginPub/v1 MGMT登录
     * @apiGroup mgmtUser
     *
     * @apiParam {String} name 账号
     * @apiParam {String} pwd 密码
     *
     * @apiSuccess (成功响应) {String} reqResult 请求结果码、结果信息
     * @apiSuccess (成功响应) {String} data X_AdminToken
     * @apiSuccessExample {json} 无需验证码响应示例:
    {
    "data": "CE9973B71C4B45FBACF448A9FF087D59",
    "reqResult": {
    "code": 1,
    "msg": "操作成功"
    }
    }
     */
    @RequestMapping(value = "/mgmt/loginPub/v1")
    public ResponseData login(String name, String pwd) throws CustomMsgException {
        for (User u : users) {
            if (u.getAccount().equals(name)) {
                // 检查密码错误次数
                if (u.getPwdErrTimes() == 5) { return ResponseData.fail("登录错误太频繁请联系管理员"); }

                // 检查密码是否正确
                if (u.getPassword().equals(pwd)) {
                    u.setToken(UUID.randomUUID().toString().replace("-", "").toUpperCase());
                    u.setPwdErrTimes(0);
                    baseRedisDao.saveOrUpdate(ERedisCacheKey.MGMT_USERS.getVal(), users);
                    return ResponseData.succ(u.getToken());
                } else {
                    u.setPwdErrTimes(u.getPwdErrTimes() + 1);
                    baseRedisDao.saveOrUpdate(ERedisCacheKey.MGMT_USERS.getVal(), users);
                    return ResponseData.fail("账号或密码不正确");
                }
            }
        }

        return ResponseData.fail("账号或密码不正确");
    }

    public User checkLogin(HttpServletRequest request) throws DefineMsgException {
        String token = HttpTool.getParameterFromRequest(request, tokenName);
        if (token == null) {
            throw new DefineMsgException(EResCodeCommon.errUserToken);
        }

        for (User u : users) {
            if (token.equals(u.getToken())) {
                return u;
            }
        }

        throw new DefineMsgException(EResCodeCommon.errUserToken);
    }
}
