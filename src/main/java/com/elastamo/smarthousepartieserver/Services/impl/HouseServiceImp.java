package com.elastamo.smarthousepartieserver.Services.impl;

import com.elastamo.smarthousepartieserver.Models.House;
import com.elastamo.smarthousepartieserver.Models.User;
import com.elastamo.smarthousepartieserver.Repository.HouseRepository;
import com.elastamo.smarthousepartieserver.Services.interfaceService.IHouseService;
import com.elastamo.smarthousepartieserver.Services.interfaceService.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
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
}
