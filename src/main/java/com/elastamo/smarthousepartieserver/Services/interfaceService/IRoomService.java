package com.elastamo.smarthousepartieserver.Services.interfaceService;

import com.elastamo.smarthousepartieserver.Models.House;
import com.elastamo.smarthousepartieserver.Models.Room;

import java.util.List;

public interface IRoomService {
    House addRoom(Room room);
    List<Room> getAll();
    String delete(Room id);
    Room findById(String is);
    Room update(Room room,String id);
}
