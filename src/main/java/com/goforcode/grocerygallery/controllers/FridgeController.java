package com.goforcode.grocerygallery.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
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
import com.goforcode.grocerygallery.repositories.ItemRepository;

@RestController
@RequestMapping("/fridge")
@CrossOrigin(origins = "*")
public class FridgeController {
	
	
	private ItemRepository itemRepo;
	
	public FridgeController(ItemRepository itemRepo) {
		this.itemRepo = itemRepo;
	}
	
	/*
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
	public List<Item> returnItemsInFridge(String partialTitle) {
		return itemRepo.findAll();
	}
	
	@PostMapping("")
	public Item addItemToFridge(@RequestBody Item fridgeItem) {
		fridgeItem.setInFridge(true);
		fridgeItem.calculateLevel();
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
		return itemRepo.save(fridgeItem);
	}
	
	@DeleteMapping("/{id}")
	public Item deleteFridgeItem(@PathVariable long id) {
		Item fridgeItem = itemRepo.findOne(id);
		itemRepo.delete(id);
		return fridgeItem;
		
	}
	
	@PostMapping("/{id}/waste")
	public Item wasteAFridgeItem(@RequestBody Item fridgeItem, @PathVariable long id) {
		fridgeItem.setWasWasted(true);
		return itemRepo.save(fridgeItem);
	}
	
	@PostMapping("/{id}/finish")
	public Item finishAFridgeItem(@RequestBody Item fridgeItem, @PathVariable long id) {
		fridgeItem.setWasFinished(true);
		return itemRepo.save(fridgeItem);
	}

}
