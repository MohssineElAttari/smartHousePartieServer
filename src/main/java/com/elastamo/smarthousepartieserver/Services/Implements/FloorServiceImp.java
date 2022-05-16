package com.elastamo.smarthousepartieserver.Services.Implements;

import com.elastamo.smarthousepartieserver.Models.Floor;
import com.elastamo.smarthousepartieserver.Repository.FloorRepository;
import com.elastamo.smarthousepartieserver.Services.Interfaces.IFloorService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FloorServiceImp implements IFloorService {

    private FloorRepository repository;

    public FloorServiceImp(FloorRepository floorRepository){
        this.repository = floorRepository;
    }

    @Override
    public Floor addFloor(Floor floor) {
//        Floor floor1 = repository.save(floor);
        return repository.save(floor);
    }

    @Override
    public List<Floor> getAll() {
//        return repository.findAll(Sort.by(Sort.Direction.DESC));
        return repository.findAll();
    }

    @Override
    public String delete(Floor floor) {
        repository.delete(floor);
        return "deleted!";
    }

    @Override
    public Floor findById(String id) {
        Floor floor= repository.findById(id).orElse(null);
        if (floor!=null){
            return repository.findById(id).get();
        }
        return null;
    }

    @Override
    public Floor update(Floor floor) {
        Floor floor1=repository.findById(floor.getId()).orElse(null);
        if (floor1!=null){
            return repository.save(floor);
        }
        return null;
    }

    @Override
    public int countFloor() {
        return (int) repository.count();
    }

    @Override
    public int countFloorByHouse(String houseID) {
        return repository.countFloorsByHouse_Id(houseID);
    }
}
