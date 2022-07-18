package com.capgemini.jwt.mongodb.util;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.capgemini.jwt.mongodb.model.Cart;



@FeignClient(value = "Cart-Service-Application" ,url = "http://localhost:9006/api/v1")
public interface FeignClientUtilCart {

	@GetMapping("/allcarts")
	public ResponseEntity<List<Cart>> getAllCarts(@RequestHeader("Authorization")  String token);
	
	 //only user
	@PostMapping("/addcart")  //this data should come from products
	public ResponseEntity<Cart> addCart(@RequestHeader("Authorization")  String token, Cart cart);

  //don't include update cart
	@PutMapping("/updatecart")
	public ResponseEntity<Cart> updateCart(@RequestHeader("Authorization")  String token,Cart cart);
	  
	//delete cart -> only user
	@DeleteMapping("/cancelcart/{id}")
	public ResponseEntity<String> cancelCart(@RequestHeader("Authorization")  String token,Long id);
}