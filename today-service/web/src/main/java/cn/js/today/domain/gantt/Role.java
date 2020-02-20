package cn.js.today.domain.gantt;

import cn.js.today.common.DataEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import javax.persistence.*;

/**
 * Simple to Introduction
 *
 * @Description: 一句话描述该类的功能
 * @Author: liuping
 * @Since 2020-02-20
 * @UpdateUser: liuping
 * @UpdateDate: 2020-02-20
 * @UpdateRemark: 说明本次修改内容
 * @Version: v1.0
 */
@Entity
@Table(name = "gantt_role")
@JsonInclude(value= JsonInclude.Include.NON_NULL)
public class Role extends DataEntity<Role> {

    /**
     * 角色ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonSerialize(using = ToStringSerializer.class)
    private Long roleId;

    /**
     * 角色名称
     */
    @Column(name = "name")
    private String name;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
