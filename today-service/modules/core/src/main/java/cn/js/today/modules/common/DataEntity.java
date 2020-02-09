package cn.js.today.modules.common;

import java.util.Date;

/**
 * Simple to Introduction
 *
 * @Description: 一句话描述该类的功能
 * @Author: liuping
 * @Since 2020-01-16
 * @UpdateUser: liuping
 * @UpdateDate: 2020-01-16
 * @UpdateRemark: 说明本次修改内容
 * @Version: v1.0
 */
public class DataEntity<T extends DataEntity<?>> extends BaseEntity<T> {

    /**
     * 创建时间
     */
    protected Date createdTime;

    /**
     * 更新时间
     */
    protected Date updatedTime;

    /**
     * 更新者
     */
    protected String updatedBy;

    /**
     * 创建者
     */
    protected String createdBy;

    /**
     *  备注信息
     */
    protected String remarks;

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
