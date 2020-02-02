package org.okcoder.app.task_result;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import org.okcoder.app.task_result.domain.entity.Events;
import org.okcoder.app.task_result.domain.entity.EventsCondition;
import org.okcoder.app.task_result.domain.entity.Task;
import org.okcoder.app.task_result.domain.entity.TaskCondition;
import org.okcoder.app.task_result.domain.mapper.EventFieldsMapper;
import org.okcoder.app.task_result.domain.mapper.EventsMapper;
import org.okcoder.app.task_result.domain.mapper.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@Autowired
	private EventsMapper events;

	@Autowired
	private TaskMapper task;
	
	//@Autowired
	//private EventFieldsMapper eventField;
	
	@GetMapping("/")
	public String home(Principal principal,Model model) {
		List<TaskInfo> taskinfos = getTasks(principal);	
		model.addAttribute("tasks", taskinfos);
		return "index";
	}

	private List<TaskInfo> getTasks(Principal principal) {
		EventsCondition example = new EventsCondition();
		example.createCriteria().andUserIdEqualTo(principal.getName());
		List<Events> eventlist = events.selectByExample(example );
		
		List<Long> eventIds = eventlist.stream().map(e->e.getEventId()).collect(Collectors.toList());
		
		TaskCondition taskCondition = new TaskCondition();
		taskCondition.createCriteria()//
		.andEventIdIn(eventIds)
		.andScheduledDateEqualTo(LocalDate.now());
		List<Task> tasks = task.selectByExample(taskCondition);
		if (tasks.size() == 0) {
			tasks =insertTask(eventIds);
		}
		return 
		tasks.stream().map(t->{
			TaskInfo ti = new TaskInfo();
			ti.setTask(t);
			ti.setEvent(eventlist.stream().filter(e->Objects.equals(e.getEventId(), t.getEventId())).findFirst().get());
			return ti;
		}).collect(Collectors.toList());
		/*
		EventFieldsCondition eventFieldsCondition = new EventFieldsCondition();
		eventFieldsCondition.createCriteria().andEventIdIn(eventIds);
		List<EventFields> eventFields = eventField.selectByExample(eventFieldsCondition);
		System.out.println(eventFields);
*/
	}

	private synchronized List<Task> insertTask(List<Long> eventIds) {
		
		AtomicLong counter =  new AtomicLong(task.countByExample(new TaskCondition()));
		List<Task> tasks = eventIds.stream().map(id->{
			Task task = new Task();
			task.setEventId(id);
			task.setScheduledDate(LocalDate.now());
			task.setTaskId(counter.getAndIncrement());
			return task;
		}).collect(Collectors.toList());
		tasks.forEach(this.task::insert);
		return tasks;
	}

}
