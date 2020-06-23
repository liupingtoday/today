package cn.js.today.service.dto.gantt;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * Simple to Introduction
 *
 * @Description: 一句话描述该类的功能
 * @Author: liuping
 * @Since 2020-02-22
 * @UpdateUser: liuping
 * @UpdateDate: 2020-02-22
 * @UpdateRemark: 说明本次修改内容
 * @Version: v1.0
 */
public class GanttDTO {

    @JSONField(name ="tasks")
    private List<TaskDTO> taskDTO;

    @JSONField(name ="role")
    private List<RoleDTO> roleDTO;

    @JSONField(name ="resources")
    private List<ResourceDTO> resourceDTO;

    public List<TaskDTO> getTaskDTO() {
        return taskDTO;
    }

    public void setTaskDTO(List<TaskDTO> taskDTO) {
        this.taskDTO = taskDTO;
    }

    public List<RoleDTO> getRoleDTO() {
        return roleDTO;
    }

    public void setRoleDTO(List<RoleDTO> roleDTO) {
        this.roleDTO = roleDTO;
    }

    public List<ResourceDTO> getResourceDTO() {
        return resourceDTO;
    }

    public void setResourceDTO(List<ResourceDTO> resourceDTO) {
        this.resourceDTO = resourceDTO;
    }
}
