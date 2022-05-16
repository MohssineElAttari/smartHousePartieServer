package com.elastamo.smarthousepartieserver.Services.Implements;

import com.elastamo.smarthousepartieserver.Models.House;
import com.elastamo.smarthousepartieserver.Models.Room;
import com.elastamo.smarthousepartieserver.Repository.RoomRepository;
import com.elastamo.smarthousepartieserver.Services.Interfaces.IRoomService;
import jdk.jfr.internal.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImp implements IRoomService {

    private RoomRepository repository;

    public RoomServiceImp(RoomRepository roomRepository){
        this.repository=roomRepository;
    }

    @Override
    public Room addRoom(Room room) {
        return this.repository.save(room);
    }

    @Override
    public List<Room> getAll() {
        return this.repository.findAll();
    }

    @Override
    public String delete(Room id) {
        repository.delete(id);
        return "deleted!";
    }

    @Override
    public Room findById(String id) {
        Room room= repository.findById(id).orElse(null);
        if (room!=null){
            return repository.findById(id).get();
        }
        return null;
    }

    @Override
    public Room update(Room room) {
        Room room1= repository.findById(room.getId()).orElse(null);
        if (room1!=null){
            return repository.save(room);
        }
        return null;
    }
}
