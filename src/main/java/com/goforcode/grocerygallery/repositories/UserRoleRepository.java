package com.goforcode.grocerygallery.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.goforcode.grocerygallery.models.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
	
	List<UserRole> findByNameEquals(String name);

}
