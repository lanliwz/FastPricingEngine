package com.upupconsultant.pricing.model;

public class BasicSplitInstruction implements SplitInstruction {
	private double percentage;
	
	public BasicSplitInstruction(double percentage){
		this.percentage=percentage;
	}

	@Override
	public double getPercentage() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}
	

}
