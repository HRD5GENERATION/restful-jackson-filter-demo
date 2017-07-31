package com.phearun.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phearun.domain.Post;

@Service
public class PostService {

	private List<Post> posts;
	
	@Autowired
	public PostService(UserService userService) {
		posts = new ArrayList<>();
		posts.add(new Post("1", "Hello World!", userService.findFirst()));
		posts.add(new Post("2", "Java Programming!", userService.findOne(1)));
		posts.add(new Post("3", "RESTful Web Service!", userService.findOne(2)));
	}
	
	public List<Post> findAll(){
		return posts;
	}
	
	public Post findFirst(){
		return posts.get(0);
	}
}
