package com.upupconsultant.pricing.model;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SplitRuleDataMapper implements SplitRuleMeta{
	private Collection<Map<String,Object>> paramSet=new ArrayList<Map<String,Object>>();
	public SplitRuleDataMapper(List<SplitRule> rules){
		for (SplitRule rule:rules){
			Map<String,Object> params = new HashMap<String,Object>();
			params.put(PROVIDER_ID, String.valueOf(rule.getProviderId()));
			params.put(RULE_NAME, rule.getRuleName());
			params.put(SALIENCE, String.valueOf(rule.getSalience()));
			params.put(ACTIVATION_GROUP , rule.getActivationGroup());
			params.put(AGENDA_GROUP,rule.getAgendaGroup());
			params.put(TIER1FLOW, rule.getTier1Flow());
			params.put(TIER2FLOW, rule.getTier2Flow());
			params.put(TIER3FLOW, rule.getTier3Flow());
			params.put(PRICING_TYPE, rule.getAction().getType());
			params.put(PRICING_VALUE, rule.getAction().getValue());
			for (SplitRuleItem item:rule.getRuleItems()){
				params.put(item.getName(), item);//item.getExpression("providerId"));
			}
			
			
			paramSet.add(params);
			
		}
		
	}
	public Collection<Map<String, Object>> getParamSet() {
		return paramSet;
	}

}
