package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name = "Category")
public class Category {

	 // Each @Entity needs an @Id - this is the primary key in the database.
	private @Id @GeneratedValue Long categoryID; // @Id means primary key
	private String category;

	
	Category(){}
	
	public Category(Long categoryID, String category) {
		super();
		this.categoryID = categoryID;
		this.category = category;
	}

}
