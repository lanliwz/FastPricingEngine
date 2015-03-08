package com.upupconsultant.pricing.error;
/**
 * 
 * @author Wei Zhang
 * Error Code 100 - 199 ENGINE SYSTEM ERROR
 * Error Code 200 - 999 PRICING ERROR
 *
 */

public class PricingException extends Throwable{
	private int errorCode;
	public PricingException(int errorCode, String message){
		super(message);
		this.errorCode=errorCode;
	}
	public PricingException(Exception e){
		super(e);
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	
}
