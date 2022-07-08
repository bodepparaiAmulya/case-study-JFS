package com.capg.springboot.service;

import java.util.List;

import com.capg.springboot.Exceptions.CustomerNotFoundException;
import com.capg.springboot.dto.Customerdto;
import com.capg.springboot.entity.Customer;

public interface CustomerService {
	/*
	 * public Customer updateCustomer(Customer cust);
	 *  public Customer
	 * removeCustomer(Customer cust); 
	 * public Customer viewCustomer(Customer cust);
	 * public List<Customer> ViewAllCustomers(String location);
	 */
	
	public Customer removeCustomer(Customer cust);
	public Customer findByCustomerId(Customer cust) throws CustomerNotFoundException;

	public Customer addCustomer(Customerdto custdto);
	public List<Customer> findCustomerByCity(String location) throws CustomerNotFoundException;
}
