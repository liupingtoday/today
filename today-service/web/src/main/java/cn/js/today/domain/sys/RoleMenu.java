package cn.js.today.domain.sys;

import cn.js.today.common.DataEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Simple to Introduction
 *
 * @Description: 角色与菜单关联表
 * @Author: liuping
 * @Since 2020-03-22
 * @UpdateUser: liuping
 * @UpdateDate: 2020-03-22
 * @UpdateRemark: 说明本次修改内容
 * @Version: v1.0
 */
@Entity
@Table(name = "sys_role_menu")
@JsonInclude(value= JsonInclude.Include.NON_NULL)
@Builder
@ToString
@NoArgsConstructor
public class RoleMenu extends DataEntity<RoleMenu> {

    /**
     * 角色编码
     */
    @EmbeddedId
    private RoleMenuUPK roleMenuUPK;

}
