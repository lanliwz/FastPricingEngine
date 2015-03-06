package com.upupconsultant.pricing.model;

public enum SplitRuleOperator {
	EQUAL_TO(" == "),
	GREATER_THAN (" > "),
	LESS_THAN (" < "),
	MEMBER_OF(" memberOf "),
	CONTAINS(" contains "),
	GREATER_OR_EQUAL(" >= "),
	LESS_OR_EQUAL(" <= "),
	BETWEEN (" between "),
	MATCHES(" matches "),
	IN (" in "),
	NOT_EQUAL(" != "),
	NOT_IN(" not in "),
	NOT_MEMBER_OF(" not memberOf "),
	NOT_CONTAINS(" not contains "),
	BETWEEN_BY_PERCENT(" between ");
	private final String sign;
	SplitRuleOperator(String sign){
		this.sign=sign;
	}
	public String getSign(){
		return this.sign;
	}
	

}
