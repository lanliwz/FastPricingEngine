package com.upupconsultant.pricing.model;

public class PricingEntity {
	private String providerId;
	
	public PricingEntity(){
		
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
