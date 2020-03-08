package cn.js.today.service.dto.sys;

import javax.persistence.Column;
import javax.validation.constraints.*;

/**
 * Simple to Introduction
 *
 * @Description: 一句话描述该类的功能
 * @Author: liuping
 * @Since 2020-03-09
 * @UpdateUser: liuping
 * @UpdateDate: 2020-03-09
 * @UpdateRemark: 说明本次修改内容
 * @Version: v1.0
 */
public class UserDTO {

    private Long userId;

    /**
     * 用户名称
     */
    @NotEmpty
    private String userName;

    /**
     * 用户昵称
     */
    private String nickName;

    /**
     * 生日
     */
    @Pattern(regexp = "^[0-9]{4}-[0-9]{2}-[0-9]{2}$", message = "出生日期格式不正确")
    private String birthday;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 年龄
     */
    @Min(value = 0)
    private String age;

    /**
     * 邮箱地址
     */
    private String email;

    /**
     * 手机号码
     */
    private String mobilePhone;

    /**
     * 座机号码
     */
    private String telPhone;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getTelPhone() {
        return telPhone;
    }

    public void setTelPhone(String telPhone) {
        this.telPhone = telPhone;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
