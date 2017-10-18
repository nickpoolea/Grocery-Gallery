package com.goforcode.grocerygallery.controllers;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.goforcode.grocerygallery.models.Item;
import com.goforcode.grocerygallery.models.User;
import com.goforcode.grocerygallery.repositories.ItemRepository;
import com.goforcode.grocerygallery.services.ApiSearchService;

@Controller
@RestController
@RequestMapping("/search")
public class SearchController {
	
	private ApiSearchService search;
	private ItemRepository itemRepo;
	
	public SearchController(ApiSearchService search, ItemRepository itemRepo) {
		this.search = search;
		this.itemRepo = itemRepo;
	}
	
	@GetMapping("")
	public JsonNode searchForItem(@RequestParam String query) {
		try {
			return search.searchForItems(query);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping("/{id}")
	public Item saveItemWithApiDetails(@PathVariable String id, Authentication auth) throws JsonProcessingException, IOException {
		User user = (User) auth.getPrincipal();
		Item item = search.jsonDetailsToObect(id);
		item.setUser(user);
		
		//Temporary - Set item in fridge
		item.setInFridge(true);
		item.setInGrocery(false);
		item.setWasFinished(false);
		item.setWasWasted(false);
		return itemRepo.save(item);
	}

}
