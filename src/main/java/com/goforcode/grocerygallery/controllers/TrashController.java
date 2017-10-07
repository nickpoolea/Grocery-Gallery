package com.goforcode.grocerygallery.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.goforcode.grocerygallery.models.Item;

@Controller
@RequestMapping("/trash")
public class TrashController {
	
	private List<Item> tempItemList = new ArrayList<Item>();

	@GetMapping("/wasted")
	public List<Item> returnWastedItemsInTrash() {
		/*Return wasted items in the trash */
		return tempItemList;
	}
	
	@GetMapping("/finished")
	public List<Item> returnFinishedItemsInTrash() {
		/*Return finished items in the trash */
		return tempItemList;
	}
	
}
