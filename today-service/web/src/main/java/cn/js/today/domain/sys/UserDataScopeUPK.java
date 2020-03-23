package cn.js.today.domain.sys;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Simple to Introduction
 *
 * @Description: 用户数据权限表联合主键
 * @Author: liuping
 * @Since 2020-03-22
 * @UpdateUser: liuping
 * @UpdateDate: 2020-03-22
 * @UpdateRemark: 说明本次修改内容
 * @Version: v1.0
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
@EqualsAndHashCode
public class UserDataScopeUPK implements Serializable {

    /**
     * 控制角色编码
     */
    @Column(name = "user_code", nullable = false, length = 128)
    private Long userCode;

    /**
     * 控制类型
     */
    @Column(name = "ctrl_type", nullable = false, length = 128)
    private String ctrlType;

    /**
     * 控制数据
     */
    @Column(name = "ctrl_data", nullable = false, length = 128)
    private String ctrlData;

    /**
     * 控制权限
     */
    @Column(name = "ctrl_permi", nullable = false, length = 128)
    private String ctrlPermi;

}
