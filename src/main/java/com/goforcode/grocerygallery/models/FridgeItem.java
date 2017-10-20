package com.goforcode.grocerygallery.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class FridgeItem {

	@Id
	@GeneratedValue(generator = "FridgeItemIdSeq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "FridgeItemIdSeq", sequenceName = "FridgeItemIdSeq")
	private Long id;
	
	@ManyToOne
	private ItemPrototype description;
	
	private Date purchaseDate;
	
	private Date expirationDate;
	
	private FridgeItemStatus status;
	
	@ManyToOne
	private User user;
	
	public FridgeItem() {
		status = FridgeItemStatus.CONSUMABLE;
	}
	
	public FridgeItem(ItemPrototype description, Date purchaseDate, Date expirationDate, User user) {
		this.description = description;
		this.purchaseDate = purchaseDate;
		this.expirationDate = expirationDate;
		this.user = user;
		status = FridgeItemStatus.CONSUMABLE;
	}
	
	public void throwInWasteBin() {
		status = FridgeItemStatus.WASTED;
	}
	
	public void throwInRecycleBin() {
		status = FridgeItemStatus.FINISHED;
	}
	
	public void markAsSpoiled() {
		status = FridgeItemStatus.SPOILED;
	}
	
	public int calculateLevel() {
		if (this.expirationDate != null) {
			// Calculate freshness based on the user supplied expiration
		} else if (this.description.getDaysUntilExpired() != null) {
			// Calculate freshness based on the general idea of the thing
		}
		return 0;
	}
	
	public String getName() {
		return description.getName();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ItemPrototype getDescription() {
		return description;
	}

	public void setDescription(ItemPrototype description) {
		this.description = description;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public FridgeItemStatus getStatus() {
		return status;
	}

	public void setStatus(FridgeItemStatus status) {
		this.status = status;
	}
	
	private enum FridgeItemStatus {
		CONSUMABLE,
		WASTED,
		FINISHED,
		SPOILED
	}
	
}
