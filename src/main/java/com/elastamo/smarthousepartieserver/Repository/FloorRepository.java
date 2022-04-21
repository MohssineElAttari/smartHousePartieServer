package com.elastamo.smarthousepartieserver.Repository;

import com.elastamo.smarthousepartieserver.Models.Device;
import com.elastamo.smarthousepartieserver.Models.Floor;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface FloorRepository extends MongoRepository<Floor,String> {
    List<Floor>findFloorByDevice(Device device);
}
