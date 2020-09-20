package org.okcoder.app.task.result.domain.dto;

import java.util.List;

import org.okcoder.app.task.result.domain.PriorityType;
import org.okcoder.app.task.result.domain.entity.Task;
import org.okcoder.app.task.result.domain.entity.TaskAction;
import org.springframework.beans.BeanUtils;

public class TaskDetailDto extends Task {

	private PriorityType[] priorityTypeOptions;

	private List<TaskAction> actions;

	public TaskDetailDto() {
	}

	public TaskDetailDto(Task task, List<TaskAction> actions, boolean includeOptions) {
		if (task != null) {
			BeanUtils.copyProperties(task, this);
		}
		this.actions = actions;
		if (includeOptions) {
			priorityTypeOptions = PriorityType.values();
		}
	}

	public PriorityType[] getPriorityTypeOptions() {
		return priorityTypeOptions;
	}

	public List<TaskAction> getActions() {
		return actions;
	}

	public void setActions(List<TaskAction> actions) {
		this.actions = actions;
	}

}
