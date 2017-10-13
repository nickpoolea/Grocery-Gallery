package com.goforcode.grocerygallery.controllers;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.goforcode.grocerygallery.models.User;
import com.goforcode.grocerygallery.repositories.UserRepository;
import com.goforcode.grocerygallery.repositories.UserRoleRepository;

@RestController
@RequestMapping("/")
public class LoginController {
	
	private UserRepository userRepo;
	private PasswordEncoder encoder;
	private UserRoleRepository roleRepo;
	
	public LoginController(UserRepository userRepo, PasswordEncoder encoder, UserRoleRepository roleRepo) {
		this.userRepo = userRepo;
		this.encoder = encoder;
		this.roleRepo = roleRepo;
	}
			
	@PostMapping("signup")
	public User createNewUser(@RequestBody User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		user.setRoles(roleRepo.findByNameEquals("USER"));
		return userRepo.save(user);
	}

}
