package com.elastamo.smarthousepartieserver.Services.interfaceService;

import com.elastamo.smarthousepartieserver.Models.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IUserService extends UserDetailsService {
    public User addUser(User user);
    public User update(User user);
    public String delete(String id);
    public User findByUsername(String username);

    User findById(String id);

    public List<User> getAll();

}
