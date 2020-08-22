package org.okcoder.app.task.result.domain.entity;

import java.time.LocalDateTime;
import javax.annotation.Generated;

public class ScheduleRepeatWeekly {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.SCHEDULE_REPEAT_WEEKLY.SCHEDULE_ID")
    private String scheduleId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.SCHEDULE_REPEAT_WEEKLY.DAY_OF_WEEK")
    private String dayOfWeek;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.SCHEDULE_REPEAT_WEEKLY.CREATE_TIME")
    private LocalDateTime createTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.SCHEDULE_REPEAT_WEEKLY.UPDATE_TIME")
    private LocalDateTime updateTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.SCHEDULE_REPEAT_WEEKLY.SCHEDULE_ID")
    public String getScheduleId() {
        return scheduleId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.SCHEDULE_REPEAT_WEEKLY.SCHEDULE_ID")
    public void setScheduleId(String scheduleId) {
        this.scheduleId = scheduleId == null ? null : scheduleId.trim();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.SCHEDULE_REPEAT_WEEKLY.DAY_OF_WEEK")
    public String getDayOfWeek() {
        return dayOfWeek;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.SCHEDULE_REPEAT_WEEKLY.DAY_OF_WEEK")
    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek == null ? null : dayOfWeek.trim();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.SCHEDULE_REPEAT_WEEKLY.CREATE_TIME")
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.SCHEDULE_REPEAT_WEEKLY.CREATE_TIME")
    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.SCHEDULE_REPEAT_WEEKLY.UPDATE_TIME")
    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.SCHEDULE_REPEAT_WEEKLY.UPDATE_TIME")
    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
}