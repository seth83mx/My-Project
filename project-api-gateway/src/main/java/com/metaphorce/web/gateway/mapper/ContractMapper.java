package com.metaphorce.web.gateway.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metaphorce.model.entity.Contract;


public class ContractMapper implements RowMapper<Contract>{

	public Contract mapRow(ResultSet rs, int rowNum) throws SQLException {
		Contract contract = new Contract();
		contract.setContractId(rs.getInt("ContractId"));
		contract.setEmployeeId(rs.getInt("EmployeeId"));
		contract.setContractTypeId(rs.getInt("Name"));
		contract.setDateFrom(rs.getDate("DateFrom"));
		contract.setDateTo(rs.getDate("DateTo"));
		contract.setSalaryPerDay(rs.getDouble("SalaryPerDay"));
		contract.setIsActive(false);
		contract.setDateCreated(rs.getDate("DateCreated"));
		return contract;
	}
	
}
