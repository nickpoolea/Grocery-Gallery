package com.goforcode.grocerygallery.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.goforcode.grocerygallery.models.User;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class LoginController {
	
	private User tempUser = new User();
	
	@PostMapping("signup")
	public User createNewUser(User user) {
		/* Take in a user and save it to the user database */
		return tempUser;
	}
	
	@PostMapping("login")
	public User validateUserToLogin(User user) {
		/* Validate User credentials to log the user in */
		return tempUser;
	}

}
