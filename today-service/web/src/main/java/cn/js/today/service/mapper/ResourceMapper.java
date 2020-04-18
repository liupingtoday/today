package cn.js.today.service.mapper;

import cn.js.today.domain.gantt.Assignee;
import cn.js.today.service.dto.gantt.ResourceDTO;
import org.springframework.stereotype.Service;

/**
 * Simple to Introduction
 *
 * @Description: 一句话描述该类的功能
 * @Author: liuping
 * @Since 2020-02-21
 * @UpdateUser: liuping
 * @UpdateDate: 2020-02-21
 * @UpdateRemark: 说明本次修改内容
 * @Version: v1.0
 */
@Service
public class ResourceMapper {

    /**
     *
     * @param resourceDTO
     * @return
     */
    public Assignee resourceDTO2Resource(ResourceDTO resourceDTO){

        if(resourceDTO == null){
            return  null;
        } else {
            Assignee assignee = new Assignee();
//            task.setResourceId(resourceDTO.getResourceId());
            assignee.setName(resourceDTO.getName());
            assignee.setRoleId(resourceDTO.getRoleId());
            assignee.setCreatedBy("");
            assignee.setUpdatedBy("");
            return assignee;
        }

    }

    public ResourceDTO resource2ResourceDTO(Assignee assignee){

        if(assignee == null){
            return  null;
        } else {
            ResourceDTO resourceDTO = new ResourceDTO();
//            task.setResourceId(resourceDTO.getResourceId());
            resourceDTO.setName(assignee.getName());
            resourceDTO.setRoleId(assignee.getRoleId());
            resourceDTO.setCreatedBy("");
            resourceDTO.setUpdatedBy("");
            return resourceDTO;
        }

    }
}
