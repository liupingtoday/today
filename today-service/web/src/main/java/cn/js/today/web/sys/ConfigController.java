package cn.js.today.web.sys;

import cn.js.today.service.ConfigService;
import cn.js.today.service.dto.ConfigDTO;
import cn.js.today.domain.sys.Config;
import cn.js.today.web.errors.BadRequestAlertException;
import io.github.jhipster.web.util.HeaderUtil;
import io.micrometer.core.annotation.Timed;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class ConfigController {

    private final Logger log = LoggerFactory.getLogger(ConfigController.class);

    private ConfigService configService;

    private static final String ENTITY_NAME = "config";

    @Value("${spring.application.name}")
    private String applicationName;

    public ConfigController(ConfigService configService) {
        this.configService = configService;
    }

    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/config/{id}")
    public ResponseEntity<Config> getConfig(@PathVariable Long id) {
        log.debug("REST request to get Config : {}", id);
        Config config = configService.findById(id);
        return ResponseEntity.ok().body(config);
    }

    /**
     *
     * @return
     */
    @Timed
    @ApiOperation(value="栏目新增", notes="栏目新增")
    @GetMapping("/configs")
    public List<Config> getAllConfigs() {
        log.debug("REST request to get all Configs");
        return configService.findAll();
    }

    /**
     *
     * @param configDTO
     * @return
     */
    @PostMapping(value = "/config")
    public ResponseEntity<Config> addConfig(ConfigDTO configDTO) {
        Config config = configService.saveConfig(configDTO);
        log.info(config.toString());
        return ResponseEntity.ok().body(config);
    }

    @PutMapping("/config")
    public ResponseEntity<Config> updateConfig(@Valid @RequestBody ConfigDTO configDTO) throws URISyntaxException {
        log.debug("REST request to update Config : {}", configDTO);
        if(configDTO.getId() == null){
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "id is null");
        }

        Config config = configService.saveConfig(configDTO);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, config.getId().toString()))
                .body(config);
    }
    /**
     *
     * @param id
     * @return
     */
    @DeleteMapping("/config/{id}")
    public ResponseEntity<Void> deleteConfig(@PathVariable Long id){
        log.debug("REST request to delete Config : {}", id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }

}
