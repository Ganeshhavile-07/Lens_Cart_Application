package com.cg.cs.service;

import java.util.List;

import com.cg.cs.entity.Customer;
import com.cg.cs.exception.CustomerNotFoundException;
import com.cg.cs.exception.NoProperDataException;

public interface CustomerService {
	// the customer service class is consist of all business related method
	// declaration
	public List<Customer> getAllCustomers() throws CustomerNotFoundException;

	public Customer addCustomer(Customer customer) throws NoProperDataException;

	public Customer updateCustomer(Customer customer, Long id) throws CustomerNotFoundException;

	public String deleteCustomer(Long id) throws CustomerNotFoundException;

	public Customer getCustomerById(Long id) throws CustomerNotFoundException;

}
