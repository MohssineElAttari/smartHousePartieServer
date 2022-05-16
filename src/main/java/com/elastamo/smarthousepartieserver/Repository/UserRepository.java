package com.elastamo.smarthousepartieserver.Repository;

import com.elastamo.smarthousepartieserver.Models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User,String> {
    //    ******************************************
//    D'autre methode pour les test unitaire

    //get a user by user name
    User findByUsername(String username);

    // get count user in database

    @Query(value = "select count(u) from User u")
    int getCountUsers();
}
