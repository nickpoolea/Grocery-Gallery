package com.goforcode.grocerygallery.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.goforcode.grocerygallery.models.Item;

@Controller
@RequestMapping("/fridge")
public class FridgeController {
	
	private List<Item> tempItemList = new ArrayList<Item>();
	private Item tempItem = new Item();
	
	@GetMapping("")
	public List<Item> returnItemsInFridge() {
		/* Return a list of all items in the fridge */
		return tempItemList;
	}
	
	@PostMapping("")
	public Item addItemToFridge(Item item) {
		/* Add an item to the fridge */
		return tempItem;
	}
	
	@GetMapping("/{id}")
	public Item getDetailsOfFridgeItem() {
		/* Return the details of one fridge item */
		return tempItem;
	}
	
	@PutMapping("/{id}")
	public Item editFridgeItem() {
		/* Edit the details of one fridge item*/
		return tempItem;
	}
	
	@DeleteMapping("/{id}")
	public Item deleteFridgeItem() {
		/* Delete an item from the fridge */
		return tempItem;
	}
	
	@PostMapping("/{id}/waste")
	public Item wasteAFridgeItem() {
		/* Mark an item as wasted from the fridge */
		return tempItem;
	}
	
	@PostMapping("/{id}/finish")
	public Item finishAFridgeItem() {
		/* Mark an item as finished from the fridge */
		return tempItem;
	}

}
