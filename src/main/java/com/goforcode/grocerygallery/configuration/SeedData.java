package com.goforcode.grocerygallery.configuration;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.goforcode.grocerygallery.models.Item;
import com.goforcode.grocerygallery.models.User;
import com.goforcode.grocerygallery.repositories.ItemRepository;
import com.goforcode.grocerygallery.repositories.UserRepository;

public class SeedData {
	
	private UserRepository userRepo;
	private ItemRepository itemRepo;
	private PasswordEncoder encoder;
	
	public SeedData(UserRepository userRepo, ItemRepository itemRepo, PasswordEncoder encoder) {
		this.userRepo = userRepo;
		this.itemRepo = itemRepo;
		this.encoder = encoder;
	}

	public void create() throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		 
				
		User priya = new User("Priya", "Prabhakar", "Priya@gmail.com", encoder.encode("password"), "USER");
		userRepo.save(priya);
		
		Item brocolli = new Item("Broccolli", sdf.parse("10/1/2017"), sdf.parse("10/20/2017"));
		brocolli.setUser(priya);
		brocolli.setInFridge(true);
		brocolli.setLevel(brocolli.calculateLevel());
		itemRepo.save(brocolli);
		
		Item milk = new Item("Milk",  sdf.parse("10/2/2017"), sdf.parse("10/18/2017"));
		milk.setUser(priya);
		milk.setInFridge(true);
		milk.setLevel(milk.calculateLevel());
		itemRepo.save(milk);
		
		Item eggs = new Item("Eggs");
		eggs.setUser(priya);
		eggs.setInGrocery(true);
		eggs.setQuantity(6);
		eggs.setLevel(eggs.calculateLevel());
		eggs.setInFridge(true);
		itemRepo.save(eggs);
		
		Item chickenFeet = new Item("Chicken Feet", sdf.parse("10/4/2017"), sdf.parse("10/22/2017"));
		chickenFeet.setUser(priya);
		chickenFeet.setInGrocery(true);
		chickenFeet.setQuantity(25);
		chickenFeet.setLevel(chickenFeet.calculateLevel());
		itemRepo.save(chickenFeet);
		
		Item lettuce = new Item("Lettuce", sdf.parse("10/3/2017"), sdf.parse("10/21/2017"));
		lettuce.setUser(priya);
		lettuce.setTrashDate(sdf.parse("10/10/2017"));
		lettuce.setWasFinished(true);
		lettuce.setLevel(lettuce.calculateLevel());
		itemRepo.save(lettuce);
		
		Item apples = new Item("Apples", sdf.parse("10/5/2017"), sdf.parse("10/29/2017"));
		apples.setUser(priya);
		apples.setTrashDate(sdf.parse("10/10/2017"));
		apples.setWasWasted(true);
		apples.setLevel(apples.calculateLevel());
		itemRepo.save(apples);
		
		Item ketchup = new Item("Ketchup", sdf.parse("10/1/2017"), sdf.parse("12/1/2017"));
		ketchup.setUser(priya);
		ketchup.setInFridge(true);
		ketchup.setLevel(ketchup.calculateLevel());
		itemRepo.save(ketchup);
		
		Item bread = new Item("Bread", sdf.parse("10/1/2017"), sdf.parse("12/30/2017"));
		bread.setUser(priya);
		bread.setInFridge(true);
		bread.setLevel(bread.calculateLevel());
		itemRepo.save(bread);
		
		Item lemon = new Item("Lemon", sdf.parse("10/09/2017"), sdf.parse("10/12/2017"));
		lemon.setUser(priya);
		lemon.setInFridge(true);
		lemon.setLevel(lemon.calculateLevel());
		itemRepo.save(lemon);
		
		Item onion = new Item("Onions", sdf.parse("10/6/2017"), sdf.parse("10/30/2017"));
		onion.setUser(priya);
		onion.setTrashDate(sdf.parse("10/10/2017"));
		onion.setWasWasted(true);
		onion.setLevel(onion.calculateLevel());
		itemRepo.save(onion);
		
		Item potatoes = new Item("Potatoes", sdf.parse("10/20/2017"), sdf.parse("12/31/2017"));
		potatoes.setUser(priya);
		potatoes.setTrashDate(sdf.parse("10/13/2017"));
		potatoes.setWasWasted(true);
		potatoes.setLevel(potatoes.calculateLevel());
		itemRepo.save(potatoes);		
	}
	
}
