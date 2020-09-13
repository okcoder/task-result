package org.okcoder.app.task.result.domain.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

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
		schedules.stream().collect(Collectors.groupingBy(Schedule::getPriorityType, Collectors.toList()));

		Map<String, List<ScheduleDetailDto>> list = schedules.stream().map(schedule -> {
			List<ScheduleRepeatWeekly> repeats = scheduleDao.getRepeat(schedule.getId());
			return new ScheduleDetailDto(schedule, repeats);
		}).collect(Collectors.groupingBy(ScheduleDetailDto::getPriorityType, Collectors.toList()));

		return list;
	}

	public ScheduleDetailDto getSchedule(String userId, String scheduleId) {

		ScheduleDetailDto detail = null;
		if ("NEW".equalsIgnoreCase(scheduleId)) {
			detail = new ScheduleDetailDto(null, null, true);
			detail.setUserId(userId);
			detail.setPriorityType(PriorityType.water.name());
			detail.setRepeatType(RepeatType.weekly.name());
			detail.setPriorityIndex(0);
			detail.setCreateTime(LocalDateTime.now());//FIXME CREATE_TIME
			return detail;
		}
		
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

		scheduleDao.mergeRepeats(scheduleId,schedule.getRepeats());
	}

}
