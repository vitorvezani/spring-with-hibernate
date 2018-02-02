package com.luv2code.springdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springdemo.model.Student;

@Controller
@RequestMapping("/student")
public class StudentController {

  @RequestMapping("/create")
  public String create(Model model) {
    model.addAttribute("student", new Student());
    return "student/create";
  }

  @RequestMapping("/new")
  public String newStudent(@ModelAttribute("student") Student student, Model model) {

    System.out.println(student);

    model.addAttribute("student", student);
    return "student/show";
  }

}
