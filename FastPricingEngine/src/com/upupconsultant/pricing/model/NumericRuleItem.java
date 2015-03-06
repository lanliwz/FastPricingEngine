package com.upupconsultant.pricing.model;

import java.sql.Date;

public class NumericRuleItem extends SplitRuleItem {

	public NumericRuleItem(String name, String operator, String value) {
		super(name, operator, value);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getExpression(String operand) {
		StringBuilder sb = new StringBuilder();
		if(this.getOperator()==SplitRuleOperator.EQUAL_TO
			||this.getOperator()==SplitRuleOperator.GREATER_OR_EQUAL
				||this.getOperator()==SplitRuleOperator.GREATER_THAN
				||this.getOperator()==SplitRuleOperator.LESS_OR_EQUAL
				||this.getOperator()==SplitRuleOperator.LESS_THAN) {
				sb.append(operand)
				.append(this.getOperator().getSign())
				.append(this.getValue().trim());
			}
		else if (this.getOperator()==SplitRuleOperator.IN
				||this.getOperator()==SplitRuleOperator.NOT_IN) {
			String[] values = this.getValue().split(",");
			sb.append(operand)
			.append(this.getOperator().getSign())
			.append("(");
			for(int i=0;i<values.length;i++){
				if(i<values.length-1){
					sb
					.append(values[i].trim())
					
					.append(",");
					
				}else{
					sb
					.append(values[i].trim())
					
					.append(")");
				}
					
			}
			
		}	else if (this.getOperator()==SplitRuleOperator.BETWEEN) {
			String[] values = this.getValue().split(",");
			sb.append("(")
			.append(operand)
			.append(SplitRuleOperator.GREATER_OR_EQUAL.getSign())
			
			.append(values[0])
			.append(" && ")
			.append(operand)
			.append(SplitRuleOperator.LESS_OR_EQUAL.getSign())
			
			.append(values[1])
			.append(")");
			}
		return sb.toString();
	}

}
