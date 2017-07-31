package com.phearun.domain;

import com.fasterxml.jackson.annotation.JsonFilter;

//@JsonPropertyOrder({"email", "name", "id"})
//@JsonIgnoreProperties({"id", "name"})
//@JsonInclude(Include.NON_EMPTY)
//@JsonFilter("userFilter")
@JsonFilter("antPathFilter")
public class User {
	
	private String id;
	
	private String name;
	
	private String email;
	
	private Address address;
	
	public User() {
		super();
	}
	
	public User(String id, String name, String email, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.address = address;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", address=" + address + "]";
	}
	
}
