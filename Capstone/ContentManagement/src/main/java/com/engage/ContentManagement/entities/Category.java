package com.engage.ContentManagement.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity 
public class Category {

	 // Each @Entity needs an @Id - this is the primary key in the database.
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id // @Id means primary key
	private int id;
	
	@Column(nullable = false)
	private String category;

	@ManyToMany(mappedBy = "categoriesOfHashtag")
	private List<Hashtag> hashtagsOfCategory;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public List<Hashtag> getHashtagsOfCategory() {
		return hashtagsOfCategory;
	}

	public void setHashtagsOfCategory(List<Hashtag> hashtagsOfCategory) {
		this.hashtagsOfCategory = hashtagsOfCategory;
	}

}