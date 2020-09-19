package org.okcoder.app.task.result.domain.repository;

import java.sql.JDBCType;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class TaskDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.TASK")
    public static final Task task = new Task();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.TASK.ID")
    public static final SqlColumn<String> id = task.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.TASK.USER_ID")
    public static final SqlColumn<String> userId = task.userId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.TASK.TASK_DAY")
    public static final SqlColumn<LocalDate> taskDay = task.taskDay;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.TASK.SCHEDULE_ID")
    public static final SqlColumn<String> scheduleId = task.scheduleId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.TASK.CATEGORY")
    public static final SqlColumn<String> category = task.category;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.TASK.TITLE")
    public static final SqlColumn<String> title = task.title;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.TASK.SUB_TITLE")
    public static final SqlColumn<String> subTitle = task.subTitle;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.TASK.PRIORITY_TYPE")
    public static final SqlColumn<String> priorityType = task.priorityType;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.TASK.PRIORITY_INDEX")
    public static final SqlColumn<Integer> priorityIndex = task.priorityIndex;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.TASK.ESTIMATE_PREPARE_TIME")
    public static final SqlColumn<Integer> estimatePrepareTime = task.estimatePrepareTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.TASK.ESTIMATE_TIME")
    public static final SqlColumn<Integer> estimateTime = task.estimateTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.TASK.ESTIMATE_CLOSE_TIME")
    public static final SqlColumn<Integer> estimateCloseTime = task.estimateCloseTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.TASK.START_TIME")
    public static final SqlColumn<LocalTime> startTime = task.startTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.TASK.FINISH_TIME")
    public static final SqlColumn<LocalTime> finishTime = task.finishTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.TASK.CREATE_TIME")
    public static final SqlColumn<LocalDateTime> createTime = task.createTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.TASK.UPDATE_TIME")
    public static final SqlColumn<LocalDateTime> updateTime = task.updateTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.TASK")
    public static final class Task extends SqlTable {
        public final SqlColumn<String> id = column("ID", JDBCType.VARCHAR);

        public final SqlColumn<String> userId = column("USER_ID", JDBCType.VARCHAR);

        public final SqlColumn<LocalDate> taskDay = column("TASK_DAY", JDBCType.DATE);

        public final SqlColumn<String> scheduleId = column("SCHEDULE_ID", JDBCType.VARCHAR);

        public final SqlColumn<String> category = column("CATEGORY", JDBCType.VARCHAR);

        public final SqlColumn<String> title = column("TITLE", JDBCType.VARCHAR);

        public final SqlColumn<String> subTitle = column("SUB_TITLE", JDBCType.VARCHAR);

        public final SqlColumn<String> priorityType = column("PRIORITY_TYPE", JDBCType.VARCHAR);

        public final SqlColumn<Integer> priorityIndex = column("PRIORITY_INDEX", JDBCType.INTEGER);

        public final SqlColumn<Integer> estimatePrepareTime = column("ESTIMATE_PREPARE_TIME", JDBCType.INTEGER);

        public final SqlColumn<Integer> estimateTime = column("ESTIMATE_TIME", JDBCType.INTEGER);

        public final SqlColumn<Integer> estimateCloseTime = column("ESTIMATE_CLOSE_TIME", JDBCType.INTEGER);

        public final SqlColumn<LocalTime> startTime = column("START_TIME", JDBCType.TIME);

        public final SqlColumn<LocalTime> finishTime = column("FINISH_TIME", JDBCType.TIME);

        public final SqlColumn<LocalDateTime> createTime = column("CREATE_TIME", JDBCType.TIMESTAMP);

        public final SqlColumn<LocalDateTime> updateTime = column("UPDATE_TIME", JDBCType.TIMESTAMP);

        public Task() {
            super("PUBLIC.TASK");
        }
    }
}