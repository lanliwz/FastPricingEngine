package com.upupconsultant.pricing.model;

public class BasicSplitInstruction implements SplitInstruction {
	private double value;
	
	public BasicSplitInstruction(double value){
		this.value=value;
	}

	@Override
	public double getValue() {
		return value;
	}



}
