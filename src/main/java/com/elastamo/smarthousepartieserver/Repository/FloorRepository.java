package com.elastamo.smarthousepartieserver.Repository;

import com.elastamo.smarthousepartieserver.Models.Device;
import com.elastamo.smarthousepartieserver.Models.Floor;
import com.elastamo.smarthousepartieserver.Models.House;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FloorRepository extends MongoRepository<Floor,String> {
    //List<Floor> findFloorByHouse(House house);
    int countFloorsByHouse_Id(String device_ID);
}
