package com.upupconsultant.pricing.model;

public class GroupRuleItem extends SplitRuleItem {

	public GroupRuleItem(String name, String operator, String value) {
		super(name, operator, value);
	}

	@Override
	public String getExpression(String operand) {
		StringBuilder sb = new StringBuilder();
		if(this.getOperator()==SplitRuleOperator.MEMBER_OF
			||this.getOperator()==SplitRuleOperator.NOT_MEMBER_OF) {
				sb.append(operand)
				.append(this.getOperator().getSign())
				.append("$")
				.append(operand);
			}
		return sb.toString();
	}

}
