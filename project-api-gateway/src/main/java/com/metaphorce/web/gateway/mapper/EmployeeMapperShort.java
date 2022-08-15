package com.metaphorce.web.gateway.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metaphorce.commons.dto.EmployeeDTO;



public class EmployeeMapperShort implements RowMapper<EmployeeDTO>{

	public EmployeeDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		EmployeeDTO employee = new EmployeeDTO();
		employee.setFullName(rs.getString("Name")+rs.getString("LastName"));
		employee.setTaxNumber(rs.getString("TaxNumber"));
		employee.setEmail(rs.getString("Email"));
		//employee.setContract(rs.getObject("ContractId"));
		return employee;
	}
	
}
