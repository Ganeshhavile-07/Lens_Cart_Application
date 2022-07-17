package com.cg.ps.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cg.ps.entity.Product;



//@Repository means it is directly connected to the database 
//by using this interface we can do all database related operations
@Repository
public interface ProductRepository extends MongoRepository<Product, Long> {

}
