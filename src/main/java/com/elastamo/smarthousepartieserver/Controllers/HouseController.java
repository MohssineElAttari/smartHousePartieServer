package com.elastamo.smarthousepartieserver.Controllers;

import com.elastamo.smarthousepartieserver.Models.House;
import com.elastamo.smarthousepartieserver.Response.ResponseHandler;
import com.elastamo.smarthousepartieserver.Services.impl.HouseServiceImp;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Collection;
import java.util.List;
import javax.validation.Valid;

@RestController
@RequestMapping("/houses")
public class HouseController {

    private final HouseServiceImp service;

    @Autowired
    public HouseController(HouseServiceImp houseServiceImp){
        this.service=houseServiceImp;
    }

    @GetMapping
    public ResponseEntity<Object> getAllHouse(){
        try {
            Collection<House> houses=service.getAll();
            return ResponseHandler.generateResponse("Successfuly get all data!",HttpStatus.OK,houses);
        }catch (Exception e){
            return ResponseHandler.generateResponse(e.getMessage(),HttpStatus.MULTI_STATUS,null);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Object> addHouse(@Valid @RequestBody House house){
        try {
            House house1 = service.addHouse(house);
            return ResponseHandler.generateResponse("Successfully added House data!",HttpStatus.OK,house1);
        }catch (Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.NOT_FOUND,null);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Object> deleteHouse(@RequestParam(name="id") String id){
        try {
            service.delete(id);
            return ResponseHandler.generateResponse("Successfully deleted house data!",HttpStatus.OK,true);
        }catch (Exception e){
        return ResponseHandler.generateResponse(e.getMessage(),HttpStatus.MULTI_STATUS,null);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Object> update(@RequestBody House house){
        try {
            House house1 = service.update(house);
            return ResponseHandler.generateResponse("Successfully update house data!",HttpStatus.OK,house);
        }catch (Exception e){
            return ResponseHandler.generateResponse(e.getMessage(),HttpStatus.MULTI_STATUS,null);
        }
    }
}
