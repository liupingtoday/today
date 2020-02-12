package cn.js.today.common;

/**
 * Simple to Introduction
 *
 * @Description: 响应的返回码和信息
 * @Author: liuping
 * @Since 2019-08-09
 * @UpdateUser: liuping
 * @UpdateDate: 2019-08-09
 * @UpdateRemark: 说明本次修改内容
 * @Version: v1.0
 */
public final class ResponseConstants {

    public static final String SUCCESS_CODE = "0000";
    public static final String PARAM_ERROR_CODE = "1000";
    public static final String INTERNET_ERROR_CODE = "1111";
    public static final String UNSUBSCRIBE_ERROR_CODE = "4001";
    public static final String FAIL_CODE = "1001";

    public static final String SUCCESS_MSG = "成功";
    public static final String PARAM_ERROR_MSG = "参数错误";
    public static final String INTERNET_ERROR_MSG = "系统错误";
    public static final String UNSUBSCRIBE_ERROR_MSG = "退订不存在";
    public static final String FAIL_MSG = "失败";

    public ResponseConstants() {

    }
}
