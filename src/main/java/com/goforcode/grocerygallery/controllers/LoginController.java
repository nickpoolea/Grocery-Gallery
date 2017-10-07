package com.goforcode.grocerygallery.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.goforcode.grocerygallery.models.User;

@Controller
@RequestMapping("/")
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
