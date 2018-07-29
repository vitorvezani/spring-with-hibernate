package com.luv2code.springdemo.dao;

import java.util.List;
import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private Random rand = new Random();
	
	@Override
	@Transactional(readOnly = true)
	public List<Customer> getCustomers() {
		
		if(rand.nextInt(100) <= 0) throw new RuntimeException("Error in app");
		
		Session session = sessionFactory.getCurrentSession();
		Query<Customer> query = session.createQuery("from Customer", Customer.class);
		return query.getResultList();
	}

	@Override
	public void save(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(customer);
	}

	@Override
	public Customer findById(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.find(Customer.class, id);
	}

	@Override
	public void delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(findById(id));
	}

	@Override
	public List<Customer> findByName(String searchString) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Customer> theQuery = null;

		// only search by name if theSearchName is not empty
		if (searchString != null && searchString.trim().length() > 0) {
			// search for firstName or lastName ... case insensitive
			theQuery = currentSession.createQuery("from Customer where lower(firstName) like :theName or lower(lastName) like :theName", Customer.class);
			theQuery.setParameter("theName", "%" + searchString.toLowerCase() + "%");
		} else {
			// theSearchName is empty ... so just get all customers
			theQuery = currentSession.createQuery("from Customer", Customer.class);
		}

		// execute query and get result list
		List<Customer> customers = theQuery.getResultList();

		// return the results
		return customers;
	}

}
