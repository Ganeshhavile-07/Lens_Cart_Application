package com.cg.jwt.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.jwt.exception.CartNotFoundException;
import com.cg.jwt.exception.RecordAlreadyExistsException;
import com.cg.jwt.models.Cart;
import com.cg.jwt.security.services.SequenceGeneratorService;
import com.cg.jwt.util.FeignClientUtilCart;

@RestController
@RequestMapping("/api/v1")
public class FeignControllerCart {
   
	@Autowired
	private FeignClientUtilCart feignclientutilcart;
	
	@Autowired
	private SequenceGeneratorService service;

	@GetMapping("/cartdata")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<List<Cart>> getAllCart(@RequestHeader("Authorization")  String token) throws CartNotFoundException {//changed here on 12/07/22 ->11:27pm
		return feignclientutilcart.getAllCarts(token);
	}

	//only user
	@PostMapping("/addcart")  //this data should come from products
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<Cart> addCart(@RequestHeader("Authorization")  String token, @Valid @RequestBody Cart cart) throws RecordAlreadyExistsException {
		cart.setId(service.getSequenceNumberForCart(Cart.SEQUENCE_NAME));
		return feignclientutilcart.addCart(token, cart);
	}

	//don't include update cart
	@PutMapping("/updatecart")
	public ResponseEntity<Cart> updateCart(@RequestHeader("Authorization")  String token,@Valid @RequestBody Cart cart) throws CartNotFoundException {
		return feignclientutilcart.updateCart(token, cart );
	}

	//delete cart -> only user
	@DeleteMapping("/cancelcart/{id}")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<String> cancelCart(@RequestHeader("Authorization")  String token,@PathVariable Long id)  throws CartNotFoundException {
		return feignclientutilcart.cancelCart(token, id); //this id will come from product
	}
}
