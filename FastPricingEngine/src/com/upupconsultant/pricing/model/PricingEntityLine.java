package com.upupconsultant.pricing.model;

public class PricingEntityLine {
	private String type="ITEM";
	private double value;
	private String pricingRule;
	
	public PricingEntityLine(String type,double value,String pricingRule){
		this.type=type;
		this.value=value;
		this.pricingRule=pricingRule;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public String getPricingRule() {
		return pricingRule;
	}
	public void setPricingRule(String pricingRule) {
		this.pricingRule = pricingRule;
	}
	@Override
	public String toString() {
		return "PricingEntityLine [type=" + type + ", value=" + value
				+ ", pricingRule=" + pricingRule + "]";
	}
	

}
