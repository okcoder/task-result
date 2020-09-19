package org.okcoder.app.task.result.domain.repository;

import java.sql.JDBCType;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class ScheduleDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.SCHEDULE")
    public static final Schedule schedule = new Schedule();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.SCHEDULE.ID")
    public static final SqlColumn<String> id = schedule.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.SCHEDULE.USER_ID")
    public static final SqlColumn<String> userId = schedule.userId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.SCHEDULE.REPEAT_TYPE")
    public static final SqlColumn<String> repeatType = schedule.repeatType;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.SCHEDULE.NAME")
    public static final SqlColumn<String> name = schedule.name;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.SCHEDULE.CATEGORY")
    public static final SqlColumn<String> category = schedule.category;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.SCHEDULE.START_DAY")
    public static final SqlColumn<LocalDate> startDay = schedule.startDay;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.SCHEDULE.FINISH_DAY")
    public static final SqlColumn<LocalDate> finishDay = schedule.finishDay;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.SCHEDULE.PRIORITY_TYPE")
    public static final SqlColumn<String> priorityType = schedule.priorityType;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.SCHEDULE.PRIORITY_INDEX")
    public static final SqlColumn<Integer> priorityIndex = schedule.priorityIndex;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.SCHEDULE.ESTIMATE_PREPARE_TIME")
    public static final SqlColumn<Integer> estimatePrepareTime = schedule.estimatePrepareTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.SCHEDULE.ESTIMATE_TIME")
    public static final SqlColumn<Integer> estimateTime = schedule.estimateTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.SCHEDULE.ESTIMATE_CLOSE_TIME")
    public static final SqlColumn<Integer> estimateCloseTime = schedule.estimateCloseTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.SCHEDULE.START_TIME")
    public static final SqlColumn<LocalTime> startTime = schedule.startTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.SCHEDULE.FINISH_TIME")
    public static final SqlColumn<LocalTime> finishTime = schedule.finishTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.SCHEDULE.CREATE_TIME")
    public static final SqlColumn<LocalDateTime> createTime = schedule.createTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.SCHEDULE.UPDATE_TIME")
    public static final SqlColumn<LocalDateTime> updateTime = schedule.updateTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.SCHEDULE")
    public static final class Schedule extends SqlTable {
        public final SqlColumn<String> id = column("ID", JDBCType.VARCHAR);

        public final SqlColumn<String> userId = column("USER_ID", JDBCType.VARCHAR);

        public final SqlColumn<String> repeatType = column("REPEAT_TYPE", JDBCType.VARCHAR);

        public final SqlColumn<String> name = column("NAME", JDBCType.VARCHAR);

        public final SqlColumn<String> category = column("CATEGORY", JDBCType.VARCHAR);

        public final SqlColumn<LocalDate> startDay = column("START_DAY", JDBCType.DATE);

        public final SqlColumn<LocalDate> finishDay = column("FINISH_DAY", JDBCType.DATE);

        public final SqlColumn<String> priorityType = column("PRIORITY_TYPE", JDBCType.VARCHAR);

        public final SqlColumn<Integer> priorityIndex = column("PRIORITY_INDEX", JDBCType.INTEGER);

        public final SqlColumn<Integer> estimatePrepareTime = column("ESTIMATE_PREPARE_TIME", JDBCType.INTEGER);

        public final SqlColumn<Integer> estimateTime = column("ESTIMATE_TIME", JDBCType.INTEGER);

        public final SqlColumn<Integer> estimateCloseTime = column("ESTIMATE_CLOSE_TIME", JDBCType.INTEGER);

        public final SqlColumn<LocalTime> startTime = column("START_TIME", JDBCType.TIME);

        public final SqlColumn<LocalTime> finishTime = column("FINISH_TIME", JDBCType.TIME);

        public final SqlColumn<LocalDateTime> createTime = column("CREATE_TIME", JDBCType.TIMESTAMP);

        public final SqlColumn<LocalDateTime> updateTime = column("UPDATE_TIME", JDBCType.TIMESTAMP);

        public Schedule() {
            super("PUBLIC.SCHEDULE");
        }
    }
}