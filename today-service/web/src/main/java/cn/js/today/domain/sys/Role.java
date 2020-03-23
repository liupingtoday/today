package cn.js.today.domain.sys;

import cn.js.today.common.DataEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import javax.persistence.*;

/**
 * Simple to Introduction
 *
 * @Description: 角色表
 * @Author: liuping
 * @Since 2020-03-22
 * @UpdateUser: liuping
 * @UpdateDate: 2020-03-22
 * @UpdateRemark: 说明本次修改内容
 * @Version: v1.0
 */
@Entity
@Table(name = "sys_role")
@JsonInclude(value= JsonInclude.Include.NON_NULL)
public class Role extends DataEntity<Role> {

    /**
     * 角色编码
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonSerialize(using = ToStringSerializer.class)
    @Column(name = "role_code")
    private Long roleCode;

    /**
     * 角色名称
     */
    @Column(name = "role_name")
    private String roleName;

    /**
     * 角色分类（高管、中层、基层、其它）
     */
    @Column(name = "role_type")
    private String roleType;

    /**
     * 角色排序（升序）
     */
    @Column(name = "role_sort")
    private String roleSort;

    /**
     * 系统内置（1是 0否）
     */
    @Column(name = "is_sys")
    private String isSys;

    /**
     * 用户类型（employee员工 member会员）
     */
    @Column(name = "user_type")
    private String userType;

    /**
     * 数据范围设置（0未设置  1全部数据 2自定义数据）
     */
    @Column(name = "data_scope")
    private String dataScope;

    /**
     * 适应业务范围（不同的功能，不同的数据权限支持）
     */
    @Column(name = "biz_scope")
    private String bizScope;
    /**
     * 状态（0正常 1删除 2停用）
     */
    @Column(name = "status")
    private String status;

    public Long getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(Long roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    public String getRoleSort() {
        return roleSort;
    }

    public void setRoleSort(String roleSort) {
        this.roleSort = roleSort;
    }

    public String getIsSys() {
        return isSys;
    }

    public void setIsSys(String isSys) {
        this.isSys = isSys;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getDataScope() {
        return dataScope;
    }

    public void setDataScope(String dataScope) {
        this.dataScope = dataScope;
    }

    public String getBizScope() {
        return bizScope;
    }

    public void setBizScope(String bizScope) {
        this.bizScope = bizScope;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
