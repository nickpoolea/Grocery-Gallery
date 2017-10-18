package com.goforcode.grocerygallery.models;

import javax.persistence.Entity;

@Entity
public class ItemPrototype {

	private Long id;
	
	private String name;
	
	private Integer daysUntilExpired;

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
