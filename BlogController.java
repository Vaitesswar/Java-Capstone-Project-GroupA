package com.example.demo;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlogController {
	private PostRepository postRepository;
	private HashTagRepository hashTagRepository;
	
	// Display post by post ID
	@SuppressWarnings("deprecation")
	@GetMapping("/{postID}")
	String displayPost(@PathVariable long postID) {
		return "";
	}
	
	// Filter blog posts by #hashtags
	@SuppressWarnings("deprecation")
	@GetMapping("/{hashTag}")
	String filterPostByHashTag(@PathVariable String hashTag) {
		return "";	
	}
	
	// Filter blog posts by category
	@SuppressWarnings("deprecation")
	@GetMapping("/{category}")
	String filterPostByCategory(@PathVariable String category) {
		return "";
	}
	
	// Filter blog posts by months
	@SuppressWarnings("deprecation")
	@GetMapping("/{months}")
	String filterPostByMonths(@PathVariable String months) {
		return "";	
	}
	
	// Insert a blog post (Recieves a json with userName, postDate, bodyofPost & dateOfExpiry)		
	@PostMapping("/{content}")
	String createPost(@RequestBody String content){
		return "";
	}
	
	// Delete an old post (user-defined)
	@DeleteMapping("/{postID}")
	String deletePostByUser(@PathVariable long postID) {
		return "";
	}
		
	// Delete old posts (by expired date)
	String deletePostByExpiry() {
		return "";
	}
		
	// Update a blog post (Recieves a json with userName, postDate, bodyofPost & dateOfExpiry)		
	@PostMapping("/{content}")
	String updateStudent(@PathVariable String content) {
		return "";
	}
}

