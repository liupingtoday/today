package cn.js.today.service.dto.jira;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private Map<String,Float> erverydaySpentTime;//key 为日期，value 为耗时


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public Map<String, Float> getErverydaySpentTime() {
        return erverydaySpentTime;
    }

    public void setErverydaySpentTime(Map<String, Float> erverydaySpentTime) {
        this.erverydaySpentTime = erverydaySpentTime;
    }

}

