package com.phearun.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.phearun.domain.Post;
import com.phearun.service.PostService;
import com.phearun.utility.JacksonBeanFilter;
import com.phearun.utility.JacksonFilter;

@RestController
@RequestMapping("/api/posts")
public class PostController {

	private PostService postService;

	@Autowired
	public PostController(PostService postService) {
		this.postService = postService;
	}

	@GetMapping("")
	public List<Post> findAll() {
		return postService.findAll();
	}

	@GetMapping("/filters")
	public MappingJacksonValue findFilter(
			@RequestParam(value = "post-fields", required = false, defaultValue = "id,text,user") Set<String> postFields,
			@RequestParam(value = "user-fields", required = false, defaultValue = "id,name,email") Set<String> userFields) {
		
		List<JacksonBeanFilter> filters = Arrays.asList(new JacksonBeanFilter("postFilter", postFields), 
														new JacksonBeanFilter("userFilter", userFields));
		
		return JacksonFilter.filterOut(filters, postService.findAll());
	}

}
