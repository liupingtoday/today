package cn.js.today.utils;

import cn.hutool.core.date.DateUtil;
import cn.js.today.service.jira.JiraService;
import com.atlassian.httpclient.api.HttpClient;
import com.atlassian.jira.rest.client.api.AuthenticationHandler;
import com.atlassian.jira.rest.client.api.JiraRestClient;
import com.atlassian.jira.rest.client.api.JiraRestClientFactory;
import com.atlassian.jira.rest.client.api.domain.*;
import com.atlassian.jira.rest.client.internal.async.AsynchronousJiraRestClientFactory;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Simple to Introduction
 *
 * @Description: 一句话描述该类的功能
 * @Author: liuping
 * @Since 2020-03-11
 * @UpdateUser: liuping
 * @UpdateDate: 2020-03-11
 * @UpdateRemark: 说明本次修改内容
 * @Version: v1.0
 */
public class JiraUtils {

    private final static Logger log = LoggerFactory.getLogger(JiraUtils.class);

    /**
     *
     * @param jiraURL
     * @param username
     * @param password
     * @return
     * @throws URISyntaxException
     */
    public static JiraRestClient loginJira(String jiraURL, String username, String password) throws URISyntaxException {
        JiraRestClientFactory factory = new AsynchronousJiraRestClientFactory();
        final String JIRA_URL = jiraURL;
        final String JIRA_ADMIN_USERNAME = username;
        final String JIRA_ADMIN_PASSWORD = password;
        final URI jiraServerUri = new URI(JIRA_URL);
        JiraRestClient jiraRestClient = factory.createWithBasicHttpAuthentication(jiraServerUri, JIRA_ADMIN_USERNAME, JIRA_ADMIN_PASSWORD);
//        String ss = jiraRestClient.getIssueClient().getIssue("YJ-1365").claim().getSummary();
//
//        log.info("111111111222222222222222222222222: " + ss);

        return jiraRestClient;
    }

    	/**
	 * 获取并返回指定的Issue对象
	 *
	 * @param issueKey
	 * @param username
	 * @param password
	 * @return
	 * @throws URISyntaxException
	 */
	public static Issue getIssue(String issueKey, String jiraURL, String username, String password) throws URISyntaxException {
		try {
			final JiraRestClient jiraRestClient = loginJira(jiraURL, username, password);
			final Issue issue = jiraRestClient.getIssueClient().getIssue(issueKey).claim();
			return issue;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 *  根据用户名username查找用户信息
	 * @param jiraURL
	 * @param loginUserName
	 * @param loginPassword
	 * @param username
	 * @return
	 * @throws URISyntaxException
	 */
	public static User getUser(String jiraURL, String loginUserName, String loginPassword, String username) throws URISyntaxException {
		try {
			final JiraRestClient jiraRestClient = loginJira(jiraURL, loginUserName, loginPassword);
			final User user = jiraRestClient.getUserClient().getUser(username).claim();
			return user;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

    	/**
	 * 获取指定JIRA的模块
	 *
	 * @param issue
	 * @return
	 * @throws URISyntaxException
	 */
	public static ArrayList<String> getModules(Issue issue) throws URISyntaxException {
		try {
			ArrayList<String> arrayList = new ArrayList<String>();
			Iterator<BasicComponent> basicComponents = issue.getComponents().iterator();
			while (basicComponents.hasNext()) {
				String moduleName = basicComponents.next().getName();
				arrayList.add(moduleName);
			}
			return arrayList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 通过jql语句进行查询并返回一个包含issue的key的数组
	 *
	 * @param username
	 *            登录JIRA的用户名
	 * @param password
	 *            登录JIRA的用户密码
	 * @param jql
	 * @return
	 * @throws URISyntaxException
     **/
	public static ArrayList<String> search_jql(String jiraURL, String username, String password, String jql)
			throws URISyntaxException {
		final JiraRestClient restClient = loginJira(jiraURL, username, password);
		SearchResult searchResult = restClient.getSearchClient().searchJql(jql).claim();
		Iterator<Issue> basicIssues = searchResult.getIssues().iterator();
		ArrayList<String> issueKeys = new ArrayList<>();
		while (basicIssues.hasNext()) {
			String issueKey = basicIssues.next().getKey();
			issueKeys.add(issueKey);
		}
		return issueKeys;
	}

	/**
	 *  根据Issue查询worklog的开始时间数组
	 * @return
	 */
	public static List<String> getWorklogStartDate(Issue issue){
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
		return worklogStartDateList;
	}

}
