package com.aoying.loan.common.apidoc;

/**
 * APIDOC 常量定义
 * @author nick
 */
public class ApiDefine {
    /**
     * @apiDefine DefHeaderPub
     * @apiHeader {String} account 账号
     * @apiHeader {Long} timestamp 时间戳，长整型的毫秒数
     * @apiHeader {String} sign 签名，MD5(account+timestamp+secret)
     */

    /**
     * @apiDefine DefHeaderPro
     * @apiHeader {String} account 账号
     * @apiHeader {Long} timestamp 时间戳，长整型的毫秒数
     * @apiHeader {String} sign 签名，MD5(account+timestamp+secret)
     * @apiHeader {String} X_UserToken 用户登录后所返回的Token
     */

    /**
     * @apiDefine DefPage
     * @apiParam {Integer} [pageNum] 第几页
     * @apiParam {Integer} [pageSize] 每页显示条数
     */
}
