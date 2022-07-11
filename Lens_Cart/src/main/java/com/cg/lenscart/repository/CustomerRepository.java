package com.cg.lenscart.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cg.lenscart.entity.Customer;

@Repository
public interface CustomerRepository  extends MongoRepository<Customer, Integer>{

}
