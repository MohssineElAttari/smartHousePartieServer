package com.elastamo.smarthousepartieserver.Services.Interfaces;

import com.elastamo.smarthousepartieserver.Models.House;

import java.util.List;

public interface IHouseService {
    House addHouse(House house);
    List<House>getAll();
    String delete(String id);
    House findById(String is);
    House update(House house);
    int countHouse();
    int countHouseByUser(String id);
    House findHouseByNameAndUserName(String name,String userName);

}
