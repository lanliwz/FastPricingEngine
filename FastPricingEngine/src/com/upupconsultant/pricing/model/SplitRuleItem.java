package com.upupconsultant.pricing.model;

import java.io.Serializable;

public abstract class SplitRuleItem implements Serializable {
	public final static String RULEFILE_DATE_FORMAT="dd-MMM-yyyy";
	public final static String INPUT_DATE_FORMAT="yyyy-MM-dd";
	
	private String name;
	private SplitRuleOperator operator;
	private String value;
	
	public SplitRuleItem(String name,String operator,String value){
		this.name=name;
		this.operator = SplitRuleOperator.valueOf(operator);
		this.value=value;
	}
	

	public SplitRuleOperator getOperator() {
		return operator;
	}

	public void setOperator(SplitRuleOperator operator) {
		this.operator = operator;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public abstract String getExpression(String operand);
	

}
