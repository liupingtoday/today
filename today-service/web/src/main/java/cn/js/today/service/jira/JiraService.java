package cn.js.today.service.jira;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.EscapeUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import cn.js.today.domain.sys.User;
import cn.js.today.repository.sys.UserRepository;
import cn.js.today.service.dto.jira.JiraIssueDTO;
import cn.js.today.service.dto.jira.UserWorklog;
import cn.js.today.service.dto.sys.UserDTO;
import cn.js.today.service.mapper.UserMapper;
import cn.js.today.utils.JiraUtils;
import com.atlassian.jira.rest.client.api.JiraRestClient;
import com.atlassian.jira.rest.client.api.domain.BasicUser;
import com.atlassian.jira.rest.client.api.domain.Issue;
import com.atlassian.jira.rest.client.api.domain.Worklog;
import net.sf.jmimemagic.MagicParseException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.DatatypeConverter;
import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
@Service
public class JiraService {

    private final Logger log = LoggerFactory.getLogger(JiraService.class);

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private ConfigMapper configMapper;
    @Autowired
    private UserMapper userMapper;

    /**
     *
     * @param userName 需要查询的用户名称
     */
    public JSONArray getWorklog(String jiraURL, String loginUserName, String loginPassword, String userName, String beginDate, String endDate){
        String jiraURL2 = "http://jira.cmvideo.cn/rest/api/latest/search?jql=worklogAuthor = liuping AND worklogDate " + EscapeUtil.escape(">") + "=2020/3/01" +  "AND worklogDate " + EscapeUtil.escape("<") + "=2020/12/31" + "";
//        String jiraURL = "http://jira.cmvideo.cn/rest/api/latest/search?jql=worklogAuthor%20=%20liuping%20AND%20worklogDate%20%3E=%20%222020/3/01%22%20AND%20worklogDate%20%3C=%20%222020/3/31%22";
        String jiraURL3 = "http://jira.cmvideo.cn/rest/api/latest/search?jql=worklogAuthor%20=%20" + userName + "%20AND%20worklogDate%20%3E=%20%22" + beginDate + "%22%20AND%20worklogDate%20%3C=%20%22" + endDate + "%22";

        try {
            JiraRestClient jiraRestClient = JiraUtils.loginJira(jiraURL3,loginUserName,loginPassword);
        } catch (URISyntaxException e) {
            log.info("-------------------------error!!!!");
            e.printStackTrace();
        }

        HttpResponse httpResponse = null;
        try {
            String plainCredentials = loginUserName + ":" + loginPassword;
            String base64Credentials = new String(Base64.encodeBase64(plainCredentials.getBytes()));
            httpResponse = HttpRequest.get(jiraURL3).header("Authorization","Basic " + base64Credentials).timeout(30*1000).execute();
        } catch (Exception e) {
            log.info("error-----" + e.getMessage());
            return JSONUtil.createArray();
        }
        //请求不成功的情况
        if(!httpResponse.isOk()){
            return JSONUtil.createArray();
        }
        String httpResponseStr = httpResponse.body();
        log.info("httpResponseStr:" + httpResponseStr);

        JSONObject jsonObject = JSONUtil.parseObj(httpResponseStr);
        Integer total = (Integer)jsonObject.get("total");
        Integer maxResults = (Integer)jsonObject.get("maxResults");
        JSONArray issueJsonArray = JSONUtil.createArray();
        if(total > 0){
            JSONArray issuesJsonArray = (JSONArray)jsonObject.get("issues");
            for(int i = 0; i < issuesJsonArray.size(); i++){
                JSONObject issueJsonObject = (JSONObject)issuesJsonArray.get(i);
                JiraIssueDTO jiraIssueDTO = new JiraIssueDTO();
                String issueKey = (String)issueJsonObject.get("key");
                log.info("-----------------------------------------issueKey:" + issueKey);

                try {
                    Issue issue = JiraUtils.getIssue(issueKey, jiraURL, loginUserName, loginPassword);

                    if(ObjectUtil.isNotNull(issue.getSummary())){
                        log.info("-----------=======########========summary:" + issue.getSummary());
                    }
                    Iterable<Worklog> worklogIterable = issue.getWorklogs();
                    Iterator worklogIterator = worklogIterable.iterator();

                    List<String> worklogStartDateList = new ArrayList<>();
                    while (worklogIterator.hasNext()){
                        Worklog worklog = (Worklog)worklogIterator.next();
                        DateTime worklogDateTime = worklog.getStartDate();
                        String worklogDateTimeStr =  DateUtil.formatDate(worklogDateTime.toDate());
                        log.info("-----------===============worklogDateTimeStr:" + worklogDateTimeStr);

                        worklogStartDateList.add(worklogDateTimeStr);
                    }
                    String worklogStartDateListStr = worklogStartDateList.toString();
                    worklogStartDateListStr = StrUtil.removePrefix(worklogStartDateListStr,"[");
                    worklogStartDateListStr = StrUtil.removeSuffix(worklogStartDateListStr,"]");
                    jiraIssueDTO.setWorklogStartDate(worklogStartDateListStr);
                    //根据登录的工时转化为任务的开始时间和结束时间
                    String[] worklogStartDateArr = StringUtils.split(worklogStartDateListStr,",");
                    if(worklogStartDateArr.length == 0){
                        jiraIssueDTO.setWorkStartDate(worklogStartDateArr[0]);
                        jiraIssueDTO.setWorkEndDate(worklogStartDateArr[0]);
                    }else {
                        jiraIssueDTO.setWorkStartDate(worklogStartDateArr[0]);
                        jiraIssueDTO.setWorkEndDate(worklogStartDateArr[worklogStartDateArr.length-1]);
                    }

                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }

                jiraIssueDTO.setKey(issueKey);
                JSONObject fieldsJsonObject = (JSONObject)issueJsonObject.get("fields");
                String issueSummary = (String)fieldsJsonObject.get("summary");
                jiraIssueDTO.setSummary(issueSummary);
                if(ObjectUtil.isNotNull(fieldsJsonObject.get("description"))){
                    String issueDescription = (String)fieldsJsonObject.get("description");
                    jiraIssueDTO.setDescription(issueDescription);
                }else {
                    //如果描述为空，则将概要赋值于描述
                    jiraIssueDTO.setDescription(issueSummary);
                }

                String issueTimespent = (Integer)fieldsJsonObject.get("timespent") + "";
                issueTimespent = Integer.valueOf(issueTimespent)/60/60 + "";
                jiraIssueDTO.setTimespent(issueTimespent);
                String issueAggregatetimespent = (Integer)fieldsJsonObject.get("aggregatetimespent") + "";
                issueAggregatetimespent = Integer.valueOf(issueAggregatetimespent)/60/60 + "";
                jiraIssueDTO.setAggregatetimespent(issueAggregatetimespent);     //
                String issueCreated = (String)fieldsJsonObject.get("created");
                jiraIssueDTO.setIssueCreated(issueCreated);
                JSONObject issuetypeJSONObject = (JSONObject)fieldsJsonObject.get("issuetype");
                String issuetypeName = (String)issuetypeJSONObject.get("name");
                jiraIssueDTO.setIssuetypeName(issuetypeName);
                JSONObject assigneeJSONObject = (JSONObject)fieldsJsonObject.get("assignee");
                String assigneeDisplayName = (String)assigneeJSONObject.get("displayName");//经办人
                jiraIssueDTO.setAssigneeDisplayName(assigneeDisplayName);
                String emailAddress = (String)assigneeJSONObject.get("emailAddress");//经办人邮箱
                jiraIssueDTO.setEmailAddress(emailAddress);
                JSONArray componentsJSONArray = (JSONArray)fieldsJsonObject.get("components");//模块
                List componentNameList = new ArrayList();
                for(int j = 0; j < componentsJSONArray.size(); j++){
                    JSONObject componentJSONObject = (JSONObject)componentsJSONArray.get(j);
                    String componentName = (String)componentJSONObject.get("name");//模块名称
                    componentNameList.add(componentName);
                }

                if(ObjectUtil.isNotNull(componentNameList)){
                    if(componentNameList.toString().indexOf("[") != -1){
                        String componentNameListStr = componentNameList.toString();
                        componentNameListStr = StrUtil.removePrefix(componentNameListStr,"[");
                        componentNameListStr = StrUtil.removeSuffix(componentNameListStr,"]");
                        if(StringUtils.isBlank(componentNameListStr)){
                            jiraIssueDTO.setComponentName("云剪");
                        }else {
                            jiraIssueDTO.setComponentName(componentNameListStr);
                        }

                    }
                }

                JSONArray fixVersionsJSONArray = (JSONArray)fieldsJsonObject.get("fixVersions");//修复的版本

                if(ObjectUtil.isNotNull(fixVersionsJSONArray)){
                    List fixVersionNameList = new ArrayList();
                    for(int j = 0; j < fixVersionsJSONArray.size(); j++){
                        JSONObject fixVersionsJSONObject = (JSONObject)fixVersionsJSONArray.get(j);
                        String fixVersionName = (String)fixVersionsJSONObject.get("name");//

                        //TODO
                        String releaseDate = (String) fixVersionsJSONObject.get("releaseDate");  // "2020-03-26"
                        fixVersionNameList.add(fixVersionName);
                    }
                    jiraIssueDTO.setFixVersionName(fixVersionNameList);
                }

//                jiraIssueDTO.setReleaseDate(releaseDate);
                issueJsonArray.add(jiraIssueDTO);
            }
        }
        return issueJsonArray;
    }

