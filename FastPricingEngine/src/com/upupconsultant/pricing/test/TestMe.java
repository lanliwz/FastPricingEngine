package com.upupconsultant.pricing.test;

import java.util.ArrayList;
import java.util.List;

import org.drools.KnowledgeBaseConfiguration;
import org.drools.KnowledgeBaseFactory;
import org.drools.conf.EventProcessingOption;
import org.drools.conf.MBeansOption;

import com.upupconsultant.common.data.Dao;
import com.upupconsultant.pricing.rule.RuleManager;
import com.upupconsultant.pricing.model.*;






public class TestMe {
	public RuleManager rmgr = new RuleManager();
	
	public void init(){
		rmgr.setRuleTemplateRoot("/Users/lanliwz/git/FastPEngine/FastPricingEngine/rulefiles");
//		rmgr.setRuleTemplateName("TemplateTest.drt");
		rmgr.setRuleTemplateName("RuleTemplate.drt");
		rmgr.setDao(new Dao());
		rmgr.setRuleFileRoot("/Users/lanliwz/FastPricingEngine/rule");
		rmgr.setRuleFileBackupRoot("/Users/lanliwz/FastPricingEngine/ruleBackup");
	}
	
	
	public static void main(String[] args){
		List<SplitRule> rules = new ArrayList<SplitRule>();
		TestMe test = new TestMe();
		test.init();
		RuleManager rmgr = test.rmgr;
		rmgr.loadPricingGroup();
		rmgr.loadKnowledgeBase();
		KnowledgeBaseConfiguration  conf = KnowledgeBaseFactory.newKnowledgeBaseConfiguration();
		conf.setOption(EventProcessingOption.STREAM);
		conf.setOption(MBeansOption.ENABLED);
//		rmgr.loadKnowledgeBase();
//		rmgr.buildKnowledgeBase(conf);
	//	//rmgr.buildKnowledgeBase(conf);
		//rmgr.saveDrl(100, "test");
		
		SplitRule rule1 = new SplitRule(100l);
		rule1.setRuleName("test rule 100");
		rule1.setActivationGroup("pricing");
		rule1.setAgendaGroup("tier1pricing");
		rule1.setProviderId(1000000l);
		BasicSplitInstruction action = new BasicSplitInstruction("PERCENTAGE",50l);
				
		rule1.setAction(action);
		
		
		
		List<SplitRuleItem> items = new ArrayList<SplitRuleItem>();
		StringRuleItem item = new StringRuleItem("providerId","EQUAL_TO","200000");
		items.add(item);
		rule1.setRuleItems(items);
		
		rules.add(rule1);

		System.out.print(rmgr.getDrl(rules, rmgr.getRuleTemplateName()));
		
		
		
		
		
	}

}