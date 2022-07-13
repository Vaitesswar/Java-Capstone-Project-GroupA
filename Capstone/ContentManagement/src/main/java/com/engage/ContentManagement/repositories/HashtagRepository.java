package com.engage.ContentManagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.engage.ContentManagement.entities.Hashtag;

//For CRUD operations
@Repository
public interface HashtagRepository extends JpaRepository<Hashtag, Integer>{
	
	Hashtag findByHashtag(String hashtag);
}
