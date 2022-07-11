package com.cg.lenscart.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.lenscart.entity.Customer;
import com.cg.lenscart.exception.CustomerNotFoundException;
import com.cg.lenscart.exception.NoProperDataException;

public interface CustomerService {
    
	public  ResponseEntity<List<Customer>> getAllCustomers() throws  CustomerNotFoundException;
	public ResponseEntity<Customer> getCustomerById(@PathVariable int id) throws CustomerNotFoundException;
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer)  throws NoProperDataException;
	public ResponseEntity<Customer> updateCustomers(@RequestBody Customer customer ,@PathVariable int id)  throws CustomerNotFoundException;
	public ResponseEntity<String> deleteCustomers(@PathVariable Integer id) throws CustomerNotFoundException;


}
