package com.metaphorce.web.gateway.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.metaphorce.commons.dto.EmployeeDTO;
import com.metaphorce.commons.exception.MetaphorceException;
import com.metaphorce.model.entity.Employee;
import com.metaphorce.web.gateway.component.IEmployeePlatform;
import com.metaphorce.web.gateway.logical.EmployeeLogical;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private IEmployeePlatform employeePlatform;
	
	private Gson gson = new Gson();
	@RequestMapping("/employees")
	@PreAuthorize("hasRole('ADMIN')")
	@Produces({ MediaType.APPLICATION_JSON })
	public ResponseEntity<List<EmployeeDTO>> getEmployees(  ) {
		LOGGER.debug("find");
		EmployeeDTO employees = null;
		
		try {
			List<EmployeeDTO> employee = employeePlatform.getEmployees();
			return new ResponseEntity<List<EmployeeDTO>>(employee, HttpStatus.OK);
		} catch (MetaphorceException e) {
			LOGGER.error( e.getDetail(), e );
		}
		return new ResponseEntity<List<EmployeeDTO>>(HttpStatus.BAD_REQUEST);
	}
	
//	http://localhost:8085/gateway/employee/find/2323
	@RequestMapping("/find/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	@Produces({ MediaType.APPLICATION_JSON })
	public ResponseEntity<Employee> getEmployeeDetail( @PathVariable Integer id ) {
		LOGGER.debug("find");
		Employee employee = null;
		System.out.println("id = " + id);
		try {
			employee = employeePlatform.getEmployeeDetail(id);
			return new ResponseEntity<Employee>(employee, HttpStatus.OK);
		} catch (MetaphorceException e) {
			LOGGER.error( e.getDetail(), e );
		}
		return new ResponseEntity<Employee>(employee, HttpStatus.BAD_REQUEST);
	}

	@RequestMapping( path = "/create", method = { RequestMethod.POST } )
    @Consumes({ MediaType.APPLICATION_JSON })
    @Produces({ MediaType.APPLICATION_JSON })
    public ResponseEntity<Employee> createEmployee(final HttpEntity<String> entity) {
		LOGGER.debug("create");
		try {
	    	Employee employee = gson.fromJson( entity.getBody(), Employee.class );
			EmployeeLogical.validateCreate( employee );
	    	employee = employeePlatform.create( employee );
	    	return new ResponseEntity<Employee>(employee, HttpStatus.OK);
		} catch (MetaphorceException e) {
			LOGGER.error( e.getDetail(), e );
		}
		return new ResponseEntity<Employee>(new Employee(), HttpStatus.BAD_REQUEST);
	}

	
	@RequestMapping( path = "/update", method = { RequestMethod.POST } )
    @Consumes({ MediaType.APPLICATION_JSON })
    @Produces({ MediaType.APPLICATION_JSON })
    public ResponseEntity<Employee> updateEmployee(final HttpEntity<String> entity) {
		LOGGER.debug("update");
		try {
	    	Employee employee = gson.fromJson( entity.getBody(), Employee.class );
			EmployeeLogical.validateUpdate( employee );
	    	employee = employeePlatform.update( employee );
	    	return new ResponseEntity<Employee>(employee, HttpStatus.OK);
		} catch (MetaphorceException e) {
			LOGGER.error( e.getDetail(), e );
		}
		return new ResponseEntity<Employee>(new Employee(), HttpStatus.BAD_REQUEST);
    }


}
