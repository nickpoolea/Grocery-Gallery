package com.goforcode.grocerygallery.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.goforcode.grocerygallery.models.User;
import com.goforcode.grocerygallery.repositories.UserRepository;

@Service
public class GroceryUserDetailsService implements UserDetailsService {
	
	private UserRepository userRepo;
	
	public GroceryUserDetailsService(UserRepository userRepo) {
		this.userRepo = userRepo;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepo.findByEmail(email);
		if (user == null) {
			throw new UsernameNotFoundException(email);
		}
		return user;
	}

}
