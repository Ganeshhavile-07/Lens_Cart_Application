package com.cg.lenscart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.lenscart.entity.Customer;
import com.cg.lenscart.exception.CustomerNotFoundException;
import com.cg.lenscart.exception.NoProperDataException;
import com.cg.lenscart.serviceimpl.CustomerServiceImpl;
import com.cg.lenscart.serviceimpl.SequenceGeneratorService;


import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api/v1")
public class CustomerController {
    
	@Autowired
	private CustomerServiceImpl customerServiceImpl;
	
	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;
	
	@GetMapping("/allcustomer") 
	public ResponseEntity<List<Customer>> getAllCustomer() throws CustomerNotFoundException
	{
		log.info("starting  of get mapping");
		return customerServiceImpl.getAllCustomers();
		
	}
	
	@GetMapping("/customer/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable  Integer id)
	throws CustomerNotFoundException{
		return customerServiceImpl.getCustomerById(id);
	}
	
	@PostMapping("/addCustomer") 
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer)  throws NoProperDataException
	{
		log.info("start");
		customer.setCust_id(sequenceGeneratorService.getSequenceNumberForCustomer(Customer.SEQUENCE_NAME));
		return customerServiceImpl.addCustomer(customer);
	}
	
	@PutMapping("/updatecustomer/{id}")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer,@PathVariable int id) throws CustomerNotFoundException
	{
		return customerServiceImpl.updateCustomers(customer, id);
	}
	

	@DeleteMapping(path="/deletecustomer/{id}")
	public ResponseEntity<String> deleteCustomers(@PathVariable int id) throws CustomerNotFoundException {
			return customerServiceImpl.deleteCustomers(id);
	}
	
}