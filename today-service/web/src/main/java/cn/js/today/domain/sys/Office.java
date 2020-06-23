package cn.js.today.domain.sys;

import cn.js.today.common.DataEntity;
import cn.js.today.common.TreeEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import javax.persistence.*;

/**
 * Simple to Introduction
 *
 * @Description: 组织机构表
 * @Author: liuping
 * @Since 2020-03-22
 * @UpdateUser: liuping
 * @UpdateDate: 2020-03-22
 * @UpdateRemark: 说明本次修改内容
 * @Version: v1.0
 */
@Entity
@Table(name = "sys_office")
@JsonInclude(value= JsonInclude.Include.NON_NULL)
public class Office extends TreeEntity<Office> {

    /**
     * 机构编码
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonSerialize(using = ToStringSerializer.class)
    @Column(name = "office_code")
    private Long officeCode;

    /**
     * 父级编号
     */
    @Column(name = "parent_code")
    private String parentCode;

    /**
     * 所有父级编号
     */
    @Column(name = "parent_codes")
    private String parentCodes;

    /**
     * 机构代码
     */
    @Column(name = "view_code")
    private String viewCode;

    /**
     * 机构名称
     */
    @Column(name = "office_name")
    private String officeName;

    /**
     * 机构全称
     */
    @Column(name = "full_name")
    private String fullName;

    /**
     * 机构类型
     */
    @Column(name = "office_type")
    private String officeType;

    /**
     * 负责人
     */
    @Column(name = "leader")
    private String leader;

    /**
     * 办公电话
     */
    @Column(name = "phone")
    private String phone;

    /**
     * 联系地址
     */
    @Column(name = "address")
    private String address;

    /**
     * 邮政编码
     */
    @Column(name = "zip_code")
    private String zipCode;

    /**
     * 电子邮箱
     */
    @Column(name = "email")
    private String email;

    /**
     * 状态（0正常 1删除 2停用）
     */
    @Column(name = "status")
    private String status;

}
