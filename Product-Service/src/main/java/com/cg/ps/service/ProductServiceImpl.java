package com.cg.ps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.ps.entity.Product;
import com.cg.ps.exception.NoProperDataException;
import com.cg.ps.exception.ProductNotFoundException;
import com.cg.ps.repository.ProductRepository;

import lombok.extern.slf4j.Slf4j;

//@Service means the class consist of all business related logic
@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> getAllProduct() throws ProductNotFoundException {
		// TODO Auto-generated method stub
		log.info("get all products  from here");
		if (productRepository.findAll().isEmpty()) {
			throw new ProductNotFoundException("No Product Found");
		} else {
			return productRepository.findAll();
		}
	}

	@Override
	public Product addProduct(Product product) throws NoProperDataException {
		// TODO Auto-generated method stub
		Product products = productRepository.save(product);
		if (products == null) {
			throw new NoProperDataException("Please fill fields");
		}
		return products;
	}

	@Override
	public Product updateProduct(Product product, Long id) throws ProductNotFoundException {
		// TODO Auto-generated method stub
		log.info("update");
		Product products = productRepository.findById(id)
				.orElseThrow(() -> new ProductNotFoundException("No lens Availble wth this id"));
		products.setProductId(product.getProductId());
		products.setProductName(product.getProductName());
		products.setProductBrand(product.getProductBrand());
		products.setProductType(product.getProductType());
		products.setProductDescription(product.getProductDescription());
		products.setProductQuantity(product.getProductQuantity());

		final Product updatedproduct = productRepository.save(products);
		return updatedproduct;
	}

	@Override
	public String deleteProduct(Long id) throws ProductNotFoundException {
		// TODO Auto-generated method stub
		log.info("delete By Id");
		var isRemoved = productRepository.findById(id);
		if (isRemoved.isPresent()) {
			productRepository.deleteById(id);
			log.debug("deleted succesfully {}", isRemoved.get());
		} else {
			throw new ProductNotFoundException("Product not available to delete on given id");
		}
		log.info("end");
		return "deleted";
	}



	@Override
	public Product getProductById(Long id) throws ProductNotFoundException {
		// TODO Auto-generated method stub
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new ProductNotFoundException("Products Not Found with id " + id));
			return product;
			// ResponseEntity.ok().body(lo);
			// getById id takes only id has input (it will not take object Product product)
		
		}

}
