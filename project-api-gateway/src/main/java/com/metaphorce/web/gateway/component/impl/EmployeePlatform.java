package com.metaphorce.web.gateway.component.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.metaphorce.commons.dto.EmployeeDTO;
import com.metaphorce.commons.exception.InvalidEmployeeException;
import com.metaphorce.commons.exception.MetaphorceException;
import com.metaphorce.model.entity.Employee;
import com.metaphorce.web.gateway.component.IEmployeePlatform;
import com.metaphorce.web.gateway.repository.EmployeeRepository;

@Component
public class EmployeePlatform implements IEmployeePlatform{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeePlatform.class);
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	@Override
	public List<EmployeeDTO> getEmployees() throws MetaphorceException {
		try{
			return employeeRepository.getEmployees();
		}catch( DataAccessException e ){
			throw new InvalidEmployeeException( e.getMessage() );
		}
	}
	
	@Override
	public Employee getEmployeeDetail(Integer id) throws MetaphorceException{
		try{
			return employeeRepository.getEmployee(id);
		}catch( DataAccessException e ){
			throw new InvalidEmployeeException( e.getMessage() );
		}
	}


	@Override
	public Employee create(final Employee employee) throws MetaphorceException{
		try{
			return employeeRepository.create(employee);
		}catch( DataAccessException e ){
			throw new InvalidEmployeeException( e.getMessage() );
		}
	}

	@Override
	public Employee update(Employee employee) throws MetaphorceException {
		// TODO Auto-generated method stub
		return null;
	}

/*

	
	@Override
	public Employee update(final Employee employee) throws MetaphorceException{
		return employeeRepository.update( employee );
	}

*/

}
