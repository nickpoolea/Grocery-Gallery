package com.goforcode.grocerygallery.controllers;

import java.util.Calendar;
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
import com.goforcode.grocerygallery.models.ItemReference;
import com.goforcode.grocerygallery.models.User;
import com.goforcode.grocerygallery.repositories.ItemReferenceRepository;
import com.goforcode.grocerygallery.repositories.ItemRepository;

@RestController
@RequestMapping("/fridge")
@CrossOrigin(origins="*")
public class FridgeController {
	
	private ItemRepository itemRepo;
	private ItemReferenceRepository itemRefRepo;
	
	public FridgeController(ItemRepository itemRepo, ItemReferenceRepository itemRefRepo) {
		this.itemRepo = itemRepo;
		this.itemRefRepo = itemRefRepo;
	}
	
	@GetMapping("")
	public List<Item> returnItemsInFridge(Authentication auth) {
		return itemRepo.findByInFridgeTrueAndUserIdEqualsOrderByExpirationDate(getPrincipalUser(auth).getId());
	}
	
	@PostMapping("")
	public Item addItemToFridge(@RequestBody Item fridgeItem, Authentication auth) {
		
		ItemReference itemRef = itemRefRepo.findByNameEquals(fridgeItem.getName());
				
		if (itemRef == null || itemRef.getId() == null) {
			Calendar purchaseDate = Calendar.getInstance();
			purchaseDate.setTime(fridgeItem.getPurchasedDate());
			Calendar expirationDate = Calendar.getInstance();
			expirationDate.setTime(fridgeItem.getExpirationDate());
			int shelfLife = expirationDate.get(Calendar.DAY_OF_YEAR) - purchaseDate.get(Calendar.DAY_OF_YEAR);
			itemRef = new ItemReference(fridgeItem.getName(), shelfLife);
			itemRefRepo.save(itemRef);
		}
		
		fridgeItem.setInFridge(true);
		fridgeItem.calculateLevel();
		fridgeItem.setUser(getPrincipalUser(auth));
		return itemRepo.save(fridgeItem);
	}
	
	@GetMapping("/{id}")
	public Item getDetailsOfFridgeItem(@PathVariable long id, Authentication auth) {
		return itemRepo.findByIdAndUserId(id, getPrincipalUser(auth).getId());
	}
	
	@PutMapping("/{id}")
	public Item editFridgeItem(@RequestBody Item fridgeItem, @PathVariable long id, Authentication auth) {
		User user = getPrincipalUser(auth);
		Item searchItem = itemRepo.findByIdAndUserId(id, user.getId());
		
		if (searchItem != null) {
			fridgeItem.setId(id);
			fridgeItem.setInFridge(true);
			fridgeItem.setUser(user);
			fridgeItem.calculateLevel();
			return itemRepo.save(fridgeItem);
		}
		return new Item();
	}
	
	@DeleteMapping("/{id}")
	public Item deleteFridgeItem(@PathVariable long id, Authentication auth) {
		Item fridgeItem = itemRepo.findByIdAndUserId(id, getPrincipalUser(auth).getId());
		
		if (fridgeItem != null && !fridgeItem.isInGrocery()) {
			itemRepo.delete(id);
			return fridgeItem;
			
		} else if (fridgeItem != null) {
			fridgeItem.setInGrocery(true);
			return itemRepo.save(fridgeItem);
		}
		return new Item();
	}
	
	//If front end implements TrashController mappings we can delete this
	@PostMapping("/{id}/waste")
	public Item wasteAFridgeItem(@PathVariable long id, Authentication auth) {
		Item item = itemRepo.findByIdAndUserId(id, getPrincipalUser(auth).getId());
		
		if (item != null) {
			item.setWasWasted(true);
			return itemRepo.save(item);
		}
		return new Item();
	}
	
	//If front end implements TrashController mappings we can delete this
	@PostMapping("/{id}/finish")
	public Item finishAFridgeItem(@PathVariable long id, Authentication auth) {
		Item item = itemRepo.findByIdAndUserId(id, getPrincipalUser(auth).getId());
		if (item != null) {
			item.setWasFinished(true);
			return itemRepo.save(item);
		}
		return new Item();
	}

	@PostMapping("/{id}/grocery")
	public Item moveAFridgeItemToGrocery(@PathVariable long id, @RequestBody Item incomingItem, Authentication auth) {
		Item item = itemRepo.findByIdAndUserId(id, getPrincipalUser(auth).getId());
		
		if (item != null) {
			item.setInFridgeAndInGrocery();
			item.setQuantity(incomingItem.getQuantity());
			return itemRepo.save(item);
		}
		return new Item();
	}
	
	@GetMapping("count")
	public int countItemByLevel(@RequestParam int level, Authentication auth) {
		return itemRepo.countByInFridgeTrueAndUserIdEqualsAndLevelEquals(getPrincipalUser(auth).getId(), level);
	}
	
	public User getPrincipalUser(Authentication auth) {
			return (User) auth.getPrincipal();
	}
	
}
