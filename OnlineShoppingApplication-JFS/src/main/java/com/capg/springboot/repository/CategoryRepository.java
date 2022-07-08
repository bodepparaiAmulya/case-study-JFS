package com.capg.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.springboot.entity.Category;

public interface CategoryRepository extends JpaRepository<Category,String> {
	Category findByCatId(String catId);
}
