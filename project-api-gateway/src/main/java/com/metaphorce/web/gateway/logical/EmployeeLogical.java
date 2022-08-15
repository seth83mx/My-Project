package com.metaphorce.web.gateway.logical;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.metaphorce.commons.exception.InvalidEmployeeException;
import com.metaphorce.commons.exception.MetaphorceException;
import com.metaphorce.model.entity.Employee;

public class EmployeeLogical {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeLogical.class);

	public static void validateCreate( Employee employee ) throws MetaphorceException{
		if( employee == null ){
			throw new InvalidEmployeeException();
		}
		if( StringUtils.isEmpty( employee.getName() ) ){
			throw new InvalidEmployeeException("El NOMBRE no es valido");
		}
		if( StringUtils.isEmpty( employee.getLastName() ) ){
			throw new InvalidEmployeeException("La localizacion no es valida");
		}
		LOGGER.debug( employee.toString() );
	}

	public static void validateUpdate(Employee employee) throws MetaphorceException{
		if( employee == null ){
			throw new InvalidEmployeeException();
		}
		if( employee.getEmployeeId() <= 0 ){
			throw new InvalidEmployeeException("El ID no es valido");
		}
		if( StringUtils.isEmpty( employee.getName() ) ){
			throw new InvalidEmployeeException("El NOMBRE no es valido");
		}
		if( StringUtils.isEmpty( employee.getLastName() ) ){
			throw new InvalidEmployeeException("La localizacion no es valida");
		}
		LOGGER.debug( employee.toString() );
	}
}
