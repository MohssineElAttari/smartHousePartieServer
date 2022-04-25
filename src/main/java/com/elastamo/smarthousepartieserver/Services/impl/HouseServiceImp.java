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

        User getUserData = userServiceImp.findById(house.getUser().getId());

        if(getUserData == null) {
            User user = house.getUser();
//            user.setHouses((Collection<House>) house);
            this.userServiceImp.addUser(user);

        }

        getUserData = userServiceImp.findById(house.getUser().getId());
        if(getUserData != null){
            house.setUser(getUserData);
            houseRepository.save(house);
        }
        return house;
    }

    @Override
    public List<House> getAll() {

        return houseRepository.findAll();
    }

    @Override
    public String delete(House house) {
        houseRepository.delete(house);
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
    public House update(House house, String id) {
        House device1 = houseRepository.findById(house.getId()).orElse(null);
        if(device1 != null){
            return houseRepository.save(house);
        }
        return null;
    }
}
