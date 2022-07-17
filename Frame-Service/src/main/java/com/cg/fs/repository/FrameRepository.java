package com.cg.fs.repository;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cg.fs.entity.Frame;

//@Repository means it is directly connected to the database 
//by using this interface we can do all database related operations
@Repository
public interface FrameRepository extends MongoRepository<Frame, Integer> {

	

}
