package cn.js.today.common;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.List;

/**
 * Simple to Introduction
 *
 * @Description: 一句话描述该类的功能
 * @Author: liuping
 * @Since 2020-02-22
 * @UpdateUser: liuping
 * @UpdateDate: 2020-02-22
 * @UpdateRemark: 说明本次修改内容
 * @Version: v1.0
 */
public class ResultBean<T> {

    /**
     *  执行结果
     */
    private boolean success = Boolean.FALSE;

    /**
     *  执行输入参数
     */
    private List<Object> inputParams;

    /**
     * 执行返回结果
     */
    private T result;

//    private List<?> returnSet;//执行结果集
//    private long total;//结果集总数
//    private int start;//结果集索引开始位置
//    private int limit = 50;//结果集数量限制
//    private String errorMessage;//执行错误描述
//    private String msg;//描述信息
//    private String[] msgList;//描述信息集合
//    private Map<String,Object> paramsMap = new HashMap<String,Object>() ;//存放标记信息

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
