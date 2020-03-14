package cn.js.today.service.dto.jira;

import cn.js.today.common.DataEntity;

import java.util.List;


/**
 * Simple to Introduction
 *
 * @Description: 一句话描述该类的功能
 * @Author: liuping
 * @Since 2020-03-10
 * @UpdateUser: liuping
 * @UpdateDate: 2020-03-10
 * @UpdateRemark: 说明本次修改内容
 * @Version: v1.0
 */
public class JiraIssueDTO extends DataEntity<JiraIssueDTO> {

    /**
     *  key
     */
    private String key;

    /**
     *  概要
     */
    private String summary;

    /**
     *  描述
     */
    private String description;

    /**
     * 耗时,单位：毫秒
     */
    private String timespent;

    /**
     *  总耗时,单位：毫秒
     */
    private String aggregatetimespent;

    /**
     *  问题类型的名称
     */
    private String issuetypeName;

    /**
     * 经办人
     */
    private String assigneeDisplayName;

    /**
     * 创建日期
     */
    private String issueCreated;

    /**
     * 模块名称
     */
    private String componentName;

    /**
     * 修复版本号
     */
    private List fixVersionName;

    /**
     *  发布版本日期
     */
    private String releaseDate;

    /**
     * 经办人邮箱
     */
    private String emailAddress;

    /**
     * 工作日志的开始日期
     */
    private String worklogStartDate;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getWorklogStartDate() {
        return worklogStartDate;
    }

    public void setWorklogStartDate(String worklogStartDate) {
        this.worklogStartDate = worklogStartDate;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getTimespent() {
        return timespent;
    }

    public void setTimespent(String timespent) {
        this.timespent = timespent;
    }

    public String getAggregatetimespent() {
        return aggregatetimespent;
    }

    public void setAggregatetimespent(String aggregatetimespent) {
        this.aggregatetimespent = aggregatetimespent;
    }

    public String getAssigneeDisplayName() {
        return assigneeDisplayName;
    }

    public void setAssigneeDisplayName(String assigneeDisplayName) {
        this.assigneeDisplayName = assigneeDisplayName;
    }

    public String getIssueCreated() {
        return issueCreated;
    }

    public void setIssueCreated(String issueCreated) {
        this.issueCreated = issueCreated;
    }

    public String getComponentName() {
        return componentName;
    }

    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }

    public List getFixVersionName() {
        return fixVersionName;
    }

    public void setFixVersionName(List fixVersionName) {
        this.fixVersionName = fixVersionName;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getIssuetypeName() {
        return issuetypeName;
    }

    public void setIssuetypeName(String issuetypeName) {
        this.issuetypeName = issuetypeName;
    }
}
