package com.cg.lenscart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	
	@GetMapping("/allcustomers") 
	public ResponseEntity<List<Customer>> getAllCustomer() throws CustomerNotFoundException
	{
		log.info("starting  of get mapping");
		return customerServiceImpl.getAllCustomers();
		
	}
	
	@GetMapping("/customers/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable  Integer id)
	throws CustomerNotFoundException{
		return customerServiceImpl.getCustomerById(id);
	}
	
	@PostMapping("/addCustomers") 
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer)  throws NoProperDataException
	{
		log.info("start");
		customer.setCust_id(sequenceGeneratorService.getSequenceNumber(Customer.SEQUENCE_NAME));
		return customerServiceImpl.addCustomer(customer);
	}
	
	@PutMapping("/updatecustomer/{id}")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer,@PathVariable int id) throws CustomerNotFoundException
	{
		return customerServiceImpl.updateCustomer(customer, id);
	}
	
//	@DeleteMapping(path="/users/{id}")
//	public ResponseEntity<Long> deletePlant(@PathVariable int id) throws PlantNotFoundException {
//			return plantServiceimpl.deletePlant(id);
//	}

	
//	@DeleteMapping("/deletecustomer/{id}")
//	public Map<String, Boolean> deleteCustomerById(@PathVariable (value="id") Integer customerId)
//	throws CustomerNotFoundException{
//		Customer customer =custRepository.findById(customerId)
//				.orElseThrow(() -> new CustomerNotFoundException("Customer is not found by that id :: "+customerId));
//	this.custRepository.delete(customer);
//	
//	Map<String, Boolean> response=new HashMap<>();
//	response.put("deleted", Boolean.TRUE);
//	return response;
//	}
	
}