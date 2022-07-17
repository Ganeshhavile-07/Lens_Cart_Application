package com.cg.ls.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cg.ls.entity.Lenses;



//@Repository means it is directly connected to the database 
//by using this interface we can do all database related operations
@Repository
public interface LensesRepository extends MongoRepository<Lenses, Integer> {
   
}
