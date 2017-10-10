package com.goforcode.grocerygallery.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
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
		List<Item> allGroceryItems = itemRepo.findByInGroceryTrue();
		return allGroceryItems;
	}
	
	@PostMapping("")
	public Item addItemToGroceryList(@RequestBody Item item) {
		/* Add an item to the grocery list */
		item.setInGrocery(true);
		return itemRepo.save(item);
	}
	
	@GetMapping("/{id}")
	public Item getDetailsOfGroceryItem(@PathVariable long id) {
		/* Return the details of one grocery item */
		return itemRepo.findOne(id);
	}
	
	@PutMapping("/{id}")
	public Item editGroceryItem(@PathVariable long id, @RequestBody Item item) {
		/* Edit the details of one grocery item*/
		item.setId(id);
		return itemRepo.save(item);
	}
	
	@DeleteMapping("/{id}")
	public Item deleteItemFromGroceryList(@PathVariable long id) {
		/* Delete an item from the grocery list */
		Item item = itemRepo.findOne(id);
		itemRepo.delete(id);
		return item;
	}

}
