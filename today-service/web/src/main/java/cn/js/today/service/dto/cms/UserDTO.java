package cn.js.today.service.dto.cms;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

/**
 * Simple to Introduction
 *
 * @Description: 一句话描述该类的功能
 * @Author: liuping
 * @Since 2020-02-13
 * @UpdateUser: liuping
 * @UpdateDate: 2020-02-13
 * @UpdateRemark: 说明本次修改内容
 * @Version: v1.0
 */
public class UserDTO {

    /**
     * 姓名
     */
    @NotEmpty
    private String name;

    /**
     * 生日
     */
    @Pattern(regexp = "^[0-9]{4}-[0-9]{2}-[0-9]{2}$", message = "出生日期格式不正确")
    private String birthday;

    /**
     * 年龄
     */
    @Min(value = 0)
    private Integer age;
}
