package cn.js.today.web.gantt;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import cn.js.today.common.ResultBean;
import cn.js.today.domain.gantt.Task;
import cn.js.today.service.dto.gantt.GanttDTO;
import cn.js.today.service.dto.gantt.ResourceDTO;
import cn.js.today.service.dto.gantt.RoleDTO;
import cn.js.today.service.dto.gantt.TaskDTO;
import cn.js.today.service.gantt.GanttService;
import cn.js.today.service.gantt.TaskService;
import cn.js.today.utils.FastJsonUtils;
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
public class GanttController {

    private final Logger log = LoggerFactory.getLogger(GanttController.class);

    @Autowired
    private TaskService taskService;

    @Autowired
    private GanttService ganttService;

    private static final String ENTITY_NAME = "gantt-gantt";

    @Value("${spring.application.name}")
    private String applicationName;


    /**
     *
     * @param taskId
     * @return
     */
//    @GetMapping("/gantt/task/{taskId}")
//    public ResponseEntity<Task> getTask(@PathVariable Long taskId) {
//        log.debug("REST request to get ConTaskfig : {}", taskId);
//        Task task = taskService.findByTaskId(taskId);
//        return ResponseEntity.ok().body(task);
//    }

    /**
     *
     * @return
     */
//    @Timed
//    @ApiOperation(value="获取所有的任务", notes="获取所有的任务")
//    @GetMapping("/gantt/tasks")
//    public List<Task> getAllTasks() {
//        log.debug("REST request to get all Tasks");
//        return taskService.findAll();
//    }

    /**
     *
     * @param requestJson
     * @return
     */

    @RequestMapping(value="/gantt/addGantt",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ResponseEntity<String> addGantt(@RequestBody String requestJson) {
        log.info("-----------##############:" + requestJson);
        JSONObject jsonObject = JSONUtil.parseObj(requestJson);
        //获取tasks对象数组
        JSONArray taskJsonArray = jsonObject.getJSONArray("tasks");
        //获取resource对象数组
        JSONArray resourceJsonArray = jsonObject.getJSONArray("resources");
        //获取role对象数组
        JSONArray roleJsonArray = jsonObject.getJSONArray("roles");

        List<TaskDTO> taskDTOList = taskJsonArray.toList(TaskDTO.class);
        List<ResourceDTO> resourceDTOList = resourceJsonArray.toList(ResourceDTO.class);
        List<RoleDTO> roleDTOList = roleJsonArray.toList(RoleDTO.class);

        //构造GanttDTO
        GanttDTO ganttDTO = new GanttDTO();
        ganttDTO.setTaskDTO(taskDTOList);
        ganttDTO.setResourceDTO(resourceDTOList);
        ganttDTO.setRoleDTO(roleDTOList);
        log.info(taskDTOList.toString());
        log.info(resourceDTOList.toString());
        log.info(roleDTOList.toString());

        ResultBean resultBean = ganttService.saveGantt(ganttDTO);
        if(resultBean.isSuccess()){
            return ResponseEntity.ok().body(FastJsonUtils.convertObjectToJSON(resultBean.getResult()));
        }else {
            return ResponseEntity.ok().body("not ok!");
        }
    }

//    @PutMapping("/gantt/task")
//    public ResponseEntity<Task> updateTask(@Valid @RequestBody TaskDTO taskDTO) throws URISyntaxException {
//        log.debug("REST request to update Task : {}", taskDTO);
//        if(taskDTO.getTaskId() == null){
//            throw new BadRequestAlertException("Invalid taskId", ENTITY_NAME, "id is null");
//        }
//
//        Task task = taskService.saveTask(taskDTO);
//        return ResponseEntity.ok().headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, task.getTaskId().toString()))
//                .body(task);
//    }
    /**
     *
     * @param taskId
     * @return
     */
//    @DeleteMapping("/gantt/task/{taskId}")
//    public ResponseEntity<Void> deleteTask(@PathVariable Long taskId){
//        log.debug("REST request to delete Task : {}", taskId);
////        taskService.
//        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, taskId.toString())).build();
//    }

}
