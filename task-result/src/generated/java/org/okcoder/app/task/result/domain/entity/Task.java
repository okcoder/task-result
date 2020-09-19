package org.okcoder.app.task.result.domain.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import javax.annotation.Generated;

public class Task {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.TASK.ID")
    private String id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.TASK.USER_ID")
    private String userId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.TASK.TASK_DAY")
    private LocalDate taskDay;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.TASK.SCHEDULE_ID")
    private String scheduleId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.TASK.CATEGORY")
    private String category;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.TASK.TITLE")
    private String title;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.TASK.SUB_TITLE")
    private String subTitle;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.TASK.PRIORITY_TYPE")
    private String priorityType;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.TASK.PRIORITY_INDEX")
    private Integer priorityIndex;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.TASK.ESTIMATE_PREPARE_TIME")
    private Integer estimatePrepareTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.TASK.ESTIMATE_TIME")
    private Integer estimateTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.TASK.ESTIMATE_CLOSE_TIME")
    private Integer estimateCloseTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.TASK.START_TIME")
    private LocalTime startTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.TASK.FINISH_TIME")
    private LocalTime finishTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.TASK.CREATE_TIME")
    private LocalDateTime createTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.TASK.UPDATE_TIME")
    private LocalDateTime updateTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.TASK.ID")
    public String getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.TASK.ID")
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.TASK.USER_ID")
    public String getUserId() {
        return userId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.TASK.USER_ID")
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.TASK.TASK_DAY")
    public LocalDate getTaskDay() {
        return taskDay;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.TASK.TASK_DAY")
    public void setTaskDay(LocalDate taskDay) {
        this.taskDay = taskDay;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.TASK.SCHEDULE_ID")
    public String getScheduleId() {
        return scheduleId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.TASK.SCHEDULE_ID")
    public void setScheduleId(String scheduleId) {
        this.scheduleId = scheduleId == null ? null : scheduleId.trim();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.TASK.CATEGORY")
    public String getCategory() {
        return category;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.TASK.CATEGORY")
    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.TASK.TITLE")
    public String getTitle() {
        return title;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.TASK.TITLE")
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.TASK.SUB_TITLE")
    public String getSubTitle() {
        return subTitle;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.TASK.SUB_TITLE")
    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle == null ? null : subTitle.trim();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.TASK.PRIORITY_TYPE")
    public String getPriorityType() {
        return priorityType;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.TASK.PRIORITY_TYPE")
    public void setPriorityType(String priorityType) {
        this.priorityType = priorityType == null ? null : priorityType.trim();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.TASK.PRIORITY_INDEX")
    public Integer getPriorityIndex() {
        return priorityIndex;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.TASK.PRIORITY_INDEX")
    public void setPriorityIndex(Integer priorityIndex) {
        this.priorityIndex = priorityIndex;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.TASK.ESTIMATE_PREPARE_TIME")
    public Integer getEstimatePrepareTime() {
        return estimatePrepareTime;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.TASK.ESTIMATE_PREPARE_TIME")
    public void setEstimatePrepareTime(Integer estimatePrepareTime) {
        this.estimatePrepareTime = estimatePrepareTime;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.TASK.ESTIMATE_TIME")
    public Integer getEstimateTime() {
        return estimateTime;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.TASK.ESTIMATE_TIME")
    public void setEstimateTime(Integer estimateTime) {
        this.estimateTime = estimateTime;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.TASK.ESTIMATE_CLOSE_TIME")
    public Integer getEstimateCloseTime() {
        return estimateCloseTime;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.TASK.ESTIMATE_CLOSE_TIME")
    public void setEstimateCloseTime(Integer estimateCloseTime) {
        this.estimateCloseTime = estimateCloseTime;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.TASK.START_TIME")
    public LocalTime getStartTime() {
        return startTime;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.TASK.START_TIME")
    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.TASK.FINISH_TIME")
    public LocalTime getFinishTime() {
        return finishTime;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.TASK.FINISH_TIME")
    public void setFinishTime(LocalTime finishTime) {
        this.finishTime = finishTime;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.TASK.CREATE_TIME")
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.TASK.CREATE_TIME")
    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.TASK.UPDATE_TIME")
    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.TASK.UPDATE_TIME")
    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
}