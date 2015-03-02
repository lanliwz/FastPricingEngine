package com.upupconsultant.pricing.rule;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedOutputStream;

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
	
	private List<GroupValue> attrGroups = new ArrayList<GroupValue>(); 
	
	public String getDrl(int providerId){
		List<PricingRule> crules=null; 
		if (crules==null||crules.size()==0)
			return null;
		return null;
		
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

	public List<GroupValue> getAttrGroups() {
		return attrGroups;
	}

	public void setAttrGroups(List<GroupValue> attrGroups) {
		this.attrGroups = attrGroups;
	}

	public String getPackage_base_name() {
		return package_base_name;
	}

}
