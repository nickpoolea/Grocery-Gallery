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

public class ItemReference {

	@Id
	@GeneratedValue(generator = "ItemReferenceIdSeq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "ItemReferenceIdSeq", sequenceName = "ItemReferenceIdSeq")
	private Long id;

	@Column(length = 255, nullable = false)
	private String name;
	
	@Column(length = 20, nullable = false)
	private int shelfLife;

	public ItemReference() {
	}

	
	public ItemReference(String name, int shelfLife) {
		this.name = name.toLowerCase();
		this.shelfLife = shelfLife;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name.toLowerCase();
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getShelfLife() {
		return shelfLife;
	}


	public void setShelfLife(int shelfLife) {
		this.shelfLife = shelfLife;
	}

}
