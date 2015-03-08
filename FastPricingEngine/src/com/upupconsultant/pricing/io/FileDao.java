package com.upupconsultant.pricing.io;

import java.util.ArrayList;
import java.util.List;

import com.upupconsultant.pricing.error.PricingException;
import com.upupconsultant.pricing.model.GroupMember;
import com.upupconsultant.pricing.model.PricingEntity;
import com.upupconsultant.pricing.model.PricingRule;
import com.upupconsultant.pricing.model.PricingRuleCondition;
import com.upupconsultant.pricing.model.ProviderGroup;

public class FileDao implements Dao {
	/* (non-Javadoc)
	 * @see com.upupconsultant.pricing.io.DaoInterface#nextPricingEntity()
	 */
	@Override
	public PricingEntity nextPricingEntity(){
		return null;
	}
	/* (non-Javadoc)
	 * @see com.upupconsultant.pricing.io.DaoInterface#savePricingEntity(com.upupconsultant.pricing.model.PricingEntity)
	 */
	@Override
	public void savePricingEntity(PricingEntity pricingEntity) throws PricingException{
		
	}
	/* (non-Javadoc)
	 * @see com.upupconsultant.pricing.io.DaoInterface#findPricingRule(long)
	 */
	@Override
	public List<PricingRule> findPricingRule(long providerId){
		List<PricingRule> prules=new ArrayList<PricingRule>();
		return prules;
	}
	/* (non-Javadoc)
	 * @see com.upupconsultant.pricing.io.DaoInterface#findPricingRuleCondition(long)
	 */
	@Override
	public List<PricingRuleCondition> findPricingRuleCondition(long ruleid){
		List<PricingRuleCondition> pconds = new ArrayList<PricingRuleCondition>();
		return pconds;
	}
	/* (non-Javadoc)
	 * @see com.upupconsultant.pricing.io.DaoInterface#findProviderGroup()
	 */
	@Override
	public List<ProviderGroup> findProviderGroup(){
		List<ProviderGroup> pgrps = new ArrayList<ProviderGroup>();
		return pgrps;
	}
	/* (non-Javadoc)
	 * @see com.upupconsultant.pricing.io.DaoInterface#findGroupMembers(java.lang.String)
	 */
	@Override
	public List<String> findGroupMembers(String groupName){
		List<String> mbrs = new ArrayList<String>();
		return mbrs;
	}

}
