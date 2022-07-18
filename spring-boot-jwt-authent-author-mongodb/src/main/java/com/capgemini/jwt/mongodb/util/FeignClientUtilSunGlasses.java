package com.capgemini.jwt.mongodb.util;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import com.capgemini.jwt.mongodb.model.SunGlasses;

@FeignClient(value = "SunGlass-Service", url = "http://localhost:9009/api/v1")
public interface FeignClientUtilSunGlasses {

	@GetMapping("/allsunglasses")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	public ResponseEntity<List<SunGlasses>> getAllSunGlasses(@RequestHeader("Authorization") String token);

	@GetMapping("/sunglasses/{id}")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public ResponseEntity<SunGlasses> getSunGlassesById(@RequestHeader("Authorization") String token, Integer id);

	// only user
	@PostMapping("/addsunglasses")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<SunGlasses> addSunGlasses(@RequestHeader("Authorization") String token, SunGlasses glass);

	// update product
//	 @PutMapping("/updatecustomer") 
//	 public ResponseEntity<Customer> updateCustomers(Customer customer ,Long id);
//	 
	// delete product -> only user
	@DeleteMapping(path = "/deletesunglasses/{id}")
	@PreAuthorize("hasRole('USER') ")
	public ResponseEntity<String> deleteSunglasses(@RequestHeader("Authorization") String token, Integer id);

}