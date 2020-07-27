package com.aoying.loan.common.constant.response.code;

import org.slf4j.Logger;
import com.aoying.loan.common.base.pojo.OptResult;

/**
 * 项目：bdfenqi 20开头
 * 日期：2018年2018月20日
 * 作者：班贺
 * 功能：cust模块相关响应码
 */
public enum EResCodeCust implements IResCode {

    /** 已实名 */
    svceErrAuthIdCardAlready(-210007, "该账号已实名", "该账号已实名"),
    /** 实名失败 */
    svceErrAuthIdCardErr(-210008, "实名认证失败，请检查身份证号码与姓名是否相符", "实名认证失败，请检查身份证号码与姓名是否相符"),
    /** 实名重复 */
    svceErrAuthIdCardRepeat(-210009, "该身份证号码已认证，请输入新的身份证号码", "该身份证号码已认证，请输入新的身份证号码"),
    /** 实名超限 */
    svceErrAuthIdCardOverLimit(-210010, "实名认证次数超过限制，请联系客服", "实名认证次数超过限制，请联系客服"),

    /** 报告超限 */
    svceErrReportOverLimit(-220010, "获取报告次数超过限制，请明天再试", "获取报告次数超过限制，请明天再试"),

    /****************************************************************************************************/
    /**********************************        错误响应码     ********************************************/
    /****************************************************************************************************/
    /** 密码错误,可添加：{remainErrTimes}参数 */
    svceErrLoginPwdError(-200001, "密码错误，慢慢来，还有{remainErrTimes}次机会。", "密码错误，慢慢来，还有{remainErrTimes}次机会"),
    /** 用户登录：账号不存在或密码错误 */
    svceErrAccNoExistOrPwdError(-200002, "手机号码不存在，请重新输入", "手机号码不存在，请重新输入"),
    /** 您的账号已被临时锁定 */
    svceErrLoginlocked(-200003, "密码错误次数超过限制，请明日再来", "密码错误次数超过限制，请明日再来"),
    /** 账号已禁止登录 */
    svceErrAccIsDisable(-200004, "您的账号已禁止登录，请联系客服", "您的账号已禁止登录，请联系客服"),
    /** 没有找到对应的微信授权登录openId。 */
    svceErrNoWxOpenId(-200005, "没有找到对应的微信授权登录openId。", "请先授权微信登陆，并完成手机绑定。"),
    /** 该手机号已被注册【固定编号】 */
    svceErrTelNoIsReged(-200006, "手机号已注册，请直接登录", "手机号已注册，请直接登录"),
    /** 数据验证：请输入6-12位密码 */
    svceInErrPwd(-200007,"请输入6-12位密码", "请输入6-12位密码"),
    /** 数据验证：验证码为空 */
    svceInErrVerCodeNotNull(-200008,"请输入4位验证码", EResCodeCommon.accessDenied),
    /** 设备类型不能为空 */
    svceInErrDeviceIdNotNull(-200009,"设备类型不能为空", EResCodeCommon.accessDenied),
    /** 渠道编号不能为空 */
    svceInErrChannelId(-200010,"渠道编号不能为空", EResCodeCommon.accessDenied),
    /** app版本号不能为空 */
    svceInErrAppVerText(-200011,"app版本号不能为空", EResCodeCommon.accessDenied),
    /** appId不能为空 */
    svceInErrAppId(-200012,"appId不能为空", EResCodeCommon.accessDenied),
    /** 修改密码，手机号不存在 */
    svceErrTelNoNotExist(-200013, "手机号码不存在，请重新输入", "手机号码不存在，请重新输入"),
    /** 原登录密码错误 */
    svceErrOldPwdIsError(-200014, "原登录密码错误", "原登录密码错误"),
    /** 新密码不能和原密码相同 */
    svceErrOldPwdEqualsNewPwd(-200015, "新密码不能和原密码相同，请换一个吧", "新密码不能和原密码相同，请换一个吧"),
    /** 身份证号码不能为空 */
    svceErrIdCardEmpty(-200016,"身份证号码不能为空","身份证号码不能为空"),
    /** 身份证号码不正确 */
    svceErrIdCardCode(-2000017,"身份证号码不正确","身份证号码不正确"),
    /** 手机号不能为空 */
    svceErrTelNoEmpty(-200018, "手机号不能为空", "手机号不能为空"),
    /** 上传头像失败 */
    svceErrUploadCustHeaderImg(-200020, "上传头像失败", "上传头像失败"),
    /** 数据验证：请输入6-12位新密码 */
    svceErrNewPwd(-200021, "请输入6-12位新密码","请输入6-12位新密码"),
    /** 数据验证：请输入6-12位原密码 */
    svceErrOldPwd(-200022, "请输入6-12位原密码", "请输入6-12位原密码"),
    /** 数据验证：请输入6-12位密码 */
    inErrPwd(-200023, "请输入6-12位密码", "请输入6-12位密码"),
    /** 修改头像资料失败 */
    svceErrUpdateCustInfo(-200024,"资料修改失败","资料修改失败"),
    /** 客户还未提交基本资料 */
    svceErrBasicInfoEmpty(-200025,"请先完成实名认证！","请先完成实名认证！"),
    /***/
    svceErrPicCodeLength(-200026,"请输入正确的图形验证码","请输入正确的图形验证码"),

