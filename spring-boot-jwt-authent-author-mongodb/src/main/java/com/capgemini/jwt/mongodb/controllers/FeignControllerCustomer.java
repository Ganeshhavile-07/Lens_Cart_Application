package com.capgemini.jwt.mongodb.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.jwt.mongodb.controllers.security.services.SequenceGeneratorService;
import com.capgemini.jwt.mongodb.exception.CustomerNotFoundException;
import com.capgemini.jwt.mongodb.exception.NoProperDataException;
import com.capgemini.jwt.mongodb.model.Customer;
import com.capgemini.jwt.mongodb.util.FeignClientUtilCustomer;


@RestController
@RequestMapping("/api/v1")//same url has this particular project
public class FeignControllerCustomer {

	//include authorization header
	@Autowired
	private FeignClientUtilCustomer feignclientutilcustomer;
    
	@Autowired
	private SequenceGeneratorService service;

	@GetMapping("/allcustomers")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<List<Customer>> getAllCustomer(@RequestHeader("Authorization") String token) throws CustomerNotFoundException {
		return feignclientutilcustomer.getAllCustomers(token);
	}
    
	@GetMapping("/customer/{id}")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public ResponseEntity<Customer> getCustomerById(@RequestHeader("Authorization") String token, @PathVariable Long id)
		throws CustomerNotFoundException {
		return feignclientutilcustomer.getCustomersById(token, id);
	}
    
	@PostMapping("/addcustomers")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<Customer> addCustomer(@RequestHeader("Authorization") String token, @RequestBody Customer customer) throws NoProperDataException {
		  customer.setCust_id(service.getSequenceNumberForCustomer(Customer.SEQUENCE_NAME));

		return feignclientutilcustomer.addCustomers(token, customer);
	}
    
//	@PutMapping("/updateproduct")
//	@PreAuthorize("hasRole('USER')")
//	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer, @PathVariable Long id)
//			throws CustomerNotFoundException {
//		return feignclientutilcustomer.updateCustomers(customer, id);
//	}
    
	@DeleteMapping(path="/deletecustomer/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<String> deleteCustomer(@RequestHeader("Authorization") String token, @PathVariable Long id) throws CustomerNotFoundException {
		return feignclientutilcustomer.deleteCustomers(token, id);
	}


}
