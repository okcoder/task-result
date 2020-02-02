package org.okcoder.app.task_result.config.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = { "org.okcoder.app.task_result.domain.mapper"})
public class MybatisConfig {

}
