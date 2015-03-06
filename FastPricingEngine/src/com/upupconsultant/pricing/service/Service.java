package com.upupconsultant.pricing.service;

import com.upupconsultant.common.data.PricingEntity;

public interface Service {
	public void log(String msg);
	public void error(PricingEntity entity,String pricingRule);
	public void process(PricingEntity entity, PricingAction action,String pricingRule);
	public void postProcess(PricingEntity entity, PricingAction action,String pricingRule);
	public void preProcess(PricingEntity entity, String pricingRule);
	public void passThrough(PricingEntity entity,String pricingRule);
	public void tier2process(PricingEntity entity, PricingAction action,String pricingRule);
	public void tier3process(PricingEntity entity, PricingAction action,String pricingRule);
	

}
