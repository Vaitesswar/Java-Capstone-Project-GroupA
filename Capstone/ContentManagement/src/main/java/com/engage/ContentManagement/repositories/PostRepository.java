package com.engage.ContentManagement.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.engage.ContentManagement.entities.Post;

//For CRUD operations
@Repository
public interface PostRepository extends JpaRepository<Post, Integer>{
	
	@Query("SELECT p FROM Post p "
			+ "WHERE MONTH(p.dateOfPost) = ?1")
	List<Post> getByMonth(int month);
}
