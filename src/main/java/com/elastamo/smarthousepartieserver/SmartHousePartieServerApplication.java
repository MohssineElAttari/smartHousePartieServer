package com.elastamo.smarthousepartieserver;

import com.elastamo.smarthousepartieserver.Repository.HouseRepository;
import com.elastamo.smarthousepartieserver.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

import java.util.Scanner;

@SpringBootApplication
public class SmartHousePartieServerApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(SmartHousePartieServerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
