package com.metaphorce.model.enums;

public enum StatusEnum {
	ACTIVO("Active","Active",1),
	INACTIVO("INACTIVE","Inactive",0),
	NULL("NULL","NULL",2),
	OK("NNULL","NULL",3);
	
	private String statusString ;
	private String description ;
	private int value ;
	
	StatusEnum(String estatusString, String description, int value) {
		this.statusString = estatusString ;
		this.description = description ;
		this.value = value ;
	}

	public String getStatusString() {
		return statusString;
	}

	public void setStatusString(String statusString) {
		this.statusString = statusString;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getValue() {
		return value;
	}

	public void setValeu(int value) {
		this.value = value;
	}

}
