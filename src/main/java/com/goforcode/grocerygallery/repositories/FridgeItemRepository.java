package com.goforcode.grocerygallery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.goforcode.grocerygallery.models.FridgeItem;

@Repository
public interface FridgeItemRepository extends JpaRepository<FridgeItem, Long> {

}
