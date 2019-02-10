package com.luv2code.springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/show-my-login-page")
	public String getIndex() {
		return "fancy-login";
	}
	
}
