package com.elastamo.smarthousepartieserver.Services.Interfaces;

import com.elastamo.smarthousepartieserver.Models.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IUserService extends UserDetailsService {
    User addUser(User user);
    User updateUser(User user);
    String deleteUser(String id);
    User findByUsername(String username);
    User findById(String id);
    List<User> getAll();
    int countUsers();
}
