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
	
	/* This needs to be fixed before it is uncommented
	// To allow search to work
	@GetMapping("")
	public List<Item> returnItemsInFridge(String partialTitle) {
		List<Item> returnList;
		if(partialTitle != null) {
			returnList = itemRepo.findByTitleContaining(partialTitle);	
		}
		else {
			returnList = itemRepo.findAll();	
		}
		return returnList;
	}*/
	
	@GetMapping("")
	public List<Item> returnItemsInFridge(Authentication auth) {
		return itemRepo.findByInFridgeTrueAndUserIdEquals(getPrincipalUser(auth).getId());
	}
	
	@PostMapping("")
	public Item addItemToFridge(@RequestBody Item fridgeItem, Authentication auth) {
		fridgeItem.setInFridge(true);
		
		//set every new item in fridge not available in other areas
		fridgeItem.setInGrocery(false);
		fridgeItem.setWasFinished(false);
		fridgeItem.setWasWasted(false);
		
		//category and date validation if false
		fridgeItem.validateCategoryAndDates();
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
	public Item editFridgeItem(@RequestBody Item fridgeItem, @PathVariable long id) {
		fridgeItem.setId(id);
		fridgeItem.setInFridge(true);
		
		//set every updated item in fridge not available in other areas
		fridgeItem.setInGrocery(false);
		fridgeItem.setWasFinished(false);
		fridgeItem.setWasWasted(false);
		
		fridgeItem.validateCategoryAndDates();
		fridgeItem.calculateLevel();
		return itemRepo.save(fridgeItem);
	}
	
	@DeleteMapping("/{id}")
	public Item deleteFridgeItem(@PathVariable long id) {
		Item fridgeItem = itemRepo.findOne(id);
		itemRepo.delete(id);
		return fridgeItem;
	}
	
	@PostMapping("/{id}/waste")
	public Item wasteAFridgeItem(@PathVariable long id) {
		Item item = itemRepo.findOne(id);
		item.setWasWasted(true);
		
		//validation of negative scenarios
		item.setInFridge(false);
		item.setInGrocery(false);
		item.setWasFinished(false);
		
		return itemRepo.save(item);
	}
	
	@PostMapping("/{id}/finish")
	public Item finishAFridgeItem(@PathVariable long id) {
		Item item = itemRepo.findOne(id);
		item.setWasFinished(true);
		
		//validation of negative scenarios
		item.setInFridge(false);
		item.setInGrocery(false);
		item.setWasWasted(false);
		
		return itemRepo.save(item);
	}

	@PostMapping("/{id}/grocery")
	public Item moveAFridgeItemToGrocery(@RequestBody Item fridgeItem, @PathVariable long id) {
		Item item = itemRepo.findOne(id);
		item.setInGrocery(true);
		
		//validation of negative scenarios
		item.setInFridge(false);
		item.setWasFinished(false);
		item.setWasWasted(false);
		
		return itemRepo.save(item);
	}
	
	public User getPrincipalUser(Authentication auth) {
			return (User) auth.getPrincipal();
	}
	
}
