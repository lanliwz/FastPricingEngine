package com.upupconsultant.pricing.service;

public enum ServiceMeta {
	NO_RULE(200);
	
	private int errorCode;
	
	ServiceMeta(int errorCode){
		this.errorCode=errorCode;
	}
	public int getErrorCode(){
		return errorCode;
	}

}
