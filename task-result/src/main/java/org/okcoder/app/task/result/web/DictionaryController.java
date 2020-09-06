package org.okcoder.app.task.result.web;

import java.time.LocalDate;
import java.util.List;

import org.okcoder.app.task.result.domain.entity.Task;
import org.okcoder.app.task.result.domain.service.TaskService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("dictionary")
public class DictionaryController {

	private TaskService taskService;

	public DictionaryController(TaskService taskService) {
		this.taskService = taskService;
	}

	@GetMapping
    @CrossOrigin
	public Object index(Model model) {

		String userId = "wxs";
		LocalDate day = LocalDate.now();
		List<Task> list = taskService.getTask(userId, day);
		if (list.size()==0) {
			taskService.initTask(userId, day);
			list = taskService.getTask(userId, day);
		}
		model.addAttribute("tasks", list);
		return list;
	}
}
