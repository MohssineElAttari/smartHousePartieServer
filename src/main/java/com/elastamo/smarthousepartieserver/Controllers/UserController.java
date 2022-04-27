package com.elastamo.smarthousepartieserver.Controllers;

import com.elastamo.smarthousepartieserver.Models.User;
import com.elastamo.smarthousepartieserver.Response.ResponseHandler;
import com.elastamo.smarthousepartieserver.Services.impl.UserServiceImp;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserServiceImp userService;

    @GetMapping
    public ResponseEntity<Object> getAll(){
        try {
            Collection<User> users = userService.getAll();
            return ResponseHandler.generateResponse("Successfuly get all data!", HttpStatus.OK,users);
        }catch(Exception e){
            return ResponseHandler.generateResponse(e.getMessage(),HttpStatus.MULTI_STATUS,null);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Object> addUser(@RequestBody User user){
        try{
           User user1= userService.addUser(user);
            return ResponseHandler.generateResponse("Successfuly add user data!", HttpStatus.OK,user1);
        }catch(Exception e){
            return ResponseHandler.generateResponse(e.getMessage(),HttpStatus.MULTI_STATUS,null);
        }
    }
}
