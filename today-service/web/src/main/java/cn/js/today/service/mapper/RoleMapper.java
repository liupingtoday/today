package cn.js.today.service.mapper;

import cn.js.today.domain.gantt.Role;
import cn.js.today.service.dto.gantt.RoleDTO;
import org.springframework.stereotype.Service;

/**
 * Simple to Introduction
 *
 * @Description: 一句话描述该类的功能
 * @Author: liuping
 * @Since 2020-02-09
 * @UpdateUser: liuping
 * @UpdateDate: 2020-02-09
 * @UpdateRemark: 说明本次修改内容
 * @Version: v1.0
 */
@Service
public class RoleMapper {

    /**
     *
     * @param roleDTO
     * @return
     */
    public Role roleDTO2Role(RoleDTO roleDTO){

        if(roleDTO == null){
            return  null;
        } else {
            Role role = new Role();
            role.setName(roleDTO.getName());
            role.setCreatedBy("");
            role.setUpdatedBy("");
            return role;
        }

    }

    public RoleDTO role2RoleDTO(Role role){

        if(role == null){
            return  null;
        } else {
            RoleDTO roleDTO = new RoleDTO();
            roleDTO.setName(role.getName());
            roleDTO.setCreatedBy("");
            roleDTO.setUpdatedBy("");
            return roleDTO;
        }

    }
}
