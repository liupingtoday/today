package cn.js.today.service.dto.gantt;

import cn.js.today.common.DataEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

/**
 * Simple to Introduction
 *
 * @Description: 一句话描述该类的功能
 * @Author: liuping
 * @Since 2020-02-20
 * @UpdateUser: liuping
 * @UpdateDate: 2020-02-20
 * @UpdateRemark: 说明本次修改内容
 * @Version: v1.0
 */
public class TaskDTO {

//    @NotBlank
    private Long taskId;

    private String name;

    private String progress;

    private String description;

    private String level;

    private String status;

    private String start;

    private String end;

    private String duration;

    private String startIsMilestone;

    private String endIsMilestone;

    private String canWrite;

    private String canAdd;

    private String canDelete;

    private String canAddIssue;

    private String collapsed;

    private String hasChild;

    private String resourceId;

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getStartIsMilestone() {
        return startIsMilestone;
    }

    public void setStartIsMilestone(String startIsMilestone) {
        this.startIsMilestone = startIsMilestone;
    }

    public String getEndIsMilestone() {
        return endIsMilestone;
    }

    public void setEndIsMilestone(String endIsMilestone) {
        this.endIsMilestone = endIsMilestone;
    }

    public String getCanWrite() {
        return canWrite;
    }

    public void setCanWrite(String canWrite) {
        this.canWrite = canWrite;
    }

    public String getCanAdd() {
        return canAdd;
    }

    public void setCanAdd(String canAdd) {
        this.canAdd = canAdd;
    }

    public String getCanDelete() {
        return canDelete;
    }

    public void setCanDelete(String canDelete) {
        this.canDelete = canDelete;
    }

    public String getCanAddIssue() {
        return canAddIssue;
    }

    public void setCanAddIssue(String canAddIssue) {
        this.canAddIssue = canAddIssue;
    }

    public String getCollapsed() {
        return collapsed;
    }

    public void setCollapsed(String collapsed) {
        this.collapsed = collapsed;
    }

    public String getHasChild() {
        return hasChild;
    }

    public void setHasChild(String hasChild) {
        this.hasChild = hasChild;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    @Override
    public String toString() {
        return "TaskDTO{" +
                "taskId=" + taskId +
                ", name='" + name + '\'' +
                ", progress='" + progress + '\'' +
                ", description='" + description + '\'' +
                ", level='" + level + '\'' +
                ", status='" + status + '\'' +
                ", start='" + start + '\'' +
                ", end='" + end + '\'' +
                ", duration='" + duration + '\'' +
                ", startIsMilestone='" + startIsMilestone + '\'' +
                ", endIsMilestone='" + endIsMilestone + '\'' +
                ", canWrite='" + canWrite + '\'' +
                ", canAdd='" + canAdd + '\'' +
                ", canDelete='" + canDelete + '\'' +
                ", canAddIssue='" + canAddIssue + '\'' +
                ", collapsed='" + collapsed + '\'' +
                ", hasChild='" + hasChild + '\'' +
                ", resourceId='" + resourceId + '\'' +
                '}';
    }
}