    svceErrExpiredPicCodeLength(-200027,"验证码不正确或已过期！","验证码不正确或已过期！"),
    /** 修改手机号时，新手机号已被注册 */
    svceErrModTelNoIsReged(-200028, "对不起，手机号已被使用了，换一个吧。", "对不起，手机号已被使用了，换一个吧。"),

    /****************************************************************************************************/
    /**********************************        系统异常响应码     ********************************************/
    /****************************************************************************************************/

    /** 注册失败 */
    svceErrRegister(EResCodeCommon.exceptionCode, "注册失败", EResCodeCommon.exceptionMsg),
    /** 系统异常：登录失败，请稍后再试 */
    exptLogin(EResCodeCommon.exceptionCode, "登录失败，请稍后再试", EResCodeCommon.exceptionMsg),
    /** 系统异常：退出失败，请稍后再试 */
    exptLoginOut(EResCodeCommon.exceptionCode, "退出失败，请稍后再试", EResCodeCommon.exceptionMsg),
    /** 修改登录密码失败，请稍后再试 */
    svceErrRestLoginPwd(EResCodeCommon.exceptionCode, "修改登录密码失败，请稍后再试", EResCodeCommon.exceptionMsg),
    /** 修改资料异常 */
    exptUpdateCustInfo(EResCodeCommon.exceptionCode,"资料修改失败",EResCodeCommon.exceptionMsg),
    /** 联系人和通话记录提交失败 */
    exptSubmitContactAndCallInfo(EResCodeCommon.exceptionCode,"系统异常：联系人和通话记录提交失败，请稍后再试",EResCodeCommon.exceptionMsg),
    /** 提交设备信息异常 */
    exptSubmitDeviceInfo(EResCodeCommon.exceptionCode,"系统异常：提交设备信息异常，请稍后再试",EResCodeCommon.exceptionMsg),
    /** 系统异常：修改支付密码失败，请稍后再试 */
    exptSetPayPwd(EResCodeCommon.exceptionCode, "修改支付密码失败，请稍后再试", EResCodeCommon.exceptionMsg),
    /** 验证身份证号码后六位失败 */
    exptCheckIdCardCode(EResCodeCommon.exceptionCode, "验证身份证号码后六位失败", EResCodeCommon.exceptionMsg),
    /** 校验手机号出现异常 */
    svceErrCheckTelNo(EResCodeCommon.exceptionCode,"校验手机号出现异常", EResCodeCommon.exceptionMsg),
    /****************************************************************************************************/
    /**********************************        成功响应码     ********************************************/
    /****************************************************************************************************/
    /** 注册成功 */
    svceRigRegister(EResCodeCommon.optSuccess, "恭喜您注册成功", "恭喜您注册成功"),
    /** 登录成功 */
    svceRigLoginSuccess(EResCodeCommon.optSuccess, "登录成功", "登录成功"),
    /** 退出成功 */
    svceRigLoginOutSuccess(EResCodeCommon.optSuccess, "退出成功", "退出成功"),

