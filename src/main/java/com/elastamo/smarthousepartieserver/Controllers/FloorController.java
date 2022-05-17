package com.elastamo.smarthousepartieserver.Controllers;

import com.elastamo.smarthousepartieserver.Models.Floor;
import com.elastamo.smarthousepartieserver.Response.ResponseHandler;
import com.elastamo.smarthousepartieserver.Services.Implements.FloorServiceImp;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/floor")
@RequiredArgsConstructor
public class FloorController {

    private final FloorServiceImp floorServiceImp;

    @GetMapping
    public ResponseEntity<Object> getAll(){
        try {
            List<Floor>floors= floorServiceImp.getAll();
            return ResponseHandler.generateResponse("Successfuly get all data!", HttpStatus.OK,floors);
        }catch(Exception e){
            return ResponseHandler.generateResponse(e.getMessage(),HttpStatus.MULTI_STATUS,null);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Object> addFloor(@RequestBody Floor floor){
        try {
            Floor floor1=floorServiceImp.addFloor(floor);
            return ResponseHandler.generateResponse("Successfuly add data!",HttpStatus.OK,floor1);
        }catch(Exception e){
            return ResponseHandler.generateResponse(e.getMessage(),HttpStatus.MULTI_STATUS,null);
    }
}
    @DeleteMapping("/delete")
    public ResponseEntity<Object> deleteFloor(@RequestParam String id){
        try {
        Floor floor = floorServiceImp.findById(id);
        String status=floorServiceImp.delete(floor);
        return ResponseHandler.generateResponse("Successfuly deleted data floor!",HttpStatus.OK,status);

        }catch (Exception e){
            return ResponseHandler.generateResponse(e.getMessage(),HttpStatus.MULTI_STATUS,null);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Object> updateFloor(@RequestBody Floor floor){
        try {
            Floor existFloor= floorServiceImp.findById(floor.getId());
            if (existFloor!=null){
                Floor floor1 =floorServiceImp.update(floor);
                return ResponseHandler.generateResponse("Successfuly update data floor!"+floor1.getNumber(),HttpStatus.OK,floor1);
            }else{
                return ResponseHandler.generateResponse("unavailable data!",HttpStatus.OK,null);

            }
        }catch (Exception e){
            return ResponseHandler.generateResponse(e.getMessage(),HttpStatus.MULTI_STATUS,null);

        }
    }

    @PostMapping("/findByID")
    public ResponseEntity<Object> findByID(@RequestParam String id){
        try {
            Floor floorExist= floorServiceImp.findById(id);
            if (floorExist!=null){
                return ResponseHandler.generateResponse("Successfuly find floor !"+floorExist.getId(),HttpStatus.OK,floorExist);
            }else{
                return ResponseHandler.generateResponse("Unavailable data!",HttpStatus.OK,null);
            }
        }catch (Exception e){
            return ResponseHandler.generateResponse(e.getMessage(),HttpStatus.MULTI_STATUS,null);
        }
    }

    @GetMapping("/count")
    public ResponseEntity<Object> count(){
        try {
            int count= floorServiceImp.countFloor();
            return ResponseHandler.generateResponse("Successfuly get count data!", HttpStatus.OK,count);
        }catch (Exception e){
            return ResponseHandler.generateResponse(e.getMessage(),HttpStatus.MULTI_STATUS,null);
        }

    }

    @GetMapping("/countByHouse")
    public ResponseEntity<Object> countByHouse(@PathVariable String houseID){
        try{
            int countByHouse=floorServiceImp.countFloorByHouse(houseID);
            return ResponseHandler.generateResponse("Succsefuly get cout floor by house data !",HttpStatus.OK,countByHouse);
        }catch(Exception e){
            return ResponseHandler.generateResponse(e.getMessage(),HttpStatus.MULTI_STATUS,null);

        }
    }
}
