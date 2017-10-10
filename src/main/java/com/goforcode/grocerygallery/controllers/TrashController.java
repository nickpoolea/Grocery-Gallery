package com.goforcode.grocerygallery.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.goforcode.grocerygallery.models.Item;
import com.goforcode.grocerygallery.repositories.ItemRepository;

@RestController
@RequestMapping("/trash")
public class TrashController {
	
	private ItemRepository itemRepo;
	
	public TrashController(ItemRepository itemRepo) {
		this.itemRepo = itemRepo;
	}

	@GetMapping("/wasted")
	public List<Item> returnWastedItemsInTrash() {
		/*Return wasted items in the trash */
		List<Item> wastedList;
		wastedList = itemRepo.findByWasWastedTrue();
		
		return wastedList;
		
	}
	
	@GetMapping("/finished")
	public List<Item> returnFinishedItemsInTrash() {
		/*Return finished items in the trash */
		List<Item> finishedList;
		finishedList = itemRepo.findByWasFinishedTrue();
		
		return finishedList;
	}
	
}
