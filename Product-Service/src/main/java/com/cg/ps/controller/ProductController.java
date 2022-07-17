package com.cg.ps.controller;

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

import com.cg.ps.entity.Product;
import com.cg.ps.exception.NoProperDataException;
import com.cg.ps.exception.ProductNotFoundException;
import com.cg.ps.service.ProductServiceImpl;
import com.cg.ps.service.SequenceGeneratorService;

import lombok.extern.slf4j.Slf4j;

//@Restcontroller means it is a combination of controller and RequestBody
//@Controller means it is handle the web request
//@RequestMapping means it is handle the map the web request
@RestController
@Slf4j
@RequestMapping("/api/v1")
public class ProductController {

	@Autowired
	private ProductServiceImpl productServiceImpl;

	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;


	@GetMapping("/allproducts") // users/admin
	public ResponseEntity<List<Product>> getAllProduct() throws ProductNotFoundException {
		// productserviceimpl.getAllProducts();
		return new ResponseEntity<>(productServiceImpl.getAllProduct(), HttpStatus.OK);
	}

	// admin/users
	@GetMapping("/getproduct/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable Long id) throws ProductNotFoundException {
		Product product = productServiceImpl.getProductById(id);
		return ResponseEntity.ok().body(product);
	}

	@PostMapping("/addproduct") // only admin
	public ResponseEntity<Product> addProduct(@RequestBody Product product) throws NoProperDataException {
		product.setProductId(sequenceGeneratorService.getSequenceNumberForProduct(Product.SEQUENCE_NAME));
		// productserviceimpl.addProduct(product);
		return new ResponseEntity<>(productServiceImpl.addProduct(product), HttpStatus.CREATED);
	}

	@PutMapping("/updateproduct/{id}") // admin only @PutMapping("/updateproduct/{id}")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable Long id)
			throws ProductNotFoundException {
		;
		return ResponseEntity.ok(productServiceImpl.updateProduct(product, id));
	}

	@DeleteMapping("/deleteproduct/{id}") // only delete
	public ResponseEntity<String> deleteProduct(@PathVariable Long id) throws ProductNotFoundException {
		productServiceImpl.deleteProduct(id);
		return ResponseEntity.ok(id + " deleted successfully");
	}
}