    /**
     *
     * @param jiraURL
     * @param loginUserName
     * @param loginPassword
     * @param userName
     * @param beginDate
     * @param endDate
     * @return
     */
    public List<JiraIssueDTO> getExportWorklogRows(String jiraURL, String loginUserName, String loginPassword, String userName, String beginDate, String endDate){

        List<JiraIssueDTO> jiraIssueDTOList = getWorklog(jiraURL, loginUserName, loginPassword, userName, beginDate, endDate).toList(JiraIssueDTO.class);
        return jiraIssueDTOList;
    }

    public  void getAllWorklog(){

    }

    /**
     * 根据用户名称获取这个用户的worklog
     * @param jiraURL
     * @param loginUserName
     * @param loginPassword
     * @param userName
     * @param beginDate
     * @param endDate
     * @return
     */
    public JSONObject getWorklogByUserName(String jiraURL, String loginUserName, String loginPassword, String userName, String beginDate, String endDate){
        String jiraURL3 = "http://jira.cmvideo.cn/rest/api/latest/search?jql=worklogAuthor%20=%20" + userName + "%20AND%20worklogDate%20%3E=%20%22" + beginDate + "%22%20AND%20worklogDate%20%3C=%20%22" + endDate + "%22";

        HttpResponse httpResponse = null;
        try {
            String plainCredentials = loginUserName + ":" + loginPassword;
            String base64Credentials = new String(Base64.encodeBase64(plainCredentials.getBytes()));
            httpResponse = HttpRequest.get(jiraURL3).header("Authorization","Basic " + base64Credentials).timeout(30*1000).execute();
        } catch (Exception e) {
            log.info("error-----" + e.getMessage());
            return JSONUtil.createObj();
        }
        //请求不成功的情况
        if(!httpResponse.isOk()){
            return JSONUtil.createObj();
        }
        String httpResponseStr = httpResponse.body();
        log.info("httpResponseStr:" + httpResponseStr);

        JSONObject jsonObject = JSONUtil.parseObj(httpResponseStr);
        Integer total = (Integer)jsonObject.get("total");
        Integer maxResults = (Integer)jsonObject.get("maxResults");
        JSONArray issueJsonArray = JSONUtil.createArray();
        List<Worklog> userWorklogList = new ArrayList();
        //存放所有用户这一段时间的worklog记录
//        Map allUserWorklog = new HashMap();
        if(total > 0){
            JSONArray issuesJsonArray = (JSONArray)jsonObject.get("issues");
            for(int i = 0; i < issuesJsonArray.size(); i++){
                JSONObject issueJsonObject = (JSONObject)issuesJsonArray.get(i);
                String issueKey = (String)issueJsonObject.get("key");
                log.info("-----------------------------------------issueKey:" + issueKey);

                try {
                    Issue issue = JiraUtils.getIssue(issueKey, jiraURL, loginUserName, loginPassword);
                    com.atlassian.jira.rest.client.api.domain.User user = JiraUtils.getUser(jiraURL,loginUserName,loginPassword,userName);
                    if(ObjectUtil.isNotNull(issue.getSummary())){
                        log.info("-----------=======########========summary:" + issue.getSummary());
                    }
                    Iterable<Worklog> worklogIterable = issue.getWorklogs();
                    Iterator worklogIterator = worklogIterable.iterator();

//                    List<String> worklogStartDateList = new ArrayList<>();
                    while (worklogIterator.hasNext()){
                        Worklog worklog = (Worklog)worklogIterator.next();
                        BasicUser basicUser = worklog.getAuthor();
                        String displayName = basicUser.getDisplayName();
//                        log.info("##@@@@##################DisplayName : " + displayName);
                        if(user.getDisplayName().equals(displayName)){
                            //只添加当前用户的工作日志
                            userWorklogList.add(worklog);
                        }
                    }

                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }
            }
        }

        UserWorklog userWorklog = parseUserWorklog(userWorklogList) ;

        return JSONUtil.parseObj(userWorklog);
    }

