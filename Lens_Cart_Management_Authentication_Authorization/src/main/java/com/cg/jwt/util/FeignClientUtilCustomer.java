package com.cg.jwt.util;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;

import com.cg.jwt.models.Customer;

@FeignClient(value = "CustomerService" ,url = "http://localhost:9005/api/v1")
public interface FeignClientUtilCustomer {

	
	@GetMapping("/allcustomers") 
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	public ResponseEntity<List<Customer>> getAllCustomers();
	 
	 @GetMapping("/customer/{id}") 
	 @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	 public ResponseEntity<Customer> getCustomersById(Long id);
	  
	 //only user
	  @PostMapping("/addcustomers")
	  @PreAuthorize("hasRole('USER')")
	  public ResponseEntity<Customer> addCustomers(Customer  customer);
	  
	  //update product 
//	 @PutMapping("/updatecustomer") 
//	 public ResponseEntity<Customer> updateCustomers(Customer customer ,Long id);
//	 
	 //delete product -> only user
	 @DeleteMapping(path="/deletecustomer/{id}")
	 @PreAuthorize("hasRole('USER') ")
	 public ResponseEntity<String> deleteCustomers(Long id);

	
		 
}
