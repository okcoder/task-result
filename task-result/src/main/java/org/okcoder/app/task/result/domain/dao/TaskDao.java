package org.okcoder.app.task.result.domain.dao;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import java.time.LocalDate;
import java.util.List;

import org.okcoder.app.task.result.domain.entity.Task;
import org.okcoder.app.task.result.domain.repository.TaskDynamicSqlSupport;
import org.okcoder.app.task.result.domain.repository.TaskMapper;
import org.springframework.stereotype.Component;

@Component
public class TaskDao {
	private TaskMapper taskMapper;

	public TaskDao(TaskMapper taskMapper) {
		super();
		this.taskMapper = taskMapper;
	}

	public List<Task> getTasks(String userId, LocalDate day) {

		List<Task> list = taskMapper.select(c -> c.where(TaskDynamicSqlSupport.userId, isEqualTo(userId))//
				.and(TaskDynamicSqlSupport.taskDay, isEqualTo(day)));
		return list;
	}

}
