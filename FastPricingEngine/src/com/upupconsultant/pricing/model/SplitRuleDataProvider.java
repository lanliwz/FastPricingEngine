package com.upupconsultant.pricing.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.drools.template.DataProvider;

public class SplitRuleDataProvider implements DataProvider{
	private Iterator<SplitRule> iterator;
	public SplitRuleDataProvider(List<SplitRule> rules){
		this.iterator = rules.iterator();
	}

	@Override
	public boolean hasNext() {
		
		return iterator.hasNext();
	}

	@Override
	public String[] next() {
		SplitRule rule = iterator.next();
		List<SplitRuleItem>items = rule.getRuleItems();
		List<String> variables = new ArrayList<String>();
		variables.add(rule.getRuleName());
		variables.add(String.valueOf(rule.getSalience()));
		variables.add(rule.getActivationGroup());
		variables.add(rule.getAgendaGroup());
		String[] vars = new String[variables.size()];
		vars = variables.toArray(vars);
		return vars;
	}

}
