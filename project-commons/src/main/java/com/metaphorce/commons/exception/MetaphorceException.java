package com.metaphorce.commons.exception;

public class MetaphorceException extends Throwable {

	private static final long serialVersionUID = 1L;
	private String message;
	private int code;
	private String detail;
	
	public MetaphorceException( int code, String message ){
		this.code = code;
		this.message = message;
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
}
