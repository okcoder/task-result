package org.okcoder.app.task_result;

import java.util.List;

import org.okcoder.app.task_result.domain.entity.EventFields;
import org.okcoder.app.task_result.domain.entity.Events;
import org.okcoder.app.task_result.domain.entity.Field;
import org.okcoder.app.task_result.domain.entity.Task;

public class TaskInfo {
	private Events event;
	private Task task;
	private	List<Field> fields;
	public Events getEvent() {
		return event;
	}
	public void setEvent(Events event) {
		this.event = event;
	}
	public Task getTask() {
		return task;
	}
	public void setTask(Task task) {
		this.task = task;
	}
	public List<Field> getFields() {
		return fields;
	}
	public void setFields(List<Field> fields) {
		this.fields = fields;
	}
}
