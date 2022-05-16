package com.elastamo.smarthousepartieserver.Services.Interfaces;

import com.elastamo.smarthousepartieserver.Models.Floor;

import java.util.List;

public interface IFloorService {
    Floor addFloor(Floor floor);
    List<Floor> getAll();
    String delete(Floor id);
    Floor findById(String is);
    Floor update(Floor floor);
    int countFloor();
    int countFloorByHouse(String house);
}
