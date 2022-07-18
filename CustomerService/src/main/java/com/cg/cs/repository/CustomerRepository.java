package com.cg.cs.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cg.cs.entity.Customer;

//@Repository means it is directly connected to the database 
//by using this interface we can do all database related operations
@Repository
public interface CustomerRepository extends MongoRepository<Customer, Long> {

	//Object findById(int i);

//	Optional<Customer> findById(int id);

}
