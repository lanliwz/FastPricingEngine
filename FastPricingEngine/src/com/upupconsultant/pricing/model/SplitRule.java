package com.upupconsultant.pricing.model;

public class SplitRule {
	private long providerId;
	private long id;
	private String activationGroup;
	private String agendaGroup;
	private int salience;
	private String ruleName;
	public SplitRule(long id){
		this.id=id;
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
