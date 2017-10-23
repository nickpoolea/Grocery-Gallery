package com.goforcode.grocerygallery.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.goforcode.grocerygallery.models.Item;
import com.goforcode.grocerygallery.models.User;
import com.goforcode.grocerygallery.repositories.ItemRepository;
import com.goforcode.grocerygallery.repositories.UserRepository;

@RestController
@RequestMapping("alexa/grocery")
public class AlexaGroceryController {
	
	private ItemRepository itemRepo;
	private UserRepository userRepo;
	
	public AlexaGroceryController(ItemRepository itemRepo, UserRepository userRepo) {
		this.itemRepo = itemRepo;
		this.userRepo = userRepo;
		
	}
	
	@GetMapping("")
	public List<Item> getGroceryItems(HttpServletRequest request, HttpServletResponse response) {
		String header = request.getHeader("X-SECRET-API-KEY");
		if (!"2039rj0aeijf98je0rij0ej9r0".equals(header)) {
			response.setStatus(403);
		}
		return itemRepo.findByInGroceryTrueAndUserIdEqualsOrderByName(1L);
	}
	
	@PostMapping("")
	public Item addItemToGroceryList(@RequestBody Item item, HttpServletRequest request, HttpServletResponse response) {
		User user = userRepo.findOne(1L);
		String header = request.getHeader("X-SECRET-API-KEY");
		if (!"2039rj0aeijf98je0rij0ej9r0".equals(header)) {
			response.setStatus(403);
		}
		item.setUser(user);
		item.setInGrocery(true);
		
		//validation of negative scenarios
		item.setInFridge(false);
		item.setWasFinished(false);
		item.setWasWasted(false);
		
		return itemRepo.save(item);
	}

}
