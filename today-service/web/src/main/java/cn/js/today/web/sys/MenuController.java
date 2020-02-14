package cn.js.today.web.sys;

import cn.js.today.common.CommonResponse;
import cn.js.today.domain.sys.Menu;
import cn.js.today.repository.sys.MenuRepository;
import cn.js.today.service.ConfigService;
import cn.js.today.service.MenuService;
import cn.js.today.service.dto.MenuDTO;
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
import java.util.List;

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
@RestController
@RequestMapping("/api")
public class MenuController {

    private final Logger log = LoggerFactory.getLogger(MenuController.class);

    private ConfigService configService;

    @Autowired
    private MenuService menuService;

    private static final String ENTITY_NAME = "Menu";

    @Value("${spring.application.name}")
    private String applicationName;
//
//    public MenuController(ConfigService configService) {
//        this.configService = configService;
//    }
//
    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/menu/id/{id}")
    public ResponseEntity<Menu> getMenu(@PathVariable Long id) {
        log.debug("REST request to get Menu : {}", id);
        Menu menu = menuService.findById(id);
        return ResponseEntity.ok().body(menu);
    }

    /**
     *
     * @param menuCode
     * @return
     */
    @GetMapping("/menu/menuCode/{menuCode}")
    public ResponseEntity<Menu> getMenu(@PathVariable String menuCode) {
        log.debug("REST request to get Menu : {}", menuCode);
        Menu menu = menuService.findByMenuCode(menuCode);
        return ResponseEntity.ok().body(menu);
    }

    /**
     *
     * @return
     */
    @GetMapping("/menus")
    public CommonResponse<Menu> getAllMenus() {
        log.debug("REST request to get all Configs");
        return CommonResponse.ok(menuService.findAll());
    }

    /**
     *
     * @param menuDTO
     * @return
     */
    @PostMapping(value = "/menu")
    public ResponseEntity<Menu> addMenu(MenuDTO menuDTO) {
        Menu menu = menuService.saveMenu(menuDTO);
        log.info(menu.toString());
        return ResponseEntity.ok().body(menu);
    }

    @PutMapping("/menu")
    public ResponseEntity<Menu> updateMenu(@Valid @RequestBody MenuDTO menuDTO) throws URISyntaxException {
        log.debug("REST request to update Menu : {}", menuDTO);
        if(menuDTO.getMenuCode() == null){
            throw new BadRequestAlertException("Invalid MenuCode", ENTITY_NAME, "id is null");
        }

        Menu config = menuService.saveMenu(menuDTO);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, menuDTO.getMenuCode().toString()))
                .body(config);
    }

    /**
     *
     * @param menuCode
     * @return
     */
    @DeleteMapping("/menu/{menuCode}")
    public ResponseEntity<Void> deleteMenu(@PathVariable Long menuCode){
        log.debug("REST request to delete Menu : {}", menuCode);
//        menuService
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, menuCode.toString())).build();
    }

}
