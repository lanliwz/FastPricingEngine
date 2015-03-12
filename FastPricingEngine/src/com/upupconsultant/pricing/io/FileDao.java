package com.upupconsultant.pricing.io;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.upupconsultant.pricing.error.PricingException;
import com.upupconsultant.pricing.model.GroupMember;
import com.upupconsultant.pricing.model.PricingEntity;
import com.upupconsultant.pricing.model.PricingRule;
import com.upupconsultant.pricing.model.PricingRuleCondition;
import com.upupconsultant.pricing.model.ProviderGroup;

public class FileDao implements Dao {
	private static Logger logger = LoggerFactory.getLogger(Dao.class);
	private String outputFolder;
	private String outputFileNameBase;
	
	public File getOutputFile(){
		
		String f = FilenameUtils.concat(outputFolder, outputFileNameBase);
		return new File(f);
		
	}

	public String getOutputFolder() {
		return outputFolder;
	}

	public void setOutputFolder(String outputFolder) {
		this.outputFolder = outputFolder;
	}

	public String getOutputFileNameBase() {
		return outputFileNameBase;
	}
	public void setOutputFileNameBase(String outputFileNameBase) {
		this.outputFileNameBase = outputFileNameBase;
	}
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
		File file = getOutputFile();
		try {
			FileUtils.writeStringToFile(file, pricingEntity.toString()+"\n",true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error("Fail to write {} outputfile", pricingEntity.toString());
		}
		
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
