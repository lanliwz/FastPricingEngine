package com.upupconsultant.pricing.model;

import java.io.Serializable;

public class PricingEntity implements Serializable{
	private String providerId;
	private int errorCode;
	private String error;
	private String pricingRule;
	
	
	public PricingEntity(){
		
	}
	
	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getPricingRule() {
		return pricingRule;
	}

	public void setPricingRule(String pricingRule) {
		this.pricingRule = pricingRule;
	}

	public PricingEntity(String providerId){
		this.providerId=providerId;
	}
	public String getProviderId() {
		return providerId;
	}

	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}
	

}
