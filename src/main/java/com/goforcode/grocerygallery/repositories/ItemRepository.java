package com.goforcode.grocerygallery.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.goforcode.grocerygallery.models.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
	
	//Make sure the user owns the item before editing
	Item findByIdAndUserId(long itemId, long userId);
	
	//Returns list of everything that was wasted in trash
	List<Item> findByWasWastedTrueAndUserIdEqualsOrderByTrashDateDesc(long userId);
	
	//Returns list of everything that was finished in trash
	List<Item> findByWasFinishedTrueAndUserIdEqualsOrderByTrashDateDesc(long userId);	
	
	//Returns list of everything in the trash
	List<Item> findByWasWastedTrueOrWasFinishedTrueAndUserIdEqualsOrderByTrashDateDesc(long userId);
	
	//Return All grocery items
	List<Item> findByInGroceryTrue();
	
	//Return All fridge items
	List<Item> findByInFridgeTrueAndUserIdEquals(long id);

	List<Item> findByInGroceryTrueAndUserIdEquals(long userId);

}
