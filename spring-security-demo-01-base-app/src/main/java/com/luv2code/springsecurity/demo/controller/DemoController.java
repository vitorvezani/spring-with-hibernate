package com.luv2code.springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

	@GetMapping("/")
	public String getIndex() {
		return "home";
	}
	
	@GetMapping("/leaders")
	public String getLeader() {
		return "leaders";
	}
	
	@GetMapping("/systems")
	public String getSystem() {
		return "systems";
	}
	
}
