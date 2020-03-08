package cn.js.today.web.sys;

import cn.js.today.common.CommonResponse;
import cn.js.today.domain.sys.Menu;
import cn.js.today.domain.sys.User;
import cn.js.today.service.dto.cms.MenuDTO;
import cn.js.today.service.dto.sys.UserDTO;
import cn.js.today.service.mapper.UserMapper;
import cn.js.today.service.sys.ConfigService;
import cn.js.today.service.sys.UserService;
import cn.js.today.web.errors.BadRequestAlertException;
import io.github.jhipster.web.util.HeaderUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URISyntaxException;

/**
 * Simple to Introduction
 *
 * @Description: 一句话描述该类的功能
 * @Author: liuping
 * @Since 2020-03-09
 * @UpdateUser: liuping
 * @UpdateDate: 2020-03-09
 * @UpdateRemark: 说明本次修改内容
 * @Version: v1.0
 */
@RestController
@RequestMapping("/api")
public class UserController {

    private final Logger log = LoggerFactory.getLogger(UserController.class);

    private ConfigService configService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    private static final String ENTITY_NAME = "User";

    @Value("${spring.application.name}")
    private String applicationName;

    /**
     *
     * @param userId
     * @return
     */
    @GetMapping("/user/id/{userId}")
    public ResponseEntity<User> getMenu(@PathVariable Long userId) {
        log.debug("REST request to get User : {}", userId);
        User user = userService.findByUserId(userId);
        return ResponseEntity.ok().body(user);
    }

    /**
     *
     * @param userName
     * @return
     */
    @GetMapping("/user/userName/{userName}")
    public ResponseEntity<User> getMenu(@PathVariable String userName) {
        log.debug("REST request to get User : {}", userName);
        User user = userService.findByUserName(userName);
        return ResponseEntity.ok().body(user);
    }

    /**
     *
     * @return
     */
    @GetMapping("/user")
    public CommonResponse<User> getAllUsers() {
        log.debug("REST request to get all Users");
        return CommonResponse.ok(userService.findAll());
    }

    /**
     *
     * @param userDTO
     * @return
     */
    @PostMapping(value = "/user")
    public ResponseEntity<User> addUser(UserDTO userDTO) {
        User user = userService.saveUser(userDTO);
        log.info(user.toString());
        return ResponseEntity.ok().body(user);
    }

    @PutMapping("/user")
    public ResponseEntity<User> updateMenu(@Valid @RequestBody UserDTO userDTO) throws URISyntaxException {
        log.debug("REST request to update User : {}", userDTO);
        if(userDTO.getUserId() == null){
            throw new BadRequestAlertException("Invalid UserId", ENTITY_NAME, "id is null");
        }

        User user = userService.saveUser(userDTO);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, userDTO.getUserId().toString()))
                .body(user);
    }

    /**
     *
     * @param userId
     * @return
     */
    @DeleteMapping("/user/{userId}")
    public ResponseEntity<Void> deleteMenu(@PathVariable Long userId){
        log.debug("REST request to delete User : {}", userId);
//        menuService
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, userId.toString())).build();
    }

}
