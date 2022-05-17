package com.elastamo.smarthousepartieserver.Services.Implements;

import com.elastamo.smarthousepartieserver.Models.User;
import com.elastamo.smarthousepartieserver.Repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.Silent.class)
class UserServiceImpTest {

    @InjectMocks
    private UserServiceImp userServiceImp;
    @Mock
    private UserRepository userRepository;
    private User userA ;
    private User user1 ;
    private User user2 ;

    List<User> userList =new ArrayList<>();

    @BeforeEach
    void setUp() {
        userA=new User("1","elastamo","12345678",null);
        user1=new User("2","pikatsho","87654321",null);
        user2=new User("3","makhito","12348765",null);
    }
    @Test
    void addUser() {
        Mockito.when(userRepository.save(user1)).thenReturn(user1);
        User userA = userServiceImp.addUser(user1);
        assertEquals(userA,user1);
        System.out.println(userA);
    }

    @Test
    void updateUser() {

        User userUP = new User("1","elastamo","12345678",null);

        Mockito.when(userRepository.findById(user1.getId())).thenReturn(Optional.of(user1));

        userUP.setUsername("yap");
        userUP.setPassword("98765432");

        User user6= userServiceImp.findById(user1.getId());
        System.out.println("====> user6 : "+user6);
        System.out.println("======> userUp : "+userUP);
        assertNotEquals(user6,userUP);


    }

    @Test
    void deleteUser() {
        Mockito.when(userRepository.findById(user1.getId())).thenReturn(Optional.of(user1));
        System.out.println(userServiceImp.deleteUser(user1.getId()));
        assertEquals(userServiceImp.deleteUser(user1.getId()),"deleted!");
    }

    @Test
    void findByUsername() {
        Mockito.lenient().when(userRepository.findByUsername(user1.getUsername())).thenReturn(user1);
        System.out.println(user1);
        User userFU = userServiceImp.findByUsername(user1.getUsername());
        assertEquals(user1,userFU);
    }

    @Test
    void findById() {
        Mockito.lenient().when(userRepository.findById(user1.getId())).thenReturn(Optional.of(user1));
        System.out.println(user1);
        User userF = userServiceImp.findById(user1.getId());
        assertEquals(user1,userF);
    }

    @Test
    void getAll() {
        List<User>users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        Mockito.when(userRepository.findAll()).thenReturn(users);

        assertNotNull(users);

        List<User> users1= userServiceImp.getAll();

        users1.forEach(c->{
            System.out.println(c);
        });
    }

    @Test
    void countUsers() {
        Mockito.when(userRepository.getCountUsers()).thenReturn(3);
        int c=userServiceImp.countUsers();
        System.out.println(c);
        assertEquals(userServiceImp.countUsers(),3);
    }

    @Test
    void loadUserByUsername() {

        Mockito.when(userRepository.findByUsername(user1.getUsername())).thenReturn(user1);
        System.out.println(user1);
        assertEquals(userRepository.findByUsername(user1.getUsername()),user1);
    }
}