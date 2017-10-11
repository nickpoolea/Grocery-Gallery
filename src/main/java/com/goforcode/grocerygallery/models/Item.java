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

	@Column(length = 255)
	private String category;

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

	public Item(String name, String category, Date purchasedDate, Date expirationDate) {
		this.name = name;
		this.category = category;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Date getpurchasedDate() {
		return purchasedDate;
	}

	public void setpurchasedDate(Date purchasedDate) {
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

	public int calculateLevel() {

		Date currentDate = new Date();

		Calendar currDate = Calendar.getInstance();
		Calendar purchDate = Calendar.getInstance();
		Calendar expiryDate = Calendar.getInstance();
		currDate.setTime(currentDate);

		purchDate.setTime(getpurchasedDate());

		expiryDate.setTime(getExpirationDate());

		double daysBetweenfirst = currDate.get(Calendar.DAY_OF_YEAR) - purchDate.get(Calendar.DAY_OF_YEAR);

		double daysBetweenSecond = expiryDate.get(Calendar.DAY_OF_YEAR) - purchDate.get(Calendar.DAY_OF_YEAR);

		System.out.println("daysBetweenFIRST is: " + daysBetweenfirst);
		System.out.println("daysBetweenSECOND is: " + daysBetweenSecond);

		double levelPercentage = daysBetweenfirst / daysBetweenSecond;
		System.out.println("Level % is: " + levelPercentage);

		if (levelPercentage <= 0.33) {
			this.setLevel(1);
		} else if (levelPercentage < 0.50 && levelPercentage > 0.33) {
			this.setLevel(2);
		} else {
			this.setLevel(3);
		}

		return this.level;
	}

}
