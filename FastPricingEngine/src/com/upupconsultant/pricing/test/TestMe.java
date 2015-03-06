package com.upupconsultant.pricing.test;

import com.upupconsultant.common.data.Dao;
import com.upupconsultant.pricing.rule.RuleManager;






public class TestMe {
	public RuleManager rmgr = new RuleManager();
	public void init(){
		rmgr.setRuleTemplateRoot("/Users/lanliwz/git/FastPEngine/FastPricingEngine/rulefiles");
		rmgr.setRuleTemplateName("RuleTemplate.drt");
		rmgr.setDao(new Dao());
		rmgr.setRuleFileRoot("/Users/lanliwz/git/FastPEngine/FastPricingEngine/rulefiles");
	}
	
	
	public static void main(String[] args){
		TestMe test = new TestMe();
		test.init();
		RuleManager rmgr = test.rmgr;
		rmgr.loadPricingGroup();
		rmgr.loadKnowledgeBase();
		
		
		
	}

}