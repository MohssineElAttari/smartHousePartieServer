package com.elastamo.smarthousepartieserver.Services.impl;

import com.elastamo.smarthousepartieserver.Models.User;
import com.elastamo.smarthousepartieserver.Repository.UserRepository;
import com.elastamo.smarthousepartieserver.Services.interfaceService.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return this.userRepository.save(user);
    }

    @Override
    public String delete(String id) {
        this.userRepository.deleteById(id);
        return "deleted";
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
}
