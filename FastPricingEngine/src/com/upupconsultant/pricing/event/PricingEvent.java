package com.upupconsultant.pricing.event;

public class PricingEvent<T> {
	private T object;
	public PricingEvent(T obj){
		object=obj;
	}
	public T getObject() {
		return object;
	}
	public void setObject(T object) {
		this.object = object;
	}
	

}
