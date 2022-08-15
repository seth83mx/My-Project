package com.metaphorce.web.gateway.spring.config;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import com.metaphorce.commons.Constants;
import com.metaphorce.web.gateway.spring.config.security.CustomBasicAuthenticationEntryPoint;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SecurityConfig.class);
	
	@Autowired
	private DataSource dataSource;
	private final String QUERY_FOR_USERS = " select username, password, enabled from users where username = ? ";
	private final String QUERY_FOR_ROLES = " select username, role from user_roles where username = ? ";
	
    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
    	LOGGER.debug("configureGlobalSecurity(AuthenticationManagerBuilder auth)");
    	auth.jdbcAuthentication()
    		.usersByUsernameQuery(QUERY_FOR_USERS)
    		.authoritiesByUsernameQuery(QUERY_FOR_ROLES)
    		.dataSource(dataSource);
        
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	LOGGER.debug("configure(HttpSecurity http)");
    	http.csrf()
    		.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
    	http
    		.authorizeRequests()
	        .antMatchers("/employee/**").hasRole("ADMIN")
	        .and().httpBasic().realmName(Constants.SECURITY_REALM).authenticationEntryPoint(getBasicAuthEntryPoint())
	        .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }
    
    @Bean
    public CustomBasicAuthenticationEntryPoint getBasicAuthEntryPoint(){
    	LOGGER.debug("getBasicAuthEntryPoint");
        return new CustomBasicAuthenticationEntryPoint();
    }
    
    @Override
    public void configure(WebSecurity web) throws Exception {
    	LOGGER.debug("configure(WebSecurity web)");
        web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
    }

}
