package com.goforcode.grocerygallery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.goforcode.grocerygallery.models.ItemPrototype;

@Repository
public interface ItemPrototypeRepository extends JpaRepository<ItemPrototype, Long> {
	
	ItemPrototype findByNameEquals(String name);
	
}
