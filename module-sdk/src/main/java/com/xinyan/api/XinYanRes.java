package com.xinyan.api;

import com.aoying.module.sdk.base.BasePojo;

/**
 * 新颜接口 响应参数类
 * @author nick
 */
public class XinYanRes<T> extends BasePojo {
    /** 响应状态 */
    private Boolean success;
    /** 错误码 */
    private String errorCode;
    /** 错误信息 */
    private String errorMsg;
    /** 业务成功数据	*/
    private String data;
    /** 业务成功数据对象 */
    private T dataObj;
    /** 响应Json */
    private String resJson;


    /** 获取 响应状态 */
    public Boolean getSuccess() {
        return this.success;
    }

    /** 设置 响应状态 */
    public void setSuccess(Boolean success) {
        this.success = success;
    }

    /** 获取 错误码 */
    public String getErrorCode() {
        return this.errorCode;
    }

    /** 设置 错误码 */
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    /** 获取 错误信息 */
    public String getErrorMsg() {
        return this.errorMsg;
    }

    /** 设置 错误信息 */
    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    /** 获取 业务成功数据	*/
    public String getData() {
        return this.data;
    }

    /** 设置 业务成功数据	*/
    public void setData(String data) {
        this.data = data;
    }

    /** 获取 业务成功数据对象 */
    public T getDataObj() {
        return this.dataObj;
    }

    /** 设置 业务成功数据对象 */
    public void setDataObj(T dataObj) {
        this.dataObj = dataObj;
    }

    /** 获取 响应Json */
    public String getResJson() {
        return this.resJson;
    }

    /** 设置 响应Json */
    public void setResJson(String resJson) {
        this.resJson = resJson;
    }
}
