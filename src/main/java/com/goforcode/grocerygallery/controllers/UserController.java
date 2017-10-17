package com.goforcode.grocerygallery.controllers;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.goforcode.grocerygallery.models.User;
import com.goforcode.grocerygallery.repositories.UserRepository;
import com.goforcode.grocerygallery.repositories.UserRoleRepository;

@RestController
@RequestMapping("/user")
public class UserController {
	
	private UserRepository userRepo;
	private PasswordEncoder encoder;
	private UserRoleRepository roleRepo;
	
	public UserController(UserRepository userRepo, PasswordEncoder encoder, UserRoleRepository roleRepo) {
		this.userRepo = userRepo;
		this.encoder = encoder;
		this.roleRepo = roleRepo;
	}
			
	@PostMapping("/signup")
	public User createNewUser(@RequestBody User user) {
		try {
			User searchUser = userRepo.findByEmail(user.getEmail());
			if (searchUser == null) {
				user.setPassword(encoder.encode(user.getPassword()));
				user.setRoles(roleRepo.findByNameEquals("USER"));
				return userRepo.save(user);
			}
		} catch (NullPointerException npe) {
			System.out.println("Error Printing");
			npe.printStackTrace();
		}
		
		return new User();
	}
	
	@PostMapping("/delete/{id}")
	public User createNewUser(@PathVariable long id) {
		User user = userRepo.findOne(id);
		userRepo.delete(id);
		return user;
	}

}
