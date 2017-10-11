package com.goforcode.grocerygallery.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.goforcode.grocerygallery.models.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
	
	//Returns list of everything that was wasted in trash
	List<Item> findByWasWastedTrue();
	
	//Returns list of everything that was finished in trash
	List<Item> findByWasFinishedTrue();	
	
	//Returns list of everything in the trash
	List<Item> findByWasWastedTrueAndWasFinishedTrue();
	
	//Return All grocery items
	List<Item> findByInGroceryTrue();

	//Returns all fridge items
	List<Item> findByInFridgeTrue();

}
