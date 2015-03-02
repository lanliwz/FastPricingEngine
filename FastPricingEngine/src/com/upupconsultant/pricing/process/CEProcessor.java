package com.upupconsultant.pricing.process;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseConfiguration;
import org.drools.KnowledgeBaseFactory;
import org.drools.runtime.rule.ConsequenceException;
import org.drools.runtime.rule.WorkingMemoryEntryPoint;
import org.drools.conf.EventProcessingOption;
import org.drools.conf.MBeansOption;
import org.drools.runtime.StatefulKnowledgeSession;

import com.upupconsultant.pricing.model.GroupValue;
import com.upupconsultant.pricing.rule.RuleManager;
import com.upupconsultant.pricing.service.PricingEntity;
import com.upupconsultant.pricing.service.PricingService;
import com.upupconsultant.pricing.event.PricingEvent;
public class CEProcessor{
	private static Logger logger = LoggerFactory.getLogger("CEProcessor");
	private RuleManager ruleManager;
	private StatefulKnowledgeSession session;
	private WorkingMemoryEntryPoint claimstream;
	private WorkingMemoryEntryPoint actionstream;
	private PricingService service = new PricingService();
	
	
	public void receive(PricingEvent<?> event){
		try {
		if (event.getObject() instanceof PricingEntity) {
			
		}
		else if (event.getObject() instanceof String){
			
		}else {
			logger.error("APPERROR - invalid pricing entity {}",event.getObject().getClass().getName());
			return;
		}
		logger.debug("preprocessClaim start at {}",new Date());
		this.claimstream.insert(event.getObject());
		this.session.getAgenda().getAgendaGroup("preprocessClaim").setFocus();
		this.session.fireAllRules();
		logger.debug("preprocessClaim end at {}",new Date());
		
		logger.debug("tier1processClaim start at {}",new Date());
		this.claimstream.insert(event.getObject());
		this.session.getAgenda().getAgendaGroup("tier1processClaim").setFocus();
		this.session.fireAllRules();
		logger.debug("tier1processClaim end at {}",new Date());
		
		logger.debug("tier2processClaim start at {}",new Date());
		this.claimstream.insert(event.getObject());
		this.session.getAgenda().getAgendaGroup("tier2processClaim").setFocus();
		this.session.fireAllRules();
		logger.debug("tier2processClaim end at {}",new Date());

		logger.debug("postprocessClaim start at {}",new Date());
		this.claimstream.insert(event.getObject());
		this.session.getAgenda().getAgendaGroup("postprocessClaim").setFocus();
		this.session.fireAllRules();
		logger.debug("postprocessClaim end at {}",new Date());
		} catch (ConsequenceException e){
			logger.error("APPERROR - CLAIM {}",e.getRule());
			logger.error("APPERROR - CLAIM",e.getCause());
			
		} catch (Exception e){
			logger.error("APPERROR - CLAIM",e);
		}
		
		
	}
	public StatefulKnowledgeSession getSession() {
		return session;
	}

	public void setSession(StatefulKnowledgeSession session) {
		this.session = session;
	}

	public CEProcessor(RuleManager ruleManager){
		this.ruleManager=ruleManager;
	}

	public synchronized void init(){
		try {
			this.session = createSession();
			ruleManager.loadPricingGroup();
			List<GroupValue> attributeGroup1 = ruleManager.getGroupValues();
			if (attributeGroup1 != null)
			for(GroupValue gv:attributeGroup1){
				this.session.insert(gv);
			}
			this.claimstream = this.session.getWorkingMemoryEntryPoint("claim stream");
			this.actionstream=this.session.getWorkingMemoryEntryPoint("action stream");
			
			
			
		} catch (Exception e){
			logger.error("APPERROR - CRITICAL - RULE ENGINE",e);
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
		return null;//ruleManager.loadKnowledgeBase();
	}
	public KnowledgeBase buildRuleBase(){
		KnowledgeBaseConfiguration  conf = KnowledgeBaseFactory.newKnowledgeBaseConfiguration();
		conf.setOption(EventProcessingOption.STREAM);
		conf.setOption(MBeansOption.ENABLED);
		
		return null; //ruleManager.buildKnowledgeBase(conf);
	}
	public StatefulKnowledgeSession createSession(KnowledgeBase kbase){
		StatefulKnowledgeSession session = kbase.newStatefulKnowledgeSession();
		service = new PricingService();
		session.setGlobal("services", service);
		session.fireAllRules();
		return session;
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
