package com.phearun.domain;

import java.util.List;

public class FieldFilter {

	private List<String> fields;

	public FieldFilter() {
	}

	public String[] getFields() {
		return fields.toArray(new String[fields.size()]);
	}

	public void setFields(List<String> fields) {
		this.fields = fields;
	}
}
