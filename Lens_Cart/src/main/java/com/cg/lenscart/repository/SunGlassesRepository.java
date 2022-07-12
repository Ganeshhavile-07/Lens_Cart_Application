package com.cg.lenscart.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cg.lenscart.entity.SunGlasses;

@Repository
public interface SunGlassesRepository extends MongoRepository<SunGlasses, Integer> {

}
