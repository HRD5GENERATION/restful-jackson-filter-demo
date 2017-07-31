package com.phearun.domain;

import com.fasterxml.jackson.annotation.JsonFilter;

@JsonFilter("antPathFilter")
public class Address {
	
	private String province;
	public Address() {
		super();
	}
	public Address(String province) {
		super();
		this.province = province;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	@Override
	public String toString() {
		return "Address [province=" + province + "]";
	}
	
}
