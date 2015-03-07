package com.upupconsultant.pricing.model;

public class BasicSplitInstruction implements SplitInstruction {
	private double value;
	private String type;
	
	public BasicSplitInstruction(){
	}
	public BasicSplitInstruction(String type, double value){
		this.type=type;
		this.value=value;
	}
	public BasicSplitInstruction(String type, String value){
		this.type=type;
		this.value=Double.valueOf(value);
	}

	public void setValue(double value) {
		this.value = value;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public double getValue() {
		return value;
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return this.type;
	}



}
