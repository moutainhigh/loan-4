package com.aoying.loan.common.constant.response.code;

import org.slf4j.Logger;
import com.aoying.loan.common.base.pojo.OptResult;

/**
 * 通用响应码
 * @author nick
 */
public enum EResCodeCommon implements IResCode {
    /****************************************************************************************************/
    /**********************************        错误响应码     ********************************************/
    /****************************************************************************************************/
    authSignNoAccount(-9801, "签名账号为空", "签名账号为空"),
    authSignNoTimestamp(-9802, "签名时间戳为空", "签名时间戳为空"),
    authSignNoSign(-9803, "签名为空", "签名为空"),
    authSignExpire(-9811, "签名过期", "签名过期"),
    authSignAccInvalid(-9812, "签名账号无效", "签名账号无效"),
    authSignAccErrType(-9813, "签名账号类型不匹配", "签名账号类型不匹配"),
    authSignAccExpire(-9814, "签名账号过期", "签名账号过期"),
    authSignInvalid(-9815, "签名无效", "签名无效"),


    /** -9980：客户端访问token无效，禁止请求 */
    noClientToken(-9980, "客户端访问禁止请求", EResCodeCommon.accessDenied),
    /** -9981：用户没有登录，无权访问。 */
    noUserToken(-9981, "您还没有登录，无权访问", "您还没有登录，请登录"),
    /** -9982：token过期 */
    errUserToken(-9982, "登录超时，请重新登录", "登录超时，请重新登录"),
    /** -9983：多用户同时登录。 */
    repeatUserToken(-9983, "您已在另一处登录，请确认密码是否外泄", "您已在另一处登录，请确认密码是否外泄"),
    /** -9984：请求无效/无权访问。 */
    errRequest(-9984, "请求无效/无权访问。", "请求无效/无权访问。"),
    /** 系统已升级，请您下载最新app再使用 */
    svceErrAppIsNotNewest(-9985, "该版本已无法继续使用，请更新至最新版本", "该版本已无法继续使用，请更新至最新版本"),


    /** 数据验证：文件路径不能为空 */
    inErrFileFullPathNotNull(-100801, "文件路径不能为空", "文件路径不能为空"),
    /** 业务逻辑：只能上传一个文件 */
    inErrUploadOnlyOneFile(-100803, "只能上传一个文件", "只能上传一个文件"),

    /** 提交失败 */
    svceErrSubmitFail(-200000, "提交失败", "资料提交失败，请稍后再试"),
    /** 获取数据失败 */
    svceErrGetDataFail(-200002, "获取数据失败", "获取数据失败"),
    /** 文件不存在 */
    svceErrFileNotExist(-200005, "文件不存在", "文件不存在"),

    svceErrSmsSendLimit(-201021, "获取验证码次数太多了，请明日再来", "获取验证码次数太多了，请明日再来"),
    /** 短信发送失败 */
    svceErrSmsSendFail(-201025, "短信发送失败。", "短信发送失败。"),

    /** 数据验证：短信验证码不正确 */
    svceErrSmsVerCode(-200108, "验证码错误，请重新输入", "验证码错误，请重新输入"),
    /** 手机号不正确 */
    svceInErrTelNo(-200220,"请输入正确的手机号码", "请输入正确的手机号码"),
    /** 业务逻辑：签名超时/无效 */
    svceErrSysAuthInfoTimeOut(EResCodeCommon.exceptionCode, "账户签名超时/无效。", "签名超时/无效"),
    /****************************************************************************************************/
    /**********************************        异常响应码     ********************************************/
    /****************************************************************************************************/

    /** -9997：服务器开小差。 */
    exptSystemException(EResCodeCommon.exceptionCode, "服务器开小差了，稍后再试！", EResCodeCommon.exceptionMsg),
    exptIllegalArgument(EResCodeCommon.exceptionCode, "参数出现异常，或者参数为空", EResCodeCommon.exceptionMsg),
    userAgentNotExists(EResCodeCommon.exceptionCode, "用户代理不存在，请确认，投保失败", "用户代理不存在，请确认，投保失败"),
    exptDataException(EResCodeCommon.exceptionCode, "资料有误请重新提交", "资料有误请重新提交"),

