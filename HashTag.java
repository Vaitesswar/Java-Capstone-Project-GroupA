package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name = "HashTag")
public class HashTag {
	
	 // Each @Entity needs an @Id - this is the primary key in the database.
	private @Id @GeneratedValue Long hashTagID; // @Id means primary key
	private String hashTag;

	
	HashTag(){}
	
	public HashTag(Long hashTagID, String hashTag) {
		super();
		this.hashTagID = hashTagID;
		this.hashTag = hashTag;
	}
}
