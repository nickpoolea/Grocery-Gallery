package com.goforcode.grocerygallery.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class GroceryListItem {

	@Id
	@GeneratedValue(generator = "GroceryItemIdSeq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "GroceryItemIdSeq", sequenceName = "GroceryItemIdSeq")
	private long id;
	
	@ManyToOne
	private ItemPrototype description;
	
	private int quantity;
	
	@ManyToOne
	private User user;
	
	public GroceryListItem() {}
	
	public GroceryListItem(ItemPrototype description, int quantity, User user) {
		this.description = description;
		this.quantity = quantity;
		this.user = user;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public ItemPrototype getDescription() {
		return description;
	}

	public void setDescription(ItemPrototype description) {
		this.description = description;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
