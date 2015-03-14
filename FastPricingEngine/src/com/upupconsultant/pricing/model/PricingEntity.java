package com.upupconsultant.pricing.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PricingEntity implements Serializable{
	private String providerId;
	private double billingAmount;
	private double paymentAmount;
	private String pricingRule;
	private String PricingTier;
	private int errorCode=0;
	private String error;
	private List<PricingEntityLine> pricingLines = new ArrayList<PricingEntityLine>();

	
	
	public List<PricingEntityLine> getPricingLines() {
		return pricingLines;
	}

	public void setPricingLines(List<PricingEntityLine> pricingLines) {
		this.pricingLines = pricingLines;
	}

	public PricingEntity(){
		
	}
	
	public String getPricingTier() {
		return PricingTier;
	}

	public void setPricingTier(String pricingTier) {
		PricingTier = pricingTier;
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
		return "PricingEntity [providerId=" + providerId + ", billingAmount="
				+ billingAmount + ", paymentAmount=" + paymentAmount
				+ ", pricingRule=" + pricingRule + ", PricingTier="
				+ PricingTier + ", errorCode=" + errorCode + ", error=" + error
				+ "]";
	}
	

}
