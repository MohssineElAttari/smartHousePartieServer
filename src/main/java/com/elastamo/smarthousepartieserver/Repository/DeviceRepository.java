package com.elastamo.smarthousepartieserver.Repository;

import com.elastamo.smarthousepartieserver.Models.Device;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceRepository extends MongoRepository<Device,String> {
}
