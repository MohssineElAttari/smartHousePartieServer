package com.elastamo.smarthousepartieserver.Repository;

import com.elastamo.smarthousepartieserver.Models.User;
import com.elastamo.smarthousepartieserver.Services.Implements.UserServiceImp;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
class UserRepositoryTest {

    @Mock
    private UserRepository userRepository;

    private User user ;
    private User user1 ;
    private User user2 ;

    List<User> userList =new ArrayList<>();

    @BeforeEach
    void setUp() {
        user=new User("1","elastamo","12345678");
        user1=new User("2","pikatsho","87654321");
        user2=new User("3","makhito","12348765");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findByUsername() {
        Mockito.lenient().when(userRepository.findByUsername("elastamo")).thenReturn(user);
        System.out.println(user);
        assertEquals(userRepository.findByUsername("Mohssine@gmail.com"),user);
        assertNotNull(userRepository.findByUsername("Mohssine@gmail.com"));
    }

    @Test
    void getCountUsers() {
        List<User> users = new ArrayList<>();

        users.add(user);
        users.add(user1);
        users.add(user2);

        Mockito.when(userRepository.findAll()).thenReturn(users);
        assertNotNull(users);


        List<User>users1=userRepository.findAll();

        users1.forEach(c->{
            System.out.println(c);
        });
    }

}