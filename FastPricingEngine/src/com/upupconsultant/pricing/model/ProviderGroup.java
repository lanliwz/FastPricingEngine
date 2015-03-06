package com.upupconsultant.pricing.model;

import java.util.ArrayList;
import java.util.List;

public class ProviderGroup {
	private List<String> providerIds;
	private String groupName;
	public ProviderGroup(String groupName){
		this.groupName=groupName;
		this.providerIds=new ArrayList<String>();
	}

	public List<String> getProviderIds() {
		return providerIds;
	}

	public void setProviderIds(List<String> providerIds) {
		this.providerIds = providerIds;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
	

}
