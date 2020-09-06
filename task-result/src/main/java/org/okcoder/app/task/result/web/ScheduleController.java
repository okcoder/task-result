package org.okcoder.app.task.result.web;

import java.util.List;

import org.okcoder.app.task.result.domain.dto.ScheduleDetailDto;
import org.okcoder.app.task.result.domain.service.ScheduleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	public List<ScheduleDetailDto> getSchedules() {
		return scheduleService.getSchedules(userId);
	}
	@GetMapping("/{scheduleId}")
	@CrossOrigin
	public ScheduleDetailDto getSchedule(@PathVariable String scheduleId) {
		return scheduleService.getSchedule(userId, scheduleId);
	}
	
	@PostMapping("/{scheduleId}")
	@CrossOrigin
	public void saveSchedule(@PathVariable String scheduleId,ScheduleDetailDto schedule) {
		logger.info("{}",schedule);
	}
}
