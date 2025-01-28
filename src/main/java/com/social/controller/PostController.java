package com.social.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {
	
	@GetMapping("/post")
	public String getPost() {
		return "This is my post feed";
	}
}
