package com.elastamo.smarthousepartieserver.Controllers;

import com.elastamo.smarthousepartieserver.Models.House;
import com.elastamo.smarthousepartieserver.Services.impl.HouseServiceImp;
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

    @GetMapping
    public List<House> getAllHouse(){
        return this.service.getAll();
    }

    @PostMapping("/add")
    public House addHouse(@RequestBody House house){
        System.out.println("yap ===================>"+house);
        return this.service.addHouse(house);
    }
}
