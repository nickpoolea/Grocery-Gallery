package com.goforcode.grocerygallery.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.goforcode.grocerygallery.models.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
	List<Item> findByInGroceryIsTrue();

}
