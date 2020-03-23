package cn.js.today.domain.sys;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * Simple to Introduction
 *
 * @Description: 角色数据权限表联合主键
 * @Author: liuping
 * @Since 2020-03-22
 * @UpdateUser: liuping
 * @UpdateDate: 2020-03-22
 * @UpdateRemark: 说明本次修改内容
 * @Version: v1.0
 */
@Builder(toBuilder = true)
@Data
//@NoArgsConstructor
//@AllArgsConstructor
@Embeddable
//@EqualsAndHashCode
public class RoleMenuUPK implements Serializable {

    /**
     * 角色编码
     */
    @Column(name = "role_code", nullable = false, length = 64)
    private String roleCode;

    /**
     * 菜单编码
     */
    @Column(name = "menu_code", nullable = false, length = 64)
    private String menuCode;

    public RoleMenuUPK() {
    }

    public RoleMenuUPK(String roleCode, String menuCode) {
        this.roleCode = roleCode;
        this.menuCode = menuCode;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleMenuUPK that = (RoleMenuUPK) o;
        return Objects.equals(roleCode, that.roleCode) &&
                Objects.equals(menuCode, that.menuCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleCode, menuCode);
    }
}
