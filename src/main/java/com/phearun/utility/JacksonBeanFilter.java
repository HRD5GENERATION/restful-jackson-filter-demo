package com.phearun.utility;

import java.util.Set;

public class JacksonBeanFilter {

	private String id;
	private Set<String> fields;

	public JacksonBeanFilter(String id, Set<String> fields) {
		this.id = id;
		this.fields = fields;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Set<String> getFields() {
		return fields;
	}

	public void setFields(Set<String> fields) {
		this.fields = fields;
	}

	@Override
	public String toString() {
		return "JacksonBeanFilter [id=" + id + ", fields=" + fields + "]";
	}
}
