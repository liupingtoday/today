package cn.js.today.service.dto.jira;

import java.util.Map;

/**
 * Simple to Introduction
 *
 * @Description: 一句话描述该类的功能
 * @Author: liuping
 * @Since 2020-04-26
 * @UpdateUser: liuping
 * @UpdateDate: 2020-04-26
 * @UpdateRemark: 说明本次修改内容
 * @Version: v1.0
 */
public class PersionWorklog {

    /**
     * 用户名称
     */
    private String username;

    /**
     * 工作日期
     */
    private String worklogDate;

    /**
     * 工作时间
     */
    private Integer worklogHours;



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getWorklogDate() {
        return worklogDate;
    }

    public void setWorklogDate(String worklogDate) {
        this.worklogDate = worklogDate;
    }


    public Integer getWorklogHours() {
        return worklogHours;
    }

    public void setWorklogHours(Integer worklogHours) {
        this.worklogHours = worklogHours;
    }
}

