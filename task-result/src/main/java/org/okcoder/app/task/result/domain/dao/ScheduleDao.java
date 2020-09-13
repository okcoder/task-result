package org.okcoder.app.task.result.domain.dao;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.okcoder.app.task.result.domain.entity.Schedule;
import org.okcoder.app.task.result.domain.entity.ScheduleRepeatWeekly;
import org.okcoder.app.task.result.domain.repository.ScheduleDynamicSqlSupport;
import org.okcoder.app.task.result.domain.repository.ScheduleMapper;
import org.okcoder.app.task.result.domain.repository.ScheduleRepeatWeeklyDynamicSqlSupport;
import org.okcoder.app.task.result.domain.repository.ScheduleRepeatWeeklyMapper;
import org.springframework.stereotype.Component;

@Component
public class ScheduleDao {
	private ScheduleMapper scheduleMapper;
	private ScheduleRepeatWeeklyMapper scheduleRepeatWeeklyMapper;

	public ScheduleDao(ScheduleMapper scheduleMapper, ScheduleRepeatWeeklyMapper scheduleRepeatWeeklyMapper) {
		super();
		this.scheduleMapper = scheduleMapper;
		this.scheduleRepeatWeeklyMapper = scheduleRepeatWeeklyMapper;
	}

	public List<Schedule> getSchedules(String userId) {

		List<Schedule> schedules = scheduleMapper
				.select(c -> c.where(ScheduleDynamicSqlSupport.userId, isEqualTo(userId))
						.orderBy(ScheduleDynamicSqlSupport.priorityIndex));
		return schedules;
	}

	public List<ScheduleRepeatWeekly> getRepeat(String scheduleId) {

		List<ScheduleRepeatWeekly> list = scheduleRepeatWeeklyMapper
				.select(c -> c.where(ScheduleRepeatWeeklyDynamicSqlSupport.scheduleId, isEqualTo(scheduleId)));
		return list;
	}

	public void mergeRepeats(String scheduleId, String[] repeats) {
		Set<String> newRepeats = new HashSet<>(Arrays.asList(repeats));
		List<ScheduleRepeatWeekly> currentRepeats = this.getRepeat(scheduleId);

		currentRepeats.stream()//
				.filter(repeat -> !newRepeats.contains(repeat.getDayOfWeek()))//
				.forEach(repeat -> {
					this.scheduleRepeatWeeklyMapper.deleteByPrimaryKey(scheduleId, repeat.getDayOfWeek());
				});
		newRepeats.stream()
				.filter(dayOfWeek -> !currentRepeats.stream()
						.filter(repeat -> Objects.equals(dayOfWeek, repeat.getDayOfWeek())).findFirst().isPresent())//
				.forEach(dayOfWeek -> {
					ScheduleRepeatWeekly record = new ScheduleRepeatWeekly();
					record.setScheduleId(scheduleId);
					record.setDayOfWeek(dayOfWeek);
					this.scheduleRepeatWeeklyMapper.insert(record);
				});

	}

}
