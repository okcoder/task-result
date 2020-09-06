package org.okcoder.app.task.result.domain.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.okcoder.app.task.result.domain.dao.ScheduleDao;
import org.okcoder.app.task.result.domain.dto.ScheduleDetailDto;
import org.okcoder.app.task.result.domain.entity.Schedule;
import org.okcoder.app.task.result.domain.entity.ScheduleRepeatWeekly;
import org.okcoder.app.task.result.domain.repository.ScheduleMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	public List<ScheduleDetailDto> getSchedules(String userId) {

		List<Schedule> schedules = scheduleDao.getSchedules(userId);

		List<ScheduleDetailDto> list = schedules.stream().map(schedule -> {
			List<ScheduleRepeatWeekly> repeats = scheduleDao.getRepeat(schedule.getId());
			return new ScheduleDetailDto(schedule, repeats);
		}).collect(Collectors.toList());

		return list;
	}

	public ScheduleDetailDto getSchedule(String userId, String scheduleId) {

		ScheduleDetailDto detail = null;
		Optional<Schedule> schedule = scheduleMapper.selectByPrimaryKey(scheduleId);
		if (schedule.isPresent()) {
			List<ScheduleRepeatWeekly> repeats = scheduleDao.getRepeat(scheduleId);
			detail = new ScheduleDetailDto(schedule.get(), repeats);
		}

		return detail;
	}

}
