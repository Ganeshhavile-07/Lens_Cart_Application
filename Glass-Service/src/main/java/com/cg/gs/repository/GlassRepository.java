package com.cg.gs.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cg.gs.entity.Glass;



//@Repository means it is directly connected to the database 
//by using this interface we can do all database related operations
@Repository
public interface GlassRepository extends MongoRepository<Glass, Integer> {

}
