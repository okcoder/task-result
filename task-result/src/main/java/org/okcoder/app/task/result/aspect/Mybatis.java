package org.okcoder.app.task.result.aspect;

import java.lang.reflect.Method;
import java.time.LocalDateTime;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

@Aspect
@EnableAspectJAutoProxy
@Component
public class Mybatis {

	@Before("execution(* org.okcoder.app.task.result.domain.repository.*Mapper.insert(..)) && args(record)")
	public void beforeInsert(JoinPoint jp, Object record) {
		Method method = ReflectionUtils.findMethod(record.getClass(), "setCreateTime",LocalDateTime.class);
		ReflectionUtils.invokeMethod(method, record, LocalDateTime.now());
	}

	@Before("execution(* org.okcoder.app.task.result.domain.repository.*Mapper.insertOrUpdate(..)) && args(entity)")
	public void beforeInsertOrUpdate(JoinPoint jp, Object entity) {
		System.err.println(jp.getSignature().toString());
		// if (entity.getCreateTime() == null) {
		// entity.setCreateTime(new Date());
		// }
		// entity.setUpdateTime(new Date());
	}

	@Before("execution(* org.okcoder.app.task.result.domain.repository.*Mapper.update*(..)) && args(entity)")
	public void beforeUpdate(JoinPoint jp, Object entity) {
		// System.err.println(jp.getSignature().toString());
		// entity.setUpdateTime(new Date());
	}
}
