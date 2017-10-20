package com.goforcode.grocerygallery.configuration;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.goforcode.grocerygallery.models.FridgeItem;
import com.goforcode.grocerygallery.models.GroceryListItem;
import com.goforcode.grocerygallery.models.ItemPrototype;
import com.goforcode.grocerygallery.models.User;
import com.goforcode.grocerygallery.repositories.FridgeItemRepository;
import com.goforcode.grocerygallery.repositories.GroceryListItemRepository;
import com.goforcode.grocerygallery.repositories.ItemPrototypeRepository;
import com.goforcode.grocerygallery.repositories.UserRepository;

public class SeedData {
	
	private UserRepository userRepo;
	private ItemPrototypeRepository prototypeRepo;
	private PasswordEncoder encoder;
	private GroceryListItemRepository groceryRepo;
	private FridgeItemRepository fridgeRepo;
	
	public SeedData(UserRepository userRepo, ItemPrototypeRepository prototypeRepo, PasswordEncoder encoder,
					GroceryListItemRepository groceryRepo, FridgeItemRepository fridgeRepo) {
		this.userRepo = userRepo;
		this.prototypeRepo = prototypeRepo;
		this.encoder = encoder;
		this.groceryRepo = groceryRepo;
		this.fridgeRepo = fridgeRepo;
	}

	public void create() throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
				
		User priya = new User("Priya", "Prabhakar", "Priya@gmail.com", encoder.encode("password"), "USER");
		userRepo.save(priya);
		