    /****************************************************************************************************/
    /**********************************        成功响应码     ********************************************/
    /****************************************************************************************************/
    /** 业务逻辑：文件下载成功 */
    svceRigDownVideoFile(EResCodeCommon.optSuccess, "文件下载成功", "文件下载成功"),
    /** 没有发送短信哦 */
    svceRigSmsNoSend(EResCodeCommon.optSuccess, "没有发送短信哦", ""),
    /** 短信已发送成功 */
    svceRigSmsSend(EResCodeCommon.optSuccess, "短信已发送，请注意查收", "短信已发送，请注意查收"),
    /** 验证码认证通过 */
    svceRigVerfiCode(EResCodeCommon.optSuccess, "验证码认证通过", "验证码认证通过"),
    /** 业务逻辑：什么都没做 */
    svceRigDoNothing(EResCodeCommon.optNothing, "什么都没做", ""),
    /** 提交成功 */
    svceRigSubmitSuccess(EResCodeCommon.optSuccess, "提交成功", "提交成功"),
    /** 操作成功 */
    svceRigOptSuccess(EResCodeCommon.optSuccess, "操作成功", "操作成功"),
    /** 获取数据成功 */
    svceRigGetDataSuccess(EResCodeCommon.optSuccess, "获取数据成功", "获取数据成功"),
    /** 新增数据成功 */
    svceRigAddDataSuccess(EResCodeCommon.optSuccess, "新增数据成功", "新增数据成功"),
    /** 更新数据成功 */
    svceRigUpdateDataSuccess(EResCodeCommon.optSuccess, "更新数据成功", "更新数据成功"),
    /** 没有查询到数据 */
    svceRigNoDataSuccess(EResCodeCommon.optSuccess, "没有查询到数据记录", "没有查询到数据记录"),
    /** 提交成功 */
    svceRigSubmitNothingSuccess(EResCodeCommon.optSuccess, "提交成功(nothing)", "提交成功(nothing)"),
    insuranceApplySuccessful(EResCodeCommon.optSuccess, "投保成功", "投保成功"),
    insuranceApplyFailure(EResCodeCommon.optSuccess, "投保失败", "投保失败"),
    insuranceApplyMsgSuccessful(EResCodeCommon.optSuccess, "获取验证码成功", "获取验证码成功")

    ;


    /** 什么都没做 */
    public static final int optNothing = 0;
    /** 操作成功 */
    public static final int optSuccess = 1;
    /** 系统异常 */
    public static final int exceptionCode = -9997;
    /** 系统异常信息 */
    public static final String exceptionMsg = "服务器开小差了，请稍后再试！";
    /** 系统异常信息 */
    public static final String accessDenied = "服务器拒绝访问！";

    /** 消息代码,大于等于0表示正确，小于表示错误 */
    private int code = 0;
    /** 消息内容（内部消息） */
    private String innerMsg;
    /** 消息内容（外部消息） */
    private String msg;

    EResCodeCommon(int code, String innerMsg, String msg) {
        this.code = code;
        this.innerMsg = innerMsg;
        this.msg = msg;
    }

    /**
     * @取得 消息代码大于等于0表示正确，小于表示错误
     */
    @Override
    public int getCode() {
        return code;
    }

    /** @取得 消息内容（外部消息） */
    @Override
    public String getMsg() {
        return msg;
    }

    /**
     * 转换成OptResult对象
     * @return
     */
    @Override
    public OptResult getOptResult(Logger logger) {
        return getOptResult(logger, "");
    }

    /**
     * 转换成OptResult对象
     * @return
     */
    @Override
    public OptResult getOptResult(Logger logger, Object otherMsg) {
        logger.info("{}", new OptResult(code, msg, innerMsg, otherMsg));
        return new OptResult(code, msg);
    }

    /**
     * 转换成OptResult对象
     * @return
     */
    @Override
    public OptResult getOptResult(Logger logger, Object otherMsg, Exception e) {
        logger.error("{}", new OptResult(code, msg, innerMsg, otherMsg), e);
        return new OptResult(code, msg);
    }
}
