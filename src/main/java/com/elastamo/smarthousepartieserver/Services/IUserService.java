package com.elastamo.smarthousepartieserver.Services;

import com.elastamo.smarthousepartieserver.Models.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IUserService {
    public User addUser(User user);
    public User update(User user);
    public String delete(String id);
    public User FindById(String id);
    public List<User> getAll();

}
