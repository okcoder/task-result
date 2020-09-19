package org.okcoder.app.task.result.domain.dto;

import org.okcoder.app.task.result.domain.PriorityType;
import org.okcoder.app.task.result.domain.entity.Task;
import org.springframework.beans.BeanUtils;

public class TaskDetailDto extends Task {

	private PriorityType[] priorityTypeOptions;

	public TaskDetailDto() {
	}

	public TaskDetailDto(Task task, boolean includeOptions) {
		if (task != null) {
			BeanUtils.copyProperties(task, this);
		}
		if (includeOptions) {
			priorityTypeOptions = PriorityType.values();
		}
	}

	public PriorityType[] getPriorityTypeOptions() {
		return priorityTypeOptions;
	}

}
