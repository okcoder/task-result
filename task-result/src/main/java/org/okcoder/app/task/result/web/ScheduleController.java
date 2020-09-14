package org.okcoder.app.task.result.web;

import java.util.List;
import java.util.Map;

import org.okcoder.app.task.result.domain.dto.ScheduleDetailDto;
import org.okcoder.app.task.result.domain.service.ScheduleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("schedule")
public class ScheduleController {

	Logger logger = LoggerFactory.getLogger(getClass());

	private ScheduleService scheduleService;

	public ScheduleController(ScheduleService scheduleService) {
		this.scheduleService = scheduleService;
	}

	private String userId = "wxs";

	@GetMapping("")
	@CrossOrigin
	public Map<String, List<ScheduleDetailDto>> getSchedules() {
		return scheduleService.getSchedules(userId);
	}
	
	@PostMapping("")
	@CrossOrigin
	public void savePriority( @RequestBody Map<String, List<ScheduleDetailDto>> schedules) {
		logger.info("{}", schedules);
		this.scheduleService.savePriority(schedules);
	}

	@GetMapping("/{scheduleId}")
	@CrossOrigin
	public ScheduleDetailDto getSchedule(@PathVariable String scheduleId) {
		return scheduleService.getSchedule(userId, scheduleId);
	}

	@GetMapping("/new/{priorityType}")
	@CrossOrigin
	public ScheduleDetailDto newSchedule(@PathVariable String priorityType) {
		return scheduleService.newSchedule(userId, priorityType);
	}

	
	@PostMapping("/{scheduleId}")
	@CrossOrigin
	public void save(@PathVariable String scheduleId, @RequestBody ScheduleDetailDto schedule) {
		logger.info("{}", schedule);
		this.scheduleService.save( scheduleId,schedule);
	}
}
