package com.metaphorce.web.gateway.component;

import java.util.List;


import com.metaphorce.commons.exception.MetaphorceException;
import com.metaphorce.model.entity.Contract;

public interface IContractPlatform {
	
	public List<Contract> getContracts() throws MetaphorceException;
	
	public Contract getContractDetail(Integer id) throws MetaphorceException;

	public Contract create(Contract employee) throws MetaphorceException;

	public Contract update(Contract employee) throws MetaphorceException;


}
