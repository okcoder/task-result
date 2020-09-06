package org.okcoder.app.task.result.domain.service;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static org.mybatis.dynamic.sql.SqlBuilder.isGreaterThanOrEqualTo;
import static org.mybatis.dynamic.sql.SqlBuilder.isLessThanOrEqualTo;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.mybatis.dynamic.sql.select.join.EqualTo;
import org.okcoder.app.task.result.domain.entity.Schedule;
import org.okcoder.app.task.result.domain.entity.Task;
import org.okcoder.app.task.result.domain.repository.ScheduleDynamicSqlSupport;
import org.okcoder.app.task.result.domain.repository.ScheduleMapper;
import org.okcoder.app.task.result.domain.repository.ScheduleRepeatWeeklyDynamicSqlSupport;
import org.okcoder.app.task.result.domain.repository.ScheduleRepeatWeeklyMapper;
import org.okcoder.app.task.result.domain.repository.TaskDynamicSqlSupport;
import org.okcoder.app.task.result.domain.repository.TaskMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

	Logger logger = LoggerFactory.getLogger(TaskService.class);

	private ScheduleMapper scheduleMapper;
	private ScheduleRepeatWeeklyMapper scheduleRepeatWeeklyMapper;
	private TaskMapper taskMapper;

	public TaskService(TaskMapper taskMapper, ScheduleMapper scheduleMapper,
			ScheduleRepeatWeeklyMapper scheduleRepeatWeeklyMapper) {
		this.taskMapper = taskMapper;
		this.scheduleMapper = scheduleMapper;
		this.scheduleRepeatWeeklyMapper = scheduleRepeatWeeklyMapper;
	}

	public void initTask(String userId, LocalDate day) {

		List<Schedule> list = scheduleMapper
				.select(c -> c.join(ScheduleRepeatWeeklyDynamicSqlSupport.scheduleRepeatWeekly)
						.on(ScheduleDynamicSqlSupport.id, new EqualTo(ScheduleRepeatWeeklyDynamicSqlSupport.scheduleId))
						.where(ScheduleDynamicSqlSupport.userId, isEqualTo(userId))//
						.and(ScheduleDynamicSqlSupport.startDay, isLessThanOrEqualTo(day))//
						.and(ScheduleDynamicSqlSupport.finishDay, isGreaterThanOrEqualTo(day))
						.and(ScheduleRepeatWeeklyDynamicSqlSupport.dayOfWeek, isEqualTo(day.getDayOfWeek().name())));
		list.forEach(s -> {
			Task task = new Task();
			BeanUtils.copyProperties(s, task, "id");
			task.setId(UUID.randomUUID().toString());
			task.setTaskDay(day);
			task.setTitle(s.getName());
			taskMapper.insert(task);
		});
	}

	public List<Task> getTask(String userId, LocalDate day) {

		List<Task> list = taskMapper.select(
				c -> c.where(TaskDynamicSqlSupport.userId, isEqualTo(userId))//
						.and(TaskDynamicSqlSupport.taskDay, isEqualTo(day)));
		return list;
	}


}
