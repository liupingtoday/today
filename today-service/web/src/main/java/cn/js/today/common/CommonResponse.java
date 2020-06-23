package cn.js.today.common;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.List;

/**
 * Simple to Introduction
 *
 * @Description: 一句话描述该类的功能
 * @Author: liuping
 * @Since 2020-01-25
 * @UpdateUser: liuping
 * @UpdateDate: 2020-01-25
 * @UpdateRemark: 说明本次修改内容
 * @Version: v1.0
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommonResponse<T> implements Serializable {

    public static final String CODE_SUCCESS = "0000";//成功
    public static final String CODE_PARAM_ERROR = "1000";//参数错误
    public static final String CODE_INVALID = "1002";//校验错误
    public static final String CODE_FAILURE = "3000";//失败
    public static final String CODE_OTHER = "9999";//其他

    public static final String MSG_SUCCESS="success";
    public static final String MSG_FAILURE="failure";

    //    private List<T> list;//每页显示的数据集合

//    public static final long CODE_SUCCESS = 200;
//    public static final long CODE_ERROR = 500;
//    public static final long CODE_VALIDATE_FAILED = 404;
//    public static final long CODE_UNAUTHORIZED = 401;
//    public static final long CODE_FORBIDDEN = 403;

    /**
     *
     */
    private String code;

    /**
     *
     */
    private String msg;

    /**
     *
     */
    private List<T> data;
//    private List<Object> table;
//    private String requestid;


    /**
     *  总记录数
     */
    private int totalCount;

    /**
     *  总页数
     */
    private int totalPage;

    /**
     * 当前页码
     */
    private int currentPage;

    /**
     *  每页显示的条数
     */
    private int pageSize;

    public CommonResponse() {
    }

    public CommonResponse(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public CommonResponse(String code, String msg, List<T> data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public CommonResponse(String code, String msg, List<T> data, int totalCount, int totalPage) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.totalCount = totalCount;
        this.totalPage = totalPage;
    }

    public static CommonResponse ok(){
        return new CommonResponse(CODE_SUCCESS, MSG_SUCCESS);
    }

    public static CommonResponse ok(List data){
        return new CommonResponse(CODE_SUCCESS, MSG_SUCCESS, data);
    }

    public static CommonResponse error(String code, String message){
        return new CommonResponse(code, message);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "CommonResponse{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                ", totalCount=" + totalCount +
                ", totalPage=" + totalPage +
                ", currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                '}';
    }
}