    public UserWorklog parseUserWorklog(List<Worklog> worklogList){
        UserWorklog userWorklog = new UserWorklog();
        String userDisplayName = "";
        Map<String,Float> erverydaySpentTime = new HashMap<>();
        for(int i = 0; i < worklogList.size(); i++){

            Worklog worklog = worklogList.get(i);
            BasicUser basicUser = worklog.getAuthor();
            userDisplayName = basicUser.getDisplayName();
            String date = DateUtil.formatDate(worklog.getStartDate().toDate());
            int workTime = worklog.getMinutesSpent();
            Float costHourTemp = Float.valueOf(workTime/60); //单位：小时
            if(erverydaySpentTime.containsKey(date)){
                Float totalTime = erverydaySpentTime.get(date) + costHourTemp;
                Float costHour = Float.valueOf(totalTime);
                erverydaySpentTime.put(date,costHour);
            }else {
                erverydaySpentTime.put(date,costHourTemp);
            }
        }
        userWorklog.setErverydaySpentTime(erverydaySpentTime);
        userWorklog.setUsername(userDisplayName);
        return userWorklog;

    }

//    public void getAggregatetimespentByUsername(String jiraURL, String loginUserName, String loginPassword, String userName, String startDate, String endDate){
//        JSONArray worklogJsonArray = getWorklog(jiraURL, loginUserName, loginPassword, userName, startDate, endDate);
//    }


