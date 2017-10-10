package com.goforcode.grocerygallery;

import java.text.ParseException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.goforcode.grocerygallery.configuration.SeedData;
import com.goforcode.grocerygallery.repositories.ItemRepository;
import com.goforcode.grocerygallery.repositories.UserRepository;

@SpringBootApplication
public class GroceryGalleryApplication {
	
	private static UserRepository userRepo;
	private static ItemRepository itemRepo;
	
	public GroceryGalleryApplication(UserRepository userRepo, ItemRepository itemRepo) {
		this.userRepo = userRepo;
		this.itemRepo = itemRepo;
	}

	public static void main(String[] args) throws ParseException {
		SpringApplication.run(GroceryGalleryApplication.class, args);
		
		SeedData sd = new SeedData(userRepo, itemRepo);
		sd.create();
	}
}