    /** 登录密码重置成功 */
    svceRigRestLoginPwd(EResCodeCommon.optSuccess, "密码重置成功", "密码重置成功"),
    /** 登录密码修改成功 */
    svceRigUpdateLoginPwd(EResCodeCommon.optSuccess, "登录密码修改成功", "登录密码修改成功"),
    /** 修改客户资料成功 */
    svceRigUpdateCustInfo(EResCodeCommon.optSuccess, "资料修改成功", "资料修改成功"),

    /** 联系人与通话记录提交成功 */
    svceRigSubmitContactAndCallInfo(EResCodeCommon.optSuccess, "联系人与通话记录提交成功", "联系人与通话记录提交成功"),
    /** 设备信息提交成功 */
    svceRigSubmitDeviceInfo(EResCodeCommon.optSuccess, "设备信息提交成功", "设备信息提交成功"),
    /** 设备信息提交成功 , 并获取版本信息*/
    svceRigSubmitDeviceInfoAndGetVer(EResCodeCommon.optSuccess, "设备信息提交成功，并获取版本信息", "设备信息提交成功，并获取版本信息"),

    /** 业务逻辑：支付密码修改成功 */
    svceRigRestPayPwd(EResCodeCommon.optSuccess, "支付密码修改成功", "支付密码修改成功"),
    /** 业务逻辑：支付密码设置成功 */
    svceRigSetPayPwd(EResCodeCommon.optSuccess, "支付密码设置成功", "支付密码设置成功"),
    /** 业务逻辑：支付密码验证通过 */
    svceRigCheckPayPwd(EResCodeCommon.optSuccess, "支付密码验证通过", "支付密码验证通过"),
    /** 修改手机号 验证码身份证号码验证通过 */
    svceRigCodeAndIdCard(EResCodeCommon.optSuccess, "验证码身份证号码验证通过", "验证码身份证号码验证通过"),
    /** 手机号可以用来绑定微信号 */
    svceRigTelAvailable(EResCodeCommon.optSuccess, "手机号可以用来绑定微信号", "手机号可以用来绑定微信号"),

    ;
    /** 消息代码,大于等于0表示正确，小于表示错误 */
    private int code = 0;
    /** 消息内容（内部消息） */
    private String innerMsg;
    /** 消息内容 （外部消息） */
    private String msg;

    private EResCodeCust(int code, String innerMsg, String msg) {
        this.code = code;
        this.msg = msg;
        this.innerMsg = innerMsg;
    }

    /**
     * @取得 消息代码大于等于0表示正确，小于表示错误
     */
    public int getCode() {
        return code;
    }

    /** @取得 消息内容（外部消息） */
    public String getMsg() {
        return msg;
    }

    /**
     * 转换成OptResult对象
     *
     * @return
     */
    public OptResult getOptResult(Logger logger) {
        return getOptResult(logger, "");
    }

    /**
     * 转换成OptResult对象
     *
     * @return
     */
    public OptResult getOptResult(Logger logger, Object otherMsg) {
        logger.info("{}", new OptResult(code, msg, innerMsg, otherMsg));
        return new OptResult(code, msg);
    }

    /**
     * 转换成OptResult对象
     *
     * @return
     */
    public OptResult getOptResult(Logger logger, Object otherMsg, Exception e) {
        logger.error("{}", new OptResult(code, msg, innerMsg, otherMsg), e);
        return new OptResult(code, msg);
    }
}
