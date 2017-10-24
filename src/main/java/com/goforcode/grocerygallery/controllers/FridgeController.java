package com.goforcode.grocerygallery.controllers;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.goforcode.grocerygallery.models.Item;
import com.goforcode.grocerygallery.models.User;
import com.goforcode.grocerygallery.repositories.ItemRepository;

@RestController
@RequestMapping("/fridge")
@CrossOrigin(origins="*")
public class FridgeController {
	
	private ItemRepository itemRepo;
	
	public FridgeController(ItemRepository itemRepo) {
		this.itemRepo = itemRepo;
	}
	
	@GetMapping("")
	public List<Item> returnItemsInFridge(Authentication auth) {
		return itemRepo.findByInFridgeTrueAndUserIdEqualsOrderByExpirationDate(getPrincipalUser(auth).getId());
	}
	
	@PostMapping("")
	public Item addItemToFridge(@RequestBody Item fridgeItem, Authentication auth) {
		fridgeItem.setInFridge(true);
		
		System.out.println("Item purchase date: " + fridgeItem.getpurchasedDate());
		System.out.println("Item expiration date: " + fridgeItem.getExpirationDate());
	
		
		
		//set every new item in fridge not available in other areas
		fridgeItem.setInGrocery(false);
		fridgeItem.setWasFinished(false);
		fridgeItem.setWasWasted(false);
		
		//category and date validation if false
		fridgeItem.calculateLevel();
		
		fridgeItem.setUser(getPrincipalUser(auth));
		return itemRepo.save(fridgeItem);
	}
	
	@GetMapping("/{id}")
	public Item getDetailsOfFridgeItem(@PathVariable long id) {
		Item fridgeItem = itemRepo.findOne(id);
		return fridgeItem;
	}
	
	@PutMapping("/{id}")
	public Item editFridgeItem(@RequestBody Item fridgeItem, @PathVariable long id, Authentication auth) {
		
		//What do we do if this fails (NullPointerException)?
		User user = (User) auth.getPrincipal();
		Item searchItem = itemRepo.findByIdAndUserId(id, user.getId());
		
		if (searchItem != null) {
			fridgeItem.setId(id);
			fridgeItem.setInFridge(true);
			fridgeItem.setUser(user);
			
			//set every updated item in fridge not available in other areas
			fridgeItem.setInGrocery(false);
			fridgeItem.setWasFinished(false);
			fridgeItem.setWasWasted(false);
			
			fridgeItem.calculateLevel();
			return itemRepo.save(fridgeItem);
		}
		return new Item();
	}
	
	@DeleteMapping("/{id}")
	public Item deleteFridgeItem(@PathVariable long id, Authentication auth) {
		User user = (User) auth.getPrincipal();
		Item fridgeItem = itemRepo.findByIdAndUserId(id, user.getId());
		if (fridgeItem != null) {
			itemRepo.delete(id);
			return fridgeItem;
		}
		return new Item();
	}
	
	@PostMapping("/{id}/waste")
	public Item wasteAFridgeItem(@PathVariable long id, Authentication auth) {
		User user = (User) auth.getPrincipal();
		Item item = itemRepo.findByIdAndUserId(id, user.getId());
		
		if (item != null) {
			item.setWasWasted(true);
			
			//validation of negative scenarios
			item.setInFridge(false);
			item.setInGrocery(false);
			item.setWasFinished(false);
			
			return itemRepo.save(item);
		}
		return new Item();
	}
	
	@PostMapping("/{id}/finish")
	public Item finishAFridgeItem(@PathVariable long id, Authentication auth) {
		User user = (User) auth.getPrincipal();
		Item item = itemRepo.findByIdAndUserId(id, user.getId());
		if (item != null) {
			item.setWasFinished(true);
			
			//validation of negative scenarios
			item.setInFridge(false);
			item.setInGrocery(false);
			item.setWasWasted(false);
			
			return itemRepo.save(item);
		}
		return new Item();
	}

	@PostMapping("/{id}/grocery")
	public Item moveAFridgeItemToGrocery(@PathVariable long id, @RequestBody Item incomingItem, Authentication auth) {
		User user = (User) auth.getPrincipal();
		Item item = itemRepo.findByIdAndUserId(id, user.getId());
		
		if (item != null) {
			item.setInGrocery(true);
			item.setQuantity(incomingItem.getQuantity());
			
			//keep it in the fridge
			item.setInFridge(true);
			
			//validation of negative scenarios
			item.setWasFinished(false);
			item.setWasWasted(false);
			
			item.calculateLevel();
			
			return itemRepo.save(item);
		}
		return new Item();
	}
	
	@GetMapping("count")
	public int countItemByLevel(@RequestParam int level, Authentication auth) {
		User user = (User) auth.getPrincipal();
		return itemRepo.countByInFridgeTrueAndUserIdEqualsAndLevelEquals(user.getId(), level);
	}
	
	public User getPrincipalUser(Authentication auth) {
			return (User) auth.getPrincipal();
	}
	
}
