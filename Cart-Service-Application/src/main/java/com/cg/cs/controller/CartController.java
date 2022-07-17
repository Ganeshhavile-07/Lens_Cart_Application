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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.cs.entity.Cart;
import com.cg.cs.exception.CartNotFoundException;
import com.cg.cs.exception.NoProperDataException;
import com.cg.cs.service.CartServiceImpl;
import com.cg.cs.service.SequenceGeneratorService;

@RestController
@RequestMapping("/api/v1")
public class CartController {

	// injecting the object directly
		@Autowired
		private CartServiceImpl cartServiceImpl;

		@Autowired
		private SequenceGeneratorService sequenceGeneratorService;

		@GetMapping("/allcarts") // users/admin
		public ResponseEntity<List<Cart>> getAllCarts() throws CartNotFoundException {
			// productserviceimpl.getAllProducts();
			return new ResponseEntity<>(cartServiceImpl.getAllCarts(), HttpStatus.OK);
		}

		// admin/users
		@GetMapping("/getcarts/{id}")
		public ResponseEntity<Cart> getCartById(@PathVariable Long id) throws CartNotFoundException {
			Cart cart= cartServiceImpl.getCartsById(id);
			return ResponseEntity.ok().body(cart);
		}

		@PostMapping("/addcarts") // only admin
		public ResponseEntity<Cart> addCarts(@RequestBody Cart carts) throws NoProperDataException {
			carts.setId(sequenceGeneratorService.getSequenceNumberForCart(Cart.SEQUENCE_NAME));
			// productserviceimpl.addProduct(product);
			return new ResponseEntity<>(cartServiceImpl.addCarts(carts), HttpStatus.CREATED);
		}

		@PutMapping("/updatecarts/{id}") // admin only @PutMapping("/updateproduct/{id}")
		public ResponseEntity<Cart> updateCarts(@RequestBody Cart carts, @PathVariable Long id)
				throws CartNotFoundException {
			;
			return ResponseEntity.ok(cartServiceImpl.updateCarts(carts, id));
		}

		@DeleteMapping("/deletecarts/{id}") // only delete
		public ResponseEntity<String> deleteCart(@PathVariable Long id) throws CartNotFoundException {
			cartServiceImpl.deleteCarts(id);
			return ResponseEntity.ok("CartId "+id + " deleted successfully");
		}
}
