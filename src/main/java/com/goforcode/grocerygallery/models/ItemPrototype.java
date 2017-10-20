package com.goforcode.grocerygallery.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class ItemPrototype {

	@Id
	@GeneratedValue(generator = "PrototypeIdSeq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "PrototypeIdSeq", sequenceName = "PrototypeIdSeq")
	private Long id;
	
	private String name;
	
	private Integer daysUntilExpired;
	
	@OneToMany(mappedBy="description")
	private List<FridgeItem> fridgeItems;
	
	@OneToMany(mappedBy="description")
	private List<GroceryListItem> groceryListItems;
	
	public ItemPrototype() {}
	
	public ItemPrototype(String name, Integer daysUntilExpired) {
		this.name = name;
		this.daysUntilExpired = daysUntilExpired;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getDaysUntilExpired() {
		return daysUntilExpired;
	}

	public void setDaysUntilExpired(Integer daysUntilExpired) {
		this.daysUntilExpired = daysUntilExpired;
	}
	
}
