package com.elastamo.smarthousepartieserver.Services.Interfaces;

import com.elastamo.smarthousepartieserver.Models.House;
import com.elastamo.smarthousepartieserver.Models.Room;

import java.util.List;

public interface IRoomService {
    Room addRoom(Room room);
    List<Room> getAll();
    String delete(Room id);
    Room findById(String id);
    Room update(Room room);
}
