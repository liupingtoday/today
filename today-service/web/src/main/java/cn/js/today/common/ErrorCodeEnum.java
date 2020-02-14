package cn.js.today.common;

/**
 * Simple to Introduction
 *
 * @Description: 错误代码枚举类
 * @Author: liuping
 * @Since 2020-02-13
 * @UpdateUser: liuping
 * @UpdateDate: 2020-02-13
 * @UpdateRemark: 说明本次修改内容
 * @Version: v1.0
 */
public enum ErrorCodeEnum {

    SUCCESS("0000", "success"),

    PARAM_EMPTY("1001", "必选参数为空"),

    PARAM_ERROR("1002", "参数格式错误"),

    UNKNOWN_ERROR("9999", "系统繁忙，请稍后再试....");

    private String code;

    private String desc;

    ErrorCodeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return this.code;
    }


    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "ErrorCodeEnum{" +
                "code='" + code + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }

}
