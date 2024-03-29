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
@Table(name = "sys_role_data_scope")
@JsonInclude(value= JsonInclude.Include.NON_NULL)
public class RoleDataScope extends DataEntity<RoleDataScope> {

    /**
     * 角色编码
     */
    @EmbeddedId
    private RoleDataScopeUPK roleDataScopeUPK;

}
