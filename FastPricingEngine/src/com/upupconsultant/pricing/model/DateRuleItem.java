package com.upupconsultant.pricing.model;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class DateRuleItem extends SplitRuleItem {
	private static final long serialVersionUID = 7828062893490592545L;
	public static final SimpleDateFormat inputDateFormat = new SimpleDateFormat(INPUT_DATE_FORMAT);
	public static final SimpleDateFormat ruleFileDateFormat = new SimpleDateFormat(RULEFILE_DATE_FORMAT);

	
	

	public DateRuleItem(String name, String operator, String value) {
		super(name, operator, value);

	}

	@Override
	public String getExpression(String operand) {
		String[] sDates = this.getValue().split(",");
		StringBuilder sb = new StringBuilder();
		if(this.getOperator()==SplitRuleOperator.EQUAL_TO
			||this.getOperator()==SplitRuleOperator.GREATER_OR_EQUAL
			||this.getOperator()==SplitRuleOperator.GREATER_THAN
			||this.getOperator()==SplitRuleOperator.LESS_OR_EQUAL
			||this.getOperator()==SplitRuleOperator.LESS_THAN) {
			Date dt = Date.valueOf(sDates[0]);
				sb.append(operand)
				.append(this.getOperator().getSign())
				.append("\"")
				.append(ruleFileDateFormat.format(dt))
				.append("\"");
			}
		else if (this.getOperator()==SplitRuleOperator.BETWEEN) {
			Date dt1 = Date.valueOf(sDates[0]);
			Date dt2 = Date.valueOf(sDates[1]);
			sb.append("(")
			.append(operand)
			.append(SplitRuleOperator.GREATER_OR_EQUAL.getSign())
			.append("\"")
			.append(ruleFileDateFormat.format(dt1))
			.append("\" && ")
			.append(operand)
			.append(SplitRuleOperator.LESS_OR_EQUAL.getSign())
			.append("\"")
			.append(ruleFileDateFormat.format(dt2))
			.append("\")");
			}
		return sb.toString();
	}

}
