package cn.js.today.service.dto.jira;

/**
 * Simple to Introduction
 *
 * @Description: 一句话描述该类的功能
 * @Author: liuping
 * @Since 2020-03-16
 * @UpdateUser: liuping
 * @UpdateDate: 2020-03-16
 * @UpdateRemark: 说明本次修改内容
 * @Version: v1.0
 */
public class WorklogSpent {
    private String startDate;
    private String spent;

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getSpent() {
        return spent;
    }

    public void setSpent(String spent) {
        this.spent = spent;
    }
}
