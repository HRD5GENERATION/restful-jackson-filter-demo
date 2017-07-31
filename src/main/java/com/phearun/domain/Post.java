package com.phearun.domain;

import com.fasterxml.jackson.annotation.JsonFilter;

//@JsonFilter("postFilter")
@JsonFilter("antPathFilter")
public class Post {
	
	private String id;
	private String text;
	
	//@JsonFilter("userFilter")
	private User user;
	
	public Post() {
		super();
	}
	
	public Post(String id, String text, User user) {
		super();
		this.id = id;
		this.text = text;
		this.user = user;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Post [id=" + id + ", text=" + text + ", user=" + user + "]";
	}
	
}
