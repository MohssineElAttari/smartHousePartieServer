package com.elastamo.smarthousepartieserver.Services.impl;

import com.elastamo.smarthousepartieserver.Models.House;
import com.elastamo.smarthousepartieserver.Models.User;
import com.elastamo.smarthousepartieserver.Repository.UserRepository;
import com.elastamo.smarthousepartieserver.Services.interfaceService.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImp implements IUserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImp(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public User addUser(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public User update(User user) {
        User userUp = userRepository.findById(user.getId()).orElse(null);
        if(userUp != null){
            return userRepository.save(user);
        }
        return null;
    }

    @Override
    public String delete(String id) {
        this.userRepository.deleteById(id);
        return "deleted";
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User findById(String id) {
        try {
            return this.userRepository.findById(id).get();
        }catch (Exception e){
            return null;
        }
    }
    @Override
    public List<User> getAll() {
        return this.userRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user= this.findByUsername(username);
        if (user==null){
            throw new UsernameNotFoundException("user not found !");
        }
        return new org.springframework.security.core.userdetails.User(username,user.getPassword(),new ArrayList<>());
    }
}
