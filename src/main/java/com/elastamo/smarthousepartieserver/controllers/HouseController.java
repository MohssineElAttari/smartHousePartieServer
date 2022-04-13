package com.elastamo.smarthousepartieserver.controllers;

import com.elastamo.smarthousepartieserver.models.House;
import com.elastamo.smarthousepartieserver.repository.HouseRepository;
import com.elastamo.smarthousepartieserver.services.HouseServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/houses")
public class HouseController {

    private final HouseServiceImp service;

    @Autowired
    public HouseController(HouseServiceImp houseServiceImp){
        this.service=houseServiceImp;
    }

    @GetMapping("/getAll")
    public List<House> getAllHouse(){
        return this.service.getAll();
    }

    @PostMapping("/add")
    public House addHouse(RequestBody house ){
        return this.addHouse(house);
    }
}
