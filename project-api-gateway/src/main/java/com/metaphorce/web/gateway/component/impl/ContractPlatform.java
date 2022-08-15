package com.metaphorce.web.gateway.component.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.metaphorce.commons.exception.InvalidContractException;
import com.metaphorce.commons.exception.MetaphorceException;
import com.metaphorce.model.entity.Contract;
import com.metaphorce.web.gateway.component.IContractPlatform;
import com.metaphorce.web.gateway.repository.ContractRepository;

@Component
public class ContractPlatform implements IContractPlatform{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ContractPlatform.class);
	
	@Autowired
	private ContractRepository contractRepository;
	
	
	@Override
	public List<Contract> getContracts() throws MetaphorceException {
		try{
			return contractRepository.getContracts();
		}catch( DataAccessException e ){
			throw new InvalidContractException( e.getMessage() );
		}
	}
	
	@Override
	public Contract getContractDetail(Integer id) throws MetaphorceException{
		try{
			return contractRepository.getContract(id);
		}catch( DataAccessException e ){
			throw new InvalidContractException( e.getMessage() );
		}
	}

	@Override
	public Contract create(final Contract contract) throws MetaphorceException{
		try{
			return contractRepository.create(contract);
		}catch( DataAccessException e ){
			throw new InvalidContractException( e.getMessage() );
		}
	}

	@Override
	public Contract update(Contract contract) throws MetaphorceException {
		// TODO Auto-generated method stub
		return null;
	}



}
