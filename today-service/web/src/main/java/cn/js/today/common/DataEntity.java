package cn.js.today.common;

import org.springframework.cloud.cloudfoundry.com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

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
@MappedSuperclass
public abstract class DataEntity<T extends DataEntity<?>> extends BaseEntity<T> {

    /**
     * 创建者
     */
//    @Column(name = "created_by")
    protected String createdBy;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    @Column(name = "created_time")
    protected LocalDateTime createdTime;

    /**
     * 更新者
     */
//    @Column(name = "updated_by")
    protected String updatedBy;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    @Column(name = "updated_time")
    protected LocalDateTime updatedTime;

    /**
     *  备注信息
     */
//    @Column(name = "remarks")
    protected String remarks;

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public LocalDateTime getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(LocalDateTime updatedTime) {
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
