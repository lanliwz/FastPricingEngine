package com.upupconsultant.pricing.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.upupconsultant.pricing.event.PricingEvent;
import com.upupconsultant.pricing.io.Dao;
import com.upupconsultant.pricing.io.FileDao;
import com.upupconsultant.pricing.model.PricingEntity;
import com.upupconsultant.pricing.process.BenefitCalculator;
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
			
		Map<String,Double> hmoCalc = new HashMap<String,Double>();
		hmoCalc.put("CO-INSURANCE,P", 0.9);
		hmoCalc.put("COPAY T1,C",-10.0 );
		hmoCalc.put("COPAY T2,C", -50.0);
		
		BenefitCalculator hmocalc = new BenefitCalculator("HMO",hmoCalc);
		
		System.out.println(hmocalc.getTotalAmout(1000));
		
		CEProcessor cep = new CEProcessor(rmgr);
		FileDao dao = new FileDao();
		dao.setOutputFolder("/Users/lanliwz/FastPricingEngine/output");
		dao.setOutputFileNameBase("pricedClaims.txt");
		cep.setDao(dao);
		PricingService service = new PricingService(dao);
		cep.setService(service);
		cep.init();
		/*
		PricingEntity claim = new PricingEntity("100");
		claim.setBillingAmount(1000);
		PricingEvent claimevt= new PricingEvent(claim);
		cep.receive(claimevt);
		*/
		PricingEntity claim1 = new PricingEntity("200");
		claim1.setBillingAmount(5000);
		claim1.setPaymentAmount(0);
		PricingEvent claimevt1= new PricingEvent(claim1);
		cep.receive(claimevt1);
		
		
		
		
		
		
	}

}
