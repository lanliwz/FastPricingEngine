package com.upupconsultant.pricing.service;

import com.upupconsultant.pricing.model.BasicSplitInstruction;
import com.upupconsultant.pricing.model.PricingEntity;

public interface Service {
	
	

	public void error(PricingEntity entity,String pricingTier,String error);
	public void postProcess(PricingEntity entity);
	public void preProcess(PricingEntity entity);
	public void passThrough(PricingEntity entity);
	public void tier2process(PricingEntity entity, BasicSplitInstruction action,String pricingRule);
	public void tier3process(PricingEntity entity, BasicSplitInstruction action,String pricingRule);
	public void tier1process(PricingEntity entity, BasicSplitInstruction action,String pricingRule);
	public void costSharing(PricingEntity entity, BasicSplitInstruction action,String pricingRule);
	

}
