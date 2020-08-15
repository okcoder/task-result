package org.okcoder.app.task.result.domain.repository;

import static org.mybatis.dynamic.sql.SqlBuilder.*;
import static org.okcoder.app.task.result.domain.repository.ScheduleRepeatDynamicSqlSupport.*;

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
import org.okcoder.app.task.result.domain.entity.ScheduleRepeat;

@Mapper
public interface ScheduleRepeatMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.SCHEDULE_REPEAT")
    BasicColumn[] selectList = BasicColumn.columnList(scheduleId, day, createTime, updateTime);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.SCHEDULE_REPEAT")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.SCHEDULE_REPEAT")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.SCHEDULE_REPEAT")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<ScheduleRepeat> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.SCHEDULE_REPEAT")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<ScheduleRepeat> multipleInsertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.SCHEDULE_REPEAT")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("ScheduleRepeatResult")
    Optional<ScheduleRepeat> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.SCHEDULE_REPEAT")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="ScheduleRepeatResult", value = {
        @Result(column="SCHEDULE_ID", property="scheduleId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="DAY", property="day", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<ScheduleRepeat> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.SCHEDULE_REPEAT")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.SCHEDULE_REPEAT")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, scheduleRepeat, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.SCHEDULE_REPEAT")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, scheduleRepeat, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.SCHEDULE_REPEAT")
    default int deleteByPrimaryKey(Integer scheduleId_, Integer day_) {
        return delete(c -> 
            c.where(scheduleId, isEqualTo(scheduleId_))
            .and(day, isEqualTo(day_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.SCHEDULE_REPEAT")
    default int insertOrUpdate(ScheduleRepeat record) {
        int count = this.updateByPrimaryKey(record);
        if (count > 0) {
            return count;
        } else {
            return this.insert(record);
        }
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.SCHEDULE_REPEAT")
    default int insert(ScheduleRepeat record) {
        return MyBatis3Utils.insert(this::insert, record, scheduleRepeat, c ->
            c.map(scheduleId).toProperty("scheduleId")
            .map(day).toProperty("day")
            .map(createTime).toProperty("createTime")
            .map(updateTime).toProperty("updateTime")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.SCHEDULE_REPEAT")
    default int insertMultiple(Collection<ScheduleRepeat> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, scheduleRepeat, c ->
            c.map(scheduleId).toProperty("scheduleId")
            .map(day).toProperty("day")
            .map(createTime).toProperty("createTime")
            .map(updateTime).toProperty("updateTime")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.SCHEDULE_REPEAT")
    default int insertSelective(ScheduleRepeat record) {
        return MyBatis3Utils.insert(this::insert, record, scheduleRepeat, c ->
            c.map(scheduleId).toPropertyWhenPresent("scheduleId", record::getScheduleId)
            .map(day).toPropertyWhenPresent("day", record::getDay)
            .map(createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
            .map(updateTime).toPropertyWhenPresent("updateTime", record::getUpdateTime)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.SCHEDULE_REPEAT")
    default Optional<ScheduleRepeat> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, scheduleRepeat, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.SCHEDULE_REPEAT")
    default List<ScheduleRepeat> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, scheduleRepeat, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.SCHEDULE_REPEAT")
    default List<ScheduleRepeat> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, scheduleRepeat, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.SCHEDULE_REPEAT")
    default Optional<ScheduleRepeat> selectByPrimaryKey(Integer scheduleId_, Integer day_) {
        return selectOne(c ->
            c.where(scheduleId, isEqualTo(scheduleId_))
            .and(day, isEqualTo(day_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.SCHEDULE_REPEAT")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, scheduleRepeat, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.SCHEDULE_REPEAT")
    static UpdateDSL<UpdateModel> updateAllColumns(ScheduleRepeat record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(scheduleId).equalTo(record::getScheduleId)
                .set(day).equalTo(record::getDay)
                .set(createTime).equalTo(record::getCreateTime)
                .set(updateTime).equalTo(record::getUpdateTime);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.SCHEDULE_REPEAT")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(ScheduleRepeat record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(scheduleId).equalToWhenPresent(record::getScheduleId)
                .set(day).equalToWhenPresent(record::getDay)
                .set(createTime).equalToWhenPresent(record::getCreateTime)
                .set(updateTime).equalToWhenPresent(record::getUpdateTime);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.SCHEDULE_REPEAT")
    default int updateByPrimaryKey(ScheduleRepeat record) {
        return update(c ->
            c.set(createTime).equalTo(record::getCreateTime)
            .set(updateTime).equalTo(record::getUpdateTime)
            .where(scheduleId, isEqualTo(record::getScheduleId))
            .and(day, isEqualTo(record::getDay))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.SCHEDULE_REPEAT")
    default int updateByPrimaryKeySelective(ScheduleRepeat record) {
        return update(c ->
            c.set(createTime).equalToWhenPresent(record::getCreateTime)
            .set(updateTime).equalToWhenPresent(record::getUpdateTime)
            .where(scheduleId, isEqualTo(record::getScheduleId))
            .and(day, isEqualTo(record::getDay))
        );
    }
}