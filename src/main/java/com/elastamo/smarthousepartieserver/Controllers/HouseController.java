package com.elastamo.smarthousepartieserver.Controllers;

import com.elastamo.smarthousepartieserver.Models.House;
import com.elastamo.smarthousepartieserver.Response.ResponseHandler;
import com.elastamo.smarthousepartieserver.Services.Implements.HouseServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Collection;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/house")
public class HouseController {

    private final HouseServiceImp service;

    @Autowired
    public HouseController(HouseServiceImp houseServiceImp){
        this.service=houseServiceImp;
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getAllHouse(){
        try {
            //get all House
            Collection<House> result=service.getAll();
            return ResponseHandler.generateResponse("Successfuly get all data!",HttpStatus.OK,result);
        }catch (Exception e){
            return ResponseHandler.generateResponse(e.getMessage(),HttpStatus.MULTI_STATUS,null);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Object> addHouse(@Valid @RequestBody House house){
        try {
            //add new hosue
            House result = service.addHouse(house);
            return ResponseHandler.generateResponse("Successfully added House data!",HttpStatus.OK,result);
        }catch (Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.NOT_FOUND,null);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Object> deleteHouse(@RequestParam(name="id") String id){
        try {
            // delete house
            String result=service.delete(id);
            return ResponseHandler.generateResponse("Successfully deleted house data!",HttpStatus.OK,result);
        }catch (Exception e){
        return ResponseHandler.generateResponse(e.getMessage(),HttpStatus.MULTI_STATUS,null);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Object> update(@RequestBody House house){
        try {
            House result = service.update(house);
            return ResponseHandler.generateResponse("Successfully update house data!",HttpStatus.OK,result);
        }catch (Exception e){
            return ResponseHandler.generateResponse(e.getMessage(),HttpStatus.MULTI_STATUS,null);
        }
    }

    @GetMapping("/count")
    public ResponseEntity<Object> countHouse(){
        try {
            int result = service.countHouse();
            return ResponseHandler.generateResponse("Successfully get count house data!",HttpStatus.OK,result);
        }catch(Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.OK,null);
        }
    }
    @GetMapping("/count/{idUser}")
    public ResponseEntity<Object> countHouseByUser(@PathVariable String idUser){
        try {
            int result = service.countHouseByUser(idUser);
            return ResponseHandler.generateResponse("Successfully get count house data By User!",HttpStatus.OK,result);
        }catch(Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.OK,null);
        }
    }
    @GetMapping("/count/{idUser}")
    public ResponseEntity<Object> finfHouseByNameAndUserName(@PathVariable String name,@PathVariable String userName){
        try {
            House result = service.findHouseByNameAndUserName(name,userName);
            return ResponseHandler.generateResponse("Successfully find house data By name and userName!",HttpStatus.OK,result);
        }catch(Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.OK,null);
        }
    }

}
