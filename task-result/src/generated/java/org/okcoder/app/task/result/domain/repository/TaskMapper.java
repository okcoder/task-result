package org.okcoder.app.task.result.domain.repository;

import static org.mybatis.dynamic.sql.SqlBuilder.*;
import static org.okcoder.app.task.result.domain.repository.TaskDynamicSqlSupport.*;

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
import org.okcoder.app.task.result.domain.entity.Task;

@Mapper
public interface TaskMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.TASK")
    BasicColumn[] selectList = BasicColumn.columnList(id, userId, taskDay, scheduleId, category, title, subTitle, priorityType, priorityIndex, estimatePrepareTime, estimateTime, estimateCloseTime, startTime, finishTime, createTime, updateTime);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.TASK")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.TASK")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.TASK")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<Task> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.TASK")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<Task> multipleInsertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.TASK")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("TaskResult")
    Optional<Task> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.TASK")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="TaskResult", value = {
        @Result(column="ID", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="USER_ID", property="userId", jdbcType=JdbcType.VARCHAR),
        @Result(column="TASK_DAY", property="taskDay", jdbcType=JdbcType.DATE),
        @Result(column="SCHEDULE_ID", property="scheduleId", jdbcType=JdbcType.VARCHAR),
        @Result(column="CATEGORY", property="category", jdbcType=JdbcType.VARCHAR),
        @Result(column="TITLE", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="SUB_TITLE", property="subTitle", jdbcType=JdbcType.VARCHAR),
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
    List<Task> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.TASK")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.TASK")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, task, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.TASK")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, task, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.TASK")
    default int deleteByPrimaryKey(String id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.TASK")
    default int insertOrUpdate(Task record) {
        int count = this.updateByPrimaryKey(record);
        if (count > 0) {
            return count;
        } else {
            return this.insert(record);
        }
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.TASK")
    default int insert(Task record) {
        return MyBatis3Utils.insert(this::insert, record, task, c ->
            c.map(id).toProperty("id")
            .map(userId).toProperty("userId")
            .map(taskDay).toProperty("taskDay")
            .map(scheduleId).toProperty("scheduleId")
            .map(category).toProperty("category")
            .map(title).toProperty("title")
            .map(subTitle).toProperty("subTitle")
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

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.TASK")
    default int insertMultiple(Collection<Task> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, task, c ->
            c.map(id).toProperty("id")
            .map(userId).toProperty("userId")
            .map(taskDay).toProperty("taskDay")
            .map(scheduleId).toProperty("scheduleId")
            .map(category).toProperty("category")
            .map(title).toProperty("title")
            .map(subTitle).toProperty("subTitle")
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

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.TASK")
    default int insertSelective(Task record) {
        return MyBatis3Utils.insert(this::insert, record, task, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(userId).toPropertyWhenPresent("userId", record::getUserId)
            .map(taskDay).toPropertyWhenPresent("taskDay", record::getTaskDay)
            .map(scheduleId).toPropertyWhenPresent("scheduleId", record::getScheduleId)
            .map(category).toPropertyWhenPresent("category", record::getCategory)
            .map(title).toPropertyWhenPresent("title", record::getTitle)
            .map(subTitle).toPropertyWhenPresent("subTitle", record::getSubTitle)
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

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.TASK")
    default Optional<Task> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, task, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.TASK")
    default List<Task> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, task, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.TASK")
    default List<Task> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, task, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.TASK")
    default Optional<Task> selectByPrimaryKey(String id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.TASK")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, task, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.TASK")
    static UpdateDSL<UpdateModel> updateAllColumns(Task record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(userId).equalTo(record::getUserId)
                .set(taskDay).equalTo(record::getTaskDay)
                .set(scheduleId).equalTo(record::getScheduleId)
                .set(category).equalTo(record::getCategory)
                .set(title).equalTo(record::getTitle)
                .set(subTitle).equalTo(record::getSubTitle)
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

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.TASK")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Task record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(userId).equalToWhenPresent(record::getUserId)
                .set(taskDay).equalToWhenPresent(record::getTaskDay)
                .set(scheduleId).equalToWhenPresent(record::getScheduleId)
                .set(category).equalToWhenPresent(record::getCategory)
                .set(title).equalToWhenPresent(record::getTitle)
                .set(subTitle).equalToWhenPresent(record::getSubTitle)
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

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.TASK")
    default int updateByPrimaryKey(Task record) {
        return update(c ->
            c.set(userId).equalTo(record::getUserId)
            .set(taskDay).equalTo(record::getTaskDay)
            .set(scheduleId).equalTo(record::getScheduleId)
            .set(category).equalTo(record::getCategory)
            .set(title).equalTo(record::getTitle)
            .set(subTitle).equalTo(record::getSubTitle)
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

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.TASK")
    default int updateByPrimaryKeySelective(Task record) {
        return update(c ->
            c.set(userId).equalToWhenPresent(record::getUserId)
            .set(taskDay).equalToWhenPresent(record::getTaskDay)
            .set(scheduleId).equalToWhenPresent(record::getScheduleId)
            .set(category).equalToWhenPresent(record::getCategory)
            .set(title).equalToWhenPresent(record::getTitle)
            .set(subTitle).equalToWhenPresent(record::getSubTitle)
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