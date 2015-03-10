package com.upupconsultant.pricing.test;

import org.junit.Test;

import com.upupconsultant.pricing.event.PricingEvent;
import com.upupconsultant.pricing.io.Dao;
import com.upupconsultant.pricing.io.FileDao;
import com.upupconsultant.pricing.model.PricingEntity;
import com.upupconsultant.pricing.process.CEProcessor;
import com.upupconsultant.pricing.rule.RuleManager;
import com.upupconsultant.pricing.service.PricingService;

public class TestClaims {

		
	
	@Test
	public void testClaim(){
		RuleManager rmgr = new RuleManager();		

			rmgr.setRuleTemplateRoot("/Users/lanliwz/git/FastPEngine/FastPricingEngine/rulefiles");
			rmgr.setRuleTemplateName("RuleTemplate.drt");
			rmgr.setDao(new FileDao());
			rmgr.setRuleFileRoot("/Users/lanliwz/FastPricingEngine/rule");
			rmgr.setRuleFileBackupRoot("/Users/lanliwz/FastPricingEngine/ruleBackup");
		
		CEProcessor cep = new CEProcessor(rmgr);
		Dao dao = new FileDao();
		cep.setDao(dao);
		PricingService service = new PricingService(dao);
		cep.setService(service);
		cep.init();
		PricingEntity claim = new PricingEntity("100");
		claim.setBillingAmount(1000);
		PricingEvent claimevt= new PricingEvent(claim);
		cep.receive(claimevt);
		PricingEntity claim1 = new PricingEntity("200");
		claim.setBillingAmount(1000);
		PricingEvent claimevt1= new PricingEvent(claim1);
		cep.receive(claimevt1);
		
		
		
		
		
		
	}

}
