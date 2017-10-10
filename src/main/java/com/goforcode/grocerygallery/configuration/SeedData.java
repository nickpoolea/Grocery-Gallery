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
				
		User priya = new User("Priya@gmail.com", "password");
		userRepo.save(priya);
		
		Item brocolli = new Item("Brocolli");
		brocolli.setUser(priya);
		brocolli.setInFridge(true);
		itemRepo.save(brocolli);
		
		Item milk = new Item("Mik");
		milk.setUser(priya);
		milk.setInFridge(true);
		itemRepo.save(milk);
		
		Item eggs = new Item("Eggs");
		eggs.setUser(priya);
		eggs.setInGrocery(true);
		itemRepo.save(eggs);
		
		Item chickenFeet = new Item("Chicken Feet");
		chickenFeet.setUser(priya);
		chickenFeet.setInGrocery(true);
		itemRepo.save(chickenFeet);
		
		Item lettuce = new Item("Lettuce");
		lettuce.setWasFinished(true);
		lettuce.setInGrocery(true);
		itemRepo.save(lettuce);
		
		Item apples = new Item("Apples");
		apples.setWasWasted(true);
		apples.setInGrocery(true);
		itemRepo.save(apples);
		
	}
	
}
