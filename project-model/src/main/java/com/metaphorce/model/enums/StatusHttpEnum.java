package com.metaphorce.model.enums;

public enum StatusHttpEnum {
	
	OK("Operation Success..."),
	ERROR("Error"),
	EN_REVISION("REVISION");
	
	private	String statusMsg ;
	
	StatusHttpEnum(String statusMsg) {
		this.statusMsg = statusMsg ;
	}

	public String getStatusMsg() {
		return statusMsg;
	}

	public void setStatusMsg(String statusMsg) {
		this.statusMsg = statusMsg;
	}
	
	

}
