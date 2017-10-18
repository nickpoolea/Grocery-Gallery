package com.goforcode.grocerygallery.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.goforcode.grocerygallery.models.Item;
import com.goforcode.grocerygallery.models.User;
import com.goforcode.grocerygallery.repositories.ItemRepository;
import com.goforcode.grocerygallery.repositories.UserRepository;

@RestController
@RequestMapping("/alexa")
@CrossOrigin(origins="*")
public class AlexaFridgeController {
	
	private ItemRepository itemRepo;
	private UserRepository userRepo; 
	private User priya;
	
	public AlexaFridgeController(ItemRepository itemRepo, UserRepository userRepo) {
		this.itemRepo = itemRepo;
		this.userRepo = userRepo;
		
		priya = userRepo.findOne(1L);
	}
	
	
	@GetMapping("/fridge")
	public List<Item> getItems(HttpServletRequest request, HttpServletResponse response) {
		String header = request.getHeader("X-SECRET-API-KEY");
		System.out.println(request.getHeader("X-SECRET-API-KEY"));
		if (!"2039rj0aeijf98je0rij0ej9r0".equals(header)) {
			response.setStatus(403);
			
		}
		
		// GO do good things, here.
		
		List<Item> itemsList = itemRepo.findByInFridgeTrueAndUserIdEquals(priya.getId());
		return null;
	
	}

}
