package com.upupconsultant.pricing.model;

public class PricingRule {
	private long id;
	private String activationGroup;
	private String agendaGroup;
	private int salience;
	private String name;
	private long providerId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getProviderId() {
		return providerId;
	}

	public void setProviderId(long providerId) {
		this.providerId = providerId;
	}
	

}
