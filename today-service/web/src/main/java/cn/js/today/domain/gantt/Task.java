package cn.js.today.domain.gantt;

import cn.js.today.common.DataEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import javax.persistence.*;
import java.util.List;

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
@Entity
@Table(name = "gantt_task")
@JsonInclude(value= JsonInclude.Include.NON_NULL)
public class Task extends DataEntity<Task> {

    /**
     * 编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonSerialize(using = ToStringSerializer.class)
    private Long taskId;

    /**
     * 任务名称
     */
    @Column(name = "name")
    private String name;

    /**
     * 进度
     */
    @Column(name = "progress")
    private String progress;

    /**
     * 描述
     */
    @Column(name = "description", length = 2000)
    private String description;

    /**
     * 等级
     */
    @Column(name = "level")
    private String level;

    /**
     * 状态
     */
    @Column(name = "status")
    private String status;

    /**
     * 任务开始时间
     */
    @Column(name = "start")
    private String start;

    /**
     * 任务结束时间
     */
    @Column(name = "end")
    private String end;

    /**
     * 任务耗时，单位：天
     */
    @Column(name = "duration")
    private String duration;

    /**
     *
     */
    @Column(name = "start_is_milestone")
    private String startIsMilestone;

    /**
     *
     */
    @Column(name = "end_is_milestone")
    private String endIsMilestone;

    /**
     *
     */
    @Column(name = "can_write")
    private String canWrite;

    /**
     *
     */
    @Column(name = "can_add")
    private String canAdd;

    /**
     *
     */
    @Column(name = "can_delete")
    private String canDelete;

    /**
     *
     */
    @Column(name = "can_add_issue")
    private String canAddIssue;

    /**
     *
     */
    @Column(name = "collapsed")
    private String collapsed;

    /**
     *
     */
    @Column(name = "has_child")
    private String hasChild;

    /**
     * 责任人,ID,以逗号分隔
     */
    @Column(name = "resource_id")
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
}
