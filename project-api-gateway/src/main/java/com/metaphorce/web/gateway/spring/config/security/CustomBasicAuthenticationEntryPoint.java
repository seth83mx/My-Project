package com.metaphorce.web.gateway.spring.config.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;

import com.metaphorce.commons.Constants;

public class CustomBasicAuthenticationEntryPoint extends BasicAuthenticationEntryPoint{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomBasicAuthenticationEntryPoint.class);

	@Override
    public void commence(final HttpServletRequest request, 
            final HttpServletResponse response, 
            final AuthenticationException authException) throws IOException, ServletException {
		LOGGER.debug("commence");

		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.addHeader("WWW-Authenticate", "Basic realm=" + getRealmName() + "");

        String msg = "HTTP Status 401 : " + authException.getMessage();

        PrintWriter writer = response.getWriter();
        writer.println(msg);
        LOGGER.error(msg);
    }
     
    @Override
    public void afterPropertiesSet() throws Exception {
        setRealmName(Constants.SECURITY_REALM);
        super.afterPropertiesSet();
    }
    
}
