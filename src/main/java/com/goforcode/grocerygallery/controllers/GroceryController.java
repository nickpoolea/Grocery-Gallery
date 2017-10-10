package com.goforcode.grocerygallery.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.goforcode.grocerygallery.models.Item;
import com.goforcode.grocerygallery.repositories.ItemRepository;

@RestController
@RequestMapping("/grocery")
public class GroceryController {
	
	private List<Item> tempItemList = new ArrayList<Item>();
	private Item tempItem = new Item();
	private ItemRepository itemRepo;
	
	public GroceryController(ItemRepository itemRepo) {
		this.itemRepo = itemRepo;
	}
	
	@GetMapping("")
	public List<Item> returnItemsInGroceryList() {
		/* Return a list of all items in the grocery list */
		List<Item> allGroceryItems = itemRepo.findByInGroceryIsTrue();
		return allGroceryItems;
	}
	
	@PostMapping("/")
	public Item addItemToGroceryList(Item item) {
		/* Add an item to the grocery list */
		return tempItem;
	}
	
	@GetMapping("/{id}")
	public Item getDetailsOfGroceryItem() {
		/* Return the details of one grocery item */
		return tempItem;
	}
	
	@PutMapping("/{id}")
	public Item editGroceryItem() {
		/* Edit the details of one grocery item*/
		return tempItem;
	}
	
	@DeleteMapping("/{id}")
	public Item deleteItemFromGroceryList() {
		/* Delete an item from the grocery list */
		return tempItem;
	}

}
