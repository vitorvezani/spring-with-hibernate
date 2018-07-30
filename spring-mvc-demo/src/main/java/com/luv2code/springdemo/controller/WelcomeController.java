package com.luv2code.springdemo.controller;

import javax.servlet.ServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WelcomeController {

  @RequestMapping("/form")
  public String form() {
    return "welcome-form";
  }

  @RequestMapping("/processForm")
  public String processForm() {
    return "hello-user";
  }

  @RequestMapping("/processFormVersionTwo")
  public String processFormversionTwo(ServletRequest request, Model model) {
    String name = request.getParameter("name");
    model.addAttribute("name", name.toUpperCase());
    return "hello-user";
  }

  @RequestMapping("/processFormVersionThree")
  public String processFormVersionThree(@RequestParam("name") String name, Model model) {
    model.addAttribute("name", name.toLowerCase());
    return "hello-user";
  }

}
