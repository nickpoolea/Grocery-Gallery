package com.goforcode.grocerygallery.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Item {

	@Id
	@GeneratedValue(generator = "ItemIdSeq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "ItemIdSeq", sequenceName = "ItemIdSeq")
	private Long id;

	@Column(length = 255, nullable = false)
	private String name;

	@Column(length = 255)
	private String category;

	@Column(length = 20)
	private Date addedDate;

	@Column(length = 20)
	private Date trashDate;

	@Column(length = 20)
	private Date expirationDate;

	private boolean inFridge;

	private boolean inGrocery;

	private boolean wasWasted;

	private boolean wasFinished;
	
	@ManyToOne
	private User user;
	
	public Item() {}

	public Item(String name) {
		this.name = name;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Date getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}

	public Date getTrashDate() {
		return trashDate;
	}

	public void setTrashDate(Date trashDate) {
		this.trashDate = trashDate;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public boolean isInFridge() {
		return inFridge;
	}

	public void setInFridge(boolean inFridge) {
		this.inFridge = inFridge;
	}

	public boolean isInGrocery() {
		return inGrocery;
	}

	public void setInGrocery(boolean inGrocery) {
		this.inGrocery = inGrocery;
	}

	public boolean isWasWasted() {
		return wasWasted;
	}

	public void setWasWasted(boolean wasWasted) {
		this.wasWasted = wasWasted;
	}

	public boolean isWasFinished() {
		return wasFinished;
	}

	public void setWasFinished(boolean wasFinished) {
		this.wasFinished = wasFinished;
	}

}
