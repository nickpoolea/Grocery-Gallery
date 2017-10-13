package com.goforcode.grocerygallery.controllers;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.goforcode.grocerygallery.models.Item;
import com.goforcode.grocerygallery.models.User;
import com.goforcode.grocerygallery.repositories.ItemRepository;

@RestController
@RequestMapping("/trash")
@CrossOrigin(origins = "*")
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
	
	
	public User getPrincipalUser(Authentication auth) {
		return (User) auth.getPrincipal();
	}
	
}
