package cn.js.today.domain.sys;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * Simple to Introduction
 *
 * @Description: 用户与角色关联表联合主键
 * @Author: liuping
 * @Since 2020-03-22
 * @UpdateUser: liuping
 * @UpdateDate: 2020-03-22
 * @UpdateRemark: 说明本次修改内容
 * @Version: v1.0
 */
@Builder(toBuilder = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
@EqualsAndHashCode
public class UserRoleUPK implements Serializable {

    /**
     * 角色编码
     */
    @Column(name = "role_code", nullable = false, length = 64)
    private String roleCode;

    /**
     * 菜单编码
     */
    @Column(name = "user_code", nullable = false, length = 64)
    private String userCode;

}
