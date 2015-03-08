package com.upupconsultant.pricing.model;

import java.io.Serializable;

public class PricingEntity implements Serializable{
	private String providerId;
	private int errorCode;
	private String error;
	private String pricingRule;
	private double billingAmount;
	private double paymentAmount;
	
	
	public PricingEntity(){
		
	}
	
	public double getBillingAmount() {
		return billingAmount;
	}

	public void setBillingAmount(double billingAmount) {
		this.billingAmount = billingAmount;
	}

	public double getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(double paymentAmount) {
		this.paymentAmount = paymentAmount;
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

	@Override
	public String toString() {
		return "PricingEntity [providerId=" + providerId + ", errorCode="
				+ errorCode + ", error=" + error + ", pricingRule="
				+ pricingRule + ", billingAmount=" + billingAmount
				+ ", paymentAmount=" + paymentAmount + "]";
	}
	

}
