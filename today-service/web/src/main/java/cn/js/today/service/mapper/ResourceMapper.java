package cn.js.today.service.mapper;

import cn.js.today.domain.gantt.Resource;
import cn.js.today.domain.gantt.Task;
import cn.js.today.service.dto.gantt.ResourceDTO;
import cn.js.today.service.dto.gantt.TaskDTO;
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
    public Resource resourceDTO2Resource(ResourceDTO resourceDTO){

        if(resourceDTO == null){
            return  null;
        } else {
            Resource resource = new Resource();
//            task.setResourceId(resourceDTO.getResourceId());
            resource.setName(resourceDTO.getName());
            resource.setRoleId(resourceDTO.getRoleId());
            resource.setCreatedBy("");
            resource.setUpdatedBy("");
            return resource;
        }

    }

    public ResourceDTO resource2ResourceDTO(Resource resource){

        if(resource == null){
            return  null;
        } else {
            ResourceDTO resourceDTO = new ResourceDTO();
//            task.setResourceId(resourceDTO.getResourceId());
            resourceDTO.setName(resource.getName());
            resourceDTO.setRoleId(resource.getRoleId());
            resourceDTO.setCreatedBy("");
            resourceDTO.setUpdatedBy("");
            return resourceDTO;
        }

    }
}
