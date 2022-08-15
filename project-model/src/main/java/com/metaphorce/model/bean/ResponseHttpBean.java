package com.metaphorce.model.bean;

import com.metaphorce.model.enums.StatusHttpEnum;

public class ResponseHttpBean {
	
	private	String msgResponse ;
	private	StatusHttpEnum statusHttpEnum ;
	
	public ResponseHttpBean() {
		statusHttpEnum = statusHttpEnum.OK;
	}
	
	public String getmsgResponse() {
		return msgResponse;
	}
	public void setmsgResponse(String msgResponse) {
		this.msgResponse = msgResponse;
	}
	public StatusHttpEnum getstatusHttpEnum() {
		return statusHttpEnum;
	}
	public void setstatusHttpEnum(StatusHttpEnum statusHttpEnum) {
		this.statusHttpEnum = statusHttpEnum;
	}
	
	
	
}
