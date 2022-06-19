package com.petitions.restapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petitions.restapi.model.User;
import com.petitions.restapi.service.UserService;

@RestController
public class UserController {	
	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public Iterable<User> getUsers(){
		return userService.getUsers();
	}
}
