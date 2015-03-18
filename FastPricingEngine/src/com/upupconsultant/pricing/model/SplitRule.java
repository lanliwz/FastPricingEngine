package com.upupconsultant.pricing.model;

import java.io.Serializable;
import java.util.List;

public class SplitRule implements SplitRuleMeta, Serializable{
	private long providerId;
	private long id;
	private String activationGroup;
	private String agendaGroup;
	private int salience=0;
	private String ruleName;
	private Boolean tier1Flow=true;
	private Boolean tier2Flow=false;
	private Boolean tier3Flow=false;
	private List<SplitRuleItem> ruleItems;
	private BasicSplitInstruction action;
	
	public BasicSplitInstruction getAction() {
		return action;
	}

	public void setAction(BasicSplitInstruction action) {
		this.action = action;
	}

	public List<SplitRuleItem> getRuleItems() {
		return ruleItems;
	}

	public void setRuleItems(List<SplitRuleItem> ruleItems) {
		this.ruleItems = ruleItems;
	}

	public Boolean getTier1Flow() {
		return tier1Flow;
	}

	public void setTier1Flow(Boolean tier1Flow) {
		this.tier1Flow = tier1Flow;
	}

	public Boolean getTier2Flow() {
		return tier2Flow;
	}

	public void setTier2Flow(Boolean tier2Flow) {
		this.tier2Flow = tier2Flow;
	}

	public Boolean getTier3Flow() {
		return tier3Flow;
	}

	public void setTier3Flow(Boolean tier3Flow) {
		this.tier3Flow = tier3Flow;
	}

	public SplitRule(long id){
		this.id=id;
	}
	public SplitRule(){
		
	}

	public long getProviderId() {
		return providerId;
	}
	public void setProviderId(long providerId) {
		this.providerId = providerId;
	}
	public String getActivationGroup() {
		return activationGroup;
	}
	public void setActivationGroup(String activationGroup) {
		this.activationGroup = activationGroup;
	}
	public String getAgendaGroup() {
		return agendaGroup;
	}
	public void setAgendaGroup(String agendaGroup) {
		this.agendaGroup = agendaGroup;
	}
	public int getSalience() {
		return salience;
	}
	public void setSalience(int salience) {
		this.salience = salience;
	}
	public String getRuleName() {
		return ruleName;
	}
	public void setRuleName(String name) {
		this.ruleName = name;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	

}
