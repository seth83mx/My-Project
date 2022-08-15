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
import com.metaphorce.commons.exception.MetaphorceException;
import com.metaphorce.model.entity.Contract;
import com.metaphorce.web.gateway.component.IContractPlatform;
import com.metaphorce.web.gateway.logical.ContractLogical;

@RestController
@RequestMapping("/contract")
public class ContractController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ContractController.class);

	@Autowired
	private IContractPlatform contractPlatform;
	
	private Gson gson = new Gson();
	@RequestMapping("/contracts")
	@PreAuthorize("hasRole('ADMIN')")
	@Produces({ MediaType.APPLICATION_JSON })
	public ResponseEntity<List<Contract>> getContracts(  ) {
		LOGGER.debug("find");
		Contract contracts = null;
		
		try {
			List<Contract> contract = contractPlatform.getContracts();
			return new ResponseEntity<List<Contract>>(contract, HttpStatus.OK);
		} catch (MetaphorceException e) {
			LOGGER.error( e.getDetail(), e );
		}
		return new ResponseEntity<List<Contract>>(HttpStatus.BAD_REQUEST);
	}
	
//	http://localhost:8085/gateway/contract/find/2323
	@RequestMapping("/find/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	@Produces({ MediaType.APPLICATION_JSON })
	public ResponseEntity<Contract> getContractDetail( @PathVariable Integer id ) {
		LOGGER.debug("find");
		Contract contract = null;
		System.out.println("id = " + id);
		try {
			contract = contractPlatform.getContractDetail(id);
			return new ResponseEntity<Contract>(contract, HttpStatus.OK);
		} catch (MetaphorceException e) {
			LOGGER.error( e.getDetail(), e );
		}
		return new ResponseEntity<Contract>(contract, HttpStatus.BAD_REQUEST);
	}

	@RequestMapping( path = "/create", method = { RequestMethod.POST } )
    @Consumes({ MediaType.APPLICATION_JSON })
    @Produces({ MediaType.APPLICATION_JSON })
    public ResponseEntity<Contract> createContract(final HttpEntity<String> entity) {
		LOGGER.debug("create");
		try {
	    	Contract contract = gson.fromJson( entity.getBody(), Contract.class );
			ContractLogical.validateCreate( contract );
	    	contract = contractPlatform.create( contract );
	    	return new ResponseEntity<Contract>(contract, HttpStatus.OK);
		} catch (MetaphorceException e) {
			LOGGER.error( e.getDetail(), e );
		}
		return new ResponseEntity<Contract>(new Contract(), HttpStatus.BAD_REQUEST);
	}

	
	@RequestMapping( path = "/update", method = { RequestMethod.POST } )
    @Consumes({ MediaType.APPLICATION_JSON })
    @Produces({ MediaType.APPLICATION_JSON })
    public ResponseEntity<Contract> updateContract(final HttpEntity<String> entity) {
		LOGGER.debug("update");
		try {
	    	Contract contract = gson.fromJson( entity.getBody(), Contract.class );
			ContractLogical.validateUpdate( contract );
	    	contract = contractPlatform.update( contract );
	    	return new ResponseEntity<Contract>(contract, HttpStatus.OK);
		} catch (MetaphorceException e) {
			LOGGER.error( e.getDetail(), e );
		}
		return new ResponseEntity<Contract>(new Contract(), HttpStatus.BAD_REQUEST);
    }


}
