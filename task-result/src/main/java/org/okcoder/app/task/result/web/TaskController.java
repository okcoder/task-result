package org.okcoder.app.task.result.web;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.okcoder.app.task.result.domain.dto.TaskDetailDto;
import org.okcoder.app.task.result.domain.entity.Task;
import org.okcoder.app.task.result.domain.service.TaskService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("task")
@CrossOrigin
public class TaskController {

	private TaskService taskService;

	public TaskController(TaskService taskService) {
		this.taskService = taskService;
	}

	private String userId = "wxs";

	//@GetMapping
	public String index(Model model) {

		LocalDate day = LocalDate.now();
		List<Task> list = taskService.getTask(userId, day);
		if (list.size()==0) {
			taskService.initTask(userId, day);
			list = taskService.getTask(userId, day);
		}
		model.addAttribute("tasks", list);
		return "task/index";
	}
	

	@GetMapping("")
	@CrossOrigin
	public Map<String, List<Task>> getTasks() {
		LocalDate day = LocalDate.now();
		return taskService.getTasks(userId, day);
	}
	
	@PostMapping("")
	@CrossOrigin
	public void savePriority( @RequestBody Map<String, List<Task>> tasks) {
		this.taskService.savePriority(tasks);
	}
	
	@GetMapping("/{taskId}")
	@CrossOrigin
	public TaskDetailDto getTask(@PathVariable String taskId) {
		return taskService.getTask(userId, taskId);
	}

	@PostMapping("/{taskId}")
	@CrossOrigin
	public void save(@PathVariable String taskId, @RequestBody TaskDetailDto task) {
		this.taskService.save( taskId,task);
	}
}
