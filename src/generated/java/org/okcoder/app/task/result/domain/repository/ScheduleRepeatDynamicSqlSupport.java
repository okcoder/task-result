package org.okcoder.app.task.result.domain.repository;

import java.sql.JDBCType;
import java.time.LocalDateTime;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class ScheduleRepeatDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.SCHEDULE_REPEAT")
    public static final ScheduleRepeat scheduleRepeat = new ScheduleRepeat();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.SCHEDULE_REPEAT.SCHEDULE_ID")
    public static final SqlColumn<Integer> scheduleId = scheduleRepeat.scheduleId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.SCHEDULE_REPEAT.DAY")
    public static final SqlColumn<Integer> day = scheduleRepeat.day;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.SCHEDULE_REPEAT.CREATE_TIME")
    public static final SqlColumn<LocalDateTime> createTime = scheduleRepeat.createTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: PUBLIC.SCHEDULE_REPEAT.UPDATE_TIME")
    public static final SqlColumn<LocalDateTime> updateTime = scheduleRepeat.updateTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.SCHEDULE_REPEAT")
    public static final class ScheduleRepeat extends SqlTable {
        public final SqlColumn<Integer> scheduleId = column("SCHEDULE_ID", JDBCType.INTEGER);

        public final SqlColumn<Integer> day = column("DAY", JDBCType.INTEGER);

        public final SqlColumn<LocalDateTime> createTime = column("CREATE_TIME", JDBCType.TIMESTAMP);

        public final SqlColumn<LocalDateTime> updateTime = column("UPDATE_TIME", JDBCType.TIMESTAMP);

        public ScheduleRepeat() {
            super("PUBLIC.SCHEDULE_REPEAT");
        }
    }
}