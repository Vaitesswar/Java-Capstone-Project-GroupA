package com.engage.ContentManagement.entities;


import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

@Entity 
@Where(clause="expired=false")
public class Post {
	
	    // Each @Entity needs an @Id - this is the primary key in the database.
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Id// @Id means primary key
		private int id;
		
		@Column(nullable = false)
		private String title;
		
		@Column(nullable = false)
		private String userName;

		@Column(nullable = false)
		private String bodyOfPost;
		
		@Column(nullable = false)
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		private LocalDate dateOfPost;
		
		@Column
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		private LocalDate dateOfExpiry;
		
		@Column(nullable = false)
		private boolean expired;
		
		@ManyToMany(mappedBy = "postsOfHashtags")
		private List<Hashtag> hashtagsOfPosts;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public LocalDate getDateOfPost() {
			return dateOfPost;
		}

		public void setDateOfPost(LocalDate dateOfPost) {
			this.dateOfPost = dateOfPost;
		}

		public String getBodyOfPost() {
			return bodyOfPost;
		}

		public void setBodyOfPost(String bodyOfPost) {
			this.bodyOfPost = bodyOfPost;
		}

		public LocalDate getDateOfExpiry() {
			return dateOfExpiry;
		}

		public void setDateOfExpiry(LocalDate dateOfExpiry) {
			this.dateOfExpiry = dateOfExpiry;
		}

		public List<Hashtag> getHashtagsOfPosts() {
			return hashtagsOfPosts;
		}

		public void setHashtagsOfPosts(List<Hashtag> hashtagsOfPosts) {
			this.hashtagsOfPosts = hashtagsOfPosts;
		}

		
		
}