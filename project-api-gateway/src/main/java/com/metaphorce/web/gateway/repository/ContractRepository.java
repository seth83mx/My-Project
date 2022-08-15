package com.metaphorce.web.gateway.repository;


import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metaphorce.model.entity.Contract;
import com.metaphorce.web.gateway.mapper.ContractMapper;


@Repository
public class ContractRepository {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ContractRepository.class);
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
	
	public List<Contract> getContracts() {
		LOGGER.debug("ContractRepository:::getContracts( )");
		List<Contract> contracts = jdbcTemplate.query(""
				+ "SELECT * FROM contract ",
                new ContractMapper()); 
		return contracts;
	}
	
	public Contract getContract( Integer id ){
		LOGGER.debug("ContractRepository:::getContract( " + id + " )");
		Contract contract = (Contract)this.jdbcTemplate.queryForObject(
				" select ContractId, TaxNumber, Name, LastName, BirthDate, Email, CellPhone, IsActive, DateCreated from contract where ContractId = ? ",
				new Object[]{ id },
				new ContractMapper());
		LOGGER.debug("ContractRepository:::contract( " + contract.toString() + " )");
		return contract;
	}

	public com.metaphorce.model.entity.Contract create(final Contract contract) {
		LOGGER.debug("ContractRepository:::create( " + contract.toString() + " )");
		Integer primaryKey = jdbcTemplate.queryForObject( "(select max(ContractId) + 1 from contract)", Integer.class );
		this.jdbcTemplate.update(
				"insert into contract ( ContractId, TaxNumber, Name, LastName, BirthDate, Email, CellPhone, IsActive, DateCreated ) values ( ?, ?, ?, ?, ?, ?, ?, ?, ? )",
				primaryKey,
				contract.getContractId(),
				contract.getEmployeeId(),
				contract.getContractTypeId(),
				contract.getDateFrom(),
				contract.getDateTo(),
				contract.getSalaryPerDay(),
				contract.getIsActive(),
				contract.getDateCreated());
		contract.setContractId( primaryKey );
		return contract;
	}
	

/*
	public Contract update(Contract contract) {
		LOGGER.debug("ContractRepository:::update( " + contract.toString() + " )");
		this.jdbcTemplate.update(
				"update contract set LastName = ?, Name = ? where ContractId = ?",
				contract.getContractId(),
				contract.getEmployeeId());
		return contract;
	}
*/
}
