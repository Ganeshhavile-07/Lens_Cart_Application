package com.cg.lenscart.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.lenscart.entity.Product;

import com.cg.lenscart.exception.NoProperDataException;
import com.cg.lenscart.exception.ProductNotFoundException;
import com.cg.lenscart.repository.ProductRepository;
import com.cg.lenscart.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public ResponseEntity<List<Product>> getAllProduct() throws ProductNotFoundException {
		// TODO Auto-generated method stub
		log.info("get all product from here");
		return new ResponseEntity<>(productRepository.findAll(), HttpStatus.OK);

	}

	@Override
	public ResponseEntity<Product> getProductById(int id) throws ProductNotFoundException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new ProductNotFoundException("product Not Found" + id));

		return ResponseEntity.ok().body(product);
	}

	@Override
	public ResponseEntity<Product> addProduct(Product product) throws NoProperDataException {
		// TODO Auto-generated method stub
		log.info("start");
		if (product != null) {
			productRepository.save(product);
			System.out.println("product added");
		} else {
			throw new NoProperDataException("Please fill fields");
		}
		return ResponseEntity.ok(product);
	}

	@Override
	public ResponseEntity<Product> updateProduct(Product product, int id) throws ProductNotFoundException {
		// TODO Auto-generated method stub
		Product productdetails = productRepository.findById(id)
				.orElseThrow(() -> new ProductNotFoundException("product not available for this id: " + id));

		productdetails.setProductName(product.getProductName());
		productdetails.setProductType(product.getProductType());
		productdetails.setProductPrice(product.getProductPrice());
		productdetails.setProductQuantity(product.getProductQuantity());
		productdetails.setProductBrand(product.getProductBrand());

		productdetails.setProductDescription(product.getProductDescription());

		final Product updatedProduct = productRepository.save(productdetails);
		return ResponseEntity.ok(updatedProduct);

	}

	@Override
	public ResponseEntity<String> deleteProduct(Integer id) throws ProductNotFoundException {
		// TODO Auto-generated method stub
		log.info("Start delete");
		var isRemoved = productRepository.findById(id);
		if (isRemoved.isPresent()) {
			productRepository.deleteById(id);
			log.debug("deleted successfully {}", isRemoved.get());
		} else {
			throw new ProductNotFoundException("Id Not Available");
		}
		log.info(" deleted End");
		return ResponseEntity.ok(id + " deleted successfully");
	}

}
