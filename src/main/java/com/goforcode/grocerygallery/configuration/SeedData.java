package com.goforcode.grocerygallery.configuration;

import com.goforcode.grocerygallery.models.Item;
import com.goforcode.grocerygallery.models.User;
import com.goforcode.grocerygallery.repositories.ItemRepository;
import com.goforcode.grocerygallery.repositories.UserRepository;

public class SeedData {
	
	private UserRepository userRepo;
	private ItemRepository itemRepo;
	
	public SeedData(UserRepository userRepo, ItemRepository itemRepo) {
		this.userRepo = userRepo;
		this.itemRepo = itemRepo;
	}

	public void create() {
		
		Item brocolli = new Item("Brocolli");
		itemRepo.save(brocolli);
		Item milk = new Item("Mik");
		Item eggs = new Item("Eggs");
		Item chickenFeet = new Item("Chicken Feet");
		
		User user = new User("Priya@gmail.com", "password");
		userRepo.save(user);
		
		user = new User("Tania@gmail.com", "password");
		userRepo.save(user);
		
		user = new User("Nick@gmail.com", "password");
		userRepo.save(user);
		
		
		
		
	}
	
}
