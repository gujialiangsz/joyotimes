package com.qiushui.joyotimes.domain.dao;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@Configuration  
@EnableJpaRepositories(basePackages = "com.qiushui.joyotimes.domain.dao")  
@EnableSpringDataWebSupport  
public class JpaConfig {  
  
} 