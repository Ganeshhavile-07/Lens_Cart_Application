package com.capgemini.jwt.mongodb.util;
//package com.cg.jwt.util;
//
//import java.util.List;
//
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
////import org.springframework.web.bind.annotation.PutMapping;
//import com.cg.jwt.models.Product;
//
//@FeignClient(value = "Lens-Cart" ,url = "http://localhost:9001/api/v1")
//public interface FeignClientUtilProduct {
//		
//	
//	@GetMapping("/allproducts") 
//	public ResponseEntity<List<Product>> getAllProducts();
//	 
//	 @GetMapping("/getproduct/{id}") public ResponseEntity<Product>
//	  getProductById(Long id);
//	  
//	 //only user
//	  @PostMapping("/addproduct")
//	  public ResponseEntity<Product> addProduct(Product  product);
//	  
////	  //update product 
////	 @PutMapping("/updateproduct") 
////	 public ResponseEntity<Product> updateProduct(Product product ,Long id);
////	 
//	 //delete product -> only user
//	 @DeleteMapping("/deleteproduct/{id}")  
//	 public ResponseEntity<String> deleteProduct(Long id);
//	 
//	
//		
//		  
//		
//		
//	
//
//}
