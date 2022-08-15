package com.metaphorce.web.gateway.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration 
@ComponentScan({
	"com.metaphorce.web.gateway.model",
	"com.metaphorce.web.gateway.component",
	"com.metaphorce.web.gateway.controller",
	"com.metaphorce.web.gateway.repository"
	})
@EnableWebMvc
@Import({
	PersistenceConfig.class,
	SecurityConfig.class,
	})
public class AppConfig extends AbstractSecurityWebApplicationInitializer{

	public AppConfig() {
	}
}
