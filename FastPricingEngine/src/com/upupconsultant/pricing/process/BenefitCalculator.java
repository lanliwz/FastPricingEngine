package com.upupconsultant.pricing.process;

import java.util.HashMap;
import java.util.Map;
/**
 * 
 * @author lanliwz
 * RateSheet format - [category,type],[value]
 * category - string, name of the category
 * type - P for percentage, 0.1 = 10%, negtive for deduction. C for constant absolute amount 
 *
 */

public class BenefitCalculator {
	private String groupName;
	private Map<String,Double> rateSheet;
	public BenefitCalculator(String groupName,Map<String,Double> rateSheet){
		this.groupName=groupName;
		this.rateSheet=rateSheet;
	}
	public double getTotalAmout(double amount){
		Map<String,Double> items = getItemAmount(amount);
		double total=0;
		for(double amt:items.values()){
			total += amt;
		}
		
		return total;
	}
	public Map<String,Double> getItemAmount(double amount){
		Map<String,Double> items = new HashMap<String,Double>();
		
		for(String key:rateSheet.keySet()){
			String[] category = key.split(",");
			double itemAmt=0;
			if (category[1].equals("P")){
				itemAmt=amount*rateSheet.get(key);
			}else if (category[1].equals("C")){
				itemAmt=rateSheet.get(key);
			}
			items.put(category[0], itemAmt);
			
			
		}
		return items;
		
	}

}
