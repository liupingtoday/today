package cn.js.today.service.dto.jira;

import java.util.Map;
import java.util.TreeMap;

/**
 * Simple to Introduction
 *
 * @Description: 一句话描述该类的功能
 * @Author: liuping
 * @Since 2020-03-14
 * @UpdateUser: liuping
 * @UpdateDate: 2020-03-14
 * @UpdateRemark: 说明本次修改内容
 * @Version: v1.0
 */
public class UserWorklog {

    private String username;
    private Map<String,Integer> everydaySpentTime = new TreeMap<>();//key 为日期，value 为耗时


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Map<String, Integer> getEverydaySpentTime() {
        return everydaySpentTime;
    }

    public void setEverydaySpentTime(Map<String, Integer> everydaySpentTime) {
        this.everydaySpentTime = everydaySpentTime;
    }

    @Override
    public String toString() {
        return "UserWorklog{" +
                "username='" + username + '\'' +
                ", everydaySpentTime=" + everydaySpentTime +
                '}';
    }
}

