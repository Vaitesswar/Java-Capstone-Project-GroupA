package com.engage.ContentManagement.entities;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.Where;

@Entity 
public class Hashtag {
	
	 // Each @Entity needs an @Id - this is the primary key in the database.
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id// @Id means primary key
	private int id;
	
	@Column(nullable = false)
	private String hashtag;
	
	@ManyToMany
	@JoinTable(name = "post_hashtag",
			joinColumns = {@JoinColumn(name = "hashtagid")},
			inverseJoinColumns = {@JoinColumn(name = "postid")})
	@Where(clause="expired=false")
	private List<Post> postsOfHashtags;
	
	@ManyToMany
	@JoinTable(name = "hashtag_category",
					joinColumns = {@JoinColumn(name = "hashtagid")}, 
					inverseJoinColumns = {@JoinColumn(name = "categoryid")})
	private List<Category> categoriesOfHashtag;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHashtag() {
		return hashtag;
	}

	public void setHashtag(String hashTag) {
		this.hashtag = hashTag;
	}


	public List<Post> getPostsOfHashtag() {
		return postsOfHashtags;
	}

	public void setPostsOfHashtag(List<Post> postsOfHashtags) {
		this.postsOfHashtags = postsOfHashtags;
	}

	public List<Category> getCategoriesOfHashtag() {
		return categoriesOfHashtag;
	}

	public void setCategoriesOfHashtag(List<Category> categoriesOfHashtag) {
		this.categoriesOfHashtag = categoriesOfHashtag;
	}
}