package com.elastamo.smarthousepartieserver.Controllers;

import com.elastamo.smarthousepartieserver.Models.User;
import com.elastamo.smarthousepartieserver.Response.ResponseHandler;
import com.elastamo.smarthousepartieserver.Services.Implements.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserServiceImp userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("all")
    public ResponseEntity<Object> getAll(){
        try {
            Collection<User> result = userService.getAll();
            return ResponseHandler.generateResponse("Successfuly get all data!", HttpStatus.OK,result);
        }catch(Exception e){
            return ResponseHandler.generateResponse(e.getMessage(),HttpStatus.MULTI_STATUS,null);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody User user){
        try {
            String password = bCryptPasswordEncoder.encode(user.getPassword());
            user.setPassword(password);
            User result=userService.addUser(user);
            return ResponseHandler.generateResponse("Successfuly Add User Data", HttpStatus.OK,result);
        }catch (Exception e){
            return ResponseHandler.generateResponse(e.getMessage(),HttpStatus.OK,null);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteUser(@RequestParam (name = "id") String id){
        try {
            userService.deleteUser(id);
            return ResponseHandler.generateResponse("Successfuly Delete User : "+id,HttpStatus.OK,"Deleted!");
        }catch(Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(),HttpStatus.MULTI_STATUS,null);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Object> updateUser(@RequestBody User user){
        try{
            User existUser= userService.findById(user.getId());
            if (existUser!=null){
                User result= userService.updateUser(user);
                return ResponseHandler.generateResponse("Successfully Update User : "+user.getUsername(),HttpStatus.OK,result);
            }
            else{
                return ResponseHandler.generateResponse("unavailable data!",HttpStatus.OK,null);
            }}
        catch (Exception e){
            return ResponseHandler.generateResponse(e.getMessage(),HttpStatus.MULTI_STATUS,null);
        }
    }

    @PostMapping("/findByUserName/{username}")
    public ResponseEntity<Object> findByUserName(@RequestParam (name = "username") String userName){
        try {
            User result= userService.findByUsername(userName);
            return ResponseHandler.generateResponse("Successfully find User by Username!",HttpStatus.OK,result);
        }catch(Exception e){
            return ResponseHandler.generateResponse(e.getMessage(),HttpStatus.MULTI_STATUS,null);
        }
    }

    @GetMapping("/count")
    public ResponseEntity<Object> countUsers(){
        try {
            int result = userService.countUsers();
            return ResponseHandler.generateResponse("successfuly get Data!",HttpStatus.OK,result);
        }catch(Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS,null);
        }
    }
}
