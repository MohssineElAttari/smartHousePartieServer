package com.elastamo.smarthousepartieserver.Services.Implements;

import com.elastamo.smarthousepartieserver.Models.User;
import com.elastamo.smarthousepartieserver.Repository.UserRepository;
import com.elastamo.smarthousepartieserver.Services.Interfaces.IUserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImp implements IUserService {

//    @Autowired
    private UserRepository userRepository;

    public UserServiceImp(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public User addUser(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        User userUp = userRepository.findById(user.getId()).orElse(null);
        if(userUp != null){
            return userRepository.save(user);
        }
        return null;
    }

    @Override
    public String deleteUser(String id) {
        this.userRepository.delete(userRepository.findById(id).get());
        return "deleted!";
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User findById(String id) {

            User existUser = this.userRepository.findById(id).orElse(null);
            if (existUser!=null){
                return this.userRepository.findById(id).get();
            }
            return existUser;
    }
    @Override
    public List<User> getAll() {
        return this.userRepository.findAll();
    }

    @Override
    public int countUsers() {
        return userRepository.getCountUsers();
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
