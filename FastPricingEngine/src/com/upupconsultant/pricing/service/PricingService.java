package com.upupconsultant.pricing.service;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class PricingService implements Service {
	Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	public void log(String msg) {
		log.info("APPINFO {}",msg);
		
	}

	@Override
	public void error(PricingEntity entity, String pricingRule) {
		String error ="";
		log.error("APPERROR {}",error);
		
	}

	@Override
	public void process(PricingEntity entity, PricingAction action,
			String pricingRule) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postProcess(PricingEntity entity, PricingAction action,
			String pricingRule) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void preProcess(PricingEntity entity, String pricingRule) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void passThrough(PricingEntity entity, String pricingRule) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void tier2process(PricingEntity entity, PricingAction action,
			String pricingRule) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void tier3process(PricingEntity entity, PricingAction action,
			String pricingRule) {
		// TODO Auto-generated method stub
		
	}
	
	

}