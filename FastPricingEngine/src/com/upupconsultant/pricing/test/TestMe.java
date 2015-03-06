package com.upupconsultant.pricing.test;

import org.drools.KnowledgeBaseConfiguration;
import org.drools.KnowledgeBaseFactory;
import org.drools.conf.EventProcessingOption;
import org.drools.conf.MBeansOption;

import com.upupconsultant.common.data.Dao;
import com.upupconsultant.pricing.rule.RuleManager;






public class TestMe {
	public RuleManager rmgr = new RuleManager();
	public void init(){
		rmgr.setRuleTemplateRoot("/Users/lanliwz/git/FastPEngine/FastPricingEngine/rulefiles");
		rmgr.setRuleTemplateName("RuleTemplate.drt");
		rmgr.setDao(new Dao());
		rmgr.setRuleFileRoot("/Users/lanliwz/FastPricingEngine/rule");
		rmgr.setRuleFileBackupRoot("/Users/lanliwz/FastPricingEngine/ruleBackup");
	}
	
	
	public static void main(String[] args){
		TestMe test = new TestMe();
		test.init();
		RuleManager rmgr = test.rmgr;
		rmgr.loadPricingGroup();
		rmgr.loadKnowledgeBase();
		KnowledgeBaseConfiguration  conf = KnowledgeBaseFactory.newKnowledgeBaseConfiguration();
		conf.setOption(EventProcessingOption.STREAM);
		conf.setOption(MBeansOption.ENABLED);
		rmgr.buildKnowledgeBase(conf);
		rmgr.saveDrl(100, "test");
		
		
		
	}

}