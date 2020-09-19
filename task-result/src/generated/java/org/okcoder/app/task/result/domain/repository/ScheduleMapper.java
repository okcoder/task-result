package org.okcoder.app.task.result.domain.repository;

import static org.mybatis.dynamic.sql.SqlBuilder.*;
import static org.okcoder.app.task.result.domain.repository.ScheduleDynamicSqlSupport.*;

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
import org.okcoder.app.task.result.domain.entity.Schedule;

@Mapper
public interface ScheduleMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.SCHEDULE")
    BasicColumn[] selectList = BasicColumn.columnList(id, userId, repeatType, name, category, startDay, finishDay, priorityType, priorityIndex, estimatePrepareTime, estimateTime, estimateCloseTime, startTime, finishTime, createTime, updateTime);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.SCHEDULE")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.SCHEDULE")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.SCHEDULE")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<Schedule> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.SCHEDULE")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<Schedule> multipleInsertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.SCHEDULE")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("ScheduleResult")
    Optional<Schedule> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.SCHEDULE")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="ScheduleResult", value = {
        @Result(column="ID", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="USER_ID", property="userId", jdbcType=JdbcType.VARCHAR),
        @Result(column="REPEAT_TYPE", property="repeatType", jdbcType=JdbcType.VARCHAR),
        @Result(column="NAME", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="CATEGORY", property="category", jdbcType=JdbcType.VARCHAR),
        @Result(column="START_DAY", property="startDay", jdbcType=JdbcType.DATE),
        @Result(column="FINISH_DAY", property="finishDay", jdbcType=JdbcType.DATE),
        @Result(column="PRIORITY_TYPE", property="priorityType", jdbcType=JdbcType.VARCHAR),
        @Result(column="PRIORITY_INDEX", property="priorityIndex", jdbcType=JdbcType.INTEGER),
        @Result(column="ESTIMATE_PREPARE_TIME", property="estimatePrepareTime", jdbcType=JdbcType.INTEGER),
        @Result(column="ESTIMATE_TIME", property="estimateTime", jdbcType=JdbcType.INTEGER),
        @Result(column="ESTIMATE_CLOSE_TIME", property="estimateCloseTime", jdbcType=JdbcType.INTEGER),
        @Result(column="START_TIME", property="startTime", jdbcType=JdbcType.TIME),
        @Result(column="FINISH_TIME", property="finishTime", jdbcType=JdbcType.TIME),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Schedule> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.SCHEDULE")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.SCHEDULE")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, schedule, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.SCHEDULE")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, schedule, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.SCHEDULE")
    default int deleteByPrimaryKey(String id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.SCHEDULE")
    default int insertOrUpdate(Schedule record) {
        int count = this.updateByPrimaryKey(record);
        if (count > 0) {
            return count;
        } else {
            return this.insert(record);
        }
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.SCHEDULE")
    default int insert(Schedule record) {
        return MyBatis3Utils.insert(this::insert, record, schedule, c ->
            c.map(id).toProperty("id")
            .map(userId).toProperty("userId")
            .map(repeatType).toProperty("repeatType")
            .map(name).toProperty("name")
            .map(category).toProperty("category")
            .map(startDay).toProperty("startDay")
            .map(finishDay).toProperty("finishDay")
            .map(priorityType).toProperty("priorityType")
            .map(priorityIndex).toProperty("priorityIndex")
            .map(estimatePrepareTime).toProperty("estimatePrepareTime")
            .map(estimateTime).toProperty("estimateTime")
            .map(estimateCloseTime).toProperty("estimateCloseTime")
            .map(startTime).toProperty("startTime")
            .map(finishTime).toProperty("finishTime")
            .map(createTime).toProperty("createTime")
            .map(updateTime).toProperty("updateTime")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.SCHEDULE")
    default int insertMultiple(Collection<Schedule> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, schedule, c ->
            c.map(id).toProperty("id")
            .map(userId).toProperty("userId")
            .map(repeatType).toProperty("repeatType")
            .map(name).toProperty("name")
            .map(category).toProperty("category")
            .map(startDay).toProperty("startDay")
            .map(finishDay).toProperty("finishDay")
            .map(priorityType).toProperty("priorityType")
            .map(priorityIndex).toProperty("priorityIndex")
            .map(estimatePrepareTime).toProperty("estimatePrepareTime")
            .map(estimateTime).toProperty("estimateTime")
            .map(estimateCloseTime).toProperty("estimateCloseTime")
            .map(startTime).toProperty("startTime")
            .map(finishTime).toProperty("finishTime")
            .map(createTime).toProperty("createTime")
            .map(updateTime).toProperty("updateTime")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.SCHEDULE")
    default int insertSelective(Schedule record) {
        return MyBatis3Utils.insert(this::insert, record, schedule, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(userId).toPropertyWhenPresent("userId", record::getUserId)
            .map(repeatType).toPropertyWhenPresent("repeatType", record::getRepeatType)
            .map(name).toPropertyWhenPresent("name", record::getName)
            .map(category).toPropertyWhenPresent("category", record::getCategory)
            .map(startDay).toPropertyWhenPresent("startDay", record::getStartDay)
            .map(finishDay).toPropertyWhenPresent("finishDay", record::getFinishDay)
            .map(priorityType).toPropertyWhenPresent("priorityType", record::getPriorityType)
            .map(priorityIndex).toPropertyWhenPresent("priorityIndex", record::getPriorityIndex)
            .map(estimatePrepareTime).toPropertyWhenPresent("estimatePrepareTime", record::getEstimatePrepareTime)
            .map(estimateTime).toPropertyWhenPresent("estimateTime", record::getEstimateTime)
            .map(estimateCloseTime).toPropertyWhenPresent("estimateCloseTime", record::getEstimateCloseTime)
            .map(startTime).toPropertyWhenPresent("startTime", record::getStartTime)
            .map(finishTime).toPropertyWhenPresent("finishTime", record::getFinishTime)
            .map(createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
            .map(updateTime).toPropertyWhenPresent("updateTime", record::getUpdateTime)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.SCHEDULE")
    default Optional<Schedule> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, schedule, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.SCHEDULE")
    default List<Schedule> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, schedule, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.SCHEDULE")
    default List<Schedule> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, schedule, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.SCHEDULE")
    default Optional<Schedule> selectByPrimaryKey(String id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.SCHEDULE")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, schedule, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.SCHEDULE")
    static UpdateDSL<UpdateModel> updateAllColumns(Schedule record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(userId).equalTo(record::getUserId)
                .set(repeatType).equalTo(record::getRepeatType)
                .set(name).equalTo(record::getName)
                .set(category).equalTo(record::getCategory)
                .set(startDay).equalTo(record::getStartDay)
                .set(finishDay).equalTo(record::getFinishDay)
                .set(priorityType).equalTo(record::getPriorityType)
                .set(priorityIndex).equalTo(record::getPriorityIndex)
                .set(estimatePrepareTime).equalTo(record::getEstimatePrepareTime)
                .set(estimateTime).equalTo(record::getEstimateTime)
                .set(estimateCloseTime).equalTo(record::getEstimateCloseTime)
                .set(startTime).equalTo(record::getStartTime)
                .set(finishTime).equalTo(record::getFinishTime)
                .set(createTime).equalTo(record::getCreateTime)
                .set(updateTime).equalTo(record::getUpdateTime);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.SCHEDULE")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Schedule record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(userId).equalToWhenPresent(record::getUserId)
                .set(repeatType).equalToWhenPresent(record::getRepeatType)
                .set(name).equalToWhenPresent(record::getName)
                .set(category).equalToWhenPresent(record::getCategory)
                .set(startDay).equalToWhenPresent(record::getStartDay)
                .set(finishDay).equalToWhenPresent(record::getFinishDay)
                .set(priorityType).equalToWhenPresent(record::getPriorityType)
                .set(priorityIndex).equalToWhenPresent(record::getPriorityIndex)
                .set(estimatePrepareTime).equalToWhenPresent(record::getEstimatePrepareTime)
                .set(estimateTime).equalToWhenPresent(record::getEstimateTime)
                .set(estimateCloseTime).equalToWhenPresent(record::getEstimateCloseTime)
                .set(startTime).equalToWhenPresent(record::getStartTime)
                .set(finishTime).equalToWhenPresent(record::getFinishTime)
                .set(createTime).equalToWhenPresent(record::getCreateTime)
                .set(updateTime).equalToWhenPresent(record::getUpdateTime);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.SCHEDULE")
    default int updateByPrimaryKey(Schedule record) {
        return update(c ->
            c.set(userId).equalTo(record::getUserId)
            .set(repeatType).equalTo(record::getRepeatType)
            .set(name).equalTo(record::getName)
            .set(category).equalTo(record::getCategory)
            .set(startDay).equalTo(record::getStartDay)
            .set(finishDay).equalTo(record::getFinishDay)
            .set(priorityType).equalTo(record::getPriorityType)
            .set(priorityIndex).equalTo(record::getPriorityIndex)
            .set(estimatePrepareTime).equalTo(record::getEstimatePrepareTime)
            .set(estimateTime).equalTo(record::getEstimateTime)
            .set(estimateCloseTime).equalTo(record::getEstimateCloseTime)
            .set(startTime).equalTo(record::getStartTime)
            .set(finishTime).equalTo(record::getFinishTime)
            .set(createTime).equalTo(record::getCreateTime)
            .set(updateTime).equalTo(record::getUpdateTime)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.SCHEDULE")
    default int updateByPrimaryKeySelective(Schedule record) {
        return update(c ->
            c.set(userId).equalToWhenPresent(record::getUserId)
            .set(repeatType).equalToWhenPresent(record::getRepeatType)
            .set(name).equalToWhenPresent(record::getName)
            .set(category).equalToWhenPresent(record::getCategory)
            .set(startDay).equalToWhenPresent(record::getStartDay)
            .set(finishDay).equalToWhenPresent(record::getFinishDay)
            .set(priorityType).equalToWhenPresent(record::getPriorityType)
            .set(priorityIndex).equalToWhenPresent(record::getPriorityIndex)
            .set(estimatePrepareTime).equalToWhenPresent(record::getEstimatePrepareTime)
            .set(estimateTime).equalToWhenPresent(record::getEstimateTime)
            .set(estimateCloseTime).equalToWhenPresent(record::getEstimateCloseTime)
            .set(startTime).equalToWhenPresent(record::getStartTime)
            .set(finishTime).equalToWhenPresent(record::getFinishTime)
            .set(createTime).equalToWhenPresent(record::getCreateTime)
            .set(updateTime).equalToWhenPresent(record::getUpdateTime)
            .where(id, isEqualTo(record::getId))
        );
    }
}