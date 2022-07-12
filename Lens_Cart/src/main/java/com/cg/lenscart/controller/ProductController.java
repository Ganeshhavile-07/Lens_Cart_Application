package com.cg.lenscart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.lenscart.entity.Product;

import com.cg.lenscart.exception.NoProperDataException;
import com.cg.lenscart.exception.ProductNotFoundException;

import com.cg.lenscart.serviceimpl.ProductServiceImpl;
import com.cg.lenscart.serviceimpl.SequenceGeneratorService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api/v1")
public class ProductController {

	@Autowired
	private ProductServiceImpl productServiceImpl;

	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;

	@GetMapping("/allproduct")
	public ResponseEntity<List<Product>> getAllProduct() throws ProductNotFoundException {
		log.info("starting  of get mapping");
		return productServiceImpl.getAllProduct();

	}

	@GetMapping("/product/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable Integer id) throws ProductNotFoundException {
		return productServiceImpl.getProductById(id);
	}

	@PostMapping("/addproduct")
	public ResponseEntity<Product> addProduct(@RequestBody Product product) throws NoProperDataException {
		log.info("start");
		product.setProductId(sequenceGeneratorService.getSequenceNumberForProduct(Product.SEQUENCE_NAME));
		return productServiceImpl.addProduct(product);
	}

	@PutMapping("/updateproduct/{id}")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable int id)
			throws ProductNotFoundException {
		return productServiceImpl.updateProduct(product, id);
	}

	@DeleteMapping(path = "/deleteproduct/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable int id) throws ProductNotFoundException {
		return productServiceImpl.deleteProduct(id);
	}

}
