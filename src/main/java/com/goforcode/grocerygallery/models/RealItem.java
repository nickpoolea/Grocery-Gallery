package com.goforcode.grocerygallery.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class RealItem {

	private Long id;
	
	@ManyToOne
	private ItemPrototype description;
	
	private Date purchaseDate;
	
	private Date expirationDate;
	
	private RealItemStatus status;
	
	public RealItem() {
		status = RealItemStatus.CONSUMABLE;
	}
	
	public void throwInWasteBin() {
		status = RealItemStatus.WASTED;
	}
	
	public void throwInRecycleBin() {
		status = RealItemStatus.FINISHED;
	}
	
	public int calculateLevel() {
		if (this.expirationDate != null) {
			// Calculate freshness based on the user supplied expiration
		} else if (this.description.getDaysUntilExpired() != null) {
			// Calculate freshness based on the general idea of the thing
		}
	}
	
	public String getName() {
		return description.getName();
	}
	
}
