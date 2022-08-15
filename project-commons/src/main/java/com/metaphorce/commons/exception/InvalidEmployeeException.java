package com.metaphorce.commons.exception;

import com.metaphorce.commons.Constants;

public class InvalidEmployeeException extends MetaphorceException{

	
	private static final long serialVersionUID = 1L;

	public InvalidEmployeeException() {
		super(Constants.INVALID_EMPLOYEE_CODE, Constants.INVALID_EMPLOYEE_MSG);
	}

	public InvalidEmployeeException( String detail ) {
		super(Constants.INVALID_EMPLOYEE_CODE, Constants.INVALID_EMPLOYEE_MSG);
		super.setDetail(detail);
	}

}
