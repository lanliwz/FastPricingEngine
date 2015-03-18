package com.upupconsultant.pricing.io;

import java.util.List;

import com.upupconsultant.pricing.error.PricingException;
import com.upupconsultant.pricing.model.PricingEntity;
import com.upupconsultant.pricing.model.PricingRule;
import com.upupconsultant.pricing.model.PricingRuleCondition;
import com.upupconsultant.pricing.model.ProviderGroup;
import com.upupconsultant.pricing.model.SplitRule;

public interface Dao {

	public abstract PricingEntity nextPricingEntity();

	public abstract void savePricingEntity(PricingEntity pricingEntity)
			throws PricingException;
	

	public abstract List<PricingRule> findPricingRule(long providerId);
	public abstract List<SplitRule> getProviderRules(long providerId);
	public abstract List<SplitRule> getProviderGroupRules(long providerGroupId);
	public abstract List<SplitRule> getCostSharingRules(String rateCode);

	public abstract List<PricingRuleCondition> findPricingRuleCondition(
			long ruleid);

	public abstract List<ProviderGroup> findProviderGroup();

	public abstract List<String> findGroupMembers(String groupName);

}