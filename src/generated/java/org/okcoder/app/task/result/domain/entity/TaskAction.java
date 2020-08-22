package org.okcoder.app.task.result.domain.entity;

import java.time.LocalDateTime;
import javax.annotation.Generated;

public class TaskAction {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.TASK_ACTION.TASK_ID")
    private String taskId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.TASK_ACTION.ACTION")
    private String action;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.TASK_ACTION.ACTION_TIME")
    private LocalDateTime actionTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.TASK_ACTION.CREATE_TIME")
    private LocalDateTime createTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.TASK_ACTION.UPDATE_TIME")
    private LocalDateTime updateTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.TASK_ACTION.TASK_ID")
    public String getTaskId() {
        return taskId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.TASK_ACTION.TASK_ID")
    public void setTaskId(String taskId) {
        this.taskId = taskId == null ? null : taskId.trim();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.TASK_ACTION.ACTION")
    public String getAction() {
        return action;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.TASK_ACTION.ACTION")
    public void setAction(String action) {
        this.action = action == null ? null : action.trim();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.TASK_ACTION.ACTION_TIME")
    public LocalDateTime getActionTime() {
        return actionTime;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.TASK_ACTION.ACTION_TIME")
    public void setActionTime(LocalDateTime actionTime) {
        this.actionTime = actionTime;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.TASK_ACTION.CREATE_TIME")
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.TASK_ACTION.CREATE_TIME")
    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.TASK_ACTION.UPDATE_TIME")
    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.TASK_ACTION.UPDATE_TIME")
    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
}