package com.upupconsultant.pricing.io;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.upupconsultant.pricing.error.PricingException;
import com.upupconsultant.pricing.model.BasicSplitInstruction;
import com.upupconsultant.pricing.model.GroupMember;
import com.upupconsultant.pricing.model.PricingEntity;
import com.upupconsultant.pricing.model.PricingEntityLine;
import com.upupconsultant.pricing.model.PricingRule;
import com.upupconsultant.pricing.model.PricingRuleCondition;
import com.upupconsultant.pricing.model.ProviderGroup;
import com.upupconsultant.pricing.model.SplitRule;
import com.upupconsultant.pricing.model.StringRuleItem;

public class FileDao implements Dao {
	private static Logger logger = LoggerFactory.getLogger(Dao.class);
	private String outputFolder;
	private String outputFileNameBase;
	private String sourceFolder;
	
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
			for (PricingEntityLine line:pricingEntity.getPricingLines()){
				FileUtils.writeStringToFile(file, line.toString()+"\n",true);
				
			}
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

	@Override
	public List<SplitRule> getProviderRules(long providerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SplitRule> getProviderGroupRules(long providerGroupId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

	@Override
	public List<SplitRule> getCostSharingRules(String rateCode) {
		String fname=FilenameUtils.concat(sourceFolder, rateCode+".txt");
		File fr = new File(fname);
		String fcname=FilenameUtils.concat(sourceFolder, rateCode+"_cond.txt");
		File fcond = new File(fname);
		String faname=FilenameUtils.concat(sourceFolder, rateCode+"_act.txt");
		File faction = new File(fname);
		try {
			List<String> rules = FileUtils.readLines(fr);
			List<String> ruleconds = FileUtils.readLines(fcond);
			List<String> ruleacts = FileUtils.readLines(faction);
			for(String r:rules){
				String[] rattr = r.split(",");
				SplitRule srule = new SplitRule(Long.valueOf(rattr[0]));
				srule.setRuleName(rattr[1]);
				
				
				
				
				
			}
			Map<String,List> items = new HashMap<String,List>();
			for(String cond:ruleconds){
				String[] cattr = cond.split(",");//0 is rule id
				StringRuleItem sitem = new StringRuleItem(cattr[1], cattr[2], cattr[3]);
				
				if(items.containsKey(cattr[0])){
					List l = items.get(cattr[0]);
					l.add(sitem);
					
				}else {
					List l = new ArrayList();
					l.add(sitem);
					items.put(cattr[0], l);
				}
				
				
				
			}
			Map<String,List> actions = new HashMap<String,List>();
			for(String act:ruleacts){
				String[] aattr = act.split(",");//0 is rule id
				BasicSplitInstruction sitem = new BasicSplitInstruction(aattr[1], aattr[2]);
				
				if(items.containsKey(aattr[0])){
					List l = items.get(aattr[0]);
					l.add(sitem);
					
				}else {
					List l = new ArrayList();
					l.add(sitem);
					items.put(aattr[0], l);
				}
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
