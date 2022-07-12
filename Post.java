package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name = "BlogPost")
public class Post {
	
	    // Each @Entity needs an @Id - this is the primary key in the database.
		private @Id @GeneratedValue Long postID; // @Id means primary key
		private String title;
		private String userName;
		private String postDate;
		private String bodyOfPost;
		private String dateOfExpiry;
		
		Post(){}
		
		public Post(Long postID, String title, String userName, String postDate, String bodyOfPost, String dateOfExpiry) {
			super();
			this.postID = postID;
			this.title = title;
			this.userName = userName;
			this.postDate = postDate;
			this.bodyOfPost = bodyOfPost;
			this.dateOfExpiry = dateOfExpiry;
		}

		
		
}
