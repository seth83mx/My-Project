package com.metaphorce.web.gateway.spring.config;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


@Configuration
public class PersistenceConfig {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PersistenceConfig.class);
	
	@Bean
	public DataSource dataSource3() {
		LOGGER.debug("PersistenceConfig:::dataSource()");
		
        DriverManagerDataSource db = new DriverManagerDataSource();
        db.setDriverClassName("com.mysql.cj.jdbc.Driver");
        db.setUrl("jdbc:mysql://localhost:3306/metaphorcebd");
        db.setUsername("root");
        db.setPassword("");
        return db;
	}
	
	@Bean
	public JdbcTemplate getJdbcTemplate( DataSource dataSource ) {
		LOGGER.debug("PersistenceConfig:::getJdbcTemplate()->dataSource:" + dataSource);
		return new JdbcTemplate(dataSource);
	}
	
}
