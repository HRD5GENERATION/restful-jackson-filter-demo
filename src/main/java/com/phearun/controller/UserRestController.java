package com.phearun.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.phearun.domain.Address;
import com.phearun.domain.User;
import com.phearun.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserRestController {

	private UserService userService;
	
	@Autowired
	public UserRestController(UserService userService) {
		this.userService = userService;	
	}
	
	@GetMapping("")
	public List<User> findAll(){
		return userService.findAll();
	}
	
	@GetMapping("/filters")
	public MappingJacksonValue findFilter(@RequestParam Set<String> fields){
		
		User user = new User("1", "Phearun", "phearun@gmail.com", new Address("PP"));
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(fields);
		FilterProvider filters = new SimpleFilterProvider().addFilter("userFilter", filter);
		
		MappingJacksonValue mapping = new MappingJacksonValue(user);
		mapping.setFilters(filters);
		return mapping;
	}
	
	
	
}
