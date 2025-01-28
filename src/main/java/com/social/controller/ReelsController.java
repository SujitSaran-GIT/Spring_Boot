package com.social.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReelsController {

	@GetMapping("/reels")
	public String getReels() {
		return "THis is my reels section";
	}
}
