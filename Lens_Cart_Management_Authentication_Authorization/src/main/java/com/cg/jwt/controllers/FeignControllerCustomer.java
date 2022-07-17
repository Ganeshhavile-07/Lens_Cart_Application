package com.cg.jwt.controllers;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.jwt.exception.CustomerNotFoundException;
import com.cg.jwt.exception.NoProperDataException;
import com.cg.jwt.models.Customer;
import com.cg.jwt.security.services.SequenceGeneratorService;
import com.cg.jwt.util.FeignClientUtilCustomer;

@RestController
@RequestMapping("/api/v1")//same url has this particular project
public class FeignControllerCustomer {

	
	@Autowired
	private FeignClientUtilCustomer feignclientutilcustomer;
    
	@Autowired
	private SequenceGeneratorService service;

	@GetMapping("/allcustomers")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	public ResponseEntity<List<Customer>> getAllCustomer() throws CustomerNotFoundException {
		return feignclientutilcustomer.getAllCustomers();
	}
    
	@GetMapping("/customer/{id}")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public ResponseEntity<Customer> getCustomerById( @PathVariable Long id)
		throws CustomerNotFoundException {
		return feignclientutilcustomer.getCustomersById(id);
	}
    
	@PostMapping("/addcustomers")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) throws NoProperDataException {
		  customer.setCust_id(service.getSequenceNumberForCustomer(Customer.SEQUENCE_NAME));

		return feignclientutilcustomer.addCustomers(customer);
	}
    
//	@PutMapping("/updateproduct")
//	@PreAuthorize("hasRole('USER')")
//	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer, @PathVariable Long id)
//			throws CustomerNotFoundException {
//		return feignclientutilcustomer.updateCustomers(customer, id);
//	}
    
	@DeleteMapping(path="/deletecustomer/{id}")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<String> deleteCustomer(@PathVariable Long id) throws CustomerNotFoundException {
		return feignclientutilcustomer.deleteCustomers(id);
	}


}
