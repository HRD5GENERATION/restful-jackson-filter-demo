package com.phearun;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.phearun.service.PostService;

import ch.mfrey.jackson.antpathfilter.Jackson2Helper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserPostTest {
	
	@Autowired
	private Jackson2Helper jackson2Helper;

	@Autowired
	private PostService postService;

	@Test
	public void getAllFields() {
		String t = jackson2Helper.writeFiltered(postService.findFirst(), "**");
		System.out.println(t);
	}
	
	@Test
	public void getAllFieldsExcludeUser() {
		String t = jackson2Helper.writeFiltered(postService.findFirst(), "**", "!user");
		System.out.println(t);
	}

	@Test
	public void getAllFieldsExcludeUserAddress() {
		String t = jackson2Helper.writeFiltered(postService.findFirst(), "**", "!user.address");
		System.out.println(t);
	}
}
