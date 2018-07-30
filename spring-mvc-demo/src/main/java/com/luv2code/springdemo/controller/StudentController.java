package com.luv2code.springdemo.controller;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springdemo.model.Student;

@Controller
@RequestMapping("/student")
public class StudentController {


  @InitBinder
  public void initBinderMethod(WebDataBinder wdb) {
    wdb.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    System.out.println("StringTrimmerEditor registered in the WebDataBinder @ StudentController");
  }

  @RequestMapping("/create")
  public String create(Model model) {
    model.addAttribute("student", new Student());
    return "student/create";
  }

  @RequestMapping("/new")
  public String newStudent(@Valid @ModelAttribute("student") Student student, BindingResult br, Model model) {

    if(br.hasErrors()) {
      System.out.println("student has errors that need to be correted: " + br);
      return "student/create";
    }
    System.out.println(student);

    model.addAttribute("student", student);
    return "student/show";
  }

}