		ItemPrototype item = new ItemPrototype("Broccoli", 16);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Carrots", 11);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Cauliflower", 8);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Celery", 14);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Corn", 17);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Cucumbers", 3);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Lettuce / Greens", 10);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Mushrooms", 6);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Onions", 19);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Peppers", 17);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Potatoes", 19);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Spinach", 2);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Squash", 13);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Zucchini", 15);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Tomatoes*", 9);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("BBQ sauce", 19);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Gravy", 16);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Honey", 3);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Hot sauce", 2);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Jam / Jelly / Preserves", 20);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Ketchup / Mustard", 2);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Mayonnaise", 3);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Pasta sauce", 6);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Relish", 4);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Salad dressing", 19);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Salsa", 9);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Soy sauce", 17);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Steak sauce", 9);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Syrup", 16);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Worcestershire sauce", 13);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Butter / Margarine", 10);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Cottage cheese", 19);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Half & half", 4);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Milk", 15);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Sour cream", 14);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Whipped cream", 15);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Yogurt", 4);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Bagels / Croissants", 20);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Buns / Rolls", 6);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Cake / Cookies", 6);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Donuts / Pastries", 7);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Fresh bread", 7);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Pie! Pie! Pie!", 11);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Pita bread", 5);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Sliced bread", 14);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Antiperspirant / Deodorant", 17);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Bath soap / Hand soap", 18);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Condoms / Other b.c.", 2);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Cosmetics", 20);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Cotton swabs / Balls", 19);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Facial cleanser", 8);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Facial tissue", 5);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Feminine products", 8);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Floss", 11);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Hair gel / Spray", 11);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Lip balm", 4);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Moisturizing lotion", 18);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Mouthwash", 9);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Razors / Shaving cream", 6);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Shampoo / Conditioner", 4);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Sunblock", 11);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Toilet paper", 11);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Toothpaste", 13);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Vitamins / Supplements", 7);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Air freshener", 4);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Bathroom cleaner", 11);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Bleach / Detergent", 5);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Dish / Dishwasher soap", 8);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Garbage bags", 3);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Glass cleaner", 13);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Mop head / Vacuum bags", 20);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Sponges / Scrubbers", 12);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Apples", 19);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Avocados", 10);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Bananas", 8);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Berries", 8);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Cherries", 16);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Grapefruit", 16);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Grapes", 11);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Kiwis", 16);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Lemons / Limes", 8);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Melon", 13);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Nectarines", 15);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Oranges", 16);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Peaches", 12);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Pears", 14);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Plums", 14);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Bagels", 6);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Chip dip", 6);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Eggs / Fake eggs", 5);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("English muffins", 15);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Fruit juice", 19);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Hummus", 2);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Ready-bake breads", 13);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Tofu", 3);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Tortillas", 5);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Breakfasts", 5);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Burritos", 14);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Fish sticks", 19);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Fries / Tater tots", 18);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Ice cream / Sorbet", 6);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Juice concentrate", 9);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Pizza", 8);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Pizza Rolls", 6);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Popsicles", 19);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("TV dinners", 2);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Vegetables", 9);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Bouillon cubes", 7);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Cereal", 18);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Coffee / Filters", 8);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Instant potatoes", 9);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Lemon / Lime juice", 4);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Mac & cheese", 13);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Olive oil", 18);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Packaged meals", 4);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Pancake / Waffle mix", 10);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Pasta", 8);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Peanut butter", 7);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Pickles", 17);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Rice", 17);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Tea", 17);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Vegetable oil", 2);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Vinegar", 11);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Applesauce", 8);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Baked beans", 7);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Broth", 17);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Fruit", 10);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Olives", 13);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Tinned meats", 9);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Tuna / Chicken", 15);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Soup / Chili", 12);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Tomatoes", 17);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Veggies", 4);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Basil", 16);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Black pepper", 16);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Cilantro", 10);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Cinnamon", 7);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Garlic", 7);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Ginger", 16);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Mint", 17);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Oregano", 4);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Paprika", 15);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Parsley", 20);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Red pepper", 19);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Salt", 13);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Vanilla extract", 13);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Bleu cheese", 7);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Cheddar", 16);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Cottage cheese", 14);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Cream cheese", 5);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Feta", 9);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Goat cheese", 16);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Mozzarella", 14);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Parmesan", 2);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Provolone", 8);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Ricotta", 11);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Sandwich slices", 18);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Swiss", 8);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Bacon / Sausage", 16);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Beef", 15);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Chicken", 13);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Ground beef / Turkey", 18);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Ham / Pork", 10);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Hot dogs", 7);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Lunchmeat", 17);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Turkey", 12);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Catfish", 18);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Crab", 12);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Lobster", 19);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Mussels", 10);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Oysters", 18);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Salmon", 14);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Shrimp", 14);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Tilapia", 9);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Tuna", 17);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Beer", 16);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Club soda / Tonic", 14);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Champagne", 14);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Gin", 4);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Juice", 20);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Mixers", 12);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Red wine / White wine", 14);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Rum", 8);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Saké", 15);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Soda pop", 6);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Sports drink", 16);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Whiskey", 11);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Vodka", 3);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Baking powder / Soda", 2);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Bread crumbs", 19);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Cake / Brownie mix", 8);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Cake icing / Decorations", 6);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Chocolate chips / Cocoa", 15);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Flour", 8);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Shortening", 14);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Sugar", 4);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Sugar substitute", 2);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Yeast", 3);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Candy / Gum", 5);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Cookies", 20);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Crackers", 12);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Dried fruit", 9);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Granola bars / Mix", 3);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Nuts / Seeds", 13);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Oatmeal", 20);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Popcorn", 20);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Potato / Corn chips", 20);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Pretzels", 20);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Burger night", 3);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Chili night", 5);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Pizza night", 11);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Spaghetti night", 16);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Taco night", 5);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Take-out deli food", 20);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Baby food", 8);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Diapers", 20);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Formula", 15);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Lotion", 20);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Baby wash", 9);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Wipes", 15);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Cat food / Treats", 13);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Cat litter", 12);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Dog food / Treats", 17);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Flea treatment", 5);
		prototypeRepo.save(item);
		
		item = new ItemPrototype("Pet shampoo", 13);
		prototypeRepo.save(item);
		
		GroceryListItem groceryItem = new GroceryListItem(prototypeRepo.findByNameEquals("Broccoli"), 10, priya);
		groceryRepo.save(groceryItem);
		groceryItem = new GroceryListItem(prototypeRepo.findByNameEquals("Carrots"), 3, priya);
		groceryRepo.save(groceryItem);
		groceryItem = new GroceryListItem(prototypeRepo.findByNameEquals("Cauliflower"), 1, priya);
		groceryRepo.save(groceryItem);
		groceryItem = new GroceryListItem(prototypeRepo.findByNameEquals("Celery"), 6, priya);
		groceryRepo.save(groceryItem);
		groceryItem = new GroceryListItem(prototypeRepo.findByNameEquals("Corn"), 10, priya);
		groceryRepo.save(groceryItem);
		groceryItem = new GroceryListItem(prototypeRepo.findByNameEquals("Cucumbers"), 9, priya);
		groceryRepo.save(groceryItem);
		groceryItem = new GroceryListItem(prototypeRepo.findByNameEquals("Lettuce / Greens"), 5, priya);
		groceryRepo.save(groceryItem);
		groceryItem = new GroceryListItem(prototypeRepo.findByNameEquals("Mushrooms"), 5, priya);
		groceryRepo.save(groceryItem);
		groceryItem = new GroceryListItem(prototypeRepo.findByNameEquals("Onions"), 3, priya);
		groceryRepo.save(groceryItem);
		groceryItem = new GroceryListItem(prototypeRepo.findByNameEquals("Peppers"), 3, priya);
		groceryRepo.save(groceryItem);
		groceryItem = new GroceryListItem(prototypeRepo.findByNameEquals("Potatoes"), 8, priya);
		groceryRepo.save(groceryItem);
		groceryItem = new GroceryListItem(prototypeRepo.findByNameEquals("Spinach"), 1, priya);
		groceryRepo.save(groceryItem);
		
		FridgeItem fridgeItem = new FridgeItem(prototypeRepo.findByNameEquals("Apples"), sdf.parse("01/27/17"), sdf.parse("02/07/17"), priya);
		fridgeRepo.save(fridgeItem);
		fridgeItem = new FridgeItem(prototypeRepo.findByNameEquals("Avocados"), sdf.parse("02/10/17"), sdf.parse("02/21/17"), priya);
		fridgeRepo.save(fridgeItem);
		fridgeItem = new FridgeItem(prototypeRepo.findByNameEquals("Bananas"), sdf.parse("01/19/17"), sdf.parse("01/31/17"), priya);
		fridgeRepo.save(fridgeItem);
		fridgeItem = new FridgeItem(prototypeRepo.findByNameEquals("Berries"), sdf.parse("01/12/17"), sdf.parse("01/27/17"), priya);
		fridgeRepo.save(fridgeItem);
		fridgeItem = new FridgeItem(prototypeRepo.findByNameEquals("Cherries"), sdf.parse("01/12/17"), sdf.parse("01/27/17"), priya);
		fridgeRepo.save(fridgeItem);
		fridgeItem = new FridgeItem(prototypeRepo.findByNameEquals("Grapefruit"), sdf.parse("01/09/17"), sdf.parse("01/21/17"), priya);
		fridgeRepo.save(fridgeItem);
		fridgeItem = new FridgeItem(prototypeRepo.findByNameEquals("Grapes"), sdf.parse("02/03/17"), sdf.parse("02/12/17"), priya);
		fridgeRepo.save(fridgeItem);
		fridgeItem = new FridgeItem(prototypeRepo.findByNameEquals("Kiwis"), sdf.parse("02/20/17"), sdf.parse("03/04/17"), priya);
		fridgeRepo.save(fridgeItem);


		

		

		
	}
	
}
