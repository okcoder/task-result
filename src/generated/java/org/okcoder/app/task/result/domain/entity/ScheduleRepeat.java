package org.okcoder.app.task.result.domain.entity;

import java.time.LocalDateTime;
import javax.annotation.Generated;

public class ScheduleRepeat {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.SCHEDULE_REPEAT.SCHEDULE_ID")
    private Integer scheduleId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.SCHEDULE_REPEAT.DAY")
    private Integer day;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.SCHEDULE_REPEAT.CREATE_TIME")
    private LocalDateTime createTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.SCHEDULE_REPEAT.UPDATE_TIME")
    private LocalDateTime updateTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.SCHEDULE_REPEAT.SCHEDULE_ID")
    public Integer getScheduleId() {
        return scheduleId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.SCHEDULE_REPEAT.SCHEDULE_ID")
    public void setScheduleId(Integer scheduleId) {
        this.scheduleId = scheduleId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.SCHEDULE_REPEAT.DAY")
    public Integer getDay() {
        return day;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.SCHEDULE_REPEAT.DAY")
    public void setDay(Integer day) {
        this.day = day;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.SCHEDULE_REPEAT.CREATE_TIME")
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.SCHEDULE_REPEAT.CREATE_TIME")
    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.SCHEDULE_REPEAT.UPDATE_TIME")
    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.SCHEDULE_REPEAT.UPDATE_TIME")
    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
}