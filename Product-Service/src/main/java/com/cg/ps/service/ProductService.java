package com.cg.ps.service;

import java.util.List;

import com.cg.ps.entity.Product;
import com.cg.ps.exception.NoProperDataException;
import com.cg.ps.exception.ProductNotFoundException;


public interface ProductService {

	// the product service class is consist of all business related method
	// declaration
	public List<Product> getAllProduct() throws ProductNotFoundException;

	public Product addProduct(Product product) throws NoProperDataException;

	
	public Product updateProduct(Product product, Long id) throws ProductNotFoundException;

	public String deleteProduct(Long id) throws ProductNotFoundException;

	Product getProductById(Long id) throws ProductNotFoundException;
}
