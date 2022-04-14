package com.elastamo.smarthousepartieserver.Controllers;

import com.elastamo.smarthousepartieserver.Models.House;
import com.elastamo.smarthousepartieserver.Services.HouseServiceImp;
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
