package cn.js.today.web.gantt;

import cn.js.today.domain.gantt.Resource;
import cn.js.today.domain.gantt.Task;
import cn.js.today.service.dto.gantt.ResourceDTO;
import cn.js.today.service.dto.gantt.TaskDTO;
import cn.js.today.service.gantt.ResourceService;
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
public class ResourceController {

    private final Logger log = LoggerFactory.getLogger(ResourceController.class);

    @Autowired
    private ResourceService resourceService;

    private static final String ENTITY_NAME = "gantt-resource";

    @Value("${spring.application.name}")
    private String applicationName;


    /**
     *
     * @param resourceId
     * @return
     */
    @GetMapping("/gantt/resource/{resourceId}")
    public ResponseEntity<Resource> getResource(@PathVariable Long resourceId) {
        log.debug("REST request to get Resource : {}", resourceId);
        Resource resource = resourceService.findByResourceId(resourceId);
        return ResponseEntity.ok().body(resource);
    }

    /**
     *
     * @return
     */
    @Timed
    @ApiOperation(value="栏目新增", notes="栏目新增")
    @GetMapping("/gantt/resources")
    public List<Resource> getAllResources() {
        log.debug("REST request to get all Resources");
        return resourceService.findAll();
    }

    /**
     *
     * @param resourceDTO
     * @return
     */
    @PostMapping(value = "/gantt/resource")
    public ResponseEntity<Resource> addResource(ResourceDTO resourceDTO) {
        Resource resource = resourceService.saveResource(resourceDTO);
        log.info(resource.toString());
        return ResponseEntity.ok().body(resource);
    }

    @PutMapping("/gantt/resource")
    public ResponseEntity<Resource> updateResource(@Valid @RequestBody ResourceDTO resourceDTO) throws URISyntaxException {
        log.debug("REST request to update Resource : {}", resourceDTO);
        if(resourceDTO.getResourceId() == null){
            throw new BadRequestAlertException("Invalid ResourceId", ENTITY_NAME, "id is null");
        }

        Resource resource = resourceService.saveResource(resourceDTO);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, resource.getResourceId().toString()))
                .body(resource);
    }
    /**
     *
     * @param resourceId
     * @return
     */
    @DeleteMapping("/gantt/resource/{resourceId}")
    public ResponseEntity<Void> deleteResource(@PathVariable Long resourceId){
        log.debug("REST request to delete Resource : {}", resourceId);
//        taskService.
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, resourceId.toString())).build();
    }

}
