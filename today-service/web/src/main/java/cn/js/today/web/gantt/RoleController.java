package cn.js.today.web.gantt;

import cn.js.today.domain.gantt.Role;
import cn.js.today.service.dto.gantt.RoleDTO;
import cn.js.today.service.gantt.RoleService;
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
public class RoleController {

    private final Logger log = LoggerFactory.getLogger(RoleController.class);

    @Autowired
    private RoleService roleService;

    private static final String ENTITY_NAME = "gantt-role";

    @Value("${spring.application.name}")
    private String applicationName;


    /**
     *
     * @param roleId
     * @return
     */
    @GetMapping("/gantt/{roleId}")
    public ResponseEntity<Role> getTask(@PathVariable Long roleId) {
        log.debug("REST request to get ConTaskfig : {}", roleId);
        Role role = roleService.findByRoleId(roleId);
        return ResponseEntity.ok().body(role);
    }

    /**
     *
     * @return
     */
    @Timed
    @ApiOperation(value="栏目新增", notes="栏目新增")
    @GetMapping("/gantt/roles")
    public List<Role> getAllRoles() {
        log.debug("REST request to get all roles");
        return roleService.findAll();
    }

    /**
     *
     * @param roleDTO
     * @return
     */
    @PostMapping(value = "/gantt/role")
    public ResponseEntity<Role> addRole(RoleDTO roleDTO) {
        Role role = roleService.saveRole(roleDTO);
        log.info(role.toString());
        return ResponseEntity.ok().body(role);
    }

    @PutMapping("/gantt/role")
    public ResponseEntity<Role> updateRole(@Valid @RequestBody RoleDTO roleDTO) throws URISyntaxException {
        log.debug("REST request to update Role : {}", roleDTO);
        if(roleDTO.getRoleId() == null){
            throw new BadRequestAlertException("Invalid RoleId", ENTITY_NAME, "id is null");
        }

        Role role = roleService.saveRole(roleDTO);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, role.getRoleId().toString()))
                .body(role);
    }
    /**
     *
     * @param roleId
     * @return
     */
    @DeleteMapping("/gantt/role/{taskId}")
    public ResponseEntity<Void> deleteRole(@PathVariable Long roleId){
        log.debug("REST request to delete Task : {}", roleId);
//        taskService.
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, roleId.toString())).build();
    }

}
