package com.metaphorce.web.gateway.component;

import java.util.List;

import com.metaphorce.commons.dto.EmployeeDTO;
import com.metaphorce.commons.exception.MetaphorceException;
import com.metaphorce.model.entity.Employee;

public interface IEmployeePlatform {
	
	public List<EmployeeDTO> getEmployees() throws MetaphorceException;
	
	public Employee getEmployeeDetail(Integer id) throws MetaphorceException;

	public Employee create(Employee employee) throws MetaphorceException;

	public Employee update(Employee employee) throws MetaphorceException;


}
