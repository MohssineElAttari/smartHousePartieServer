package com.elastamo.smarthousepartieserver.Services;

import com.elastamo.smarthousepartieserver.Models.House;
import com.elastamo.smarthousepartieserver.Repository.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseServiceImp implements IHouseService {

    final private HouseRepository houseRepository;
    @Autowired
    public HouseServiceImp(HouseRepository houseRepository){
        this.houseRepository=houseRepository;
    }

    @Override
    public House addHouse(House house) {
        return houseRepository.save(house);
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
        return houseRepository.findById(id).get();
    }

    @Override
    public House update(House house, String id) {
        House house1 =houseRepository.findById(id).get();
        house1.setName(house.getName());
        return houseRepository.save(house1);
    }
}
