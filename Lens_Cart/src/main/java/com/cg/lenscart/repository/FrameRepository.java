package com.cg.lenscart.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cg.lenscart.entity.Frame;

@Repository
public interface FrameRepository extends MongoRepository<Frame, Integer> {

}
