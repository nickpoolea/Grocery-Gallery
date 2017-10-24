package com.goforcode.grocerygallery.controllers;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.goforcode.grocerygallery.models.Item;
import com.goforcode.grocerygallery.models.User;
import com.goforcode.grocerygallery.repositories.ItemRepository;

@RestController
@RequestMapping("/trash")
@CrossOrigin(origins="*")
public class TrashController {
	
	private ItemRepository itemRepo;
	
	public TrashController(ItemRepository itemRepo) {
		this.itemRepo = itemRepo;
	}

	@GetMapping("/wasted")
	public List<Item> returnWastedItemsInTrash(Authentication auth) {
		List<Item> wastedList;
		wastedList = itemRepo.findByWasWastedTrueAndUserIdEqualsOrderByTrashDateDesc(getPrincipalUser(auth).getId());
		System.out.println(wastedList);
		return wastedList;
		
	}
	
	@GetMapping("/finished")
	public List<Item> returnFinishedItemsInTrash(Authentication auth) {
		/*Return finished items in the trash */
		List<Item> finishedList;
		finishedList = itemRepo.findByWasFinishedTrueAndUserIdEqualsOrderByTrashDateDesc(getPrincipalUser(auth).getId());
		
		return finishedList;
	}
	
	@GetMapping("")
	public List<Item> returnAllItemsInTrasb(Authentication auth) {
		/*Return finished items in the trash */
		List<Item> allTrashList;
		allTrashList = itemRepo.findByWasWastedTrueOrWasFinishedTrueAndUserIdEqualsOrderByTrashDateDesc(getPrincipalUser(auth).getId());
		
		return allTrashList;
	}
	
	
	//Currently unused - front end has to change their code to send
	//item object rather than just ID 
	@PostMapping("/{id}/wasted")
	public Item addItemToWasted(@PathVariable long id, Authentication auth) {
		User user = (User) auth.getPrincipal();
		Item item = itemRepo.findByIdAndUserId(id, user.getId());
		
		if(item != null) {
			item.setWasWasted(true);
			return itemRepo.save(item);
		}
		return new Item();		
	}
	
	
	//Currently unused - front end has to change their code to send
	//item object rather than just ID 
	@PostMapping("/{id}/finished")
	public Item addItemToFinished(@PathVariable long id, Authentication auth) {
		User user = (User) auth.getPrincipal();
		Item item = itemRepo.findByIdAndUserId(id, user.getId());
		
		if(item != null) {
			item.setWasFinished(true);
			return itemRepo.save(item);
		}
		return new Item();	
		
	}
	
	
	public User getPrincipalUser(Authentication auth) {
		return (User) auth.getPrincipal();
	}
	
}
