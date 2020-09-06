package org.okcoder.app.task.result.domain.dto;

import java.time.DayOfWeek;
import java.util.List;

import org.okcoder.app.task.result.domain.PriorityType;
import org.okcoder.app.task.result.domain.entity.Schedule;
import org.okcoder.app.task.result.domain.entity.ScheduleRepeatWeekly;
import org.springframework.beans.BeanUtils;

public class ScheduleDetailDto extends Schedule {

	private String[] repeats = new String[0];
	private DayOfWeek[] repeatOptions = DayOfWeek.values();
	private PriorityType[] priorityTypeOptions = PriorityType.values();

	public ScheduleDetailDto() {
	}

	public ScheduleDetailDto(Schedule schedule, List<ScheduleRepeatWeekly> repeats) {
		BeanUtils.copyProperties(schedule, this);
		this.setRepeats(repeats);
	}

	public String[] getRepeats() {
		return repeats;

	}

	public void setRepeats(List<ScheduleRepeatWeekly> repeats) {
		this.repeats = repeats.stream().map(repeat -> repeat.getDayOfWeek()).toArray(n -> new String[n]);
	}

	public DayOfWeek[] getRepeatOptions() {
		return repeatOptions;
	}

	public PriorityType[] getPriorityTypeOptions() {
		return priorityTypeOptions;
	}

}
