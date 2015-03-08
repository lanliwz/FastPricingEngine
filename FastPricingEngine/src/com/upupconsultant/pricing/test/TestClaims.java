package com.upupconsultant.pricing.test;

import org.junit.Test;

import com.upupconsultant.pricing.event.PricingEvent;
import com.upupconsultant.pricing.io.Dao;
import com.upupconsultant.pricing.model.PricingEntity;
import com.upupconsultant.pricing.process.CEProcessor;
import com.upupconsultant.pricing.rule.RuleManager;

public class TestClaims {

		
	
	@Test
	public void testClaim(){
		RuleManager rmgr = new RuleManager();		

			rmgr.setRuleTemplateRoot("/Users/lanliwz/git/FastPEngine/FastPricingEngine/rulefiles");
			rmgr.setRuleTemplateName("RuleTemplate.drt");
			rmgr.setDao(new Dao());
			rmgr.setRuleFileRoot("/Users/lanliwz/FastPricingEngine/rule");
			rmgr.setRuleFileBackupRoot("/Users/lanliwz/FastPricingEngine/ruleBackup");
		
		CEProcessor cep = new CEProcessor(rmgr);
		cep.init();
		PricingEntity claim = new PricingEntity("100");
		PricingEvent claimevt= new PricingEvent(claim);
		cep.receive(claimevt);
		
		
		
		
		
		
	}

}
