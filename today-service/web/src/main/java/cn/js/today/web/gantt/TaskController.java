package cn.js.today.web.gantt;

import cn.js.today.domain.gantt.Task;
import cn.js.today.service.dto.gantt.TaskDTO;
import cn.js.today.service.gantt.TaskService;
import cn.js.today.web.errors.BadRequestAlertException;
import io.github.jhipster.web.util.HeaderUtil;
import io.micrometer.core.annotation.Timed;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URISyntaxException;
import java.util.List;

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
@RestController
@RequestMapping("/api")
public class TaskController {

    private final Logger log = LoggerFactory.getLogger(TaskController.class);

    @Autowired
    private TaskService taskService;

    private static final String ENTITY_NAME = "gantt";

    @Value("${spring.application.name}")
    private String applicationName;


    /**
     *
     * @param taskId
     * @return
     */
    @GetMapping("/gantt/task/{taskId}")
    public ResponseEntity<Task> getTask(@PathVariable Long taskId) {
        log.debug("REST request to get ConTaskfig : {}", taskId);
        Task task = taskService.findByTaskId(taskId);
        return ResponseEntity.ok().body(task);
    }

    /**
     *
     * @return
     */
    @Timed
    @ApiOperation(value="获取所有的任务", notes="获取所有的任务")
    @GetMapping("/gantt/tasks")
    public List<Task> getAllTasks() {
        log.debug("REST request to get all Tasks");
        return taskService.findAll();
    }

    /**
     *
     * @param taskDTO
     * @return
     */
    @PostMapping(value = "/gantt/task")
    public ResponseEntity<Task> addTask(TaskDTO taskDTO) {
        Task task = taskService.saveTask(taskDTO);
        log.info(task.toString());
        return ResponseEntity.ok().body(task);
    }

    @PutMapping("/gantt/task")
    public ResponseEntity<Task> updateTask(@Valid @RequestBody TaskDTO taskDTO) throws URISyntaxException {
        log.debug("REST request to update Task : {}", taskDTO);
        if(taskDTO.getTaskId() == null){
            throw new BadRequestAlertException("Invalid taskId", ENTITY_NAME, "id is null");
        }

        Task task = taskService.saveTask(taskDTO);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, task.getTaskId().toString()))
                .body(task);
    }
    /**
     *
     * @param taskId
     * @return
     */
    @DeleteMapping("/gantt/task/{taskId}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long taskId){
        log.debug("REST request to delete Task : {}", taskId);
//        taskService.
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, taskId.toString())).build();
    }

}
