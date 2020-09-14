package org.okcoder.app.task.result.domain.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.okcoder.app.task.result.domain.PriorityType;
import org.okcoder.app.task.result.domain.RepeatType;
import org.okcoder.app.task.result.domain.dao.ScheduleDao;
import org.okcoder.app.task.result.domain.dto.ScheduleDetailDto;
import org.okcoder.app.task.result.domain.entity.Schedule;
import org.okcoder.app.task.result.domain.entity.ScheduleRepeatWeekly;
import org.okcoder.app.task.result.domain.repository.ScheduleMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {

	Logger logger = LoggerFactory.getLogger(ScheduleService.class);

	private ScheduleMapper scheduleMapper;
	private ScheduleDao scheduleDao;

	public ScheduleService(ScheduleMapper scheduleMapper, ScheduleDao scheduleDao) {
		this.scheduleMapper = scheduleMapper;
		this.scheduleDao = scheduleDao;
	}

	public Map<String, List<ScheduleDetailDto>> getSchedules(String userId) {

		List<Schedule> schedules = scheduleDao.getSchedules(userId);

		Map<String, List<ScheduleDetailDto>> list = schedules.stream().map(schedule -> {
			List<ScheduleRepeatWeekly> repeats = scheduleDao.getRepeat(schedule.getId());
			return new ScheduleDetailDto(schedule, repeats);
		}).collect(Collectors.groupingBy(ScheduleDetailDto::getPriorityType, Collectors.toList()));

		// SORT
		list.forEach((k, v) -> v.sort((a, b) -> a.getPriorityIndex() - b.getPriorityIndex()));

		// add priorityType without schedule
		Stream.of(PriorityType.values())//
				.map(pt -> pt.name())//
				.filter(pt -> !list.containsKey(pt))//
				.forEach(pt -> list.put(pt, new ArrayList<>()));

		return list;
	}

	public ScheduleDetailDto newSchedule(String userId, String priorityType) {
		ScheduleDetailDto detail = null;
		detail = new ScheduleDetailDto(null, null, true);
		detail.setUserId(userId);
		detail.setPriorityType(PriorityType.valueOf(priorityType).name());
		detail.setRepeatType(RepeatType.weekly.name());
		detail.setPriorityIndex(0);
		detail.setCreateTime(LocalDateTime.now());// FIXME CREATE_TIME
		return detail;
	}

	public ScheduleDetailDto getSchedule(String userId, String scheduleId) {

		ScheduleDetailDto detail = null;

		Optional<Schedule> schedule = scheduleMapper.selectByPrimaryKey(scheduleId);
		if (schedule.isPresent()) {
			List<ScheduleRepeatWeekly> repeats = scheduleDao.getRepeat(scheduleId);
			detail = new ScheduleDetailDto(schedule.get(), repeats, true);
		}

		return detail;
	}

	public void save(String scheduleId, ScheduleDetailDto schedule) {
		Schedule entity = new Schedule();
		BeanUtils.copyProperties(schedule, entity);

		if ("NEW".equalsIgnoreCase(scheduleId)) {
			scheduleId = UUID.randomUUID().toString();
			entity.setId(scheduleId);
		}

		this.scheduleMapper.insertOrUpdate(entity);

		scheduleDao.mergeRepeats(scheduleId, schedule.getRepeats());
	}

	public void savePriority(Map<String, List<ScheduleDetailDto>> schedules) {
		schedules.forEach((k, v) -> {
			IntStream.range(0, v.size()).filter(i -> {
				ScheduleDetailDto schedule = v.get(i);
				return !Objects.equals(schedule.getPriorityType(), k) || schedule.getPriorityIndex() != i;
			}).forEach(i -> {
				ScheduleDetailDto schedule = v.get(i);
				schedule.setPriorityType(k);
				schedule.setPriorityIndex(i);
				this.scheduleMapper.updateByPrimaryKey(schedule);
			});
		});

	}

}
