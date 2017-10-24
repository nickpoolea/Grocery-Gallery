package com.goforcode.grocerygallery.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.goforcode.grocerygallery.models.Item;
import com.goforcode.grocerygallery.models.ItemReference;

@Repository
public interface ItemReferenceRepository extends JpaRepository<ItemReference, Long> {
	
	//Make sure the user owns the item before editing
	Item findById(long itemId);

	List<ItemReference> findByNameLike(String name);
	
	
	

}
