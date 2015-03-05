package com.upupconsultant.pricing.rule;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedOutputStream;

import com.upupconsultant.common.data.Dao;
import com.upupconsultant.pricing.model.*;

import org.drools.KnowledgeBase;
import org.slf4j.*;

public class RuleManager {
	private static Logger logger = LoggerFactory.getLogger(RuleManager.class);
	private final String package_base_name="com.upupconsultant.pricing.rule.provider";
	private KnowledgeBase knowledgebase;
	private String ruleTemplateName;
	private static String RULE_FILE_BASENAME ="ProviderRule";
	private static String RULE_PACKAGE_BASENAME="com.upupconsultant.pricing.rule";
	private static String RULE_FILE_KNOWLEDGEBASE="KnowledgeBase";
	private String ruleFileRoot;
	private String ruleFileBackupRoot;
	private String ruleTemplateRoot;
	private Dao dao;
	
	private List<?> attrGroups = new ArrayList(); 
	
	public String getDrl(int providerId){
		List<PricingRule> crules=dao.findPricingRule(providerId); 
		if (crules==null||crules.size()==0){
			logger.info("No rule defined for provider {}",providerId);
			return null;
		}
		List<SplitRule> rules = new ArrayList<SplitRule>();
		for (PricingRule prule:crules){
			logger.info("construction rule id = {}",prule.getId());
			List<PricingRuleCondition> conds = dao.findPricingRuleCondition(prule.getId());
			List<SplitRuleItem> items = new ArrayList<SplitRuleItem>();
			SplitRule srule = new SplitRule(prule.getId());
			srule.setActivationGroup(prule.getActivationGroup());
			srule.setAgendaGroup(prule.getAgendaGroup());
			srule.setProviderId(prule.getProviderId());
			srule.setSalience(prule.getSalience());
			srule.setRuleName(prule.getName());
			
			
		}
		return "";
		
		
	}
	
	public void init(){
		
	}
			
	public void loadPricingGroup(){
		
	}
	public List<GroupValue> getGroupValues(){
		return null;
	}

	public KnowledgeBase getKnowledgebase() {
		return knowledgebase;
	}

	public void setKnowledgebase(KnowledgeBase knowledgebase) {
		this.knowledgebase = knowledgebase;
	}

	public String getRuleTemplateName() {
		return ruleTemplateName;
	}

	public void setRuleTemplateName(String ruleTemplateName) {
		this.ruleTemplateName = ruleTemplateName;
	}

	public String getRuleFileRoot() {
		return ruleFileRoot;
	}

	public void setRuleFileRoot(String ruleFileRoot) {
		this.ruleFileRoot = ruleFileRoot;
	}

	public String getRuleFileBackupRoot() {
		return ruleFileBackupRoot;
	}

	public void setRuleFileBackupRoot(String ruleFileBackupRoot) {
		this.ruleFileBackupRoot = ruleFileBackupRoot;
	}

	public String getRuleTemplateRoot() {
		return ruleTemplateRoot;
	}

	public void setRuleTemplateRoot(String ruleTemplateRoot) {
		this.ruleTemplateRoot = ruleTemplateRoot;
	}



	public String getPackage_base_name() {
		return package_base_name;
	}

}
