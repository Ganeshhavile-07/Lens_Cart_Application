package com.cg.lenscart.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.lenscart.entity.Product;
import com.cg.lenscart.exception.NoProperDataException;
import com.cg.lenscart.exception.ProductNotFoundException;



public interface ProductService {
    
	public  ResponseEntity<List<Product>> getAllProduct() throws  ProductNotFoundException;
	public ResponseEntity<Product> getProductById(@PathVariable int id) throws ProductNotFoundException;
	public ResponseEntity<Product> addProduct(@RequestBody Product product)  throws NoProperDataException;
	public ResponseEntity<Product> updateProduct(@RequestBody Product product ,@PathVariable int id)  throws ProductNotFoundException;
	public ResponseEntity<String> deleteProduct(@PathVariable Integer id) throws ProductNotFoundException;

}
