package com.cg.gs.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cg.gs.entity.Glass;

@Repository
public interface GlassRepository extends MongoRepository<Glass, Integer> {

}
