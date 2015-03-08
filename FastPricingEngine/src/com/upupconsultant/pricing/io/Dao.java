package com.upupconsultant.pricing.io;

import java.util.ArrayList;
import java.util.List;

import com.upupconsultant.pricing.model.GroupMember;
import com.upupconsultant.pricing.model.PricingEntity;
import com.upupconsultant.pricing.model.PricingRule;
import com.upupconsultant.pricing.model.PricingRuleCondition;
import com.upupconsultant.pricing.model.ProviderGroup;

public class Dao {
	public PricingEntity nextPricingEntity(){
		return null;
	}
	public void savePricingEntity(PricingEntity pricingEntity){
		
	}
	public List<PricingRule> findPricingRule(long providerId){
		List<PricingRule> prules=new ArrayList<PricingRule>();
		return prules;
	}
	public List<PricingRuleCondition> findPricingRuleCondition(long ruleid){
		List<PricingRuleCondition> pconds = new ArrayList<PricingRuleCondition>();
		return pconds;
	}
	public List<ProviderGroup> findProviderGroup(){
		List<ProviderGroup> pgrps = new ArrayList<ProviderGroup>();
		return pgrps;
	}
	public List<String> findGroupMembers(String groupName){
		List<String> mbrs = new ArrayList<String>();
		return mbrs;
	}

}
