package com.goforcode.grocerygallery.controllers;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.goforcode.grocerygallery.models.Item;
import com.goforcode.grocerygallery.models.ItemReference;
import com.goforcode.grocerygallery.models.User;
import com.goforcode.grocerygallery.repositories.ItemReferenceRepository;
import com.goforcode.grocerygallery.repositories.ItemRepository;
import com.goforcode.grocerygallery.repositories.UserRepository;


@RestController
@RequestMapping("/alexa/fridge")
@CrossOrigin(origins="*")
public class AlexaFridgeController {
	
	private ItemRepository itemRepo;
	private UserRepository userRepo; 
	private ItemReferenceRepository itemRefRepo;

	public AlexaFridgeController(ItemRepository itemRepo, UserRepository userRepo,
								 ItemReferenceRepository itemRefRepo) {
		this.itemRepo = itemRepo;
		this.userRepo = userRepo;
		this.itemRefRepo = itemRefRepo;
	}
	
	
	@GetMapping("")
	public List<Item> getItems(HttpServletRequest request, HttpServletResponse response) {
		String header = request.getHeader("X-SECRET-API-KEY");
		if (!"2039rj0aeijf98je0rij0ej9r0".equals(header)) {
			response.setStatus(403);
		}		
		List<Item> itemsList = itemRepo.findByInFridgeTrueAndUserIdEqualsOrderByExpirationDate(1);
		return itemsList;
	
	}
	
	@PostMapping("")
	public Item addItemToFridge(@RequestBody Item fridgeItem, HttpServletRequest request, HttpServletResponse response) {
		User user = userRepo.findOne(1l);
		String header = request.getHeader("X-SECRET-API-KEY");
		if (!"2039rj0aeijf98je0rij0ej9r0".equals(header)) {
			response.setStatus(403);
		}
		
		ItemReference itemRef = itemRefRepo.findOneByNameEqualsIgnoreCase(fridgeItem.getName());
		Item item = new Item(fridgeItem.getName());
		item.setInFridge(true);
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		
		item.setPurchasedDate(cal.getTime());
		
		if (itemRef != null) {
			cal.add(Calendar.DATE, itemRef.getShelfLife());
			item.setExpirationDate(cal.getTime());
		} else {
			cal.add(Calendar.DATE, 7);
			item.setExpirationDate(cal.getTime());
		}
		
		item.calculateLevel();
		item.setInFridge(true);
		item.setUser(user);
		System.out.println(item.getName());
		System.out.println(item.getExpirationDate());
		System.out.println(item.getPurchasedDate());
		System.out.println(item.getLevel());
		System.out.println("User: " + item.getUser().getId());
		
		return itemRepo.save(item);
	}
}
