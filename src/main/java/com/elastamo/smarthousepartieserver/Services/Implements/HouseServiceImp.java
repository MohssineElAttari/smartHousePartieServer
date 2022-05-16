package com.elastamo.smarthousepartieserver.Services.Implements;

import com.elastamo.smarthousepartieserver.Models.House;
import com.elastamo.smarthousepartieserver.Models.User;
import com.elastamo.smarthousepartieserver.Repository.HouseRepository;
import com.elastamo.smarthousepartieserver.Services.Interfaces.IHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseServiceImp implements IHouseService {

    final private HouseRepository houseRepository;

    @Autowired
    private UserServiceImp userServiceImp;

    @Autowired
    public HouseServiceImp(HouseRepository houseRepository){
        this.houseRepository=houseRepository;
    }

    @Override
    public House addHouse(House house) {

        User userData = userServiceImp.findById(house.getUser().getId());

        if(userData == null) {
            User user = house.getUser();
            this.userServiceImp.addUser(user);
        }

        userData = userServiceImp.findById(house.getUser().getId());

        if(userData != null){
            house.setUser(userData);
            houseRepository.save(house);
        }
        return house;
    }

    @Override
    public List<House> getAll() {
        return houseRepository.findAll();
    }

    @Override
    public String delete(String id) {
        houseRepository.deleteById(id);
        return "Deleted!";
    }

    @Override
    public House findById(String id) {
        House existClient = houseRepository.findById(id).orElse(null);
        if(existClient!=null){
            return houseRepository.findById(id).get();
        }
        return existClient;
    }

    @Override
    public House update(House house) {
        House houseUp = houseRepository.findById(house.getId()).orElse(null);
        if(houseUp != null){
            return houseRepository.save(house);
        }
        return null;
    }

    @Override
    public int countHouse() {
        return houseRepository.countHouse();
    }

    @Override
    public int countHouseByUser(String id) {
        return houseRepository.countByUser(id);
    }

    @Override
    public House findHouseByNameAndUserName(String name, String userName) {
        return houseRepository.findHouseByNameAndUser_Username(name,userName);
    }
}
