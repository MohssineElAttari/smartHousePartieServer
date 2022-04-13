package com.elastamo.smarthousepartieserver.services;

import com.elastamo.smarthousepartieserver.models.House;

import java.util.List;

public interface HouseServiceInt {
    House addHouse(House house);
    List<House>getAll();
    String delete(House id);
    House findById(String is);
    House update(House house,String id);
}
