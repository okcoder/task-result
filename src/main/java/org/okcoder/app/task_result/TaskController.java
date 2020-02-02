package org.okcoder.app.task_result;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import org.okcoder.app.task_result.domain.entity.EventFields;
import org.okcoder.app.task_result.domain.entity.EventFieldsCondition;
import org.okcoder.app.task_result.domain.entity.Events;
import org.okcoder.app.task_result.domain.entity.EventsCondition;
import org.okcoder.app.task_result.domain.entity.Field;
import org.okcoder.app.task_result.domain.entity.FieldCondition;
import org.okcoder.app.task_result.domain.entity.Task;
import org.okcoder.app.task_result.domain.entity.TaskCondition;
import org.okcoder.app.task_result.domain.mapper.EventFieldsMapper;
import org.okcoder.app.task_result.domain.mapper.EventsMapper;
import org.okcoder.app.task_result.domain.mapper.FieldMapper;
import org.okcoder.app.task_result.domain.mapper.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class TaskController {


	
	@Autowired
	private EventFieldsMapper eventField;
	
	@Autowired
	private FieldMapper field;
	@Autowired
	private EventsMapper events;
	
	@GetMapping("/task/{eventId}/{taskId}")
	public String home(Principal principal,Model model,@PathVariable  long eventId, @PathVariable int taskId) {
		TaskInfo taskinfo = getTask(principal.getName(), eventId,taskId);	
		model.addAttribute("ti",taskinfo);
		return "task";
	}

	private TaskInfo getTask(String userId, long eventId, int taskId) {
		
		EventFieldsCondition eventFieldsCondition = new EventFieldsCondition();
		eventFieldsCondition.createCriteria().andEventIdEqualTo(eventId);
		List<EventFields> eventFields = eventField.selectByExample(eventFieldsCondition);

		List<Integer> fieldIds = eventFields.stream().map(e->e.getFieldId()).collect(Collectors.toList());
		
		FieldCondition fieldCondition = new FieldCondition();
		fieldCondition.createCriteria().andFieldIdIn(fieldIds);
		List<Field> fields = field.selectByExample(fieldCondition );
		
		TaskInfo ti = new TaskInfo();
		ti.setFields(fields);
		ti.setEvent(events.selectByPrimaryKey(userId, eventId));
		return ti;
	}

}
