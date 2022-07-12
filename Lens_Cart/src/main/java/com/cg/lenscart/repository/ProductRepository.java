package com.cg.lenscart.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cg.lenscart.entity.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, Integer> {

}
