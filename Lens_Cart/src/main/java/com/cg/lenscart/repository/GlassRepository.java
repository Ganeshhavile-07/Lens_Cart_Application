package com.cg.lenscart.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cg.lenscart.entity.Glass;

@Repository
public interface GlassRepository extends MongoRepository<Glass, Integer> {

}
