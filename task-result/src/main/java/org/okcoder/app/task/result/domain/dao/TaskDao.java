package org.okcoder.app.task.result.domain.dao;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import java.time.LocalDate;
import java.util.List;

import org.okcoder.app.task.result.domain.entity.Task;
import org.okcoder.app.task.result.domain.entity.TaskAction;
import org.okcoder.app.task.result.domain.repository.TaskActionDynamicSqlSupport;
import org.okcoder.app.task.result.domain.repository.TaskActionMapper;
import org.okcoder.app.task.result.domain.repository.TaskDynamicSqlSupport;
import org.okcoder.app.task.result.domain.repository.TaskMapper;
import org.springframework.stereotype.Component;

@Component
public class TaskDao {
	private TaskMapper taskMapper;
	private TaskActionMapper taskActionMapper;

	public TaskDao(TaskMapper taskMapper, TaskActionMapper taskActionMapper) {
		super();
		this.taskMapper = taskMapper;
		this.taskActionMapper = taskActionMapper;
	}

	public List<Task> getTasks(String userId, LocalDate day) {

		List<Task> list = taskMapper.select(c -> c.where(TaskDynamicSqlSupport.userId, isEqualTo(userId))//
				.and(TaskDynamicSqlSupport.taskDay, isEqualTo(day)));
		return list;
	}

	public List<TaskAction> getActions(String taskId) {

		List<TaskAction> list = taskActionMapper
				.select(c -> c.where(TaskActionDynamicSqlSupport.taskId, isEqualTo(taskId))//
						.orderBy(TaskActionDynamicSqlSupport.actionTime));
		return list;
	}

}
