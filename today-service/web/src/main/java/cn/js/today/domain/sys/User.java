package cn.js.today.domain.sys;

import cn.js.today.common.DataEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

/**
 * Simple to Introduction
 *
 * @Description: 一句话描述该类的功能
 * @Author: liuping
 * @Since 2020-02-26
 * @UpdateUser: liuping
 * @UpdateDate: 2020-02-26
 * @UpdateRemark: 说明本次修改内容
 * @Version: v1.0
 */
@Entity
@Table(name = "sys_user")
@JsonInclude(value= JsonInclude.Include.NON_NULL)
public class User extends DataEntity<User> {

    /**
     * 用户编码
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonSerialize(using = ToStringSerializer.class)
    @Column(name = "user_code")
    private Long userCode;

    /**
     * 登录账号
     */
    @Column(name = "login_code")
    private String loginCode;

    /**
     * 用户昵称
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 用户类型
     */
    @Column(name = "user_type")
    private String userType;

    /**
     * 用户密码
     */
    @Column(name = "password")
    private String password;

    /**
     * 年龄
     */
    @Column(name = "age")
    private String age;

    /**
     * 用户性别
     */
    @Column(name = "sex")
    private String sex;

    /**
     * 生日
     */
    @Column(name = "birthday")
    private String birthday;

    /**
     * 邮箱地址
     */
    @Column(name = "email")
    private String email;

    /**
     * 手机号码
     */
    @Column(name = "mobile")
    private String mobile;

    /**
     * 办公电话
     */
    @Column(name = "phone")
    private String phone;

    /**
     * 头像路径
     */
    @Column(name = "avatar")
    private String avatar;

    /**
     * 个性签名
     */
    @Column(name = "sign")
    private String sign;

    /**
     * 绑定的微信号
     */
    @Column(name = "wx_openid")
    private String wxOpenid;

    /**
     * 用户类型引用编号
     */
    @Column(name = "ref_code")
    private String refCode;
    /**
     * 用户类型引用姓名
     */
    @Column(name = "ref_name")
    private String refName;

    /**
     * 绑定的微信号
     */
    @Column(name = "mobile_imei")
    private String mobileImei;

    /**
     * 最后登陆时间
     */
    @Column(name = "last_login_date")
    private String lastLoginDate;

    /**
     * 冻结时间
     */
    @Column(name = "freeze_date")
    private String freezeDate;

    /**
     * 冻结原因
     */
    @Column(name = "freeze_cause")
    private String freezeCause;

    /**
     * 状态（0:正常 1:删除 2:停用 3:冻结）
     */
    @Column(name = "status")
    private String status;


    public Long getUserCode() {
        return userCode;
    }

    public void setUserCode(Long userCode) {
        this.userCode = userCode;
    }

    public String getLoginCode() {
        return loginCode;
    }

    public void setLoginCode(String loginCode) {
        this.loginCode = loginCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getWxOpenid() {
        return wxOpenid;
    }

    public void setWxOpenid(String wxOpenid) {
        this.wxOpenid = wxOpenid;
    }

    public String getRefCode() {
        return refCode;
    }

    public void setRefCode(String refCode) {
        this.refCode = refCode;
    }

    public String getRefName() {
        return refName;
    }

    public void setRefName(String refName) {
        this.refName = refName;
    }

    public String getMobileImei() {
        return mobileImei;
    }

    public void setMobileImei(String mobileImei) {
        this.mobileImei = mobileImei;
    }

    public String getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(String lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public String getFreezeDate() {
        return freezeDate;
    }

    public void setFreezeDate(String freezeDate) {
        this.freezeDate = freezeDate;
    }

    public String getFreezeCause() {
        return freezeCause;
    }

    public void setFreezeCause(String freezeCause) {
        this.freezeCause = freezeCause;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
