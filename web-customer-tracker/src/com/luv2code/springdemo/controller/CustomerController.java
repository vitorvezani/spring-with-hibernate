package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;

@Controller
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerDAO customerDAO;
	
	@RequestMapping
	public String listCustomers(Model model) {
		List<Customer> customers = customerDAO.getCustomers();
		System.out.println("customersSize: " + customers.size());
		model.addAttribute("customers", customers);
		return "list-customers";
	}
	
}
