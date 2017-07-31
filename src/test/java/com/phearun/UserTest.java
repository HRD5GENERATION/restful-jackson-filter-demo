package com.phearun;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.phearun.service.UserService;

import ch.mfrey.jackson.antpathfilter.Jackson2Helper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

	@Autowired
	private Jackson2Helper jackson2Helper;

	@Autowired
	private UserService userService;
	

	@Test
	public void getLevel1Fields() {
		String t = jackson2Helper.writeFiltered(userService.findFirst(), "*");
		System.out.println(t);
	}

	@Test
	public void getAllLevelFields() {
		String t = jackson2Helper.writeFiltered(userService.findFirst(), "**");
		System.out.println(t);
	}

	@Test
	public void getAllFieldsExcludeAddress() {
		String t = jackson2Helper.writeFiltered(userService.findAll(), "**", "!address");
		System.out.println(t);
	}
	
	@Test
	public void getAllFieldsExcludeProvince() {
		String t = jackson2Helper.writeFiltered(userService.findAll(), "**", "!address.province");
		System.out.println(t);
	}
	
	
	@Test
	public void getUserIdField() {
		String t = jackson2Helper.writeFiltered(userService.findFirst(), "id");
		System.out.println(t);
	}
	
	@Test
	public void getUserNameField() {
		String t = jackson2Helper.writeFiltered(userService.findFirst(), "id", "name");
		System.out.println(t);
	}
	
	@Test
	public void getIdAndAllAddressFields() {
		String t = jackson2Helper.writeFiltered(userService.findFirst(), "id", "address", "address.*");
		System.out.println(t);
	}
	
	@Test
	public void excludeAllFields() {
		String t = jackson2Helper.writeFiltered(userService.findFirst(), "!**");
		System.out.println(t);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
