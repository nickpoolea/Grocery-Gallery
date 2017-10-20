package com.goforcode.grocerygallery;

import java.text.ParseException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.goforcode.grocerygallery.configuration.SeedData;
import com.goforcode.grocerygallery.repositories.FridgeItemRepository;
import com.goforcode.grocerygallery.repositories.GroceryListItemRepository;
import com.goforcode.grocerygallery.repositories.ItemPrototypeRepository;
import com.goforcode.grocerygallery.repositories.UserRepository;

@SpringBootApplication
public class GroceryGalleryApplication {
	
	private static UserRepository userRepo;
	private static PasswordEncoder encoder;
	private static ItemPrototypeRepository prototypeRepo;
	private static GroceryListItemRepository groceryRepo;
	private static FridgeItemRepository fridgeRepo;
	
	public GroceryGalleryApplication(UserRepository userRepo, PasswordEncoder encoder, ItemPrototypeRepository prototypeRepo,
			GroceryListItemRepository groceryRepo, FridgeItemRepository fridgeRepo) {
		this.userRepo = userRepo;
		this.encoder = encoder;
		this.prototypeRepo = prototypeRepo;
		this.fridgeRepo = fridgeRepo;
		this.groceryRepo = groceryRepo;
	}

	public static void main(String[] args) throws ParseException {
		SpringApplication.run(GroceryGalleryApplication.class, args);	
		SeedData sd = new SeedData(userRepo, prototypeRepo, encoder, groceryRepo, fridgeRepo);
		sd.create();
		
	}
}
