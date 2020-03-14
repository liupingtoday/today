package cn.js.today.web.jira;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import cn.js.today.domain.sys.Config;
import cn.js.today.domain.sys.User;
import cn.js.today.service.dto.jira.JiraIssueDTO;
import cn.js.today.service.dto.sys.ConfigDTO;
import cn.js.today.service.jira.JiraService;
import cn.js.today.service.sys.ConfigService;
import cn.js.today.service.sys.UserService;
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
import java.util.ArrayList;
import java.util.List;

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
public class JiraController {

    private final Logger log = LoggerFactory.getLogger(JiraController.class);

    @Autowired
    private ConfigService configService;

    @Autowired
    private JiraService jiraService;

    @Autowired
    private UserService userService;

    private static final String ENTITY_NAME = "jira";

    @Value("${spring.application.name}")
    private String applicationName;


    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/jira/{id}")
    public ResponseEntity<Config> getConfig(@PathVariable Long id) {
        log.debug("REST request to get Config : {}", id);
        Config config = configService.findById(id);
        return ResponseEntity.ok().body(config);
    }

    /**
     *
     * @param
     * @return
     */
    @GetMapping("/jira/worklog/{userName}")
    public ResponseEntity<JSONArray> getJiraWorklogByUserName(@PathVariable String userName) {
        log.debug("REST request to get Jira : {}", userName);
        JSONArray jsonArray = jiraService.getWorklog("http://jira.cmvideo.cn", userName,"123456", "wumin","2020-02-01","2020-03-01");
        return ResponseEntity.ok().body(jsonArray);

    }

    @GetMapping("/jira/worklog/all")
    public ResponseEntity<JSONArray> getJiraAllWorklog(String beginDate, String endDate) {
        List<User> userList = userService.findAll();
        JSONArray allWorklogJsonArray = JSONUtil.createArray();
        List<JiraIssueDTO> jiraIssueDTOAllList = new ArrayList<>();

        for(User user : userList){
            String loginCode = user.getLoginCode();
//            JSONArray jsonArray = jiraService.getWorklog("http://jira.cmvideo.cn", "liuping","123456", loginCode,beginDate,endDate);
            List<JiraIssueDTO> jiraIssueDTOList = jiraService.getExportWorklogRows("http://jira.cmvideo.cn", "liuping","123456", loginCode,beginDate,endDate);
            jiraIssueDTOAllList.addAll(jiraIssueDTOList);
            allWorklogJsonArray.addAll(jiraIssueDTOList);
        }



        //通过工具类创建writer
        ExcelWriter writer = ExcelUtil.getWriter("C:/data/writeTest12.xlsx");
        //自定义标题别名
        writer.addHeaderAlias("key", "JIRA的ID");
        writer.addHeaderAlias("componentName", "模块");
        writer.addHeaderAlias("summary", "概要");
        writer.addHeaderAlias("description", "描述");
        writer.addHeaderAlias("worklogStartDate", "登陆工时开始日期");
        writer.addHeaderAlias("timespent", "工时耗时");
        writer.addHeaderAlias("issuetypeName", "问题类型");
        writer.addHeaderAlias("assigneeDisplayName", "经办人");
        writer.addHeaderAlias("aggregatetimespent", "总耗时");

        // 一次性写出内容，使用默认样式
        writer.write(jiraIssueDTOAllList);
        // 关闭writer，释放内存
        writer.close();

        return ResponseEntity.ok().body(allWorklogJsonArray);

    }

    @GetMapping("/jira/worklog/user")
    public ResponseEntity<JSONObject> getJiraAllWorklog(String username, String beginDate, String endDate){

        JSONObject jsonArray = jiraService.getWorklogByUserName("http://jira.cmvideo.cn", "liuping","123456", username,beginDate,endDate);
        return ResponseEntity.ok().body(jsonArray);
    }


    /**
     *
     * @return
     */
    @Timed
    @ApiOperation(value="栏目新增", notes="栏目新增")
    @GetMapping("/jiras")
    public List<Config> getAllConfigs() {
        log.debug("REST request to get all Configs");
        return configService.findAll();
    }

    /**
     *
     * @param configDTO
     * @return
     */
    @PostMapping(value = "/jira")
    public ResponseEntity<Config> addConfig(ConfigDTO configDTO) {
        Config config = configService.saveConfig(configDTO);
        log.info(config.toString());
        return ResponseEntity.ok().body(config);
    }

    @PutMapping("/jira")
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
    @DeleteMapping("/jira/{id}")
    public ResponseEntity<Void> deleteConfig(@PathVariable Long id){
        log.debug("REST request to delete Config : {}", id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }

}
