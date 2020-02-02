package org.okcoder.app.task_result.config.security.details;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "task-result.user")
@Component
public class AccountProperties {
	
	private Map<String,String> password=new HashMap<>();

	public Map<String,String> getPassword() {
		return password;
	}

	public void setPassword(Map<String,String> password) {
		this.password = password;
	}

}
