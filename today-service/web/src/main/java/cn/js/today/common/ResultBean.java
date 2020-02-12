package cn.js.today.common;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * Simple to Introduction
 *
 * @Description: 一句话描述该类的功能
 * @Author: liuping
 * @Since 2019-08-09
 * @UpdateUser: liuping
 * @UpdateDate: 2019-08-09
 * @UpdateRemark: 说明本次修改内容
 * @Version: v1.0
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultBean<T> implements Serializable {

    private String code;
    private String message;
    private T data;

    public ResultBean(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResultBean(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResultBean() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResultBean{" +
            "code='" + code + '\'' +
            ", message='" + message + '\'' +
            ", data=" + data +
            '}';
    }
}
