package com.luv2code.springdemo.service;

import java.util.List;

import com.luv2code.springdemo.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);

	public Customer findById(int id);

	public void delete(int id);

	public List<Customer> searchCustomers(String theSearchName);
	
}
