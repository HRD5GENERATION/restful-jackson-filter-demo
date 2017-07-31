package com.phearun.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.phearun.domain.Address;
import com.phearun.domain.User;

@Service
public class UserService {

	private List<User> users = new ArrayList<>();
	
	public UserService() {
		users.add(new User("1", "Phearun", "phearun@gmail.om", new Address("PP")));
		users.add(new User("2", "", "dara@gmail.om", new Address("TK")));
		users.add(new User("3", "Ryda", null, new Address("PV")));
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User findFirst(){
		return users.get(0);
	}
	
	public User findOne(int index){
		return users.get(index);
	}
}
