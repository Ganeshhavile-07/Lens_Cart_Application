//package com.cg.jwt.controllers;
//
//import java.util.List;
//
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
////import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
////import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//
//import com.cg.jwt.exception.NoProperDataException;
//import com.cg.jwt.exception.ProductsNotFoundException;
//import com.cg.jwt.models.Product;
//import com.cg.jwt.security.services.SequenceGeneratorService;
//import com.cg.jwt.util.FeignClientUtilProduct;

//@RestController
//@RequestMapping("/api/v2")//same url has this particular project
//public class FeignControllerProduct {
//
//	@Autowired
//	private FeignClientUtilProduct feignclientutilproduct;
//
//	@Autowired
//	private SequenceGeneratorService service;
//
//	@GetMapping("/allproducts")
//	@PreAuthorize("hasRole('ADMIN')")
//	public ResponseEntity<List<Product>> getAllProducts() throws ProductsNotFoundException {
//		return feignclientutilproduct.getAllProducts();
//	}
//
//	@GetMapping("/getproduct/{id}")
//	@PreAuthorize("hasRole('USER')")
//	public ResponseEntity<Product> getProductById( @PathVariable Long id)
//		throws ProductsNotFoundException {
//		return feignclientutilproduct.getProductById( id);
//	}
//
//	@PostMapping("/addproduct")
//	@PreAuthorize("hasRole('USER')")
//	public ResponseEntity<Product> addProduct(@RequestBody Product product) throws NoProperDataException {
//		
//		return feignclientutilproduct.addProduct(product);
//	}
//
////	@PutMapping("/updateproduct")
////	@PreAuthorize("hasRole('USER')")
////	public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable Long id)
////			throws ProductsNotFoundException {
////		return feignclientutilproduct.updateProduct(product, id);
////	}
//
//	@DeleteMapping("/deleteproduct/{id}")
//	@PreAuthorize("hasRole('USER')")
//	public ResponseEntity<String> deleteProduct(@PathVariable Long id) throws ProductsNotFoundException {
//		return feignclientutilproduct.deleteProduct(id);
//	}
//
//}
