package cn.js.today.service.mapper;

import cn.js.today.domain.gantt.Task;
import cn.js.today.domain.sys.Config;
import cn.js.today.service.dto.gantt.TaskDTO;
import cn.js.today.service.dto.sys.ConfigDTO;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;

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
public class TaskMapper {

    /**
     *
     * @param taskDTO
     * @return
     */
    public Task taskDTO2Task(TaskDTO taskDTO){

        if(taskDTO == null){
            return  null;
        } else {
            Task task = new Task();
            task.setName(taskDTO.getName());
            task.setResourceId(taskDTO.getResourceId());
            task.setDescription(taskDTO.getDescription());
            task.setCanAdd(taskDTO.getCanAdd());
            task.setCanDelete(taskDTO.getCanDelete());
            task.setDuration(taskDTO.getDuration());
            task.setStart(taskDTO.getStart());
            task.setEnd(taskDTO.getEnd());

            task.setStartIsMilestone(taskDTO.getStartIsMilestone());
            task.setEndIsMilestone(taskDTO.getEndIsMilestone());
            task.setLevel(taskDTO.getLevel());
            task.setProgress(taskDTO.getProgress());
            task.setCreatedBy("");
            task.setUpdatedBy("");
            return task;
        }

    }

    public TaskDTO Task2taskDTO(Task task){
        if(task == null){
            return  null;
        }else {
            TaskDTO taskDTO = new TaskDTO();
            taskDTO.setName(task.getName());
            taskDTO.setResourceId(task.getResourceId());
            taskDTO.setDescription(task.getDescription());
            taskDTO.setDuration(task.getDuration());
            taskDTO.setStart(task.getStart());
            taskDTO.setEnd(task.getEnd());
            taskDTO.setLevel(task.getLevel());
            return taskDTO;
        }

    }
}
