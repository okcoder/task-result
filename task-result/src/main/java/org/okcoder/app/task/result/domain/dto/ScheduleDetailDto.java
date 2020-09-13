package org.okcoder.app.task.result.domain.dto;

import java.time.DayOfWeek;
import java.util.List;

import org.okcoder.app.task.result.domain.PriorityType;
import org.okcoder.app.task.result.domain.entity.Schedule;
import org.okcoder.app.task.result.domain.entity.ScheduleRepeatWeekly;
import org.springframework.beans.BeanUtils;

public class ScheduleDetailDto extends Schedule {

	private String[] repeats = new String[0];
	private DayOfWeek[] repeatOptions;
	private PriorityType[] priorityTypeOptions;

	public ScheduleDetailDto() {
	}

	public ScheduleDetailDto(Schedule schedule, List<ScheduleRepeatWeekly> repeats, boolean includeOptions) {
		if (schedule != null) {
			BeanUtils.copyProperties(schedule, this);
		}
		if (repeats != null) {
			this.setRepeatsInfo(repeats);
		}
		if (includeOptions) {
			repeatOptions = DayOfWeek.values();
			priorityTypeOptions = PriorityType.values();
		}
	}

	private void setRepeatsInfo(List<ScheduleRepeatWeekly> repeats) {
		this.repeats = repeats.stream().map(repeat -> repeat.getDayOfWeek()).toArray(n -> new String[n]);
	}

	public ScheduleDetailDto(Schedule schedule, List<ScheduleRepeatWeekly> repeats) {
		this(schedule, repeats, false);
	}

	public String[] getRepeats() {
		return repeats;

	}

	public void setRepeats(String[] repeats) {
		this.repeats = repeats;
	}

	public DayOfWeek[] getRepeatOptions() {
		return repeatOptions;
	}

	public PriorityType[] getPriorityTypeOptions() {
		return priorityTypeOptions;
	}

}
