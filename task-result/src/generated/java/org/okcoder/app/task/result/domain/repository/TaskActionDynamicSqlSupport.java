package org.okcoder.app.task.result.domain.repository;

import java.sql.JDBCType;
import java.time.LocalDateTime;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class TaskActionDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.TASK_ACTION")
    public static final TaskAction taskAction = new TaskAction();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.TASK_ACTION.TASK_ID")
    public static final SqlColumn<String> taskId = taskAction.taskId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.TASK_ACTION.ACTION")
    public static final SqlColumn<String> action = taskAction.action;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.TASK_ACTION.ACTION_TIME")
    public static final SqlColumn<LocalDateTime> actionTime = taskAction.actionTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.TASK_ACTION.CREATE_TIME")
    public static final SqlColumn<LocalDateTime> createTime = taskAction.createTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.TASK_ACTION.UPDATE_TIME")
    public static final SqlColumn<LocalDateTime> updateTime = taskAction.updateTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.TASK_ACTION")
    public static final class TaskAction extends SqlTable {
        public final SqlColumn<String> taskId = column("TASK_ID", JDBCType.VARCHAR);

        public final SqlColumn<String> action = column("ACTION", JDBCType.VARCHAR);

        public final SqlColumn<LocalDateTime> actionTime = column("ACTION_TIME", JDBCType.TIMESTAMP);

        public final SqlColumn<LocalDateTime> createTime = column("CREATE_TIME", JDBCType.TIMESTAMP);

        public final SqlColumn<LocalDateTime> updateTime = column("UPDATE_TIME", JDBCType.TIMESTAMP);

        public TaskAction() {
            super("PUBLIC.TASK_ACTION");
        }
    }
}