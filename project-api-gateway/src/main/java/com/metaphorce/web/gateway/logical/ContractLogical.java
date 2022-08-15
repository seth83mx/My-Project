package com.metaphorce.web.gateway.logical;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.metaphorce.commons.exception.InvalidContractException;
import com.metaphorce.commons.exception.MetaphorceException;
import com.metaphorce.model.entity.Contract;

public class ContractLogical {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ContractLogical.class);

	public static void validateCreate( Contract contract ) throws MetaphorceException{
		if( contract == null ){
			throw new InvalidContractException();
		}
		if( StringUtils.isEmpty( contract.getEmployeeId() ) ){
			throw new InvalidContractException("El Dato no es valido");
		}
		if( StringUtils.isEmpty( contract.getContractId() ) ){
			throw new InvalidContractException("La cadena no es valida");
		}
		LOGGER.debug( contract.toString() );
	}

	public static void validateUpdate(Contract contract) throws MetaphorceException{
		if( contract == null ){
			throw new InvalidContractException();
		}
		if( contract.getContractId() <= 0 ){
			throw new InvalidContractException("El ID no es valido");
		}
		if( StringUtils.isEmpty( contract.getEmployeeId() ) ){
			throw new InvalidContractException("El NOMBRE no es valido");
		}
		if( StringUtils.isEmpty( contract.getContractId() ) ){
			throw new InvalidContractException("La cadena no es valida");
		}
		LOGGER.debug( contract.toString() );
	}
}
