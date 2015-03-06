package com.upupconsultant.pricing.rule;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

import com.upupconsultant.common.data.Dao;
import com.upupconsultant.pricing.model.*;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.filefilter.PrefixFileFilter;
import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseConfiguration;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.core.util.StringUtils;
import org.drools.definition.KnowledgePackage;
import org.drools.io.ResourceFactory;
import org.drools.template.ObjectDataCompiler;
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
	
	private List<ProviderGroup> providerGroups = new ArrayList(); 
	
	public String getDrl(long providerId){
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
	private String getDrl(List<SplitRule> rules,String template){
		String packageName=RULE_PACKAGE_BASENAME+".provider"+rules.get(0).getProviderId();
		ObjectDataCompiler converter = new ObjectDataCompiler();
		SplitRuleDataMapper paramSet = new SplitRuleDataMapper(rules);
		InputStream templateStream=null;
		String drl=null;
		template = FilenameUtils.concat(ruleTemplateRoot, template);
		try {
			templateStream = new FileInputStream(new File(template));
			drl = converter.compile(paramSet.getParamSet(), templateStream);
			drl = StringUtils.replace(drl, "package default", "package"+packageName);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return drl;
	}
	public String getDrl(long providerId,SplitRuleDataProvider dataProvider,String template){
		return null;
	}
	
	public synchronized void addToKnowledgeBase(long providerId, String drl, KnowledgeBase kbase){
		String packageName=package_base_name+providerId;
		if (drl==null || drl.equals("")){
			logger.info("Remove package {}",packageName);
			try {
			kbase.removeKnowledgePackage(packageName);
			}catch(Exception e){
				logger.error("Remove package {} failed",packageName);
			}
			return;
		}
		if (kbase==null){
			logger.error("Fail to add {} to knowledgebase",drl);
			return;
		}
		KnowledgeBuilder builder = KnowledgeBuilderFactory.newKnowledgeBuilder();
		builder.add(ResourceFactory.newByteArrayResource(drl.getBytes()), ResourceType.DRL);
		if (builder.hasErrors()){
			logger.error(builder.getErrors().toString());
			return;
		}
		kbase.removeKnowledgePackage(packageName);
		kbase.addKnowledgePackages(builder.getKnowledgePackages());
		
		logger.info(showCurrentRules(providerId));
		
	}
	public String showCurrentRules(long providerId){
		String package_name= package_base_name+providerId;
		KnowledgePackage pkg = this.knowledgebase.getKnowledgePackage("package_name");
		StringBuffer rules = new StringBuffer("");
		rules.append(package_name).append("\n");
		if (pkg!=null){
			for (org.drools.definition.rule.Rule rule:pkg.getRules()){
				rules.append(rule.getName());
				rules.append("\n");
			}
		}
		
		return rules.toString();
	}
	
	public synchronized KnowledgeBase buildKnowledgeBase(KnowledgeBaseConfiguration conf){
		
		KnowledgeBuilder builder = KnowledgeBuilderFactory.newKnowledgeBuilder();
		File ruleDir = new File(ruleFileRoot);
		KnowledgeBase kbase = null;
		String[] ruleFiles = ruleDir.list(new PrefixFileFilter(RULE_FILE_BASENAME));
		
		for(String fname:ruleFiles){
			String filename = FilenameUtils.concat(ruleFileRoot, fname);
			builder.add(ResourceFactory.newFileResource(filename), ResourceType.DRL);
			kbase = KnowledgeBaseFactory.newKnowledgeBase("Pricing Rules",conf);
			kbase.addKnowledgePackages(builder.getKnowledgePackages());
			if(builder.hasErrors()){
				logger.error("Fail to build knowledge base {}",builder.getErrors());
			}
			this.knowledgebase=kbase;
			return kbase;
			
		}
		
		return null;
		
	}
	public synchronized KnowledgeBase loadKnowledgeBase(){
		KnowledgeBase kbase=null;
		File ruleDir = new File(ruleFileRoot);
		String[] ruleFiles = ruleDir.list(new PrefixFileFilter(RULE_FILE_BASENAME));
		String filename=null;
		if (ruleFiles!=null && ruleFiles.length>0){
			filename = FilenameUtils.concat(ruleFileRoot, ruleFiles[0]);
			logger.info("Loading binary knowledge file {}",filename);
			try {
				FileInputStream fin = new FileInputStream(filename);
				ObjectInputStream oin = new ObjectInputStream(fin);
				kbase = (KnowledgeBase) oin.readObject();
				oin.close();
				logger.info("Loaded binary knowledge file {}",filename);
			} catch (FileNotFoundException e) {
				logger.info("No binary knowledge file {}",filename);
			} catch (IOException e) {
				logger.error("Fail to build knowledge base",e);
			} catch (ClassNotFoundException e) {
				logger.error("Fail to build knowledge base",e);
			}
			
			
			
		}else
			logger.info("No binary knowledge file exists, the rule manager will rebuild it and it will take minutes to complete ...",filename);
		
		this.knowledgebase=kbase;
		return kbase;
	}
	public void saveDrl(long providerId){
		String drl;
		drl = getDrl(providerId);
		addToKnowledgeBase(providerId,drl,this.knowledgebase);
		saveDrl(providerId,drl);
		succeed(providerId,"The rule file is succesfully published");
		
	}
	public void succeed(long id,String desc){
		
	}
	public void failure(long id,String desc){
		
	}
	public void saveDrl(long providerId,String drl){
		long version = System.currentTimeMillis();
		File ruleDir = new File(ruleFileRoot);
		File backupDir = new File(ruleFileBackupRoot);
		String[] ruleFiles = ruleDir.list(new PrefixFileFilter(RULE_FILE_BASENAME+providerId));
		for (String filename:ruleFiles){
			filename=FilenameUtils.concat(ruleFileRoot, filename);
			try {
				FileUtils.moveFileToDirectory(new File(filename), backupDir, true);
				logger.info("Backup Rule file {}",filename);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				logger.error("Fail to backup file",e);
			}
			if (drl!=null && !drl.trim().equals("")){
				String rulefile = FilenameUtils.concat(ruleFileRoot, RULE_FILE_BASENAME+providerId+"_v"+version+".drl");
				try {
					FileUtils.writeStringToFile(new File(rulefile), drl);
					logger.info("New rule file {}",rulefile);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					logger.error("Fail to create new rule file",e);
				}
			}
		}
				
	}
	public void init(){
		
	}
			
	public void loadPricingGroup(){
		List<ProviderGroup> pgrps = dao.findProviderGroup();
		for(ProviderGroup gp:pgrps){
			
			List<String> providers = dao.findGroupMembers(gp.getGroupName());
			gp.setProviderIds(providers);
			pgrps.add(gp);
			
		}
		this.providerGroups=pgrps;
		
	}
	public List<GroupMember> getGroupValues(){
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
	public Dao getDao() {
		return dao;
	}
	public void setDao(Dao dao) {
		this.dao = dao;
	}
	

}
