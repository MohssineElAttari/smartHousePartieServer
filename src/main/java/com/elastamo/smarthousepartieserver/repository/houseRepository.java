package com.elastamo.smarthousepartieserver.repository;

import com.elastamo.smarthousepartieserver.entity.House;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface houseRepository extends MongoRepository<House,String> {

}
