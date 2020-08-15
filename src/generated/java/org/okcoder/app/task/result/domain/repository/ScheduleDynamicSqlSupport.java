package org.okcoder.app.task.result.domain.repository;

import java.sql.JDBCType;
import java.time.LocalDateTime;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class ScheduleDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.SCHEDULE")
    public static final Schedule schedule = new Schedule();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.SCHEDULE.ID")
    public static final SqlColumn<Integer> id = schedule.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.SCHEDULE.USER_ID")
    public static final SqlColumn<String> userId = schedule.userId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.SCHEDULE.REPEAT_TYPE")
    public static final SqlColumn<String> repeatType = schedule.repeatType;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.SCHEDULE.NAME")
    public static final SqlColumn<String> name = schedule.name;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.SCHEDULE.CREATE_TIME")
    public static final SqlColumn<LocalDateTime> createTime = schedule.createTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.SCHEDULE.UPDATE_TIME")
    public static final SqlColumn<LocalDateTime> updateTime = schedule.updateTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.SCHEDULE")
    public static final class Schedule extends SqlTable {
        public final SqlColumn<Integer> id = column("ID", JDBCType.INTEGER);

        public final SqlColumn<String> userId = column("USER_ID", JDBCType.VARCHAR);

        public final SqlColumn<String> repeatType = column("REPEAT_TYPE", JDBCType.VARCHAR);

        public final SqlColumn<String> name = column("NAME", JDBCType.VARCHAR);

        public final SqlColumn<LocalDateTime> createTime = column("CREATE_TIME", JDBCType.TIMESTAMP);

        public final SqlColumn<LocalDateTime> updateTime = column("UPDATE_TIME", JDBCType.TIMESTAMP);

        public Schedule() {
            super("PUBLIC.SCHEDULE");
        }
    }
}