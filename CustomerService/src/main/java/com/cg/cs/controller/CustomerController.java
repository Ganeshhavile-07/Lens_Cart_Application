package com.cg.cs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.cs.entity.Customer;
import com.cg.cs.exception.CustomerNotFoundException;
import com.cg.cs.exception.NoProperDataException;
import com.cg.cs.serviceimpl.CustomerServiceImpl;
import com.cg.cs.serviceimpl.SequenceGeneratorService;

//@Restcontroller means it is a combination of controller and RequestBody
//@Controller means it is handle the web request
//@RequestMapping means it is handle the map the web request
@RestController
@RequestMapping("/api/v1")
public class CustomerController {

	// injecting the object directly
	@Autowired
	private CustomerServiceImpl customerServiceImpl;

	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;

	@GetMapping("/allcustomers") // users/admin
	public ResponseEntity<List<Customer>> getAllCustomers() throws CustomerNotFoundException {
		// productserviceimpl.getAllProducts();
		return new ResponseEntity<>(customerServiceImpl.getAllCustomers(), HttpStatus.OK);
	}

	// admin/users
	@GetMapping("/customer/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) throws CustomerNotFoundException {
		Customer cust = customerServiceImpl.getCustomerById(id);
		return ResponseEntity.ok().body(cust);
	}

	@PostMapping("/addcustomers") // only admin
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) throws NoProperDataException {
		customer.setCust_id(sequenceGeneratorService.getSequenceNumberForCustomer(Customer.SEQUENCE_NAME));
		// productserviceimpl.addProduct(product);
		return new ResponseEntity<>(customerServiceImpl.addCustomer(customer), HttpStatus.CREATED);
	}
    
	@PutMapping("/updatecustomer/{id}") // admin only @PutMapping("/updateproduct/{id}")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer, @PathVariable Long id)
			throws CustomerNotFoundException {
		
		return ResponseEntity.ok(customerServiceImpl.updateCustomer(customer, id));
	}

	@DeleteMapping("/deletecustomer/{id}") // only delete
	public ResponseEntity<String> deleteCustomer(@PathVariable Long id) throws CustomerNotFoundException {
		String msg=customerServiceImpl.deleteCustomer(id);
		if(msg!=null && msg!="") {
			return ResponseEntity.ok(id + " deleted successfully");
		}else {
			return new ResponseEntity<String>( id+"not exists",HttpStatus.NOT_FOUND);
		}
		
	}
}