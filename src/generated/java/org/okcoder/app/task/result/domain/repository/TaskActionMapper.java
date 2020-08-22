package org.okcoder.app.task.result.domain.repository;

import static org.mybatis.dynamic.sql.SqlBuilder.*;
import static org.okcoder.app.task.result.domain.repository.TaskActionDynamicSqlSupport.*;

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
import org.okcoder.app.task.result.domain.entity.TaskAction;

@Mapper
public interface TaskActionMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.TASK_ACTION")
    BasicColumn[] selectList = BasicColumn.columnList(taskId, action, actionTime, createTime, updateTime);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.TASK_ACTION")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.TASK_ACTION")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.TASK_ACTION")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<TaskAction> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.TASK_ACTION")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<TaskAction> multipleInsertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.TASK_ACTION")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("TaskActionResult")
    Optional<TaskAction> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.TASK_ACTION")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="TaskActionResult", value = {
        @Result(column="TASK_ID", property="taskId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="ACTION", property="action", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="ACTION_TIME", property="actionTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<TaskAction> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.TASK_ACTION")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.TASK_ACTION")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, taskAction, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.TASK_ACTION")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, taskAction, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.TASK_ACTION")
    default int deleteByPrimaryKey(String taskId_, String action_) {
        return delete(c -> 
            c.where(taskId, isEqualTo(taskId_))
            .and(action, isEqualTo(action_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.TASK_ACTION")
    default int insertOrUpdate(TaskAction record) {
        int count = this.updateByPrimaryKey(record);
        if (count > 0) {
            return count;
        } else {
            return this.insert(record);
        }
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.TASK_ACTION")
    default int insert(TaskAction record) {
        return MyBatis3Utils.insert(this::insert, record, taskAction, c ->
            c.map(taskId).toProperty("taskId")
            .map(action).toProperty("action")
            .map(actionTime).toProperty("actionTime")
            .map(createTime).toProperty("createTime")
            .map(updateTime).toProperty("updateTime")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.TASK_ACTION")
    default int insertMultiple(Collection<TaskAction> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, taskAction, c ->
            c.map(taskId).toProperty("taskId")
            .map(action).toProperty("action")
            .map(actionTime).toProperty("actionTime")
            .map(createTime).toProperty("createTime")
            .map(updateTime).toProperty("updateTime")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.TASK_ACTION")
    default int insertSelective(TaskAction record) {
        return MyBatis3Utils.insert(this::insert, record, taskAction, c ->
            c.map(taskId).toPropertyWhenPresent("taskId", record::getTaskId)
            .map(action).toPropertyWhenPresent("action", record::getAction)
            .map(actionTime).toPropertyWhenPresent("actionTime", record::getActionTime)
            .map(createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
            .map(updateTime).toPropertyWhenPresent("updateTime", record::getUpdateTime)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.TASK_ACTION")
    default Optional<TaskAction> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, taskAction, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.TASK_ACTION")
    default List<TaskAction> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, taskAction, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.TASK_ACTION")
    default List<TaskAction> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, taskAction, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.TASK_ACTION")
    default Optional<TaskAction> selectByPrimaryKey(String taskId_, String action_) {
        return selectOne(c ->
            c.where(taskId, isEqualTo(taskId_))
            .and(action, isEqualTo(action_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.TASK_ACTION")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, taskAction, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.TASK_ACTION")
    static UpdateDSL<UpdateModel> updateAllColumns(TaskAction record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(taskId).equalTo(record::getTaskId)
                .set(action).equalTo(record::getAction)
                .set(actionTime).equalTo(record::getActionTime)
                .set(createTime).equalTo(record::getCreateTime)
                .set(updateTime).equalTo(record::getUpdateTime);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.TASK_ACTION")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(TaskAction record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(taskId).equalToWhenPresent(record::getTaskId)
                .set(action).equalToWhenPresent(record::getAction)
                .set(actionTime).equalToWhenPresent(record::getActionTime)
                .set(createTime).equalToWhenPresent(record::getCreateTime)
                .set(updateTime).equalToWhenPresent(record::getUpdateTime);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.TASK_ACTION")
    default int updateByPrimaryKey(TaskAction record) {
        return update(c ->
            c.set(actionTime).equalTo(record::getActionTime)
            .set(createTime).equalTo(record::getCreateTime)
            .set(updateTime).equalTo(record::getUpdateTime)
            .where(taskId, isEqualTo(record::getTaskId))
            .and(action, isEqualTo(record::getAction))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: PUBLIC.TASK_ACTION")
    default int updateByPrimaryKeySelective(TaskAction record) {
        return update(c ->
            c.set(actionTime).equalToWhenPresent(record::getActionTime)
            .set(createTime).equalToWhenPresent(record::getCreateTime)
            .set(updateTime).equalToWhenPresent(record::getUpdateTime)
            .where(taskId, isEqualTo(record::getTaskId))
            .and(action, isEqualTo(record::getAction))
        );
    }
}