package com.elastamo.smarthousepartieserver.repository;

import com.elastamo.smarthousepartieserver.models.House;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseRepository extends MongoRepository<House,String> {

}
