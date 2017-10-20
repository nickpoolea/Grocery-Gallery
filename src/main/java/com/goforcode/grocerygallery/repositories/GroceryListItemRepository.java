package com.goforcode.grocerygallery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.goforcode.grocerygallery.models.GroceryListItem;

@Repository
public interface GroceryListItemRepository extends JpaRepository<GroceryListItem, Long> {

}
