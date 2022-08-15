package com.metaphorce.web.gateway.repository;


import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metaphorce.commons.dto.EmployeeDTO;
import com.metaphorce.model.entity.Employee;
import com.metaphorce.web.gateway.mapper.EmployeeMapper;
import com.metaphorce.web.gateway.mapper.EmployeeMapperShort;

@Repository
public class EmployeeRepository {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeRepository.class);
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
	
	public List<EmployeeDTO> getEmployees() {
		LOGGER.debug("EmployeeRepository:::getEmployees( )");
		List<EmployeeDTO> employees = jdbcTemplate.query(""
				+ "SELECT EmployeeId, TaxNumber, Name, LastName, "
				+ "BirthDate, Email, CellPhone, IsActive, "
				+ "DateCreated FROM employee where IsActive = 1",
                new EmployeeMapperShort()); 
		return employees;
	}
	
	public Employee getEmployee( Integer id ){
		LOGGER.debug("EmployeeRepository:::getEmployee( " + id + " )");
		Employee employee = (Employee)this.jdbcTemplate.queryForObject(
				" select EmployeeId, TaxNumber, Name, LastName, BirthDate, Email, CellPhone, IsActive, DateCreated from employee where EmployeeId = ? ",
				new Object[]{ id },
				new EmployeeMapper());
		LOGGER.debug("EmployeeRepository:::employee( " + employee.toString() + " )");
		return employee;
	}

	public com.metaphorce.model.entity.Employee create(final Employee employee) {
		LOGGER.debug("EmployeeRepository:::create( " + employee.toString() + " )");
		Integer primaryKey = jdbcTemplate.queryForObject( "(select max(EmployeeId) + 1 from employee)", Integer.class );
		this.jdbcTemplate.update(
				"insert into employee ( EmployeeId, TaxNumber, Name, LastName, BirthDate, Email, CellPhone, IsActive, DateCreated ) values ( ?, ?, ?, ?, ?, ?, ?, ?, ? )",
				primaryKey,
				employee.getTaxNumber(),
				employee.getName(),
				employee.getLastName(),
				employee.getBirthDate(),
				employee.getEmail(),
				employee.getCellPhone(),
				employee.getIsActive(),
				employee.getDateCreated());
		employee.setEmployeeId( primaryKey );
		return employee;
	}
	


	public Employee update(Employee employee) {
		LOGGER.debug("EmployeeRepository:::update( " + employee.toString() + " )");
		this.jdbcTemplate.update(
				"update employee set LastName = ?, Name = ? where EmployeeId = ?",
				employee.getLastName(),
				employee.getName(),
				employee.getEmployeeId());
		return employee;
	}

}