    public void test() throws ClientProtocolException, IOException {
        // 认证信息对象，用于包含访问翻译服务的用户名和密码

        String path = "http://jira.cmvideo.cn";
        // 1.创建客户端访问服务器的httpclient对象 打开浏览器
        HttpClient httpclient = HttpClients.createDefault();
        // 2.以请求的连接地址创建get请求对象 浏览器中输入网址
        HttpGet httpget = new HttpGet(path);

        // username:password--->访问的用户名，密码,并使用base64进行加密，将加密的字节信息转化为string类型，encoding--->token
        String encoding = DatatypeConverter.printBase64Binary("liuping:123456".getBytes("UTF-8"));

        log.info("Authorization:" + "Basic " + encoding);
        httpget.setHeader("Authorization", "Basic " + encoding);
        // 3.向服务器端发送请求 并且获取响应对象 浏览器中输入网址点击回车
        org.apache.http.HttpResponse response = httpclient.execute(httpget);
        // 4.获取响应对象中的响应码
        StatusLine statusLine = response.getStatusLine();// 获取请求对象中的响应行对象
        int responseCode = statusLine.getStatusCode();// 从状态行中获取状态码

        System.out.println(responseCode);
        if (HttpStatus.SC_OK == responseCode) {
            // 5. 可以接收和发送消息
            HttpEntity entity = response.getEntity();
            // 6.从消息载体对象中获取操作的读取流对象
            InputStream input = entity.getContent();
            BufferedReader br = new BufferedReader(new InputStreamReader(input));

            String line = null;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            String result = new String(sb.toString().getBytes("utf-8"), "utf-8");
//            System.out.println("服务器的响应是:" + result);
            log.info("1111111111服务器的响应是:" + result);
            br.close();
            input.close();
        } else {
            System.out.println("响应失败!");
        }
    }


    /**
     *
     *
     * @param url
     * @param param
     * @return
     */
    public String getAPIResult(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            URLConnection conn = realUrl.openConnection();
            conn.setConnectTimeout(5000);
            String plainCredentials = "liuping:123456";
            String base64Credentials = new String(Base64.encodeBase64(plainCredentials.getBytes()));
            log.info("Authorization:" +  "Basic " + base64Credentials);
            conn.setRequestProperty("Authorization", "Basic " + base64Credentials);
//            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("Content-type", "application/json");
//            conn.setRequestProperty("connection", "Keep-Alive");
//            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            out = new PrintWriter(conn.getOutputStream());
//            out.print(param);
            out.flush();
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
                in.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }


    public User saveUser(UserDTO userDTO){
        User user = userMapper.userDTO2User(userDTO);
        return userRepository.save(user);
    }

    public User findByUserId(Long userId){
        Optional<User> user = userRepository.findOneByUserCode(userId);
        return user.orElse(null);
    }

    /**
     *
     * @param userName
     * @return
     */
    public User findByUserName(String userName){
        return userRepository.findOneByUserName(userName).orElse(null);
    }

    /**
     *
     * @return
     */
    public List<User> findAll(){
        return userRepository.findAll();
    }

}
