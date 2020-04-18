package cn.js.today.service.gantt;

import cn.js.today.common.ResultBean;
import cn.js.today.domain.gantt.Assignee;
import cn.js.today.domain.gantt.Role;
import cn.js.today.domain.gantt.Task;
import cn.js.today.repository.gantt.ResourceRepository;
import cn.js.today.repository.gantt.RoleRepository;
import cn.js.today.repository.gantt.TaskRepository;
import cn.js.today.service.dto.gantt.GanttDTO;
import cn.js.today.service.dto.gantt.ResourceDTO;
import cn.js.today.service.dto.gantt.RoleDTO;
import cn.js.today.service.dto.gantt.TaskDTO;
import cn.js.today.service.mapper.ResourceMapper;
import cn.js.today.service.mapper.RoleMapper;
import cn.js.today.service.mapper.TaskMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
@Service
public class GanttService {

    private final Logger log = LoggerFactory.getLogger(GanttService.class);

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private ResourceRepository resourceRepository;

    @Autowired
    private TaskMapper taskMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private ResourceMapper resourceMapper;

    public ResultBean saveGantt(GanttDTO ganttDTO){
        GanttDTO savedGanttDTO = new GanttDTO();
        ResultBean<GanttDTO> resultBean = new ResultBean();
        List<TaskDTO> taskDTOList = ganttDTO.getTaskDTO();
        List<TaskDTO> savedTaskDTOList = new ArrayList<TaskDTO>();
        List<ResourceDTO> savedResourceDTOList = new ArrayList<ResourceDTO>();
        List<RoleDTO> savedRoleDTOList = new ArrayList<RoleDTO>();
        for(TaskDTO taskDTO : taskDTOList){
            Task task = taskMapper.taskDTO2Task(taskDTO);
            Task savedTask = taskRepository.save(task);
            taskMapper.Task2taskDTO(savedTask);
            savedTaskDTOList.add(taskMapper.Task2taskDTO(savedTask));
        }

        List<ResourceDTO> resourceDTOList = ganttDTO.getResourceDTO();

        for(ResourceDTO resourceDTO : resourceDTOList){
            Assignee assignee = resourceMapper.resourceDTO2Resource(resourceDTO);
            Assignee savedAssignee = resourceRepository.save(assignee);
            savedResourceDTOList.add(resourceMapper.resource2ResourceDTO(savedAssignee));
        }

        List<RoleDTO> roleDTOList = ganttDTO.getRoleDTO();

        for(RoleDTO roleDTO : roleDTOList){
            Role role = roleMapper.roleDTO2Role(roleDTO);
            Role savedRole = roleRepository.save(role);
            savedRoleDTOList.add(roleMapper.role2RoleDTO(savedRole));
        }
        savedGanttDTO.setRoleDTO(savedRoleDTOList);
        savedGanttDTO.setResourceDTO(savedResourceDTOList);
        savedGanttDTO.setTaskDTO(savedTaskDTOList);
        resultBean.setSuccess(Boolean.TRUE);
        resultBean.setResult(savedGanttDTO);
        return resultBean;
    }

//    public Task findByTaskId(Long taskId){
//        Optional<Task> task = taskRepository.findOneByTaskId(taskId);
//        return task.orElse(null);
//    }

    /**
     *
     * @return
     */
    public List<Task> findAll(){
        return taskRepository.findAll();
    }

}
