package com.goforcode.grocerygallery.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.goforcode.grocerygallery.models.User;
import com.goforcode.grocerygallery.services.GroceryUserDetailsService;

@RestController
@CrossOrigin(origins="*")
public class SessionController {
	
	private GroceryUserDetailsService groceryUserDetails;
	private AuthenticationManager authenticator;
	
	public SessionController(GroceryUserDetailsService groceryUserDetails, AuthenticationManager authenticator) {
		this.groceryUserDetails = groceryUserDetails;
		this.authenticator = authenticator;
	}

	@PostMapping("/login")
	public boolean checkCredentials(@RequestBody User user) {
		System.out.println("Login");
		UserDetails userDetails = groceryUserDetails.loadUserByUsername(user.getEmail());
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userDetails, user.getPassword(), userDetails.getAuthorities());
		authenticator.authenticate(token);
		token.isAuthenticated();
		
		 if (token.isAuthenticated()) {
	            SecurityContextHolder.getContext().setAuthentication(token);
	        }
	     return token.isAuthenticated();
	}
	
	@DeleteMapping("/log-out")
	public Boolean logout(Authentication auth, HttpServletRequest request, HttpServletResponse response) {
		new SecurityContextLogoutHandler().logout(request, response, auth);
		return true;
	}
	
}
