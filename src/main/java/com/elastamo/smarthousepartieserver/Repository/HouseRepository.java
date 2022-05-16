package com.elastamo.smarthousepartieserver.Repository;

import com.elastamo.smarthousepartieserver.Models.House;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseRepository extends MongoRepository<House,String> {

    House findHouseByNameAndUser_Username(String nameHouse,String nameUser);

    @Query(value = "select count(h) from House h")
    int countHouse();

    @Query(value = "select count(h) from House h where h.user.id=:id")
    int countByUser(@Param("id") String id);

}
