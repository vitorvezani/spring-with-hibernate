package com.luv2code.springdemo.dao;

import java.util.List;

import com.luv2code.springdemo.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();

	public void save(Customer customer);

	public Customer findById(int id);

	public void delete(int id);

	public List<Customer> findByName(String theSearchName);
	
}
