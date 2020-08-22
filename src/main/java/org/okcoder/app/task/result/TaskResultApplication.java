package org.okcoder.app.task.result;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan
public class TaskResultApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskResultApplication.class, args);
	}

}
