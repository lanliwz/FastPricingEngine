package com.upupconsultant.pricing.model;

public class StringRuleItem extends SplitRuleItem implements SpitRuleMeta{
	private String operand;
	public StringRuleItem(String name,String operator,String value){
		super(name,operator,value);
	}
	@Override
	public String getExpression(String operand) {
		StringBuilder sb = new StringBuilder();
		if(this.getOperator()==SplitRuleOperator.EQUAL_TO
			||this.getOperator()==SplitRuleOperator.MATCHES
			||this.getOperator()==SplitRuleOperator.NOT_EQUAL) {
				sb.append(operand)
				.append(this.getOperator().getSign())
				.append("\"")
				.append(this.getValue().trim())
				.append("\"");
			}
		else if (this.getOperator()==SplitRuleOperator.IN
				||this.getOperator()==SplitRuleOperator.NOT_IN) {
			String[] values = this.getValue().split(",");
			sb.append(operand)
			.append(this.getOperator().getSign())
			.append("(");
			for(int i=0;i<values.length;i++){
				if(i<values.length-1){
					sb.append("\"")
					.append(values[i].trim())
					.append("\"")
					.append(",");
					
				}else{
					sb.append("\"")
					.append(values[i].trim())
					.append("\"")
					.append(")");
				}
					
			}
			
		}else if (this.getOperator()==SplitRuleOperator.MEMBER_OF
				||this.getOperator()==SplitRuleOperator.NOT_MEMBER_OF
				) {
			sb.append(operand)
			.append(this.getOperator().getSign())
			.append(this.getValue());
		}
		return sb.toString();
	}
	

}
