package com.goforcode.grocerygallery.controllers;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.goforcode.grocerygallery.models.GroceryEmail;
import com.goforcode.grocerygallery.models.Item;
import com.goforcode.grocerygallery.models.User;
import com.goforcode.grocerygallery.repositories.ItemRepository;
import com.goforcode.grocerygallery.services.MailService;
import com.mashape.unirest.http.exceptions.UnirestException;

@RestController
@RequestMapping("/grocery")
@CrossOrigin(origins="*")
public class GroceryController {
	
	private ItemRepository itemRepo;
	
	public GroceryController(ItemRepository itemRepo) {
		this.itemRepo = itemRepo;
	}
	
	@GetMapping("")
	public List<Item> returnItemsInGroceryList(Authentication auth) throws UnirestException {
		User user = (User) auth.getPrincipal();
		long userId = user.getId();
		return itemRepo.findByInGroceryTrueAndUserIdEquals(userId); 
	}
	
	@PostMapping("")
	public Item addItemToGroceryList(@RequestBody Item item, Authentication auth) {
		User user = (User) auth.getPrincipal();
		item.setUser(user);
		item.setInGrocery(true);
		return itemRepo.save(item);
	}
	
	@GetMapping("/{id}")
	public Item getDetailsOfGroceryItem(@PathVariable long id) {
		return itemRepo.findOne(id);
	}
	
	@PutMapping("/{id}")
	public Item editGroceryItem(@PathVariable long id, @RequestBody Item item) {
		item.setInGrocery(true);
		item.setId(id);
		return itemRepo.save(item);
	}
	
	@DeleteMapping("/{id}")
	public Item deleteItemFromGroceryList(@PathVariable long id) {
		Item item = itemRepo.findOne(id);
		itemRepo.delete(id);
		return item;
	}
	
	@PostMapping("/{id}/fridge")
	public Item moveAGroceryItemToFridge(@RequestBody Item fridgeItem, @PathVariable long id) {
		Item item = itemRepo.findOne(id);
		item.setInFridge(true);
		item.setInGrocery(false);
		return itemRepo.save(item);
	}
	
	@PostMapping("/mail")
	public String emailGroceryList(@RequestBody GroceryEmail email, Authentication auth) throws UnirestException {
		User user = (User) auth.getPrincipal();
		email.setGroceryUsername(user.getFirstName());
		email.setEmailSubject(email.getGroceryUsername() +"'s grocery list");
		email.setEmailText(email.getGroceryUsername() + " has sent a grocery list!");
		
		List<Item> groceryItems = itemRepo.findByInGroceryTrueAndUserIdEquals(user.getId());
		String response = "There are no items in the grocery list - No email sent";
		
		if (groceryItems.size() > 0) {
			String html = "<ul>";
			for(Item item: groceryItems) {
				html += "<li>" + item.getName() + " - " + item.getQuantity() + "</li>";
			}
			html += "</ul>";
			
			email.setEmailHtml(html);
			MailService mail = new MailService();
			response = mail.sendMail(email);
		}
		
		return response;
	}
}
