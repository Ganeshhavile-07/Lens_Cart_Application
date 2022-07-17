package com.cg.ps.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cg.ps.entity.Payment;

@Repository
public interface Payment_repository extends MongoRepository<Payment, Integer>{

}
