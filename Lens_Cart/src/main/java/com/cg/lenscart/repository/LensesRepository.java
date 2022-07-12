package com.cg.lenscart.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cg.lenscart.entity.Lenses;

@Repository
public interface LensesRepository extends MongoRepository<Lenses, Integer> {
   
}
