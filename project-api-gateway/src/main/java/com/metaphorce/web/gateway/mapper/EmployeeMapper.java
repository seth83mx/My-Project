package com.metaphorce.web.gateway.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metaphorce.model.entity.Employee;


public class EmployeeMapper implements RowMapper<Employee>{

	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee employee = new Employee();
		employee.setEmployeeId(rs.getInt("EmployeeId"));
		employee.setTaxNumber(rs.getString("TaxNumber"));
		employee.setName(rs.getString("Name"));
		employee.setLastName(rs.getString("LastName"));
		employee.setBirthDate(rs.getDate("BirthDate"));
		employee.setEmail(rs.getString("Email"));
		employee.setCellPhone(rs.getString("CellPhone"));
		employee.setIsActive(rs.getBoolean("IsActive"));
		employee.setDateCreated(rs.getDate("DateCreated"));
		//employee.setContractType(rs.getString(""));
		return employee;
	}
	
}
