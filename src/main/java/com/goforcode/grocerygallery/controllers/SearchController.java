package com.goforcode.grocerygallery.controllers;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.goforcode.grocerygallery.services.ApiSearchService;

@Controller
@RestController
@RequestMapping("/search")
public class SearchController {
	
	private ApiSearchService search;
	
	public SearchController(ApiSearchService search) {
		this.search = search;
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
	public JsonNode getItemDetails(@PathVariable String id) {
		try {
			return search.getDetailsOfItem(id);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
