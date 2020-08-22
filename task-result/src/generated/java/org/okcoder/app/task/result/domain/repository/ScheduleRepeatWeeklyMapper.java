package org.okcoder.app.task.result.domain.repository;

import static org.mybatis.dynamic.sql.SqlBuilder.*;
import static org.okcoder.app.task.result.domain.repository.ScheduleRepeatWeeklyDynamicSqlSupport.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.insert.render.MultiRowInsertStatementProvider;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;
import org.okcoder.app.task.result.domain.entity.ScheduleRepeatWeekly;

@Mapper
public interface ScheduleRepeatWeeklyMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.SCHEDULE_REPEAT_WEEKLY")
    BasicColumn[] selectList = BasicColumn.columnList(scheduleId, dayOfWeek, createTime, updateTime);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.SCHEDULE_REPEAT_WEEKLY")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.SCHEDULE_REPEAT_WEEKLY")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.SCHEDULE_REPEAT_WEEKLY")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<ScheduleRepeatWeekly> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.SCHEDULE_REPEAT_WEEKLY")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<ScheduleRepeatWeekly> multipleInsertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.SCHEDULE_REPEAT_WEEKLY")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("ScheduleRepeatWeeklyResult")
    Optional<ScheduleRepeatWeekly> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.SCHEDULE_REPEAT_WEEKLY")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="ScheduleRepeatWeeklyResult", value = {
        @Result(column="SCHEDULE_ID", property="scheduleId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="DAY_OF_WEEK", property="dayOfWeek", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<ScheduleRepeatWeekly> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.SCHEDULE_REPEAT_WEEKLY")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.SCHEDULE_REPEAT_WEEKLY")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, scheduleRepeatWeekly, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.SCHEDULE_REPEAT_WEEKLY")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, scheduleRepeatWeekly, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.SCHEDULE_REPEAT_WEEKLY")
    default int deleteByPrimaryKey(String scheduleId_, String dayOfWeek_) {
        return delete(c -> 
            c.where(scheduleId, isEqualTo(scheduleId_))
            .and(dayOfWeek, isEqualTo(dayOfWeek_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.SCHEDULE_REPEAT_WEEKLY")
    default int insertOrUpdate(ScheduleRepeatWeekly record) {
        int count = this.updateByPrimaryKey(record);
        if (count > 0) {
            return count;
        } else {
            return this.insert(record);
        }
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.SCHEDULE_REPEAT_WEEKLY")
    default int insert(ScheduleRepeatWeekly record) {
        return MyBatis3Utils.insert(this::insert, record, scheduleRepeatWeekly, c ->
            c.map(scheduleId).toProperty("scheduleId")
            .map(dayOfWeek).toProperty("dayOfWeek")
            .map(createTime).toProperty("createTime")
            .map(updateTime).toProperty("updateTime")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.SCHEDULE_REPEAT_WEEKLY")
    default int insertMultiple(Collection<ScheduleRepeatWeekly> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, scheduleRepeatWeekly, c ->
            c.map(scheduleId).toProperty("scheduleId")
            .map(dayOfWeek).toProperty("dayOfWeek")
            .map(createTime).toProperty("createTime")
            .map(updateTime).toProperty("updateTime")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.SCHEDULE_REPEAT_WEEKLY")
    default int insertSelective(ScheduleRepeatWeekly record) {
        return MyBatis3Utils.insert(this::insert, record, scheduleRepeatWeekly, c ->
            c.map(scheduleId).toPropertyWhenPresent("scheduleId", record::getScheduleId)
            .map(dayOfWeek).toPropertyWhenPresent("dayOfWeek", record::getDayOfWeek)
            .map(createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
            .map(updateTime).toPropertyWhenPresent("updateTime", record::getUpdateTime)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.SCHEDULE_REPEAT_WEEKLY")
    default Optional<ScheduleRepeatWeekly> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, scheduleRepeatWeekly, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.SCHEDULE_REPEAT_WEEKLY")
    default List<ScheduleRepeatWeekly> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, scheduleRepeatWeekly, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.SCHEDULE_REPEAT_WEEKLY")
    default List<ScheduleRepeatWeekly> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, scheduleRepeatWeekly, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.SCHEDULE_REPEAT_WEEKLY")
    default Optional<ScheduleRepeatWeekly> selectByPrimaryKey(String scheduleId_, String dayOfWeek_) {
        return selectOne(c ->
            c.where(scheduleId, isEqualTo(scheduleId_))
            .and(dayOfWeek, isEqualTo(dayOfWeek_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.SCHEDULE_REPEAT_WEEKLY")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, scheduleRepeatWeekly, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.SCHEDULE_REPEAT_WEEKLY")
    static UpdateDSL<UpdateModel> updateAllColumns(ScheduleRepeatWeekly record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(scheduleId).equalTo(record::getScheduleId)
                .set(dayOfWeek).equalTo(record::getDayOfWeek)
                .set(createTime).equalTo(record::getCreateTime)
                .set(updateTime).equalTo(record::getUpdateTime);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.SCHEDULE_REPEAT_WEEKLY")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(ScheduleRepeatWeekly record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(scheduleId).equalToWhenPresent(record::getScheduleId)
                .set(dayOfWeek).equalToWhenPresent(record::getDayOfWeek)
                .set(createTime).equalToWhenPresent(record::getCreateTime)
                .set(updateTime).equalToWhenPresent(record::getUpdateTime);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.SCHEDULE_REPEAT_WEEKLY")
    default int updateByPrimaryKey(ScheduleRepeatWeekly record) {
        return update(c ->
            c.set(createTime).equalTo(record::getCreateTime)
            .set(updateTime).equalTo(record::getUpdateTime)
            .where(scheduleId, isEqualTo(record::getScheduleId))
            .and(dayOfWeek, isEqualTo(record::getDayOfWeek))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.SCHEDULE_REPEAT_WEEKLY")
    default int updateByPrimaryKeySelective(ScheduleRepeatWeekly record) {
        return update(c ->
            c.set(createTime).equalToWhenPresent(record::getCreateTime)
            .set(updateTime).equalToWhenPresent(record::getUpdateTime)
            .where(scheduleId, isEqualTo(record::getScheduleId))
            .and(dayOfWeek, isEqualTo(record::getDayOfWeek))
        );
    }
}