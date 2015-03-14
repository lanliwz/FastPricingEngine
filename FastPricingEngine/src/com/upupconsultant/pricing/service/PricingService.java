package com.upupconsultant.pricing.service;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import com.upupconsultant.pricing.error.PricingException;
import com.upupconsultant.pricing.io.Dao;
import com.upupconsultant.pricing.model.BasicSplitInstruction;
import com.upupconsultant.pricing.model.PricingEntity;

public class PricingService implements Service {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	private Dao dao;
	
	public PricingService(Dao dao){
		this.dao=dao;
	}

	public Dao getDao() {
		return dao;
	}

	public void setDao(Dao dao) {
		this.dao = dao;
	}



	@Override
	public void error(PricingEntity entity, String pricingTier,String error) {
		try {
			dao.savePricingEntity(entity);
		} catch (PricingException e) {
			log.error("APPERROR",e);
		} catch (Exception e){
			log.error("APPERROR",e);
		}
		log.error("APPERROR {} {}",pricingTier,error);
		
	}


	@Override
	public void postProcess(PricingEntity entity) {
		
		
		if(entity.getErrorCode()==0 && entity.getPricingRule()==null){
			entity.setPricingTier("postPricing");
			entity.setErrorCode(ServiceMeta.NO_RULE.getErrorCode());
			entity.setError(ServiceMeta.NO_RULE.name());
		}	
		try {
				dao.savePricingEntity(entity);
				log.debug("post pricing {}",entity.toString());
			} catch (PricingException e) {
				log.error("APPERROR",e);
			} catch (Exception e){
				log.error("APPERROR",e);
			}
		
		
		
	}

	@Override
	public void preProcess(PricingEntity entity) {
		
		entity.setPricingTier("prePricing");
		log.debug("{}",entity.toString());
		
	}

	@Override
	public void passThrough(PricingEntity entity) {
		if(entity.getErrorCode()==0 && entity.getPricingRule()==null){
			entity.setPricingTier("passThrough");
			entity.setErrorCode(ServiceMeta.NO_RULE.getErrorCode());
			entity.setError(ServiceMeta.NO_RULE.name());
//			try {
//				dao.savePricingEntity(entity);
//			} catch (PricingException e) {
//				log.error("APPERROR",e);
//			} catch (Exception e){
//				log.error("APPERROR",e);
//			}
		}

		log.debug("passThrough {}",entity.toString());
		
	}

	@Override
	public void tier2process(PricingEntity entity, BasicSplitInstruction action,
			String pricingRule) {
		if(action.getType().equals("PERCENT"))
			entity.setPaymentAmount(entity.getPaymentAmount()*action.getValue()/100);
		entity.setPricingTier("tier2pricing");
		entity.setPricingRule(pricingRule);
//		try {
//			dao.savePricingEntity(entity);
//		} catch (PricingException e) {
//			log.error("APPERROR",e);
//		} catch (Exception e){
//			log.error("APPERROR",e);
//		}
		log.debug("{}",entity.toString());
		
	}

	@Override
	public void tier3process(PricingEntity entity, BasicSplitInstruction action,
			String pricingRule) {
		if(action.getType().equals("MINIMUM") && action.getValue()>entity.getPaymentAmount())
			entity.setPaymentAmount(action.getValue());
		entity.setPricingTier("tier3pricing");
		entity.setPricingRule(pricingRule);
//		try {
//			dao.savePricingEntity(entity);
//		} catch (PricingException e) {
//			log.error("APPERROR",e);
//		} catch (Exception e){
//			log.error("APPERROR",e);
//		}

		log.debug("{}",entity.toString());
		
	}

	@Override
	public void tier1process(PricingEntity entity, BasicSplitInstruction action,
			String pricingRule) {
		if(action.getType().equals("ITEM"))
			entity.setPaymentAmount(action.getValue());
		entity.setPricingTier("tier1pricing");
		entity.setPricingRule(pricingRule);
//		try {
//			dao.savePricingEntity(entity);
//		} catch (PricingException e) {
//			log.error("APPERROR",e);
//		} catch (Exception e){
//			log.error("APPERROR",e);
//		}
		log.debug("{}",entity.toString());
		
	}

	@Override
	public void costSharing(PricingEntity entity, BasicSplitInstruction action,
			String pricingRule) {
		if(action.getType().equals("ITEM")){
			entity.setPaymentAmount(entity.getPaymentAmount()+action.getValue());
		}else if(action.getType().equals("PERCENT")){
			entity.setPaymentAmount(entity.getPaymentAmount()+entity.getPaymentAmount()*action.getValue());
		}if(action.getType().equals("MAXIMUM") && entity.getPaymentAmount()>action.getValue()){
			entity.setPaymentAmount(action.getValue());
		}
		entity.setPricingRule(pricingRule);
		entity.setPricingTier("Cost Sharing");
		log.debug("{}",entity.toString());
	}
	
	

}
