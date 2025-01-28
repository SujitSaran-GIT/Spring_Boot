package com.social.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StoriesController {

	@GetMapping("/stories")
	public String getStories() {
		return "This is my stories section";
	}
}
