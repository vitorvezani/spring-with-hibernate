package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping
	public String listCustomers(Model model) {
		model.addAttribute("customers", customerService.getCustomers());
		return "list-customers";
	}
	
	@GetMapping(path="/showFormForAdd")
	public String showFormForAdd(Model model) {
		model.addAttribute("customer", new Customer());
		return "customer-form";
	}
	
	@GetMapping(path="/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int id, Model model) {
		model.addAttribute("customer", customerService.findById(id));
		return "customer-form";
	}
	
	@PostMapping(path="/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		customerService.saveCustomer(customer);
		return "redirect:/customers";
	}
	
	@GetMapping(path="/delete")
	public String deleteCustomer(@RequestParam("customerId") int id) {
		customerService.delete(id);
		return "redirect:/customers";
	}
	
	@PostMapping("/search")
    public String searchCustomers(@RequestParam("theSearchName") String searchString, Model theModel) {

        // search customers from the service
        List<Customer> theCustomers = customerService.searchCustomers(searchString);
                
        // add the customers to the model
        theModel.addAttribute("customers", theCustomers);

        return "list-customers";        
    }
	
}
