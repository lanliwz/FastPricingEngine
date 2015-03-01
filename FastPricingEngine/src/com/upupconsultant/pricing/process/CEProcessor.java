package com.upupconsultant.pricing.process;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.drools.KnowledgeBase;
import org.drools.WorkingMemoryEntryPoint;
import org.drools.runtime.StatefulKnowledgeSession;

import com.upupconsultant.pricing.rule.RuleManager;
import com.upupconsultant.pricing.service.PricingService;

public class CEProcessor{
	private static Logger logger = LoggerFactory.getLogger("CEProcessor");
	private RuleManager ruleManager;
	private StatefulKnowledgeSession session;
	private WorkingMemoryEntryPoint claimstream;
	private WorkingMemoryEntryPoint actionstream;
	private PricingService service = new PricingService();
	
	
	
	public CEProcessor(RuleManager ruleManager){
		this.ruleManager=ruleManager;
	}

	public synchronized void init(){
		try {
			
		} catch (Exception e){
			logger.error("APPERROR - CRITICAL",e);
		}
	}
	public StatefulKnowledgeSession createSession(){
		KnowledgeBase kbase = loadRuleBase();
		if (kbase == null){
			kbase = buildRuleBase();
		}
		return createSession(kbase);
			
		
	}
	public KnowledgeBase loadRuleBase(){
		return null;
	}
	public KnowledgeBase buildRuleBase(){
		return null;
	}
	public StatefulKnowledgeSession createSession(KnowledgeBase kbase){
		return null;
	}

	public RuleManager getRuleManager() {
		return ruleManager;
	}



	public void setRuleManager(RuleManager ruleManager) {
		this.ruleManager = ruleManager;
	}



	public PricingService getService() {
		return service;
	}



	public void setService(PricingService service) {
		this.service = service;
	}


	

}
