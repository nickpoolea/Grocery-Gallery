package com.goforcode.grocerygallery.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.goforcode.grocerygallery.models.Item;
import com.goforcode.grocerygallery.models.User;
import com.goforcode.grocerygallery.repositories.ItemRepository;
import com.goforcode.grocerygallery.repositories.UserRepository;

@RestController
@RequestMapping("/alexa/trash")
public class AlexaTrashController {
	
	private ItemRepository itemRepo;
	private User user;
	
	public AlexaTrashController(ItemRepository itemRepo, UserRepository userRepo) {
		this.itemRepo = itemRepo;
		user = userRepo.findOne(1L);
	}
	
	@GetMapping("/wasted")
	public List<Item> returnWastedItemsInTrash(Authentication auth, HttpServletRequest request, HttpServletResponse response) {
		String header = request.getHeader("X-SECRET-API-KEY");
		if (!"2039rj0aeijf98je0rij0ej9r0".equals(header)) {
			response.setStatus(403);
		}	
		return itemRepo.findByWasWastedTrueAndUserIdEqualsOrderByTrashDateDesc(user.getId());
		
	}
	
	@GetMapping("/finished")
	public List<Item> returnFinishedItemsInTrash(Authentication auth, HttpServletRequest request, HttpServletResponse response) {
		String header = request.getHeader("X-SECRET-API-KEY");
		if (!"2039rj0aeijf98je0rij0ej9r0".equals(header)) {
			response.setStatus(403);
		}	
		return itemRepo.findByWasFinishedTrueAndUserIdEqualsOrderByTrashDateDesc(user.getId());
	}

}
