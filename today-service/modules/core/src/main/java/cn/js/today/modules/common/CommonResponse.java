package cn.js.today.modules.common;

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
public class CommonResponse implements Serializable {

    /**
     *
     */
    private String code;

    /**
     *
     */
    private String message;

    /**
     *
     */
    private Long total;

    /**
     *
     */
    private List<Object> data;
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

//    private List<T> list;//每页显示的数据集合

//    public static final long CODE_SUCCESS = 200;
//    public static final long CODE_ERROR = 500;
//    public static final long CODE_VALIDATE_FAILED = 404;
//    public static final long CODE_UNAUTHORIZED = 401;
//    public static final long CODE_FORBIDDEN = 403;


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

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<Object> getData() {
        return data;
    }

    public void setData(List<Object> data) {
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
}
