package cn.js.today.domain.sys;

import cn.js.today.common.DataEntity;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Simple to Introduction
 *
 * @Description: 用户与角色关联表
 * @Author: liuping
 * @Since 2020-03-22
 * @UpdateUser: liuping
 * @UpdateDate: 2020-03-22
 * @UpdateRemark: 说明本次修改内容
 * @Version: v1.0
 */
@Entity
@Table(name = "sys_user_role")
@JsonInclude(value= JsonInclude.Include.NON_NULL)
public class UserRole extends DataEntity<UserRole> {

    /**
     * 用户与角色关联表
     */
    @EmbeddedId
    private UserRoleUPK userRoleUPK;

}
