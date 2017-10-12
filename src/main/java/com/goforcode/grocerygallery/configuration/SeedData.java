package com.goforcode.grocerygallery.configuration;

import java.text.ParseException;
import java.text.SimpleDateFormat;

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

	public void create() throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		 
				
		User priya = new User("Priya@gmail.com", "password");
		userRepo.save(priya);
		
		Item brocolli = new Item("Brocolli", "Produce", sdf.parse("10/1/2017"), sdf.parse("10/20/2017"));
		brocolli.setUser(priya);
		brocolli.setInFridge(true);
		brocolli.setLevel(brocolli.calculateLevel());
		System.out.println("Broccoli level is: " + brocolli.getLevel());
		itemRepo.save(brocolli);
		
		Item milk = new Item("Mik", "Eggs/Dairy", sdf.parse("10/2/2017"), sdf.parse("10/18/2017"));
		milk.setUser(priya);
		milk.setInFridge(true);
		milk.setLevel(milk.calculateLevel());
		System.out.println("Milk level is: " + milk.getLevel());
		itemRepo.save(milk);
		
		Item eggs = new Item("Eggs", "Eggs/Dairy", sdf.parse("10/3/2017"), sdf.parse("10/21/2017"));
		eggs.setUser(priya);
		eggs.setInGrocery(true);
		eggs.setLevel(eggs.calculateLevel());
		System.out.println("Eggs level is: " + eggs.getLevel());
		itemRepo.save(eggs);
		
		Item chickenFeet = new Item("Chicken Feet", "Eggs/Dairy", sdf.parse("10/4/2017"), sdf.parse("10/22/2017"));
		chickenFeet.setUser(priya);
		chickenFeet.setInGrocery(true);
		chickenFeet.setLevel(chickenFeet.calculateLevel());
		System.out.println("Chicken feet level is: " + chickenFeet.getLevel());
		itemRepo.save(chickenFeet);
		
		Item lettuce = new Item("Lettuce", "Produce", sdf.parse("10/3/2017"), sdf.parse("10/21/2017"));
		lettuce.setUser(priya);
		lettuce.setTrashDate(sdf.parse("10/10/2017"));
		lettuce.setWasFinished(true);
		lettuce.setLevel(lettuce.calculateLevel());
		System.out.println("Lettuce level is: " + lettuce.getLevel());
		itemRepo.save(lettuce);
		
		Item apples = new Item("Apples", "Produce", sdf.parse("10/5/2017"), sdf.parse("10/29/2017"));
		apples.setUser(priya);
		apples.setTrashDate(sdf.parse("10/10/2017"));
		apples.setWasWasted(true);
		apples.setLevel(apples.calculateLevel());
		System.out.println("apples level is: " + apples.getLevel());
		itemRepo.save(apples);
		
		Item ketchup = new Item("Ketchup", "Condiments", sdf.parse("10/1/2017"), sdf.parse("12/1/2017"));
		ketchup.setUser(priya);
		ketchup.setInFridge(true);
		ketchup.setLevel(ketchup.calculateLevel());
		System.out.println("Ketchup level is: " + ketchup.getLevel());
//		System.out.println("Ketchup level is: " + ketchup.calculateLevel());
		itemRepo.save(ketchup);
		
		Item bread = new Item("Bread", "Grains/Nuts", sdf.parse("10/1/2017"), sdf.parse("12/30/2017"));
		bread.setUser(priya);
		bread.setInFridge(true);
		bread.setLevel(bread.calculateLevel());
		System.out.println("Bread level is: " + bread.getLevel());
//		System.out.println("Bread level is: " + bread.calculateLevel());
		itemRepo.save(bread);
		
		Item lemon = new Item("Lemon", "Produce", sdf.parse("10/09/2017"), sdf.parse("10/12/2017"));
		lemon.setUser(priya);
		lemon.setInFridge(true);
		lemon.setLevel(lemon.calculateLevel());
		System.out.println("Lemon level is: " + lemon.getLevel());
		itemRepo.save(lemon);
		
		Item onion = new Item("Onions", "Produce", sdf.parse("10/6/2017"), sdf.parse("10/30/2017"));
		onion.setUser(priya);
		onion.setTrashDate(sdf.parse("10/10/2017"));
		onion.setWasWasted(true);
		onion.setLevel(onion.calculateLevel());
		System.out.println("Onion level is: " + onion.getLevel());
		itemRepo.save(onion);
		
		Item potatoes = new Item("Potatoes", "Produce", sdf.parse("10/20/2017"), sdf.parse("12/31/2017"));
		potatoes.setUser(priya);
		potatoes.setTrashDate(sdf.parse("10/10/2017"));
		potatoes.setWasWasted(true);
		potatoes.setLevel(potatoes.calculateLevel());
		System.out.println("Potato level is: " + potatoes.getLevel());
		itemRepo.save(potatoes);
		
		
		
		
		
	}
	
}
