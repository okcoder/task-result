package org.okcoder.app.task.result.domain.service;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static org.mybatis.dynamic.sql.SqlBuilder.isGreaterThanOrEqualTo;
import static org.mybatis.dynamic.sql.SqlBuilder.isLessThanOrEqualTo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.mybatis.dynamic.sql.select.join.EqualTo;
import org.okcoder.app.task.result.domain.PriorityType;
import org.okcoder.app.task.result.domain.dao.ScheduleDao;
import org.okcoder.app.task.result.domain.dao.TaskDao;
import org.okcoder.app.task.result.domain.dto.TaskDetailDto;
import org.okcoder.app.task.result.domain.entity.Schedule;
import org.okcoder.app.task.result.domain.entity.Task;
import org.okcoder.app.task.result.domain.entity.TaskAction;
import org.okcoder.app.task.result.domain.repository.ScheduleDynamicSqlSupport;
import org.okcoder.app.task.result.domain.repository.ScheduleMapper;
import org.okcoder.app.task.result.domain.repository.ScheduleRepeatWeeklyDynamicSqlSupport;
import org.okcoder.app.task.result.domain.repository.TaskActionMapper;
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
	private TaskMapper taskMapper;
	private TaskActionMapper taskActionMapper;
	private TaskDao taskDao;
	private ScheduleDao scheduleDao;

	public TaskService(ScheduleMapper scheduleMapper, TaskMapper taskMapper, TaskActionMapper taskActionMapper,
			TaskDao taskDao, ScheduleDao scheduleDao) {
		super();
		this.scheduleMapper = scheduleMapper;
		this.taskMapper = taskMapper;
		this.taskActionMapper = taskActionMapper;
		this.taskDao = taskDao;
		this.scheduleDao = scheduleDao;
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

		List<Task> list = taskMapper.select(c -> c.where(TaskDynamicSqlSupport.userId, isEqualTo(userId))//
				.and(TaskDynamicSqlSupport.taskDay, isEqualTo(day)));
		return list;
	}

	public Map<String, List<TaskDetailDto>> getTasks(String userId, LocalDate day) {

		List<Task> tasks = taskDao.getTasks(userId, day);
		List<Schedule> schedules = this.scheduleDao.getSchedules(userId, day);
		Set<String> scheduleIds = tasks.stream().map(task -> task.getScheduleId()).collect(Collectors.toSet());

		schedules.stream().filter(s -> !scheduleIds.contains(s.getId())).map(s -> {
			Task task = new Task();
			BeanUtils.copyProperties(s, task, "id");
			task.setId(UUID.randomUUID().toString());
			task.setTaskDay(day);
			task.setTitle(s.getName());
			task.setScheduleId(s.getId());
			taskMapper.insert(task);
			return task;
		}).forEach(t -> tasks.add(t));

		;
		/*-
		taks.forEach(task->{
			task.setActions()
			taskDao.getActions(task.getId());
		});*/

		Map<String, List<TaskDetailDto>> list = tasks.stream().map(task -> {
			List<TaskAction> actions = taskDao.getActions(task.getId());
			return new TaskDetailDto(task, actions, false);
		}).collect(Collectors.groupingBy(TaskDetailDto::getPriorityType, Collectors.toList()));

		// SORT
		list.forEach((k, v) -> v.sort((a, b) -> a.getPriorityIndex() - b.getPriorityIndex()));

		// add priorityType without schedule
		Stream.of(PriorityType.values())//
				.map(pt -> pt.name())//
				.filter(pt -> !list.containsKey(pt))//
				.forEach(pt -> list.put(pt, new ArrayList<>()));

		return list;

	}

	public void savePriority(Map<String, List<Task>> tasks) {
		tasks.forEach((k, v) -> {
			IntStream.range(0, v.size()).filter(i -> {
				Task task = v.get(i);
				return !Objects.equals(task.getPriorityType(), k) || task.getPriorityIndex() != i;
			}).forEach(i -> {
				Task task = v.get(i);
				task.setPriorityType(k);
				task.setPriorityIndex(i);
				this.taskMapper.updateByPrimaryKey(task);
			});
		});

	}

	/*-
	public TaskDetailDto getTask(String userId, String taskId) {
	
		TaskDetailDto detail = null;
	
		Optional<Task> task = taskMapper.selectByPrimaryKey(taskId);
		if (task.isPresent()) {
			detail = new TaskDetailDto(task.get(), true);
		}
	
		return detail;
	}*/

	public void save(String taskId, TaskDetailDto task) {
		Task entity = new Task();
		BeanUtils.copyProperties(task, entity);

		this.taskMapper.insertOrUpdate(entity);

	}

	public List<TaskAction> addAction(String taskId, String action) {
		TaskAction record = new TaskAction();
		record.setTaskId(taskId);
		record.setAction(action);
		record.setActionTime(LocalDateTime.now());
		record.setCreateTime(LocalDateTime.now());// FIXME
		taskActionMapper.insert(record);

		return taskDao.getActions(taskId);
	}

}
