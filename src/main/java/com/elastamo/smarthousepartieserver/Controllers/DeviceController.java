package com.elastamo.smarthousepartieserver.Controllers;

import com.elastamo.smarthousepartieserver.Models.Device;
import com.elastamo.smarthousepartieserver.Response.ResponseHandler;
import com.elastamo.smarthousepartieserver.Services.Implements.DeviceServiceImp;
import com.elastamo.smarthousepartieserver.Services.Interfaces.IDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/device")
public class DeviceController {

    @Autowired
    private DeviceServiceImp deviceService;

    @PostMapping("/add")
    public ResponseEntity<Object> addDevice(@RequestBody Device device){
        try {
            Device device1=deviceService.addDevice(device);
            return ResponseHandler.generateResponse("successfuly data!", HttpStatus.OK,device1);
        }catch (Exception e){
            return ResponseHandler.generateResponse(e.getMessage(),HttpStatus.MULTI_STATUS,null);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Object> updateDevice(@RequestBody Device device3){
        try {
            Device device = deviceService.findById(device3.getId());
            if (device!=null){
                return ResponseHandler.generateResponse("successfuly data!",HttpStatus.OK,device);
            }else
                return ResponseHandler.generateResponse("unvailable data!",HttpStatus.OK,null);
        }catch(Exception e){
            return ResponseHandler.generateResponse(e.getMessage(),HttpStatus.MULTI_STATUS,null);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Object> deleteDevice(@RequestParam String id){
        try {
            Device device=deviceService.findById(id);
            String deleted=deviceService.delete(device);
            return ResponseHandler.generateResponse("successfuly Deleted data!",HttpStatus.OK,deleted);
        }
        catch (Exception e){
            return ResponseHandler.generateResponse(e.getMessage(),HttpStatus.MULTI_STATUS,null);
        }
    }

    @PostMapping("/findByID")
    public ResponseEntity<Object> findByID(@RequestParam String id){
        try {
            Device device=deviceService.findById(id);
            if (device!=null){
                return ResponseHandler.generateResponse("successfuly find data!",HttpStatus.OK,device);
            }else
                return ResponseHandler.generateResponse("ubvailable data!",HttpStatus.OK,null);
        }catch (Exception e){
            return ResponseHandler.generateResponse(e.getMessage(),HttpStatus.MULTI_STATUS,null);
        }
    }

}
