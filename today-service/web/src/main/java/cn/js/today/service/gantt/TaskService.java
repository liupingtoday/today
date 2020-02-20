package cn.js.today.service.gantt;

import cn.js.today.domain.gantt.Task;
import cn.js.today.domain.sys.Config;
import cn.js.today.repository.gantt.TaskRepository;
import cn.js.today.repository.sys.ConfigRepository;
import cn.js.today.service.dto.gantt.TaskDTO;
import cn.js.today.service.dto.sys.ConfigDTO;
import cn.js.today.service.mapper.ConfigMapper;
import cn.js.today.service.mapper.TaskMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Simple to Introduction
 *
 * @Description: 一句话描述该类的功能
 * @Author: liuping
 * @Since 2020-02-20
 * @UpdateUser: liuping
 * @UpdateDate: 2020-02-20
 * @UpdateRemark: 说明本次修改内容
 * @Version: v1.0
 */
@Service
public class TaskService {

    private final Logger log = LoggerFactory.getLogger(TaskService.class);

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TaskMapper taskMapper;

    public Task saveTask(TaskDTO taskDTO){

        Task task = taskMapper.taskDTO2Task(taskDTO);
        return taskRepository.save(task);
    }

    public Task findByTaskId(Long taskId){
        Optional<Task> task = taskRepository.findOneByTaskId(taskId);
        return task.orElse(null);
    }

    /**
     *
     * @return
     */
    public List<Task> findAll(){
        return taskRepository.findAll();
    }

}
