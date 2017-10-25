package com.goforcode.grocerygallery.models;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;
//import org.joda.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
// @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
// property = "id")
public class Item {

	@Id
	@GeneratedValue(generator = "ItemIdSeq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "ItemIdSeq", sequenceName = "ItemIdSeq")
	private Long id;

	@Column(length = 255, nullable = false)
	private String name;

	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(length = 20)
	private Date purchasedDate;

	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(length = 20)
	private Date trashDate;

	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(length = 20)
	private Date expirationDate;

	private boolean inFridge;

	private boolean inGrocery;

	private boolean wasWasted;

	private boolean wasFinished;

	private int level;

	private int quantity;

	@JsonIgnore
	@ManyToOne
	private User user;

	public Item() {
	}

	public Item(String name) {
		this.name = name;
	}

	public Item(String name, Date purchasedDate, Date expirationDate) {
		this.name = name;
		this.purchasedDate = purchasedDate;
		this.expirationDate = expirationDate;
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

	public Date getPurchasedDate() {
		return purchasedDate;
	}

	public void setPurchasedDate(Date purchasedDate) {
		this.purchasedDate = purchasedDate;
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
		
		if (inFridge) {
			setInGrocery(false);
			setWasWasted(false);
			setWasFinished(false);
		}
	}

	public boolean isInGrocery() {
		return inGrocery;
	}

	public void setInGrocery(boolean inGrocery) {
		this.inGrocery = inGrocery;
		
		if (inGrocery) {
			setInFridge(false);
			setWasWasted(false);
			setWasFinished(false);
		}
	}

	public boolean isWasWasted() {
		return wasWasted;
	}

	public void setWasWasted(boolean wasWasted) {
		this.wasWasted = wasWasted;
		
		if (wasWasted) {
			setInGrocery(false);
			setInFridge(false);
			setWasFinished(false);
		}
	}

	public boolean isWasFinished() {
		return wasFinished;
	}

	public void setWasFinished(boolean wasFinished) {
		this.wasFinished = wasFinished;
		
		if (wasFinished) {
			setInGrocery(false);
			setInFridge(false);
			setWasWasted(false);
		}
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public double getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public void setInFridgeAndInGrocery() {
		this.inFridge = true;
		this.inGrocery = true;
		this.wasWasted = false;
		this.wasFinished = false;
	}
	
	public int calculateLevel() {

		Date currentDate = new Date();

		Calendar currDate = Calendar.getInstance();
		Calendar purchDate = Calendar.getInstance();
		Calendar expiryDate = Calendar.getInstance();
		currDate.setTime(currentDate);

		if(getPurchasedDate() != null ) {
			purchDate.setTime(getPurchasedDate());
		}
		else {
			purchDate.setTime(new Date());
		}
		
		if(getExpirationDate() != null ) {
			expiryDate.setTime(getExpirationDate());
		}
		else {	 
			expiryDate.add(Calendar.DATE, 7);	
		}

		double daysBetweenfirst = currDate.get(Calendar.DAY_OF_YEAR) - purchDate.get(Calendar.DAY_OF_YEAR);

		double daysBetweenSecond = expiryDate.get(Calendar.DAY_OF_YEAR) - purchDate.get(Calendar.DAY_OF_YEAR);

		double levelPercentage = daysBetweenfirst / daysBetweenSecond;

		if (levelPercentage <= 0.33) {
			this.setLevel(1);
		} else if (levelPercentage <= 0.55 && levelPercentage > 0.33) {
			this.setLevel(2);
		} else if (levelPercentage <= 0.99 && levelPercentage > 0.55) {
			this.setLevel(3);
		}
		else {
			this.setLevel(4);
		}

		return this.level;
	}
}
