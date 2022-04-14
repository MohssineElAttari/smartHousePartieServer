package com.elastamo.smarthousepartieserver;

import com.elastamo.smarthousepartieserver.Models.House;
import com.elastamo.smarthousepartieserver.Models.User;
import com.elastamo.smarthousepartieserver.Repository.HouseRepository;
import com.elastamo.smarthousepartieserver.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SmartHousePartieServerApplication implements CommandLineRunner {


    private final HouseRepository houseRepository;
    private final UserRepository userRepository;

    @Autowired
    public SmartHousePartieServerApplication(HouseRepository houseRepository, UserRepository userRepository) {
        this.houseRepository = houseRepository;
        this.userRepository = userRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(SmartHousePartieServerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        if(houseRepository.findAll().isEmpty()){
            houseRepository.save(new House("House elattari"));
            houseRepository.save(new House("House elbarkani"));
        }
        if(userRepository.findAll().isEmpty()){
            userRepository.save(new User("elattari","12345"));
            userRepository.save(new User("elastamo","12345"));
        }
        for (House house : houseRepository.findAll()){
            System.out.println(house);
        }
        for (User user : userRepository.findAll()){
            System.out.println(user);
        }
    }
}
