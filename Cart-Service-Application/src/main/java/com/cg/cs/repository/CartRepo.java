package com.cg.cs.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cg.cs.entity.Cart;


@Repository
public interface CartRepo extends MongoRepository<Cart,Long>{

	/*
	 * @Query("{'Product.id':?0}") List<Product> findByIdProduct(Long id);
	 */
}
