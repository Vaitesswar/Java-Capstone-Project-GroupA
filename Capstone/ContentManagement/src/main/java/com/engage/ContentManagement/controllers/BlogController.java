package com.engage.ContentManagement.controllers;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.engage.ContentManagement.entities.Category;
import com.engage.ContentManagement.entities.Hashtag;
import com.engage.ContentManagement.entities.Post;
import com.engage.ContentManagement.repositories.CategoryRepository;
import com.engage.ContentManagement.repositories.HashtagRepository;
import com.engage.ContentManagement.repositories.PostRepository;

@Controller
public class BlogController {

	@Autowired
	private PostRepository posts;
	
	@Autowired
	private HashtagRepository hashtags;
	
	@Autowired
	private CategoryRepository categories;
	
	// Display index/home page containing 10 latest posts
	@GetMapping("/")
	public String index(Model model) {
		List<Post> postList = posts.findAll();
		List<Category> categoryList = categories.findAll();
		List<Integer> months = IntStream.rangeClosed(1, 12).boxed().collect(Collectors.toList());
		
		model.addAttribute("posts", postList);
		model.addAttribute("categories", categoryList);
		model.addAttribute("months", months);
		return "index";
	}
	
	// Display posts by #hashtag
	@GetMapping("/viewHashtag/{id}")
	public String viewPostsByHashtag(@PathVariable Integer id, Model model) {
		List<Category> categoryList = categories.findAll();
		List<Integer> months = IntStream.rangeClosed(1, 12).boxed().collect(Collectors.toList());
		model.addAttribute("categories", categoryList);
		model.addAttribute("months", months);
		
		Hashtag hashtag = hashtags.findById(id).orElse(null);
		List<Post> postList = hashtag.getPostsOfHashtag();
		
		model.addAttribute("hashtag", hashtag.getHashtag());
		model.addAttribute("posts", postList);
		return "viewHashtag";
	}
	
	
	// Filter posts by #hashtag
	@PostMapping("/viewHashtag")
	public String filterPostsByHashtag(HttpServletRequest request) {
		String hashtag = request.getParameter("hashtag");
		Hashtag hashtagObj = hashtags.findByHashtag(hashtag);
		return "redirect:/viewHashtag/" + hashtagObj.getId();
	}
	
	// Display posts by category
	@GetMapping("/viewCategory")
	public String viewPostsByCategory(Integer id, Model model) {
		List<Category> categoryList = categories.findAll();
		List<Integer> months = IntStream.rangeClosed(1, 12).boxed().collect(Collectors.toList());
		model.addAttribute("categories", categoryList);
		model.addAttribute("months", months);
		
		Category category = categories.findById(id).orElse(null);
		List<Hashtag> hashtagList = category.getHashtagsOfCategory();
		List<Post> postList = new ArrayList<>();
		for (Hashtag hashtag: hashtagList) {
			List<Post> p = hashtag.getPostsOfHashtag();
			postList.addAll(p);
		}
		
		Collections.sort(postList, Comparator.comparing(obj -> ((Post) obj).getDateOfPost()).reversed());
		model.addAttribute("category", category);
		model.addAttribute("posts", postList);
		return "viewCategory";
	}
	
	// Filter posts by category
	@PostMapping("/viewCategory")
	public String filterPostByCategory(HttpServletRequest request) {
		String category = request.getParameter("category");
		Category categoryObj = categories.findByCategory(category);
		return "redirect:/viewCategory?category=" + categoryObj.getId();
	}
	
	// Display posts by month
	@GetMapping("/viewMonth")
	public String viewPostsByMonth(Integer month, Model model) {
		List<Category> categoryList = categories.findAll();
		List<Integer> months = IntStream.rangeClosed(1, 12).boxed().collect(Collectors.toList());
		model.addAttribute("categories", categoryList);
		model.addAttribute("months", months);
		
		List<Post> postList = posts.getByMonth(month);
		model.addAttribute("month", month);
		model.addAttribute("posts", postList);
		return "viewMonth";
	}
	
	// Filter posts by months
	@PostMapping("/viewMonth")
	public String filterPostsByMonth(HttpServletRequest request) {
		int month = Integer.parseInt(request.getParameter("month"));
		return "redirect:/viewMonth?month=" + month;	
	}
	
	// Display add post page
	@GetMapping("/addPost")
	public String addPost(Model model) {
		List<Category> categoryList = categories.findAll();
		List<Integer> months = IntStream.rangeClosed(1, 12).boxed().collect(Collectors.toList());
		model.addAttribute("categories", categoryList);
		model.addAttribute("months", months);
		
		return "addPost";
	}
	
	// Add a post (Receives a json with title, userName, bodyOfPost, dateOfPost, (Optional) dateOfExpiry)	
	@PostMapping("/addPost")
	public String addPost(Post post){
		posts.save(post);
		return "redirect:/";
	}
	
	// Delete an old post (user-defined)
	@GetMapping("/deletePost")
	public String deletePost(Integer id) {
		posts.deleteById(id);
		return "redirect:/"; 
	}
		
	// Display edit post page
	@GetMapping("/editPost")
	public String displayPost(Integer id, Model model) {
		List<Category> categoryList = categories.findAll();
		List<Integer> months = IntStream.rangeClosed(1, 12).boxed().collect(Collectors.toList());
		model.addAttribute("categories", categoryList);
		model.addAttribute("months", months);
		
		Post post = posts.findById(id).orElse(null);
		model.addAttribute("id", post.getId());
		model.addAttribute("post", post);
		return "editPost";
	}
	
	// Update a blog post (Receives a json with title, userName, bodyOfPost, dateOfPost, (Optional) dateOfExpiry)		
	@PostMapping("/editPost")
	public String editPost(Integer postId, Post post) {
		post.setId(postId);
		posts.save(post);
		return "redirect:/";
	}
	
	
}