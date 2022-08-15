package com.metaphorce.commons.exception;

import com.metaphorce.commons.Constants;

public class InvalidContractException extends MetaphorceException{

	
	private static final long serialVersionUID = 1L;

	public InvalidContractException() {
		super(Constants.INVALID_CONTRACT_CODE, Constants.INVALID_CONTRACT_MSG);
	}

	public InvalidContractException( String detail ) {
		super(Constants.INVALID_CONTRACT_CODE, Constants.INVALID_CONTRACT_MSG);
		super.setDetail(detail);
	}

}
