package com.elastamo.smarthousepartieserver.Controllers;

import com.elastamo.smarthousepartieserver.Models.Room;
import com.elastamo.smarthousepartieserver.Response.ResponseHandler;
import com.elastamo.smarthousepartieserver.Services.Implements.RoomServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/room")
public class RoomController {

    private RoomServiceImp roomServiceImp;
    public RoomController(RoomServiceImp roomServiceImp){
        this.roomServiceImp=roomServiceImp;
    }

    @GetMapping
    public ResponseEntity<Object> getAll(){
        try {
            List<Room> rooms = roomServiceImp.getAll();
            return ResponseHandler.generateResponse("Succssfuly get Data!", HttpStatus.OK,rooms);
        }catch(Exception e){
            return ResponseHandler.generateResponse(e.getMessage(),HttpStatus.MULTI_STATUS,null);

        }
    }

    @PostMapping("/add")
    public ResponseEntity<Object> addRoom(@RequestBody Room room){
        try {
            Room room1= roomServiceImp.addRoom(room);
            return ResponseHandler.generateResponse("Succsefuly add data!",HttpStatus.OK,room1);
        }catch (Exception e){
            return ResponseHandler.generateResponse(e.getMessage(),HttpStatus.MULTI_STATUS,null);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Object >deleteRoom(@RequestParam String id){
        try {
            Room room= roomServiceImp.findById(id);
            if (room!=null){
                String deleted= roomServiceImp.delete(room);
                return ResponseHandler.generateResponse("succssfuly deleted data!",HttpStatus.OK,deleted);
            }else{
                return ResponseHandler.generateResponse("unavailable data!",HttpStatus.OK,null);
            }
        }catch(Exception e){
            return ResponseHandler.generateResponse(e.getMessage(),HttpStatus.MULTI_STATUS,null);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Object> updateRoom(@RequestBody Room room){
        try {
            Room room1= roomServiceImp.findById(room.getId());
            if (room!=null){
                roomServiceImp.update(room);
                return ResponseHandler.generateResponse("Successfuly data!",HttpStatus.OK,room);
            }
            else {
                return ResponseHandler.generateResponse("unvailable data!",HttpStatus.OK,null);
            }
        }catch(Exception e){
            return ResponseHandler.generateResponse(e.getMessage(),HttpStatus.MULTI_STATUS,null);
        }
    }

    @PostMapping("/findByID")
    public ResponseEntity<Object> findByID(@RequestParam String id){
        try {
            Room room= roomServiceImp.findById(id);
            return ResponseHandler.generateResponse("successfuly data!"+room.getId(),HttpStatus.OK,room);
        }catch(Exception e){
            return ResponseHandler.generateResponse(e.getMessage(),HttpStatus.MULTI_STATUS,null);
        }
    }
}
