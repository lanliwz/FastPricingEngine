package com.upupconsultant.pricing.test;

import java.util.ArrayList;
import java.util.List;

import org.drools.KnowledgeBaseConfiguration;
import org.drools.KnowledgeBaseFactory;
import org.drools.conf.EventProcessingOption;
import org.drools.conf.MBeansOption;

import com.upupconsultant.pricing.rule.RuleManager;
import com.upupconsultant.pricing.io.FileDao;
import com.upupconsultant.pricing.model.*;






public class TestMe {
	public RuleManager rmgr = new RuleManager();
	
	public void init(){
		rmgr.setRuleTemplateRoot("/Users/lanliwz/git/FastPEngine/FastPricingEngine/rulefiles");
//		rmgr.setRuleTemplateName("TemplateTest.drt");
		rmgr.setRuleTemplateName("CostSharingTemplate.drt");
		FileDao dao = new FileDao();
		dao.setSourceFolder("/Users/lanliwz/git/FastPEngine/FastPricingEngine/rulefiles");
		rmgr.setDao(dao);
		rmgr.setRuleFileRoot("/Users/lanliwz/FastPricingEngine/rule");
		rmgr.setRuleFileBackupRoot("/Users/lanliwz/FastPricingEngine/ruleBackup");
		
	}
	public void test1() {
		List<SplitRule> rules = new ArrayList<SplitRule>();
		
		rmgr.loadPricingGroup();
		rmgr.loadKnowledgeBase();
//		KnowledgeBaseConfiguration  conf = KnowledgeBaseFactory.newKnowledgeBaseConfiguration();
	//	conf.setOption(EventProcessingOption.STREAM);
		//conf.setOption(MBeansOption.ENABLED);
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
	public void test2(String rateCode){
		String s = rmgr.getDrl4CostSharing(rateCode, rmgr.getRuleTemplateName());
		System.out.print(s);
	}
	public static void main(String[] args){
		
		TestMe test = new TestMe();
		test.init();
		test.test2("AA2T1");

		
		
		
		
		
	}

}