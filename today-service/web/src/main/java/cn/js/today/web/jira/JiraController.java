package cn.js.today.web.jira;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import cn.js.today.domain.sys.Config;
import cn.js.today.domain.sys.User;
import cn.js.today.service.dto.jira.JiraIssueDTO;
import cn.js.today.service.dto.jira.PersionWorklog;
import cn.js.today.service.dto.jira.UserWorklog;
import cn.js.today.service.dto.sys.ConfigDTO;
import cn.js.today.service.jira.JiraService;
import cn.js.today.service.sys.ConfigService;
import cn.js.today.service.sys.UserService;
import cn.js.today.web.errors.BadRequestAlertException;
import io.github.jhipster.web.util.HeaderUtil;
import io.micrometer.core.annotation.Timed;
import io.swagger.annotations.ApiOperation;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
@ApiOperation("获取jira内容")
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
            if("0".equals(user.getStatus())){
                String loginCode = user.getLoginCode();
                List<JiraIssueDTO> jiraIssueDTOList = jiraService.getExportWorklogRows("http://jira.cmvideo.cn", "liuping","123456", loginCode,beginDate,endDate);
                jiraIssueDTOAllList.addAll(jiraIssueDTOList);
                allWorklogJsonArray.addAll(jiraIssueDTOList);
            }
        }


        //通过工具类创建writer
        ExcelWriter writer = ExcelUtil.getWriter("C:/data/writeTest.xlsx");
        //自定义标题别名
        writer.addHeaderAlias("key", "JIRA的ID");
        writer.addHeaderAlias("componentName", "模块");
        writer.addHeaderAlias("summary", "概要");
        writer.addHeaderAlias("description", "描述");
//        writer.addHeaderAlias("worklogStartDate", "登陆工时开始日期");
        writer.addHeaderAlias("workStartDate", "开始时间");
        writer.addHeaderAlias("workEndDate", "结束时间");
        writer.addHeaderAlias("timespent", "工时耗时");
        writer.addHeaderAlias("issuetypeName", "问题类型");
        writer.addHeaderAlias("assigneeDisplayName", "经办人");
        writer.addHeaderAlias("aggregatetimespent", "总耗时");
        writer.addHeaderAlias("emailAddress", "邮箱地址");
        writer.addHeaderAlias("issueCreated", "创建时间");

        // 一次性写出内容，使用默认样式
        writer.write(jiraIssueDTOAllList);
        // 关闭writer，释放内存
        writer.close();

        return ResponseEntity.ok().body(allWorklogJsonArray);

    }

    /**
     * 根据用户姓名获取个人的指定时间段内的工时
     * @param userName 姓名
     * @param beginDate
     * @param endDate
     * @return
     */
    @GetMapping("/jira/worklog/userName")
    public ResponseEntity<UserWorklog> getJiraPersonWorklogSpent(String userName, String beginDate, String endDate) {
        log.info("88888888userName:" + userName + ",beginDate:" + beginDate + ",endDate:" + endDate);
        User user = userService.findByUserName(userName);
        List<PersionWorklog> persionWorklogList = jiraService.getWorklogRows("http://jira.cmvideo.cn", "liuping","123456", user.getLoginCode(),beginDate,endDate);
        log.info("@@@@@@@@@@@@@@@@@@@@@@@@" + persionWorklogList.size());
        UserWorklog userWorklog = parseWorklogByUserName(beginDate, endDate, userName, persionWorklogList);
        log.info("@@@@@-------------@@@@@@" + userWorklog.toString());
        return ResponseEntity.ok().body(userWorklog);
    }


    /**
     * 根据开始时间和结束时间查询所有人的工时信息
     * @param beginDate
     * @param endDate
     * @return
     */
    @GetMapping("/jira/worklog/allSpent")
    public ResponseEntity<List<UserWorklog>> getJiraAllWorklogSpent(String beginDate, String endDate) {
        List<User> userList = userService.findAll();
//        log.info("userList . size:" + userList.size());
        List<PersionWorklog> allPersionWorklogList = new ArrayList<>();
        for(User user : userList){
            if("0".equals(user.getStatus())){
                String loginCode = user.getLoginCode();
                List<PersionWorklog> persionWorklogList = jiraService.getWorklogRows("http://jira.cmvideo.cn", "liuping","123456", loginCode,beginDate,endDate);
                allPersionWorklogList.addAll(persionWorklogList);
            }

        }

        List<UserWorklog> userWorklogList = new ArrayList<>();
        for(User user : userList){
            if("0".equals(user.getStatus())){
                UserWorklog userWorklog = parseWorklogByUserName(beginDate, endDate, user.getUserName(), allPersionWorklogList);
                userWorklogList.add(userWorklog);
            }
        }
        JSONArray userWorklogListJsonArray=new JSONArray(userWorklogList);
        log.info("~~~~~~~~~~~~~~~~~~~~~~~~~~~QQQQQQQQQ----------------------:" + userWorklogListJsonArray);
        return ResponseEntity.ok().body(userWorklogList);

    }

    public UserWorklog parseWorklogByUserName(String beginDate, String endDate, String worklogUserName, List<PersionWorklog> allPersionWorklogList){
        UserWorklog userWorklog = new UserWorklog();
        for(int i = 0; i < allPersionWorklogList.size(); i++){
            PersionWorklog persionWorklog = allPersionWorklogList.get(i);
            String userName = persionWorklog.getUsername();
            log.info("HHHHHHHJJJJJJJJJJJJJJJ---------userName:" + userName);
            log.info("HHHHHHHhhgggggggggggggg---------worklogUserName:" + worklogUserName);
            if(userName.equals(worklogUserName) && ObjectUtil.isNotNull(userName)){
                userWorklog.setUsername(userName);
                log.info("HHHHHHHHHHHHHHHHHHHHH---------userName:" + userName);
                Map<String, Integer> everydaySpentTime = userWorklog.getEverydaySpentTime();
                String persionWorklogDate = persionWorklog.getWorklogDate();
                //工作日志的时间小于查询时间，则退出循环
                int comparedBeginDate = persionWorklogDate.compareTo(beginDate);
                int comparedendDate = persionWorklogDate.compareTo(endDate);
                if(comparedBeginDate < 0){
                    continue;
                }
                if(comparedendDate > 0){
                    continue;
                }

                if(everydaySpentTime.containsKey(persionWorklogDate)){
                    //包含该日期，则计算
                    Integer totalSpentTime = everydaySpentTime.get(persionWorklogDate) + persionWorklog.getWorklogHours();
                    everydaySpentTime.remove(persionWorklogDate);
                    everydaySpentTime.put(persionWorklogDate, totalSpentTime);
                }else {
                    //新增日期的工时
                    everydaySpentTime.put(persionWorklogDate,persionWorklog.getWorklogHours());
                }
            }else{
                log.info("------------#########------userName和worklogUserName不等:" + worklogUserName + "," + userName);
            }
        }
        return userWorklog;

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
