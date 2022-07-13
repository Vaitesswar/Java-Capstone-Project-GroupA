package com.engage.ContentManagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.engage.ContentManagement.entities.Category;

//For CRUD operations
@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{

	Category findByCategory(String category);
}
