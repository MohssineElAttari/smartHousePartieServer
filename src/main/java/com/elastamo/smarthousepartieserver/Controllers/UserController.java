package com.elastamo.smarthousepartieserver.Controllers;

import com.elastamo.smarthousepartieserver.Models.User;
import com.elastamo.smarthousepartieserver.Services.impl.UserServiceImp;
import com.elastamo.smarthousepartieserver.Services.interfaceService.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserServiceImp userService;

    @GetMapping
    public Collection<User> getAll(){
        Collection<User> users = userService.getAll();
        return  users;
    }

    @PostMapping("/add")
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }
}
