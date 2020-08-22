package org.okcoder.app.task.result.domain.repository;

import java.sql.JDBCType;
import java.time.LocalDateTime;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class ScheduleRepeatWeeklyDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.SCHEDULE_REPEAT_WEEKLY")
    public static final ScheduleRepeatWeekly scheduleRepeatWeekly = new ScheduleRepeatWeekly();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.SCHEDULE_REPEAT_WEEKLY.SCHEDULE_ID")
    public static final SqlColumn<String> scheduleId = scheduleRepeatWeekly.scheduleId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.SCHEDULE_REPEAT_WEEKLY.DAY_OF_WEEK")
    public static final SqlColumn<String> dayOfWeek = scheduleRepeatWeekly.dayOfWeek;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.SCHEDULE_REPEAT_WEEKLY.CREATE_TIME")
    public static final SqlColumn<LocalDateTime> createTime = scheduleRepeatWeekly.createTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.SCHEDULE_REPEAT_WEEKLY.UPDATE_TIME")
    public static final SqlColumn<LocalDateTime> updateTime = scheduleRepeatWeekly.updateTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.SCHEDULE_REPEAT_WEEKLY")
    public static final class ScheduleRepeatWeekly extends SqlTable {
        public final SqlColumn<String> scheduleId = column("SCHEDULE_ID", JDBCType.VARCHAR);

        public final SqlColumn<String> dayOfWeek = column("DAY_OF_WEEK", JDBCType.VARCHAR);

        public final SqlColumn<LocalDateTime> createTime = column("CREATE_TIME", JDBCType.TIMESTAMP);

        public final SqlColumn<LocalDateTime> updateTime = column("UPDATE_TIME", JDBCType.TIMESTAMP);

        public ScheduleRepeatWeekly() {
            super("PUBLIC.SCHEDULE_REPEAT_WEEKLY");
        }
    }
}