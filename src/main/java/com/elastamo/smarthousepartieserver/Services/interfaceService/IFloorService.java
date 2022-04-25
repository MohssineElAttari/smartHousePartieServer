package com.elastamo.smarthousepartieserver.Services.interfaceService;

import com.elastamo.smarthousepartieserver.Models.Floor;
import com.elastamo.smarthousepartieserver.Models.House;

import java.util.List;

public interface IFloorService {
    Floor addHouse(Floor floor);
    List<Floor> getAll();
    String delete(Floor id);
    Floor findById(String is);
    Floor update(Floor floor,String id);
}
