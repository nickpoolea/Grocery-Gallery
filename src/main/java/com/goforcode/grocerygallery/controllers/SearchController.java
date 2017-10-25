package com.goforcode.grocerygallery.controllers;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.goforcode.grocerygallery.models.Item;
import com.goforcode.grocerygallery.models.ItemReference;
import com.goforcode.grocerygallery.repositories.ItemReferenceRepository;
import com.goforcode.grocerygallery.repositories.ItemRepository;

@Controller
@RestController
@RequestMapping("/search")
public class SearchController {
	
	private ItemReferenceRepository itemRefRepo;
	private ItemRepository itemRepo;
	
	public SearchController(ItemReferenceRepository itemRefRepo, ItemRepository itemRepo) {
		this.itemRefRepo = itemRefRepo;
		this.itemRepo = itemRepo;
	}
	
	@GetMapping("") // list
	public List<ItemReference> searchForAReferenceItem(@RequestParam String query) {
		return itemRefRepo.findByNameLikeIgnoreCase(query);
	}
	
	@GetMapping("/{id}") // add selected item to repo
	public Item createItemFromExistingReference(@PathVariable long id) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		ItemReference itemRef = itemRefRepo.findOne(id);
		Item item = new Item(itemRef.getName());
		item.setPurchasedDate(cal.getTime());
		item.calculateLevel();
		cal.add(Calendar.DATE, itemRef.getShelfLife() - 1);
		item.setExpirationDate(cal.getTime());
		return item;
	}

}
