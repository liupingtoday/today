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
@Table(name = "gantt_resource")
@JsonInclude(value= JsonInclude.Include.NON_NULL)
public class Resource extends DataEntity<Resource> {

    /**
     * 编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonSerialize(using = ToStringSerializer.class)
    private Long resourceId;

    /**
     * 任务名称
     */
    @Column(name = "name")
    private String name;

    /**
     * 角色ID
     */
    @Column(name = "roleId")
    private String roleId;

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}
