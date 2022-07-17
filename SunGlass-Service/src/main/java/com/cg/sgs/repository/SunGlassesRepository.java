package com.cg.sgs.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cg.sgs.entity.SunGlasses;



//@Repository means it is directly connected to the database 
//by using this interface we can do all database related operations
@Repository
public interface SunGlassesRepository extends MongoRepository<SunGlasses, Integer> {

}
