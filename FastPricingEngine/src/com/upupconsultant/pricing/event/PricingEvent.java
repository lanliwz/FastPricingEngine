package com.upupconsultant.pricing.event;

public class PricingEvent<T> {
	private T object;
	private long timestamp;
	public PricingEvent(T obj){
		object=obj;
		this.timestamp=System.currentTimeMillis();
	}
	public T getObject() {
		return object;
	}
	public void setObject(T object) {
		this.object = object;
	}
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	

}
